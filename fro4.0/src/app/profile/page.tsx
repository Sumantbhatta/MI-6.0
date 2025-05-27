'use client';

import { useState, useEffect } from 'react';
import { Card, CardContent, CardDescription, CardFooter, CardHeader, CardTitle } from '@/components/ui/card';
import { Input } from '@/components/ui/input';
import { Label } from '@/components/ui/label';
import { Button } from '@/components/ui/button';
import { Avatar, AvatarFallback, AvatarImage } from '@/components/ui/avatar';
import { useAuth } from '@/contexts/AuthContext';
import { Badge } from '@mui/material';

interface UserProfile {
  name: string;
  email: string;
  role: string;
  avatar: string;
  phone: string;
  department?: string;
}

export default function ProfilePage() {
  const { user: authUser } = useAuth();
  
  // Simulate new order approvals for admin
  const [newApprovals, setNewApprovals] = useState(2); // Example: 2 new orders

  // Initialize with default values that will be overridden
  const [user, setUser] = useState<UserProfile>({
    name: authUser?.name || 'User',
    email: authUser?.email || 'user@example.com',
    role: authUser?.role || 'User',
    avatar: authUser?.avatar || 'https://ui-avatars.com/api/?name=User',
    phone: '+1 (555) 123-4567',
    department: authUser?.role === 'User' ? 'General' : undefined
  });

  const [isEditing, setIsEditing] = useState(false);
  const [formData, setFormData] = useState<UserProfile>(user);

  // Load user profile from localStorage on component mount
  useEffect(() => {
    const storedProfile = localStorage.getItem('userProfile');
    if (storedProfile) {
      try {
        const profileData = JSON.parse(storedProfile);
        if (authUser) {
          profileData.name = authUser.name;
          profileData.email = authUser.email;
          profileData.avatar = authUser.avatar;
          profileData.role = authUser.role;
        }
        setUser(profileData);
      } catch (error) {
        console.error('Failed to parse user profile from localStorage', error);
      }
    } else if (authUser) {
      setUser(prev => ({
        ...prev,
        name: authUser.name,
        email: authUser.email,
        avatar: authUser.avatar,
        role: authUser.role,
        department: authUser.role === 'User' ? 'General' : undefined
      }));
    }
  }, [authUser]);

  useEffect(() => {
    // Reset form data when user data changes or when switching to edit mode
    setFormData(user);
  }, [user, isEditing]);

  const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    const { name, value } = e.target;
    setFormData(prev => ({
      ...prev,
      [name]: value
    }));
  };

  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault();
    // Save the updated profile
    setUser(formData);
    // Store in localStorage for persistence
    localStorage.setItem('userProfile', JSON.stringify(formData));
    setIsEditing(false);
  };

  return (
    <div className="container mx-auto py-10">
      <div className="grid grid-cols-1 md:grid-cols-3 gap-6">
        {/* Profile Card */}
        <div className="md:col-span-1">
          <Card>
            <CardHeader className="flex flex-col items-center">
              <Avatar className="h-24 w-24 mb-4">
                <AvatarImage src={user.avatar} alt={user.name} />
                <AvatarFallback>{user.name?.[0] || 'U'}</AvatarFallback>
              </Avatar>
              <CardTitle>{user.name}</CardTitle>
              <CardDescription>{user.role}</CardDescription>
            </CardHeader>
            <CardContent className="text-center">
              <p className="text-sm text-gray-500 mb-2">{user.email}</p>
              <p className="text-sm text-gray-500 mb-2">{user.phone}</p>
              {user.role === 'User' && (
                <p className="text-sm text-gray-500">Department: {user.department}</p>
              )}
            </CardContent>
            <CardFooter className="flex justify-center">
              <Button variant="outline" onClick={() => setIsEditing(true)}>Edit Profile</Button>
            </CardFooter>
          </Card>
        </div>

        {/* Main Content */}
        <div className="md:col-span-2 flex flex-col gap-6">
          <Card className="mb-4">
            <CardHeader>
              <CardTitle>Welcome {user.role === 'Admin' ? 'Admin' : user.name},</CardTitle>
              <CardDescription>Have a nice day</CardDescription>
            </CardHeader>
            <CardContent className="flex items-center gap-8">
              {/* Simple clock illustration */}
              <div className="flex flex-col items-center">
                <svg width="80" height="80" viewBox="0 0 80 80">
                  <circle cx="40" cy="40" r="38" stroke="#bbb" strokeWidth="2" fill="#f9f9f9" />
                  <line x1="40" y1="40" x2="40" y2="20" stroke="#333" strokeWidth="2" />
                  <line x1="40" y1="40" x2="60" y2="40" stroke="#e53e3e" strokeWidth="2" />
                  <circle cx="40" cy="40" r="2" fill="#333" />
                </svg>
              </div>
              {user.role === 'Admin' && (
                <div className="ml-8">
                  <Card className="shadow-md">
                    <CardHeader>
                      <CardTitle>Orders</CardTitle>
                      <CardDescription>Here you can make a new Order and print invoices</CardDescription>
                    </CardHeader>
                    <CardContent>
                      <Badge color="error" badgeContent={newApprovals} invisible={newApprovals === 0}>
                        <Button variant="default">New Order</Button>
                      </Badge>
                      {newApprovals > 0 && (
                        <p className="text-xs text-red-600 mt-2">{newApprovals} new order approvals!</p>
                      )}
                    </CardContent>
                  </Card>
                </div>
              )}
            </CardContent>
          </Card>

          {/* For user, show department and details */}
          {user.role === 'User' && (
            <div className="grid grid-cols-1 md:grid-cols-2 gap-4">
              <Card>
                <CardHeader>
                  <CardTitle>Department</CardTitle>
                </CardHeader>
                <CardContent>
                  <p>{user.department}</p>
                </CardContent>
              </Card>
              <Card>
                <CardHeader>
                  <CardTitle>Contact Details</CardTitle>
                </CardHeader>
                <CardContent>
                  <p>Email: {user.email}</p>
                  <p>Phone: {user.phone}</p>
                </CardContent>
              </Card>
            </div>
          )}
        </div>
      </div>
    </div>
  );
}
