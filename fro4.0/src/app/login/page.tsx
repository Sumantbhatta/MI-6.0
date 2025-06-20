'use client';

import { useState } from 'react';
import Link from 'next/link';
import { useRouter } from 'next/navigation';
import { Card, CardContent, CardFooter, CardHeader, CardTitle } from '@/components/ui/card';
import { Input } from '@/components/ui/input';
import { Label } from '@/components/ui/label';
import { Button } from '@/components/ui/button';
import { loginUser } from '@/services/authService';
import { Loader2, Lock, Mail, AlertCircle } from 'lucide-react';
import { motion } from 'framer-motion';

export default function LoginPage() {
    const router = useRouter();

    const [formData, setFormData] = useState({
        email: '',
        password: '',
    });

    const [error, setError] = useState('');
    const [authLoading, setAuthLoading] = useState(false); // ✅ loading state

    const containerVariants = {
        hidden: { opacity: 0 },
        visible: {
            opacity: 1,
            transition: {
                staggerChildren: 0.1,
                delayChildren: 0.2,
            },
        },
    };

    const itemVariants = {
        hidden: { y: 20, opacity: 0 },
        visible: {
            y: 0,
            opacity: 1,
            transition: { type: 'spring', stiffness: 300, damping: 24 },
        },
    };

    const fadeIn = {
        hidden: { opacity: 0 },
        visible: { opacity: 1, transition: { duration: 0.6 } },
    };

    const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        const { name, value } = e.target;
        setFormData((prev) => ({
            ...prev,
            [name]: value,
        }));
    };

    const handleSubmit = async (e: React.FormEvent) => {
        e.preventDefault();
        setError('');
        setAuthLoading(true);

        try {
            const token = await loginUser(formData);
            const payload = JSON.parse(atob(token.split('.')[1]));
            const role = payload.role;

            // redirect by role
            if (role === 'admin') {
                router.push('/admin-dashboard');
            } else if (role === 'employee') {
                router.push('/employee-dashboard');
            } else {
                router.push('/user-dashboard');
            }
        } catch (err: any) {
            setError('Invalid email or password');
        } finally {
            setAuthLoading(false);
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
                    className="text-center absolute top-1/2 left-[calc(50%+20px)] transform -translate-x-1/2 -translate-y-1/2"
                    variants={itemVariants}
                >
                    <h1 className="text-4xl font-extrabold text-black">Welcome Back</h1>
                    <p className="text-black/90">Sign in to your account</p>
                </motion.div>
            </motion.div>

            <motion.div
                className="w-full max-w-md z-10 mt-32 mb-32"
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
                            <CardTitle className="text-2xl font-bold text-center text-black-800">Sign In</CardTitle>
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
                                    <div className="flex justify-between items-center">
                                        <Label htmlFor="password" className="text-gray-700 font-medium">Password</Label>
                                        <Link href="#" className="text-sm text-yellow-600 hover:text-yellow-500 transition-colors duration-200">
                                            Forgot password?
                                        </Link>
                                    </div>
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
                                </motion.div>

                                <motion.div className="flex items-center space-x-2 pt-2" variants={itemVariants}>
                                    <input
                                        type="checkbox"
                                        id="remember"
                                        className="h-4 w-4 text-yellow-600 focus:ring-yellow-500 border-gray-300 rounded"
                                    />
                                    <Label htmlFor="remember" className="text-sm text-gray-600">
                                        Remember me
                                    </Label>
                                </motion.div>
                            </CardContent>

                            <CardFooter className="flex flex-col space-y-4 pb-6">
                                <motion.div variants={itemVariants}>
                                    <Button
                                        type="submit"
                                        className="w-full bg-gradient-to-r from-yellow-600 to-yellow-600 hover:from-yellow-700 hover:to-yellow-700 text-white font-medium py-2 px-4 rounded-md transition-all duration-200 shadow-md hover:shadow-lg"
                                        disabled={authLoading}
                                    >
                                        {authLoading ? (
                                            <>
                                                <Loader2 className="mr-2 h-4 w-4 animate-spin" />
                                                Signing in...
                                            </>
                                        ) : 'Sign in'}
                                    </Button>
                                </motion.div>

                                <motion.div className="text-center text-sm mt-4" variants={itemVariants}>
                                    <span className="text-gray-600">Don't have an account?</span>{' '}
                                    <Link href="/register" className="text-yellow-600 hover:text-yellow-500 font-medium transition-colors duration-200">
                                        Sign up
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
