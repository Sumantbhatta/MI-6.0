import { toast } from 'react-hot-toast';

export enum ErrorType {
  DUPLICATE_ENTRY = 'DUPLICATE_ENTRY',
  VALIDATION_ERROR = 'VALIDATION_ERROR',
  NOT_FOUND = 'NOT_FOUND',
  UNAUTHORIZED = 'UNAUTHORIZED',
  FORBIDDEN = 'FORBIDDEN',
  SERVER_ERROR = 'SERVER_ERROR',
  NETWORK_ERROR = 'NETWORK_ERROR',
  UNKNOWN_ERROR = 'UNKNOWN_ERROR',
}

export interface ApiError {
  type: ErrorType;
  message: string;
  details?: Record<string, string[]>;
  statusCode?: number;
}

export const handleApiError = (error: any): ApiError => {
  // Handle Axios errors
  if (error.response) {
    const { data, status } = error.response;
    
    // Handle 409 Conflict (Duplicate entry)
    if (status === 409) {
      return {
        type: ErrorType.DUPLICATE_ENTRY,
        message: data?.message || 'This record already exists',
        details: data?.errors,
        statusCode: status
      };
    }

    // Handle 400 Bad Request
    if (status === 400) {
      return {
        type: ErrorType.VALIDATION_ERROR,
        message: data?.message || 'Validation failed',
        details: data?.errors,
        statusCode: status
      };
    }

    // Handle 401 Unauthorized
    if (status === 401) {
      return {
        type: ErrorType.UNAUTHORIZED,
        message: data?.message || 'Unauthorized access',
        statusCode: status
      };
    }

    // Handle 403 Forbidden
    if (status === 403) {
      return {
        type: ErrorType.FORBIDDEN,
        message: data?.message || 'You do not have permission to perform this action',
        statusCode: status
      };
    }

    // Handle 404 Not Found
    if (status === 404) {
      return {
        type: ErrorType.NOT_FOUND,
        message: data?.message || 'The requested resource was not found',
        statusCode: status
      };
    }

    // Handle 5xx Server Errors
    if (status >= 500) {
      // Try to detect duplicate entry from error message
      const message = data?.message || '';
      if (
        message.toLowerCase().includes('duplicate') ||
        message.toLowerCase().includes('constraint') ||
        message.toLowerCase().includes('unique')
      ) {
        return {
          type: ErrorType.DUPLICATE_ENTRY,
          message: 'A project with this name already exists.',
          statusCode: status
        };
      }
      return {
        type: ErrorType.SERVER_ERROR,
        message: message || 'An unexpected server error occurred',
        statusCode: status
      };
    }
  }

  // Handle network errors
  if (error.message === 'Network Error') {
    return {
      type: ErrorType.NETWORK_ERROR,
      message: 'Unable to connect to the server. Please check your internet connection.'
    };
  }

  // Handle request cancellation
  if (error.code === 'ECONNABORTED') {
    return {
      type: ErrorType.NETWORK_ERROR,
      message: 'Request timed out. Please try again.'
    };
  }

  // Fallback for unknown errors
  return {
    type: ErrorType.UNKNOWN_ERROR,
    message: error.message || 'An unknown error occurred'
  };
};

export const showErrorToast = (error: ApiError) => {
  // You can customize the toast based on error type
  let toastMessage = error.message;
  
  // If there are validation errors, include them in the message
  if (error.details) {
    const errorMessages = Object.values(error.details).flat();
    if (errorMessages.length > 0) {
      toastMessage = `${error.message}: ${errorMessages.join(', ')}`;
    }
  }

  // Add more specific handling based on error type
  let title = 'Error';
  
  switch (error.type) {
    case ErrorType.DUPLICATE_ENTRY:
      title = 'Duplicate Entry';
      break;
    case ErrorType.VALIDATION_ERROR:
      title = 'Validation Error';
      break;
    case ErrorType.UNAUTHORIZED:
      title = 'Unauthorized';
      break;
    case ErrorType.FORBIDDEN:
      title = 'Access Denied';
      break;
    case ErrorType.NOT_FOUND:
      title = 'Not Found';
      break;
    case ErrorType.SERVER_ERROR:
      title = 'Server Error';
      break;
    case ErrorType.NETWORK_ERROR:
      title = 'Connection Error';
      break;
  }

  toast.error(`${title}: ${toastMessage}`);
};

export const handleAndNotifyError = (error: any) => {
  const apiError = handleApiError(error);
  showErrorToast(apiError);
  return apiError;
};
