'use client';

// import Sidebar from '@/components/Sidebar';
// import TopNavBar from '@/components/TopNavBar';
import React from 'react';

export default function DashboardLayout({ children }: { children: React.ReactNode }) {
  return (
    <>
      {/*<TopNavBar />*/}
      <div className="flex min-h-[calc(100vh-3rem)]">
        {/*<Sidebar />*/}
        <main className="flex-1 bg-gray-50">
          {children}
        </main>
      </div>
    </>
  );
} 