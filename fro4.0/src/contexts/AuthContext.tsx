'use client';

import React, { createContext, useContext, useState, useEffect, ReactNode } from 'react';
import { useRouter, usePathname } from 'next/navigation';
import { supabase } from '@/lib/supabase';
import { User, Session } from '@supabase/supabase-js';

interface AuthUser {
  id: string;
  name: string;
  email: string;
  avatar: string;
  email_confirmed_at?: string | null;
}

interface AuthContextType {
  user: AuthUser | null;
  loading: boolean;
  login: (email: string, password: string) => Promise<void>;
  register: (name: string, email: string, password: string) => Promise<void>;
  logout: () => Promise<void>;
  signInWithGoogle: () => Promise<void>;
}

const AuthContext = createContext<AuthContextType | undefined>(undefined);

export function AuthProvider({ children }: { children: ReactNode }) {
  const [user, setUser] = useState<AuthUser | null>(null);
  const [loading, setLoading] = useState(true);
  const router = useRouter();
  const pathname = usePathname();

  useEffect(() => {
    // Check active sessions and sets the user
    supabase.auth.getSession().then(({ data: { session } }) => {
      if (session?.user) {
        setUser({
          id: session.user.id,
          name: session.user.user_metadata?.name || session.user.email?.split('@')[0] || 'User',
          email: session.user.email || '',
          avatar: session.user.user_metadata?.avatar || `https://ui-avatars.com/api/?name=${encodeURIComponent(session.user.user_metadata?.name || 'User')}`,
          email_confirmed_at: session.user.email_confirmed_at
        });
      } else {
        setUser(null);
      }
      setLoading(false);

      // If user is not verified, redirect to profile page
      if (session?.user && !session.user.email_confirmed_at) {
        router.push('/profile');
      }
    });

    const { data: { subscription } } = supabase.auth.onAuthStateChange(async (_event, session) => {
      if (session?.user) {
        setUser({
          id: session.user.id,
          name: session.user.user_metadata?.name || session.user.email?.split('@')[0] || 'User',
          email: session.user.email || '',
          avatar: session.user.user_metadata?.avatar || `https://ui-avatars.com/api/?name=${encodeURIComponent(session.user.user_metadata?.name || 'User')}`,
          email_confirmed_at: session.user.email_confirmed_at
        });
      } else {
        setUser(null);
      }
      setLoading(false);

      // If user is not verified, redirect to profile page
      if (session?.user && !session.user.email_confirmed_at) {
        router.push('/profile');
      }
    });

    return () => subscription.unsubscribe();
  }, [router]);

  useEffect(() => {
    // Redirect unauthenticated users to login page
    // except for login, register, and homepage
    if (!loading && !user && 
        pathname !== '/login' && 
        pathname !== '/register' &&
        pathname !== '/') {
      router.push('/');
    }
  }, [user, loading, pathname, router]);

  const login = async (email: string, password: string) => {
    const { data, error } = await supabase.auth.signInWithPassword({
      email,
      password,
    });

    if (error) throw error;

    // If user is not verified, redirect to profile page
    if (data.user && !data.user.email_confirmed_at) {
      router.push('/profile');
    } else {
      router.push('/dashboard');
    }
  };

  const register = async (name: string, email: string, password: string) => {
    const { data, error } = await supabase.auth.signUp({
      email,
      password,
      options: {
        data: {
          name,
        },
      },
    });

    if (error) throw error;

    // Redirect to profile page for email verification
    router.push('/profile');
  };

  const logout = async () => {
    const { error } = await supabase.auth.signOut();
    if (error) throw error;
    router.push('/login');
  };

  const signInWithGoogle = async () => {
    const { error } = await supabase.auth.signInWithOAuth({
      provider: 'google',
    });
    if (error) throw error;
  };

  return (
    <AuthContext.Provider value={{
      user,
      loading,
      login,
      register,
      logout,
      signInWithGoogle,
    }}>
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
