import React, { useEffect, useState } from 'react';
import { motion } from 'framer-motion';

const SplashScreen = ({ onLoadingComplete }) => {
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    // Simulate loading time and check if all resources are loaded
    const checkLoading = async () => {
      try {
        // Wait for all images to load
        const images = document.querySelectorAll('img');
        await Promise.all(
          Array.from(images).map(
            (img) =>
              new Promise((resolve) => {
                if (img.complete) resolve();
                else img.onload = resolve;
              })
          )
        );

        // Add a minimum loading time of 2 seconds
        await new Promise((resolve) => setTimeout(resolve, 2000));
        
        setLoading(false);
        onLoadingComplete();
      } catch (error) {
        console.error('Error loading resources:', error);
        setLoading(false);
        onLoadingComplete();
      }
    };

    checkLoading();
  }, [onLoadingComplete]);

  if (!loading) return null;

  return (
    <motion.div
      initial={{ opacity: 1 }}
      exit={{ opacity: 0 }}
      className="fixed inset-0 z-50 flex items-center justify-center bg-primary"
    >
      <div className="text-center">
        <motion.div
          initial={{ scale: 0.8, opacity: 0 }}
          animate={{ scale: 1, opacity: 1 }}
          transition={{ duration: 0.5 }}
          className="mb-8"
        >
          <img
            src="/assets/yellowLogo.png"
            alt="Logo"
            className="w-24 h-24 mx-auto animate-spin"
            style={{ animationDuration: '3s' }}
          />
        </motion.div>
        
        <motion.h1
          initial={{ y: 20, opacity: 0 }}
          animate={{ y: 0, opacity: 1 }}
          transition={{ delay: 0.2 }}
          className="text-4xl font-bold text-[#ffbd2b] mb-4"
        >
          RealEstatePro
        </motion.h1>

        <motion.div
          initial={{ width: 0 }}
          animate={{ width: "200px" }}
          transition={{ duration: 1, repeat: Infinity, repeatType: "reverse" }}
          className="h-1 bg-[#ffbd2b] mx-auto rounded-full"
        />

        <motion.p
          initial={{ opacity: 0 }}
          animate={{ opacity: 1 }}
          transition={{ delay: 0.4 }}
          className="text-white mt-4"
        >
          Loading your perfect collaborator...
        </motion.p>
      </div>
    </motion.div>
  );
};

export default SplashScreen; 