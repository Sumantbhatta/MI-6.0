import axios, { AxiosError } from 'axios';
import { API_URL } from '@/config';
import { handleAndNotifyError } from '@/utils/errorHandling';

export interface Project {
  id?: number;
  name: string;
  description: string;
  location: string;
  startDate: string;
  endDate: string;
  status: string;
}

export const projectService = {
  getAllProjects: async () => {
    try {
      const response = await axios.get(`${API_URL}/v1/projects`);
      return response.data?.data || [];
    } catch (error) {
      handleAndNotifyError(error);
      return [];
    }
  },

  getProjectById: async (id: number) => {
    try {
      const response = await axios.get(`${API_URL}/v1/projects/${id}`);
      return response.data?.data;
    } catch (error) {
      handleAndNotifyError(error);
      throw error;
    }
  },

  createProject: async (project: Project) => {
    try {
      const response = await axios.post(`${API_URL}/v1/projects`, project);
      return response.data?.data;
    } catch (error) {
      const apiError = handleAndNotifyError(error);
      // For duplicate entries, we can add more specific handling if needed
      throw apiError;
    }
  },

  updateProject: async (id: number, project: Project) => {
    try {
      const response = await axios.put(`${API_URL}/v1/projects/${id}`, project);
      return response.data?.data;
    } catch (error) {
      const apiError = handleAndNotifyError(error);
      throw apiError;
    }
  },

  deleteProject: async (id: number) => {
    try {
      const response = await axios.delete(`${API_URL}/v1/projects/${id}`);
      return response.data?.data;
    } catch (error) {
      const apiError = handleAndNotifyError(error);
      throw apiError;
    }
  }
};
