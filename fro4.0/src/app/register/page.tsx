'use client';

import { useState } from 'react';
import Link from 'next/link';
import { Card, CardContent, CardDescription, CardFooter, CardHeader, CardTitle } from '@/components/ui/card';
import { Input } from '@/components/ui/input';
import { Label } from '@/components/ui/label';
import { Button } from '@/components/ui/button';
import { useAuth } from '@/contexts/AuthContext';
import { Loader2, Lock, Mail, User, AlertCircle } from 'lucide-react';
import { motion } from 'framer-motion';

export default function RegisterPage() {
  const { register, loading: authLoading } = useAuth();
  const [formData, setFormData] = useState({
    name: '',
    email: '',
    password: '',
    confirmPassword: ''
  });
  const [error, setError] = useState('');
  
  // Animation variants
  const containerVariants = {
    hidden: { opacity: 0 },
    visible: { 
      opacity: 1,
      transition: { 
        staggerChildren: 0.1,
        delayChildren: 0.2
      } 
    }
  };
  
  const itemVariants = {
    hidden: { y: 20, opacity: 0 },
    visible: { 
      y: 0, 
      opacity: 1,
      transition: { type: 'spring', stiffness: 300, damping: 24 }
    }
  };

  const fadeIn = {
    hidden: { opacity: 0 },
    visible: { opacity: 1, transition: { duration: 0.6 } }
  };

  const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    const { name, value } = e.target;
    setFormData(prev => ({
      ...prev,
      [name]: value
    }));
  };

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    setError('');
    
    // Basic validation
    if (formData.password !== formData.confirmPassword) {
      setError('Passwords do not match');
      return;
    }
    
    try {
      await register(formData.name, formData.email, formData.password);
    } catch (err) {
      setError('Failed to create account. Please try again.');
    }
  };

  return (
    <div className="min-h-screen flex items-center justify-center bg-gradient-to-br from-indigo-50 via-purple-50 to-blue-50 py-12 px-4 sm:px-6 lg:px-8 overflow-hidden">
      <motion.div 
        className="absolute top-0 right-0 w-full h-32 bg-gradient-to-l from-indigo-600 to-purple-600 rounded-b-[30%] opacity-80 z-0"
        initial={{ x: '100%', opacity: 0 }}
        animate={{ x: 0, opacity: 0.8 }}
        transition={{ duration: 0.8, ease: 'easeOut' }}
      />
      
      <motion.div 
        className="w-full max-w-md z-10"
        variants={containerVariants}
        initial="hidden"
        animate="visible"
      >
        <motion.div 
          className="text-center mb-8"
          variants={itemVariants}
        >
          <h1 className="text-3xl font-extrabold text-gray-900 mb-2">Join Our Platform</h1>
          <p className="text-gray-600">Create your account to get started</p>
        </motion.div>
        
        <motion.div variants={itemVariants}>
          <Card className="w-full max-w-md border-none shadow-xl bg-white/90 backdrop-blur-sm overflow-hidden">
            <motion.div
              className="absolute top-0 left-0 w-full h-1 bg-gradient-to-r from-indigo-500 to-purple-600"
              initial={{ scaleX: 0, originX: 0 }}
              animate={{ scaleX: 1 }}
              transition={{ delay: 0.5, duration: 0.8, ease: 'easeOut' }}
            />
            <CardHeader className="space-y-1 pb-2">
              <CardTitle className="text-2xl font-bold text-center text-gray-800">Sign Up</CardTitle>
              <motion.div 
                className="w-16 h-1 bg-gradient-to-r from-indigo-500 to-purple-600 mx-auto rounded-full"
                initial={{ width: 0 }}
                animate={{ width: 64 }}
                transition={{ delay: 0.6, duration: 0.4 }}
              />
            </CardHeader>
          
          <form onSubmit={handleSubmit}>
            <CardContent className="space-y-4 pt-6">
              {error && (
                <motion.div 
                  className="bg-red-50 p-4 rounded-lg border border-red-200 flex items-start gap-3"
                  initial={{ opacity: 0, y: -10 }}
                  animate={{ opacity: 1, y: 0 }}
                  transition={{ type: 'spring' }}
                >
                  <AlertCircle className="h-5 w-5 text-red-500 mt-0.5 flex-shrink-0" />
                  <p className="text-sm text-red-700">{error}</p>
                </motion.div>
              )}
              
              <motion.div className="space-y-2" variants={itemVariants}>
                <Label htmlFor="name" className="text-gray-700 font-medium">Full Name</Label>
                <div className="relative">
                  <div className="absolute inset-y-0 left-0 pl-3 flex items-center pointer-events-none">
                    <User className="h-5 w-5 text-gray-400" />
                  </div>
                  <Input
                    id="name"
                    name="name"
                    type="text"
                    placeholder="John Doe"
                    required
                    value={formData.name}
                    onChange={handleChange}
                    className="pl-10 bg-white/60 border-gray-300 focus:border-indigo-500 focus:ring-indigo-500 transition-all duration-200"
                  />
                </div>
              </motion.div>
              
              <motion.div className="space-y-2" variants={itemVariants}>
                <Label htmlFor="email" className="text-gray-700 font-medium">Email Address</Label>
                <div className="relative">
                  <div className="absolute inset-y-0 left-0 pl-3 flex items-center pointer-events-none">
                    <Mail className="h-5 w-5 text-gray-400" />
                  </div>
                  <Input
                    id="email"
                    name="email"
                    type="email"
                    placeholder="name@example.com"
                    required
                    value={formData.email}
                    onChange={handleChange}
                    className="pl-10 bg-white/60 border-gray-300 focus:border-indigo-500 focus:ring-indigo-500 transition-all duration-200"
                  />
                </div>
              </motion.div>
              
              <motion.div className="space-y-2" variants={itemVariants}>
                <Label htmlFor="password" className="text-gray-700 font-medium">Password</Label>
                <div className="relative">
                  <div className="absolute inset-y-0 left-0 pl-3 flex items-center pointer-events-none">
                    <Lock className="h-5 w-5 text-gray-400" />
                  </div>
                  <Input
                    id="password"
                    name="password"
                    type="password"
                    required
                    value={formData.password}
                    onChange={handleChange}
                    className="pl-10 bg-white/60 border-gray-300 focus:border-indigo-500 focus:ring-indigo-500 transition-all duration-200"
                  />
                </div>
                <p className="text-xs text-gray-500 mt-1">Password must be at least 8 characters long</p>
              </motion.div>
              
              <motion.div className="space-y-2" variants={itemVariants}>
                <Label htmlFor="confirmPassword" className="text-gray-700 font-medium">Confirm Password</Label>
                <div className="relative">
                  <div className="absolute inset-y-0 left-0 pl-3 flex items-center pointer-events-none">
                    <Lock className="h-5 w-5 text-gray-400" />
                  </div>
                  <Input
                    id="confirmPassword"
                    name="confirmPassword"
                    type="password"
                    required
                    value={formData.confirmPassword}
                    onChange={handleChange}
                    className="pl-10 bg-white/60 border-gray-300 focus:border-indigo-500 focus:ring-indigo-500 transition-all duration-200"
                  />
                </div>
              </motion.div>
              
              <motion.div className="flex items-center space-x-2 pt-2" variants={itemVariants}>
                <input
                  type="checkbox"
                  id="terms"
                  className="h-4 w-4 text-indigo-600 focus:ring-indigo-500 border-gray-300 rounded"
                  required
                />
                <Label htmlFor="terms" className="text-sm text-gray-600">
                  I agree to the <a href="#" className="text-indigo-600 hover:text-indigo-500">Terms of Service</a> and <a href="#" className="text-indigo-600 hover:text-indigo-500">Privacy Policy</a>
                </Label>
              </motion.div>
            </CardContent>
            
            <CardFooter className="flex flex-col space-y-4 pb-6">
              <motion.div variants={itemVariants}>
                <Button 
                  type="submit" 
                  className="w-full bg-gradient-to-r from-indigo-600 to-purple-600 hover:from-indigo-700 hover:to-purple-700 text-white font-medium py-2 px-4 rounded-md transition-all duration-200 shadow-md hover:shadow-lg"
                  disabled={authLoading}
                >
                  {authLoading ? (
                    <>
                      <Loader2 className="mr-2 h-4 w-4 animate-spin" />
                      Creating account...
                    </>
                  ) : 'Create account'}
                </Button>
              </motion.div>
              
              {/* Social login options removed */}
              
              <motion.div className="text-center text-sm mt-4" variants={itemVariants}>
                <span className="text-gray-600">Already have an account?</span>{' '}
                <Link href="/login" className="text-indigo-600 hover:text-indigo-500 font-medium transition-colors duration-200">
                  Sign in
                </Link>
              </motion.div>
            </CardFooter>
          </form>
          </Card>
        </motion.div>
        
        <motion.div 
          className="text-center mt-8 text-sm text-gray-500"
          variants={fadeIn}
        >
          &copy; {new Date().getFullYear()} Equipment Management System. All rights reserved.
        </motion.div>
      </motion.div>
      
      <motion.div 
        className="absolute bottom-0 left-0 w-full h-32 bg-gradient-to-r from-purple-600 to-indigo-600 rounded-t-[30%] opacity-80 z-0"
        initial={{ x: '-100%', opacity: 0 }}
        animate={{ x: 0, opacity: 0.8 }}
        transition={{ duration: 0.8, ease: 'easeOut', delay: 0.2 }}
      />
    </div>
  );
}
