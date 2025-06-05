'use client';

import React, { useEffect, useState } from 'react';
import { useRouter } from 'next/navigation';
import { jwtDecode } from "D:/internship/MI-6.0/fro4.0/node_modules/jwt-decode/build/esm/index"
// import Sidebar from '@/components/Sidebar';
// import TopNavBar from '@/components/TopNavBar';

export default function DashboardLayout({ children }: { children: React.ReactNode }) {
    const router = useRouter();
    const [isAuthorized, setIsAuthorized] = useState(false);

    useEffect(() => {
        const token = localStorage.getItem('token');

        if (!token) {
            router.push('/login');
            return;
        }

        try {
            const decoded: any = jwtDecode(token);
            const allowedRoles = ['admin', 'employee', 'user'];
            const userRole = decoded.role;

            if (!allowedRoles.includes(userRole)) {
                router.push('/unauthorized');
            } else {
                setIsAuthorized(true);
            }
        } catch (error) {
            console.error('Token decode error:', error);
            router.push('/login');
        }
    }, [router]);

    if (!isAuthorized) {
        return null; // You can return a spinner here if you want
    }

    return (
        <>
            {/* <TopNavBar /> */}
            <div className="flex min-h-[calc(100vh-3rem)]">
                {/* <Sidebar /> */}
                <main className="flex-1 bg-gray-50">{children}</main>
            </div>
        </>
    );
}
