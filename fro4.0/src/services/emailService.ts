import { supabase } from '@/lib/supabase';

export const emailService = {
  async sendOTP(email: string): Promise<{ success: boolean; error?: string }> {
    try {
      const { data, error } = await supabase.auth.signInWithOtp({
        email,
        options: {
          emailRedirectTo: `${window.location.origin}/verify-email`,
        },
      });

      if (error) throw error;
      return { success: true };
    } catch (error: any) {
      console.error('Error sending OTP:', error);
      return { success: false, error: error.message };
    }
  },

  async verifyOTP(email: string, token: string): Promise<{ success: boolean; error?: string }> {
    try {
      const { data, error } = await supabase.auth.verifyOtp({
        email,
        token,
        type: 'email',
      });

      if (error) throw error;
      return { success: true };
    } catch (error: any) {
      console.error('Error verifying OTP:', error);
      return { success: false, error: error.message };
    }
  }
}; 