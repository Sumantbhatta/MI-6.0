'use client';

import './globals.css';
import { Inter } from 'next/font/google';
import Sidebar from '@/components/Sidebar';
import Header from '@/components/TopNavBar';
import { QueryClient, QueryClientProvider } from 'react-query';
import { ThemeProvider } from '@mui/material/styles';
import CssBaseline from '@mui/material/CssBaseline';
import { theme } from '@/theme';
import { Toaster } from 'react-hot-toast';
import { AuthProvider } from '@/contexts/AuthContext';
import { usePathname, useSelectedLayoutSegments } from 'next/navigation';
import { SettingsProvider } from '@/contexts/SettingsContext';
import { useEffect } from 'react';
import { initializePerformanceOptimizations } from '@/utils/performanceOptimizer';

const inter = Inter({ subsets: ['latin'] });

const queryClient = new QueryClient({
  defaultOptions: {
    queries: {
      refetchOnWindowFocus: false,
      retry: false,
    },
  },
});

// Layout wrapper component to conditionally render sidebar and navbar
function LayoutWrapper({ children }: { children: React.ReactNode }) {
  const pathname = usePathname();
  const segments = useSelectedLayoutSegments();
  const isAuthPage = pathname === '/login' || pathname === '/register';
  const isHomePage = pathname === '/';
  const isErrorPage = pathname === '/not-found' || segments.includes('not-found');
  
  // Check if the current page is a 404 page
  const is404Page = typeof window !== 'undefined' && 
    (window.location.pathname.includes('404') || 
     document.querySelector('[data-status="404"]') !== null);
  
  // Pages that should not have sidebar and navbar
  if (isAuthPage || isHomePage || isErrorPage || is404Page) {
    return <>{children}</>;
  }
  
  // All other pages will have sidebar and navbar
  return (
    <>
      <Header />
      <div className="flex min-h-[calc(100vh-3rem)]">
        <Sidebar />
        <main className="flex-1 bg-gray-50">
          {children}
        </main>
      </div>
    </>
  );
}

export default function RootLayout({
  children,
}: {
  children: React.ReactNode;
}) {
  useEffect(() => {
    initializePerformanceOptimizations();
  }, []);

  return (
    <html lang="en">
      <head>
        <meta charSet="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <meta name="theme-color" content="#000000" />
        <link rel="icon" href="/favicon.ico" />
        <link rel="preconnect" href="https://fonts.googleapis.com" />
        <link rel="preconnect" href="https://fonts.gstatic.com" crossOrigin="anonymous" />
        <link href="https://fonts.googleapis.com/css2?family=Anton&family=Cascadia+Code:ital,wght@0,200..700;1,200..700&family=Inter:ital,opsz,wght@0,14..32,100..900;1,14..32,100..900&family=Roboto:ital,wdth,wght@0,75..100,100..900;1,75..100,100..900&display=swap" rel="stylesheet" />
      </head>
      <body className={inter.className}>
        <QueryClientProvider client={queryClient}>
          <ThemeProvider theme={theme}>
            <CssBaseline />
            <AuthProvider>
              <SettingsProvider>
                <LayoutWrapper>
                  {children}
                </LayoutWrapper>
                <Toaster position="top-right" />
              </SettingsProvider>
            </AuthProvider>
          </ThemeProvider>
        </QueryClientProvider>
      </body>
    </html>
  );
}