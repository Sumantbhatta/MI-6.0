'use client';

import { useState } from 'react';
import { Card, CardContent, CardDescription, CardFooter, CardHeader, CardTitle } from '@/components/ui/card';
import { Label } from '@/components/ui/label';
import { Button } from '@/components/ui/button';
import { Tabs, TabsContent, TabsList, TabsTrigger } from '@/components/ui/tabs';
import { Checkbox } from '@mui/material';

export default function SettingsPage() {
  const [notifications, setNotifications] = useState({
    email: true,
    push: false,
    sms: false,
    weekly: true,
    marketing: false
  });

  const [appearance, setAppearance] = useState({
    darkMode: false,
    compactView: true,
    highContrast: false
  });

  const handleNotificationChange = (key: keyof typeof notifications) => {
    setNotifications(prev => ({
      ...prev,
      [key]: !prev[key]
    }));
  };

  const handleAppearanceChange = (key: keyof typeof appearance) => {
    setAppearance(prev => ({
      ...prev,
      [key]: !prev[key]
    }));
  };

  return (
    <div className="container mx-auto py-10 bg-gradient-to-br from-blue-400 to-indigo-600">
      <h1 className="text-2xl font-bold mb-6">Settings</h1>
      
      <Tabs defaultValue="notifications" className="w-full">
        <TabsList className="grid w-full md:w-[400px] grid-cols-2">
          <TabsTrigger value="notifications ">Notifications</TabsTrigger>
          <TabsTrigger value="appearance">Appearance</TabsTrigger>
        </TabsList>
        
        <TabsContent value="notifications" className="mt-6">
          <Card>
            <CardHeader>
              <CardTitle>Notification Preferences</CardTitle>
              <CardDescription>
                Configure how you want to receive notifications
              </CardDescription>
            </CardHeader>
            <CardContent className="space-y-4">
              <div className="flex items-center justify-between">
                <Label htmlFor="email-notifications" className="flex flex-col space-y-1">
                  <span>Email Notifications</span>
                  <span className="text-sm text-gray-500">Receive notifications via email</span>
                </Label>
                <Checkbox 
                  id="email-notifications" 
                  checked={notifications.email} 
                  onChange={() => handleNotificationChange('email')} 
                />
              </div>
              
              <div className="flex items-center justify-between">
                <Label htmlFor="push-notifications" className="flex flex-col space-y-1">
                  <span>Push Notifications</span>
                  <span className="text-sm text-gray-500">Receive push notifications in browser</span>
                </Label>
                <Checkbox 
                  id="push-notifications" 
                  checked={notifications.push} 
                  onChange={() => handleNotificationChange('push')} 
                />
              </div>
              
              <div className="flex items-center justify-between">
                <Label htmlFor="sms-notifications" className="flex flex-col space-y-1">
                  <span>SMS Notifications</span>
                  <span className="text-sm text-gray-500">Receive notifications via SMS</span>
                </Label>
                <Checkbox 
                  id="sms-notifications" 
                  checked={notifications.sms} 
                  onChange={() => handleNotificationChange('sms')} 
                />
              </div>
              
              <div className="flex items-center justify-between">
                <Label htmlFor="weekly-digest" className="flex flex-col space-y-1">
                  <span>Weekly Digest</span>
                  <span className="text-sm text-gray-500">Receive a weekly summary</span>
                </Label>
                <Checkbox 
                  id="weekly-digest" 
                  checked={notifications.weekly} 
                  onChange={() => handleNotificationChange('weekly')} 
                />
              </div>
              
              <div className="flex items-center justify-between">
                <Label htmlFor="marketing-emails" className="flex flex-col space-y-1">
                  <span>Marketing Emails</span>
                  <span className="text-sm text-gray-500">Receive marketing and promotional emails</span>
                </Label>
                <Checkbox 
                  id="marketing-emails" 
                  checked={notifications.marketing} 
                  onChange={() => handleNotificationChange('marketing')} 
                />
              </div>
            </CardContent>
            <CardFooter>
              <Button>Save Notification Settings</Button>
            </CardFooter>
          </Card>
        </TabsContent>
        
        <TabsContent value="appearance" className="mt-6">
          <Card>
            <CardHeader>
              <CardTitle>Appearance Settings</CardTitle>
              <CardDescription>
                Customize how the application looks
              </CardDescription>
            </CardHeader>
            <CardContent className="space-y-4">
              <div className="flex items-center justify-between">
                <Label htmlFor="dark-mode" className="flex flex-col space-y-1">
                  <span>Dark Mode</span>
                  <span className="text-sm text-gray-500">Use dark color theme</span>
                </Label>
                <Checkbox 
                  id="dark-mode" 
                  checked={appearance.darkMode} 
                  onChange={() => handleAppearanceChange('darkMode')} 
                />
              </div>
              
              <div className="flex items-center justify-between">
                <Label htmlFor="compact-view" className="flex flex-col space-y-1">
                  <span>Compact View</span>
                  <span className="text-sm text-gray-500">Reduce spacing between elements</span>
                </Label>
                <Checkbox 
                  id="compact-view" 
                  checked={appearance.compactView} 
                  onChange={() => handleAppearanceChange('compactView')} 
                />
              </div>
              
              <div className="flex items-center justify-between">
                <Label htmlFor="high-contrast" className="flex flex-col space-y-1">
                  <span>High Contrast</span>
                  <span className="text-sm text-gray-500">Increase contrast for better visibility</span>
                </Label>
                <Checkbox 
                  id="high-contrast" 
                  checked={appearance.highContrast} 
                  onChange={() => handleAppearanceChange('highContrast')} 
                />
              </div>
            </CardContent>
            <CardFooter>
              <Button>Save Appearance Settings</Button>
            </CardFooter>
          </Card>
        </TabsContent>
      </Tabs>
    </div>
  );
}
