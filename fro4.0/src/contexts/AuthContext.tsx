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
  phone?: string;
  email_confirmed_at?: string | null;
}

interface AuthContextType {
  user: AuthUser | null;
  loading: boolean;
  login: (email: string, password: string, phone?: string) => Promise<void>;
  register: (name: string, email: string, password: string, phone?: string) => Promise<void>;
  logout: () => Promise<void>;
  signInWithGoogle: () => Promise<void>;
  testSupabaseConnection: () => Promise<{ success: boolean; message?: string; error?: any }>;
  checkAndUpdateUserMetadata: () => Promise<{ success: boolean; originalMetadata?: any; updatedMetadata?: any; error?: any }>;
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
          phone: session.user.user_metadata?.phone,
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
          phone: session.user.user_metadata?.phone,
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

  const login = async (email: string, password: string, phone?: string) => {
    try {
      // First, sign in the user
      const { data, error } = await supabase.auth.signInWithPassword({
        email,
        password,
      });

      if (error) throw error;

      // Update user metadata with phone and name
      const { error: updateError } = await supabase.auth.updateUser({
        data: { 
          phone: phone || data.user?.user_metadata?.phone || '',
          name: data.user?.user_metadata?.name || email.split('@')[0]
        }
      });

      if (updateError) {
        console.error('Error updating user metadata:', updateError);
      }

      // Get the updated user data
      const { data: { user: updatedUser } } = await supabase.auth.getUser();

      // Set the user state with the updated data
      if (updatedUser) {
        setUser({
          id: updatedUser.id,
          name: updatedUser.user_metadata?.name || email.split('@')[0],
          email: updatedUser.email || '',
          phone: updatedUser.user_metadata?.phone,
          avatar: updatedUser.user_metadata?.avatar || `https://ui-avatars.com/api/?name=${encodeURIComponent(updatedUser.user_metadata?.name || 'User')}`,
          email_confirmed_at: updatedUser.email_confirmed_at
        });
      }

      // If user is not verified, redirect to profile page
      if (data.user && !data.user.email_confirmed_at) {
        router.push('/profile');
      } else {
        router.push('/dashboard');
      }
    } catch (error) {
      console.error('Login error:', error);
      throw error;
    }
  };

  const register = async (name: string, email: string, password: string, phone?: string) => {
    try {
      // Sign up the user with initial metadata
      const { data, error } = await supabase.auth.signUp({
        email,
        password,
        options: {
          data: {
            name,
            phone: phone || '',
            avatar: `https://ui-avatars.com/api/?name=${encodeURIComponent(name)}`
          },
        },
      });

      if (error) throw error;

      // If signup was successful, update the user state
      if (data.user) {
        setUser({
          id: data.user.id,
          name: data.user.user_metadata?.name || name,
          email: data.user.email || '',
          phone: data.user.user_metadata?.phone || phone || '',
          avatar: data.user.user_metadata?.avatar || `https://ui-avatars.com/api/?name=${encodeURIComponent(name)}`,
          email_confirmed_at: data.user.email_confirmed_at
        });
      }

      // Redirect to profile page for email verification
      router.push('/profile');
    } catch (error) {
      console.error('Registration error:', error);
      throw error;
    }
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

  // Add this test function
  const testSupabaseConnection = async () => {
    try {
      console.log('Testing Supabase connection...');
      
      // Test 1: Get current session
      const { data: sessionData, error: sessionError } = await supabase.auth.getSession();
      console.log('Current session:', sessionData);
      if (sessionError) console.error('Session error:', sessionError);

      // Test 2: Get current user
      const { data: userData, error: userError } = await supabase.auth.getUser();
      console.log('Current user:', userData);
      if (userError) console.error('User error:', userError);

      // Test 3: Update user metadata
      if (userData?.user) {
        const { data: updateData, error: updateError } = await supabase.auth.updateUser({
          data: {
            test_metadata: 'test_value',
            name: userData.user.user_metadata?.name || 'Test User',
            phone: userData.user.user_metadata?.phone || '+1234567890'
          }
        });
        console.log('Update metadata result:', updateData);
        if (updateError) console.error('Update error:', updateError);

        // Test 4: Get updated user data to verify changes
        const { data: updatedUserData, error: updatedUserError } = await supabase.auth.getUser();
        console.log('Updated user data:', updatedUserData);
        if (updatedUserError) console.error('Updated user error:', updatedUserError);

        return { 
          success: true, 
          message: 'Tests completed. Check console for details.',
          currentUser: {
            id: userData.user.id,
            email: userData.user.email,
            metadata: userData.user.user_metadata,
            updatedMetadata: updatedUserData?.user?.user_metadata
          }
        };
      }

      return { 
        success: true, 
        message: 'Tests completed but no user was found.',
        session: sessionData
      };
    } catch (error) {
      console.error('Test error:', error);
      return { success: false, error };
    }
  };

  // Add this function to check and update user metadata
  const checkAndUpdateUserMetadata = async () => {
    try {
      // Get current user
      const { data: { user }, error: userError } = await supabase.auth.getUser();
      
      if (userError) throw userError;
      
      if (!user) {
        console.log('No user found');
        return;
      }

      console.log('Current user metadata:', user.user_metadata);

      // Update user metadata
      const { data: updateData, error: updateError } = await supabase.auth.updateUser({
        data: {
          name: user.user_metadata?.name || user.email?.split('@')[0],
          phone: user.user_metadata?.phone || '',
          updated_at: new Date().toISOString()
        }
      });

      if (updateError) {
        console.error('Error updating metadata:', updateError);
        return;
      }

      console.log('Updated user data:', updateData);

      // Get updated user data to verify
      const { data: { user: updatedUser }, error: getError } = await supabase.auth.getUser();
      
      if (getError) {
        console.error('Error getting updated user:', getError);
        return;
      }

      console.log('Final user metadata:', updatedUser?.user_metadata);

      return {
        success: true,
        originalMetadata: user.user_metadata,
        updatedMetadata: updatedUser?.user_metadata
      };
    } catch (error) {
      console.error('Error in checkAndUpdateUserMetadata:', error);
      return { success: false, error };
    }
  };

  return (
    <AuthContext.Provider value={{
      user,
      loading,
      login,
      register,
      logout,
      signInWithGoogle,
      testSupabaseConnection,
      checkAndUpdateUserMetadata,
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
