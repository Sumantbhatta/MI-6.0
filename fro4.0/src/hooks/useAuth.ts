import { useEffect, useState } from 'react';

export const useAuth = () => {
    const [role, setRole] = useState<string | null>(null);
    const [isAuthenticated, setIsAuthenticated] = useState<boolean>(false);
    const [loading, setLoading] = useState<boolean>(true);

    useEffect(() => {
        const token = localStorage.getItem('token');

        if (token) {
            try {
                const payload = JSON.parse(atob(token.split('.')[1]));
                setRole(payload.role);
                setIsAuthenticated(true);
            } catch (e) {
                console.error('Invalid token');
                localStorage.removeItem('token');
                setIsAuthenticated(false);
            }
        } else {
            setIsAuthenticated(false);
        }

        setLoading(false);
    }, []);

    return { role, isAuthenticated, loading };
};
