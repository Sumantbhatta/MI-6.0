'use client';

import { useState, useEffect } from 'react';
import { Card, CardContent, CardDescription, CardFooter, CardHeader, CardTitle } from '@/components/ui/card';
import { Input } from '@/components/ui/input';
import { Label } from '@/components/ui/label';
import { Button } from '@/components/ui/button';
import { Avatar, AvatarFallback, AvatarImage } from '@/components/ui/avatar';
import { useAuth } from '@/contexts/AuthContext';
import { emailService } from '@/services/emailService';
import { toast } from 'react-hot-toast';
import { useRouter } from 'next/navigation';

interface UserProfile {
  name: string;
  email: string;
  role: string;
  avatar: string;
  phone: string;
  department: string;
  email_confirmed_at?: string | null;
}

export default function ProfilePage() {
  const { user: authUser } = useAuth();
  const router = useRouter();
  
  // Initialize with default values that will be overridden
  const [user, setUser] = useState<UserProfile>({
    name: authUser?.name || 'User',
    email: authUser?.email || 'user@example.com',
    role: 'User',
    avatar: authUser?.avatar || 'https://ui-avatars.com/api/?name=User',
    phone: '+1 (555) 123-4567',
    department: 'General'
  });

  const [isEditing, setIsEditing] = useState(false);
  const [formData, setFormData] = useState<UserProfile>(user);
  const [isVerified, setIsVerified] = useState(false);
  const [otp, setOtp] = useState('');
  const [showOtpInput, setShowOtpInput] = useState(false);
  const [isLoading, setIsLoading] = useState(false);

  // Load user profile from localStorage on component mount
  useEffect(() => {
    const storedProfile = localStorage.getItem('userProfile');
    if (storedProfile) {
      try {
        const profileData = JSON.parse(storedProfile);
        // Make sure we have the latest name and email from auth
        if (authUser) {
          profileData.name = authUser.name;
          profileData.email = authUser.email;
          profileData.avatar = authUser.avatar;
        }
        setUser(profileData);
      } catch (error) {
        console.error('Failed to parse user profile from localStorage', error);
      }
    } else if (authUser) {
      // Initialize with auth user data if available
      setUser(prev => ({
        ...prev,
        name: authUser.name,
        email: authUser.email,
        avatar: authUser.avatar
      }));
    }
  }, [authUser]);

  useEffect(() => {
    // Reset form data when user data changes or when switching to edit mode
    setFormData(user);
  }, [user, isEditing]);

  useEffect(() => {
    // Check if user is verified
    if (user?.email_confirmed_at) {
      setIsVerified(true);
    }
  }, [user]);

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

  const handleSendOTP = async () => {
    if (!user?.email) return;
    
    setIsLoading(true);
    const { success, error } = await emailService.sendOTP(user.email);
    setIsLoading(false);

    if (success) {
      setShowOtpInput(true);
      toast.success('OTP sent to your email!');
    } else {
      toast.error(error || 'Failed to send OTP');
    }
  };

  const handleVerifyOTP = async () => {
    if (!user?.email || !otp) return;

    setIsLoading(true);
    const { success, error } = await emailService.verifyOTP(user.email, otp);
    setIsLoading(false);

    if (success) {
      setIsVerified(true);
      toast.success('Email verified successfully!');
      router.push('/dashboard');
    } else {
      toast.error(error || 'Invalid OTP');
    }
  };

  if (!user) {
    return <div>Loading...</div>;
  }

  return (
    <div className="container mx-auto py-10 bg-gradient-to-br from-blue-400 to-indigo-500">
      <h1 className="text-2xl font-bold mb-6">My Profile</h1>
      
      <div className="grid grid-cols-1 md:grid-cols-3 gap-6">
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
              <p className="text-sm text-gray-500">Department: {user.department}</p>
            </CardContent>
            <CardFooter className="flex justify-center">
              <Button variant="outline" onClick={() => setIsEditing(true)}>Edit Profile</Button>
            </CardFooter>
          </Card>
        </div>

        <div className="md:col-span-2">
          <Card>
            <CardHeader>
              <CardTitle>{isEditing ? 'Edit Profile Information' : 'Profile Information'}</CardTitle>
              <CardDescription>
                {isEditing 
                  ? 'Update your profile details below'
                  : 'View your profile information'}
              </CardDescription>
            </CardHeader>
            <form onSubmit={handleSubmit}>
              <CardContent className="space-y-4">
                <div className="space-y-2">
                  <Label htmlFor="name">Full Name</Label>
                  <Input 
                    id="name" 
                    name="name" 
                    value={formData.name} 
                    onChange={handleChange} 
                    disabled={!isEditing} 
                  />
                </div>

                <div className="space-y-2">
                  <Label htmlFor="email">Email</Label>
                  <Input 
                    id="email" 
                    name="email" 
                    type="email" 
                    value={formData.email} 
                    onChange={handleChange} 
                    disabled={!isEditing} 
                  />
                </div>

                <div className="space-y-2">
                  <Label htmlFor="phone">Phone</Label>
                  <Input 
                    id="phone" 
                    name="phone" 
                    value={formData.phone} 
                    onChange={handleChange} 
                    disabled={!isEditing} 
                  />
                </div>

                <div className="space-y-2">
                  <Label htmlFor="department">Department</Label>
                  <Input 
                    id="department" 
                    name="department" 
                    value={formData.department} 
                    onChange={handleChange} 
                    disabled={!isEditing} 
                  />
                </div>
              </CardContent>
              
              {isEditing && (
                <CardFooter className="flex justify-between">
                  <Button type="button" variant="outline" onClick={() => setIsEditing(false)}>Cancel</Button>
                  <Button type="submit">Save Changes</Button>
                </CardFooter>
              )}
            </form>
          </Card>
        </div>
      </div>

      {!isVerified && (
        <div className="mt-6">
          <Card>
            <CardHeader>
              <CardTitle>Email Verification</CardTitle>
              <CardDescription>
                Please verify your email to access the dashboard
              </CardDescription>
            </CardHeader>
            <CardContent className="space-y-4">
              {!showOtpInput ? (
                <Button 
                  onClick={handleSendOTP} 
                  disabled={isLoading}
                >
                  {isLoading ? 'Sending...' : 'Send Verification OTP'}
                </Button>
              ) : (
                <div className="space-y-4">
                  <div className="space-y-2">
                    <Label>Enter OTP</Label>
                    <Input
                      type="text"
                      value={otp}
                      onChange={(e) => setOtp(e.target.value)}
                      placeholder="Enter the OTP sent to your email"
                    />
                  </div>
                  <Button 
                    onClick={handleVerifyOTP}
                    disabled={isLoading || !otp}
                  >
                    {isLoading ? 'Verifying...' : 'Verify OTP'}
                  </Button>
                </div>
              )}
            </CardContent>
          </Card>
        </div>
      )}

      {isVerified && (
        <div className="mt-6 text-green-600">
          Email verified successfully!
        </div>
      )}
    </div>
  );
}
