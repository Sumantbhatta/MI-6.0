import { api } from '@/lib/api';

export interface LoginInput {
    email: string;
    password: string;
}

export interface RegisterInput {
    email: string;
    username: string;
    password: string;
}

export const loginUser = async (data: LoginInput): Promise<string> => {
    const response = await api.post('/auth/login', data);
    const token = response.data.token;
    localStorage.setItem('token', token);
    return token;
};

export const registerUser = async (data: RegisterInput) => {
    const response = await api.post('/auth/register', data);
    return response.data;
};
