// src/hooks/useRole.ts
import { jwtDecode } from "D:/internship/MI-6.0/fro4.0/node_modules/jwt-decode/build/esm/index"

export type Role = 'admin' | 'employee' | 'user';

export const getUserRoleFromToken = (): Role => {
    const token = localStorage.getItem('token');
    if (!token) return 'user';
    try {
        const decoded: any = jwtDecode(token);
        return decoded.role || 'user';
    } catch {
        return 'user';
    }
};
