'use client';
import Link from 'next/link';
import { useEffect, useState } from 'react';

export default function NotFound() {
  const [showLoading, setShowLoading] = useState(true);

  useEffect(() => {
    const interval = setInterval(() => {
      setShowLoading((prev) => !prev);
    }, 4500);
    return () => clearInterval(interval);
  }, []);

  return (
    <div className="relative flex items-center justify-center min-h-screen w-full bg-white overflow-hidden" data-status="404">
      {/* Fullscreen Caveman GIF */}
      <img
        src="/images/caveman.gif"
        alt="Caveman Animation"
        className="absolute items-center bottom-[-120px] w-[1000px] h-[850px]  object-center "
        style={{ zIndex: 1 }}
      />
      {/* Overlay Content */}
      <div className="relative z-10 h-[90vh] flex flex-col items-center justify-between text-center px-4">
        <h1 className="text-4xl md:text-5xl font-extrabold text-yellow-400 mb-4 ">
          {showLoading ? 'This feature is loading…' : '404 error'}
        </h1>
        <Link href="/" legacyBehavior>
          <a className="inline-block px-8 py-4 bg-yellow-500 text-white rounded-full font-semibold shadow hover:bg-yellow-600 transition-all text-lg">Go to Homepage</a>
        </Link>
      </div>
      {/* Optional: dark overlay for better text contrast */}
      {/*<div className="absolute inset-0 bg-black/40" style={{ zIndex: 2 }} />*/}
    </div>
  );
}

