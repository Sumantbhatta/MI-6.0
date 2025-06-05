import axios from 'axios';

export const api = axios.create({
  baseURL: process.env.NEXT_PUBLIC_API_URL || 'http://localhost:8080/api',
  headers: {
    'Content-Type': 'application/json',
    'Accept': 'application/json',
  },
});

// ✅ Add token to each request if available
api.interceptors.request.use(
    (config) => {
      const token = localStorage.getItem('token'); // 🔐 your JWT
      if (token) {
        config.headers.Authorization = `Bearer ${token}`;
      }
      return config;
    },
    (error) => {
      console.error('API Request Error:', error);
      return Promise.reject(error);
    }
);

// Response error logging (keep this as is)
api.interceptors.response.use(
    (response) => response,
    (error) => {
      console.error('API Response Error:', error.response?.data || error.message);
      return Promise.reject(error);
    }
);
