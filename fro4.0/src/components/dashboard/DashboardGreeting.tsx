import React from 'react';
import { CalendarDays, FileText, Bell, ChevronDown } from 'lucide-react';

interface DashboardGreetingProps {
  userName?: string;
  date?: Date;
}

export default function DashboardGreeting({ userName = 'Admin User', date = new Date() }: DashboardGreetingProps) {
  // Get greeting based on time of day
  const getGreeting = () => {
    const hour = date.getHours();
    if (hour < 12) return 'Good morning';
    if (hour < 17) return 'Good afternoon';
    return 'Good evening';
  };

  const formattedDate = date.toLocaleDateString('en-US', {
    weekday: 'long',
    year: 'numeric',
    month: 'long',
    day: 'numeric',
  });

  return (
    <div className="bg-gradient-to-r from-blue-50 to-indigo-50 rounded-2xl p-6 mb-6 shadow-sm border border-blue-100">
      <div className="flex flex-col md:flex-row md:items-center justify-between gap-4">
        <div>
          <h2 className="text-3xl font-bold text-gray-800 flex items-center gap-2">
            <span className="bg-blue-600 w-2 h-8 rounded-full inline-block mr-2"></span>
            Welcome to Your Dashboard
          </h2>
          <div className="text-gray-600 mt-2 text-lg font-medium">
            {getGreeting()}, <span className="text-blue-600 font-semibold">{userName}</span>! Here's your operational overview.
          </div>
        </div>
        <div className="flex items-center gap-3 flex-wrap md:flex-nowrap">
          <div className="flex items-center gap-2 px-4 py-2 rounded-lg bg-white border shadow-sm">
            <CalendarDays className="h-5 w-5 text-blue-600" />
            <span className="text-sm font-medium text-gray-700">{formattedDate}</span>
          </div>
          <button className="inline-flex items-center gap-2 px-4 py-2 bg-blue-600 text-white rounded-lg hover:bg-blue-700 transition shadow-sm">
            <FileText className="h-5 w-5" />
            <span>Reports</span>
            <ChevronDown className="h-4 w-4" />
          </button>
          <button className="relative p-2 bg-white text-gray-700 rounded-full hover:bg-gray-100 transition shadow-sm border">
            <Bell className="h-5 w-5" />
            <span className="absolute -top-1 -right-1 bg-red-500 text-white text-xs rounded-full w-5 h-5 flex items-center justify-center">3</span>
          </button>
        </div>
      </div>
    </div>
  );
}
