'use client';

import { Button } from '@/components/ui/button';
import { Avatar, AvatarFallback, AvatarImage } from '@/components/ui/avatar';
import { Bell, Settings, User, LogOut } from 'lucide-react';
import {
  DropdownMenu,
  DropdownMenuContent,
  DropdownMenuItem,
  DropdownMenuSeparator,
  DropdownMenuTrigger,
} from '@/components/ui/dropdown-menu';
import { useRouter } from 'next/navigation';
import { useAuth } from '@/contexts/AuthContext';

export default function TopNavBar() {
  const router = useRouter();
  const { user, logout } = useAuth();
  
  // Default user data to prevent null errors
  const defaultUser = {
    name: 'Guest',
    avatar: 'https://ui-avatars.com/api/?name=Guest'
  };

  return (
    <header className="sticky top-0 z-40 w-full border-b bg-gradient-to-r from-white via-blue-50/50 to-white h-12 flex items-center justify-between shadow-sm relative overflow-hidden">
      {/* Decorative Background Elements */}
      <div className="absolute inset-0 overflow-hidden pointer-events-none">
        <div className="absolute top-0 right-0 w-32 h-32 bg-blue-200/10 rounded-full blur-2xl" />
        <div className="absolute top-0 left-0 w-24 h-24 bg-indigo-200/10 rounded-full blur-2xl" />
      </div>

      <div className="w-[220px] flex items-center px-4 font-semibold relative z-10">
        <div className="h-6 w-6 rounded-full bg-gradient-to-br from-blue-500 to-indigo-600 animate-pulse" />
      </div>

      <div className="flex items-center gap-3 pr-6 relative z-10">
        {/* Notification Button with Animation */}
        <Button 
          variant="ghost" 
          size="icon"
          className="relative group hover:bg-blue-50/50 transition-all duration-300"
        >
          <Bell className="h-5 w-5 text-gray-600 group-hover:text-blue-600 transition-colors duration-300" />
          <span className="absolute -top-1 -right-1 h-4 w-4 bg-red-500 rounded-full border-2 border-white animate-pulse" />
        </Button>

        {/* User Menu with Enhanced Design */}
        <DropdownMenu>
          <DropdownMenuTrigger asChild>
            <Button 
              variant="ghost" 
              size="icon" 
              className="p-0 hover:bg-blue-50/50 transition-all duration-300"
            >
              <div className="relative">
                <Avatar className="h-8 w-8 border-2 border-blue-200 shadow-md transition-all duration-300 hover:border-blue-400">
                  <AvatarImage 
                    src={user?.avatar || defaultUser.avatar} 
                    alt={user?.name || defaultUser.name}
                    className="transition-transform duration-300 hover:scale-110"
                  />
                  <AvatarFallback className="bg-gradient-to-br from-blue-500 to-indigo-600 text-white">
                    {(user?.name || defaultUser.name)[0]}
                  </AvatarFallback>
                </Avatar>
                <div className="absolute -bottom-1 -right-1 h-3 w-3 bg-green-500 rounded-full border-2 border-white" />
              </div>
            </Button>
          </DropdownMenuTrigger>
          <DropdownMenuContent 
            align="end" 
            className="w-48 mt-2 p-2 bg-white/80 backdrop-blur-sm border border-blue-100/50 shadow-lg"
          >
            <DropdownMenuItem 
              onClick={() => router.push('/profile')}
              className="flex items-center gap-2 p-2 rounded-md hover:bg-blue-50/50 cursor-pointer transition-colors duration-300"
            >
              <User className="h-4 w-4 text-blue-600" />
              <span>Profile</span>
            </DropdownMenuItem>
            <DropdownMenuItem 
              onClick={() => router.push('/settings')}
              className="flex items-center gap-2 p-2 rounded-md hover:bg-blue-50/50 cursor-pointer transition-colors duration-300"
            >
              <Settings className="h-4 w-4 text-blue-600" />
              <span>Settings</span>
            </DropdownMenuItem>
            <DropdownMenuSeparator className="bg-blue-100/50" />
            <DropdownMenuItem 
              onClick={logout}
              className="flex items-center gap-2 p-2 rounded-md hover:bg-red-50/50 cursor-pointer transition-colors duration-300 text-red-600"
            >
              <LogOut className="h-4 w-4" />
              <span>Logout</span>
            </DropdownMenuItem>
          </DropdownMenuContent>
        </DropdownMenu>
      </div>
    </header>
  );
}

