'use client';

import { useState } from 'react';
import { Card, CardContent, CardDescription, CardFooter, CardHeader, CardTitle } from '@/components/ui/card';
import { Label } from '@/components/ui/label';
import { Button } from '@/components/ui/button';
import { Tabs, TabsContent, TabsList, TabsTrigger } from '@/components/ui/tabs';
import { Checkbox } from '@mui/material';
import { useSettings } from '@/contexts/SettingsContext';
import { toast } from 'react-hot-toast';

export default function SettingsPage() {
  const { settings, updateNotificationSettings, updateAppearanceSettings } = useSettings();
  const [isSaving, setIsSaving] = useState(false);

  const handleNotificationChange = (key: keyof typeof settings.notifications) => {
    updateNotificationSettings(key, !settings.notifications[key]);
  };

  const handleAppearanceChange = (key: keyof typeof settings.appearance) => {
    updateAppearanceSettings(key, !settings.appearance[key]);
  };

  const handleSaveSettings = async (type: 'notifications' | 'appearance') => {
    setIsSaving(true);
    try {
      // Simulate API call
      await new Promise(resolve => setTimeout(resolve, 1000));
      toast.success(`${type === 'notifications' ? 'Notification' : 'Appearance'} settings saved successfully!`);
    } catch (error) {
      toast.error('Failed to save settings. Please try again.');
    } finally {
      setIsSaving(false);
    }
  };

  return (
    <div className="container mx-auto py-10 bg-gradient-to-br from-blue-400 to-indigo-600">
      <h1 className="text-2xl font-bold mb-6">Settings</h1>
      
      <Tabs defaultValue="notifications" className="w-full">
        <TabsList className="grid w-full md:w-[400px] grid-cols-2">
          <TabsTrigger value="notifications">Notifications</TabsTrigger>
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
                  checked={settings.notifications.email} 
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
                  checked={settings.notifications.push} 
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
                  checked={settings.notifications.sms} 
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
                  checked={settings.notifications.weekly} 
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
                  checked={settings.notifications.marketing} 
                  onChange={() => handleNotificationChange('marketing')} 
                />
              </div>
            </CardContent>
            <CardFooter>
              <Button 
                onClick={() => handleSaveSettings('notifications')}
                disabled={isSaving}
              >
                {isSaving ? 'Saving...' : 'Save Notification Settings'}
              </Button>
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
                  checked={settings.appearance.darkMode} 
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
                  checked={settings.appearance.compactView} 
                  onChange={() => handleAppearanceChange('compactView')} 
                />
              </div>
            </CardContent>
            <CardFooter>
              <Button 
                onClick={() => handleSaveSettings('appearance')}
                disabled={isSaving}
              >
                {isSaving ? 'Saving...' : 'Save Appearance Settings'}
              </Button>
            </CardFooter>
          </Card>
        </TabsContent>
      </Tabs>
    </div>
  );
}
