'use client';

import { useState } from 'react';
import Link from 'next/link';
import { Card, CardContent, CardDescription, CardFooter, CardHeader, CardTitle } from '@/components/ui/card';
import { Input } from '@/components/ui/input';
import { Label } from '@/components/ui/label';
import { Button } from '@/components/ui/button';
import { registerUser } from '@/services/authService';
import { Loader2, Lock, Mail, User, AlertCircle, Phone } from 'lucide-react';
import { motion } from 'framer-motion';

export default function RegisterPage() {
  const [loading, setLoading] = useState(false);
  const [formData, setFormData] = useState({
    name: '',
    email: '',
    password: '',
    confirmPassword: '',
    phone: '',
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
    setLoading(true);
    
    // Basic validation
    if (formData.password !== formData.confirmPassword) {
      setError('Passwords do not match');
      setLoading(false);
      return;
    }

    if (formData.password.length < 6) {
      setError('Password must be at least 6 characters long');
      setLoading(false);
      return;
    }

    if (!formData.name.trim()) {
      setError('Name is required');
      setLoading(false);
      return;
    }

    if (!formData.email.trim()) {
      setError('Email is required');
      setLoading(false);
      return;
    }

    // Email format validation
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!emailRegex.test(formData.email)) {
      setError('Please enter a valid email address');
      setLoading(false);
      return;
    }
    
    try {
      await registerUser({
      username: formData.name,
      email: formData.email,
      password: formData.password
    });

    } catch (err: any) {
      console.error('Registration error:', err);
      setError(err.message || 'Failed to create account. Please try again.');
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="min-h-screen flex items-center justify-center bg-gradient-to-br from-yellow-500 via-yellow-100 to-yellow-500 py-12 px-4 sm:px-6 lg:px-8 overflow-hidden">
      <motion.div 
        className="absolute top-0 right-0 w-full h-32 bg-gradient-to-l from-[#ffbd2b] to-[#ffbd2b] rounded-b-[30%] opacity-80 z-0"
        initial={{ x: '100%', opacity: 0 }}
        animate={{ x: 0, opacity: 0.8 }}
        transition={{ duration: 0.8, ease: 'easeOut' }}
      >
        <motion.div 
          className="text-center absolute top-1/2 left-1/2 transform -translate-x-1/2 -translate-y-1/2"
          variants={itemVariants}
        >
          <h1 className="text-4xl font-extrabold text-black">Join Our Platform</h1>
          <p className="text-black/90">Create your account to get started</p>
        </motion.div>
      </motion.div>
      
      <motion.div
        className="w-full max-w-md z-10"
        variants={containerVariants}
        initial="hidden"
        animate="visible"
      >
        <motion.div variants={itemVariants}>
          <Card className="w-full max-w-md border-none shadow-xl bg-yellow-200 backdrop-blur-sm overflow-hidden">
            <motion.div
              className="absolute top-0 left-0 w-full h-1 bg-gradient-to-r from-yellow-500 to-yellow-600"
              initial={{ scaleX: 0, originX: 0 }}
              animate={{ scaleX: 1 }}
              transition={{ delay: 0.5, duration: 0.8, ease: 'easeOut' }}
            />
            <CardHeader className="space-y-1 pb-2">
              <CardTitle className="text-2xl font-bold text-center text-black-800">Sign Up</CardTitle>
              <motion.div 
                className="w-16 h-1 bg-gradient-to-r from-yellow-500 to-yellow-600 mx-auto rounded-full"
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
                      className="pl-10 bg-white/60 border-gray-300 focus:border-orange-500 focus:ring-orange-500 transition-all duration-200"
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
                      className="pl-10 bg-white/60 border-gray-300 focus:border-orange-500 focus:ring-orange-500 transition-all duration-200"
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
                      className="pl-10 bg-white/60 border-gray-300 focus:border-orange-500 focus:ring-orange-500 transition-all duration-200"
                    />
                  </div>
                  <p className="text-xs text-gray-500 mt-1">Password must be at least 6 characters long</p>
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
                      className="pl-10 bg-white/60 border-gray-300 focus:border-orange-500 focus:ring-orange-500 transition-all duration-200"
                    />
                  </div>
                </motion.div>
                
                <motion.div className="space-y-2" variants={itemVariants}>
                  <Label htmlFor="phone" className="text-gray-700 font-medium">Phone Number (Optional)</Label>
                  <div className="relative">
                    <div className="absolute inset-y-0 left-0 pl-3 flex items-center pointer-events-none">
                      <Phone className="h-5 w-5 text-gray-400" />
                    </div>
                    <Input
                      id="phone"
                      name="phone"
                      type="tel"
                      placeholder="+91 1234567890"
                      value={formData.phone}
                      onChange={handleChange}
                      className="pl-10 bg-white/60 border-gray-300 focus:border-orange-500 focus:ring-orange-500 transition-all duration-200"
                    />
                  </div>
                </motion.div>
                
                <motion.div className="flex items-center space-x-2 pt-2" variants={itemVariants}>
                  <input
                    type="checkbox"
                    id="terms"
                    className="h-4 w-4 text-yellow-600 focus:ring-yellow-500 border-gray-300 rounded"
                    required
                  />
                  <Label htmlFor="terms" className="text-sm text-gray-600">
                    I agree to the <a href="#" className="text-yellow-600 hover:text-yellow-500">Terms of Service</a> and <a href="#" className="text-yellow-600 hover:text-yellow-500">Privacy Policy</a>
                  </Label>
                </motion.div>
              </CardContent>
              
              <CardFooter className="flex flex-col space-y-4 pb-6">
                <motion.div variants={itemVariants}>
                  <Button 
                    type="submit" 
                    className="w-full bg-gradient-to-r from-yellow-600 to-yellow-600 hover:from-yellow-700 hover:to-yellow-700 text-white font-medium py-2 px-4 rounded-md transition-all duration-200 shadow-md hover:shadow-lg"
                    disabled={loading}
                  >
                    {loading ? (
                      <>
                        <Loader2 className="mr-2 h-4 w-4 animate-spin" />
                        Creating account...
                      </>
                    ) : 'Create account'}
                  </Button>
                </motion.div>
                
                <motion.div className="text-center text-sm mt-4" variants={itemVariants}>
                  <span className="text-gray-600">Already have an account?</span>{' '}
                  <Link href="/login" className="text-yellow-600 hover:text-yellow-500 font-medium transition-colors duration-200">
                    Sign in
                  </Link>
                </motion.div>
              </CardFooter>
            </form>
          </Card>
        </motion.div>
      </motion.div>
      
      <motion.div
        className="absolute bottom-0 left-0 w-full h-32 bg-gradient-to-r from-[#ffbd2b] to-[#ffbd2b] rounded-t-[30%] opacity-80 z-0"
        initial={{ x: '-100%', opacity: 0 }}
        animate={{ x: 0, opacity: 0.8 }}
        transition={{ duration: 0.8, ease: 'easeOut', delay: 0.2 }}
      >
        <motion.div 
          className="text-center absolute top-1/2 left-1/2 transform -translate-x-1/2 -translate-y-1/2"
          variants={fadeIn}
        >
          <p className="text-sm text-black/90">
            &copy; {new Date().getFullYear()} Equipment Management System. All rights reserved.
          </p>
        </motion.div>
      </motion.div>
    </div>
  );
}
