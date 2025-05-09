import { createClient } from '@supabase/supabase-js';

const supabaseUrl = 'https://gtrbhxfondbarhmfejyy.supabase.co';
const supabaseAnonKey = 'eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Imd0cmJoeGZvbmRiYXJobWZlanl5Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3NDU5OTQ4NjIsImV4cCI6MjA2MTU3MDg2Mn0.rZ8ZIY_iq3vpnYc8CXKAdFLXZ3s4gakjugMdOpiKZAA';

export const supabase = createClient(supabaseUrl, supabaseAnonKey); 