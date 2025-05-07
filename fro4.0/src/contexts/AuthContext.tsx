'use client';

import React, { createContext, useContext, useState, useEffect, ReactNode } from 'react';
import { useRouter, usePathname } from 'next/navigation';

type User = {
  name: string;
  email: string;
  avatar: string;
} | null;

type AuthContextType = {
  user: User;
  login: (email: string, password: string) => Promise<void>;
  register: (name: string, email: string, password: string) => Promise<void>;
  logout: () => void;
  loading: boolean;
};

const AuthContext = createContext<AuthContextType | undefined>(undefined);

export function AuthProvider({ children }: { children: ReactNode }) {
  const [user, setUser] = useState<User>(null);
  const [loading, setLoading] = useState(true);
  const router = useRouter();
  const pathname = usePathname();

  useEffect(() => {
    // Check if user is stored in localStorage
    const storedUser = localStorage.getItem('user');
    if (storedUser) {
      try {
        setUser(JSON.parse(storedUser));
      } catch (error) {
        console.error('Failed to parse user from localStorage', error);
      }
    }
    setLoading(false);
  }, []);

  useEffect(() => {
    // Redirect unauthenticated users to login page
    // except for login, register, and homepage
    if (!loading && !user && 
        pathname !== '/login' && 
        pathname !== '/register' &&
        pathname !== '/') {
      router.push('/login');
    }
  }, [user, loading, pathname, router]);

  const login = async (email: string, password: string) => {
    setLoading(true);
    try {
      // In a real app, you would make an API call to authenticate the user
      // For this demo, we'll simulate a successful login after a short delay
      await new Promise(resolve => setTimeout(resolve, 1000));
      
      const newUser = {
        name: 'James', // In a real app, this would come from the API
        email,
        avatar: 'https://ui-avatars.com/api/?name=James'
      };
      
      // Store user info in localStorage
      localStorage.setItem('user', JSON.stringify(newUser));
      setUser(newUser);
      
      // Redirect to dashboard
      router.push('/dashboard');
    } catch (error) {
      console.error('Login failed:', error);
      throw error;
    } finally {
      setLoading(false);
    }
  };

  const register = async (name: string, email: string, password: string) => {
    setLoading(true);
    try {
      // In a real app, you would make an API call to register the user
      // For this demo, we'll simulate a successful registration after a short delay
      await new Promise(resolve => setTimeout(resolve, 1000));
      
      const newUser = {
        name,
        email,
        avatar: `https://ui-avatars.com/api/?name=${encodeURIComponent(name)}`
      };
      
      // Store user info in localStorage
      localStorage.setItem('user', JSON.stringify(newUser));
      setUser(newUser);
      
      // Redirect to dashboard
      router.push('/');
    } finally {
      setLoading(false);
    }
  };

  const logout = () => {
    // Clear user data from localStorage
    localStorage.removeItem('user');
    setUser(null);
    
    // Redirect to login page
    router.push('/login');
  };

  return (
    <AuthContext.Provider value={{ user, login, register, logout, loading }}>
      {children}
    </AuthContext.Provider>
  );
}

export function useAuth() {
  const context = useContext(AuthContext);
  if (context === undefined) {
    throw new Error('useAuth must be used within an AuthProvider');
  }
  return context;
}
