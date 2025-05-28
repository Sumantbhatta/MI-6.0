import { useEffect, useCallback, useRef } from 'react';

// Image optimization
export const optimizeImage = (url, width = 800, quality = 80) => {
  if (!url) return url;
  if (url.startsWith('data:')) return url;
  
  // Add width and quality parameters to image URL
  const separator = url.includes('?') ? '&' : '?';
  return `${url}${separator}w=${width}&q=${quality}`;
};

// Data caching
const CACHE_DURATION = 5 * 60 * 1000; // 5 minutes
const cache = new Map();

export const cacheData = (key, data) => {
  cache.set(key, {
    data,
    timestamp: Date.now()
  });
};

export const getCachedData = (key) => {
  const cached = cache.get(key);
  if (!cached) return null;
  
  if (Date.now() - cached.timestamp > CACHE_DURATION) {
    cache.delete(key);
    return null;
  }
  
  return cached.data;
};

// Resource preloading
export const preloadResources = (resources) => {
  resources.forEach(resource => {
    const link = document.createElement('link');
    link.rel = 'preload';
    link.as = resource.type;
    link.href = resource.url;
    document.head.appendChild(link);
  });
};

// Debounce function
export const debounce = (func, wait) => {
  let timeout;
  return function executedFunction(...args) {
    const later = () => {
      clearTimeout(timeout);
      func(...args);
    };
    clearTimeout(timeout);
    timeout = setTimeout(later, wait);
  };
};

// Throttle function
export const throttle = (func, limit) => {
  let inThrottle;
  return function executedFunction(...args) {
    if (!inThrottle) {
      func(...args);
      inThrottle = true;
      setTimeout(() => inThrottle = false, limit);
    }
  };
};

// React hooks for performance optimization
export const useLazyImage = (src) => {
  const imgRef = useRef(null);
  
  useEffect(() => {
    const observer = new IntersectionObserver(
      (entries) => {
        entries.forEach(entry => {
          if (entry.isIntersecting) {
            const img = entry.target;
            img.src = src;
            observer.unobserve(img);
          }
        });
      },
      { threshold: 0.1 }
    );
    
    if (imgRef.current) {
      observer.observe(imgRef.current);
    }
    
    return () => observer.disconnect();
  }, [src]);
  
  return imgRef;
};

export const useMemoizedCallback = (callback, deps) => {
  return useCallback(callback, deps);
};

export const useScrollOptimization = (callback, options = {}) => {
  const { throttleMs = 100 } = options;
  
  useEffect(() => {
    const throttledCallback = throttle(callback, throttleMs);
    window.addEventListener('scroll', throttledCallback);
    return () => window.removeEventListener('scroll', throttledCallback);
  }, [callback, throttleMs]);
};

// Service worker registration
export const registerServiceWorker = async () => {
  if ('serviceWorker' in navigator) {
    try {
      const registration = await navigator.serviceWorker.register('/sw.js');
      console.log('Service Worker registered:', registration);
    } catch (error) {
      console.error('Service Worker registration failed:', error);
    }
  }
};

// Resource hints
export const addResourceHints = () => {
  const hints = [
    { rel: 'preconnect', href: 'https://api.example.com' },
    { rel: 'dns-prefetch', href: 'https://api.example.com' }
  ];
  
  hints.forEach(hint => {
    const link = document.createElement('link');
    link.rel = hint.rel;
    link.href = hint.href;
    document.head.appendChild(link);
  });
};

// Initialize performance optimizations
export const initializePerformanceOptimizations = () => {
  registerServiceWorker();
  addResourceHints();
  
  // Preload critical resources
  preloadResources([
    { url: '/assets/yellowLogo.png', type: 'image' },
    { url: '/assets/mainBgg.png', type: 'image' }
  ]);
}; 