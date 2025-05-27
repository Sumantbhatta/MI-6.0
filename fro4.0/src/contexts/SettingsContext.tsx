'use client';

import React, { createContext, useContext, useState, useEffect } from 'react';

interface Settings {
  notifications: {
    email: boolean;
    push: boolean;
    sms: boolean;
    weekly: boolean;
    marketing: boolean;
  };
  appearance: {
    darkMode: boolean;
    compactView: boolean;
  };
}

interface SettingsContextType {
  settings: Settings;
  updateNotificationSettings: (key: keyof Settings['notifications'], value: boolean) => void;
  updateAppearanceSettings: (key: keyof Settings['appearance'], value: boolean) => void;
  toggleDarkMode: () => void;
}

const defaultSettings: Settings = {
  notifications: {
    email: true,
    push: false,
    sms: false,
    weekly: true,
    marketing: false
  },
  appearance: {
    darkMode: false,
    compactView: true
  }
};

const SettingsContext = createContext<SettingsContextType | undefined>(undefined);

export function SettingsProvider({ children }: { children: React.ReactNode }) {
  const [settings, setSettings] = useState<Settings>(() => {
    // Load settings from localStorage on initial load
    if (typeof window !== 'undefined') {
      const savedSettings = localStorage.getItem('appSettings');
      if (savedSettings) {
        return JSON.parse(savedSettings);
      }
    }
    return defaultSettings;
  });

  // Apply dark mode class to document
  useEffect(() => {
    if (settings.appearance.darkMode) {
      document.documentElement.classList.add('dark');
    } else {
      document.documentElement.classList.remove('dark');
    }
  }, [settings.appearance.darkMode]);

  // Apply compact view class
  useEffect(() => {
    if (settings.appearance.compactView) {
      document.documentElement.classList.add('compact-view');
    } else {
      document.documentElement.classList.remove('compact-view');
    }
  }, [settings.appearance.compactView]);

  // Save settings to localStorage whenever they change
  useEffect(() => {
    localStorage.setItem('appSettings', JSON.stringify(settings));
  }, [settings]);

  const updateNotificationSettings = (key: keyof Settings['notifications'], value: boolean) => {
    setSettings(prev => ({
      ...prev,
      notifications: {
        ...prev.notifications,
        [key]: value
      }
    }));
  };

  const updateAppearanceSettings = (key: keyof Settings['appearance'], value: boolean) => {
    setSettings(prev => ({
      ...prev,
      appearance: {
        ...prev.appearance,
        [key]: value
      }
    }));
  };

  const toggleDarkMode = () => {
    setSettings(prev => ({
      ...prev,
      appearance: {
        ...prev.appearance,
        darkMode: !prev.appearance.darkMode
      }
    }));
  };

  return (
    <SettingsContext.Provider value={{
      settings,
      updateNotificationSettings,
      updateAppearanceSettings,
      toggleDarkMode
    }}>
      {children}
    </SettingsContext.Provider>
  );
}

export function useSettings() {
  const context = useContext(SettingsContext);
  if (context === undefined) {
    throw new Error('useSettings must be used within a SettingsProvider');
  }
  return context;
} 