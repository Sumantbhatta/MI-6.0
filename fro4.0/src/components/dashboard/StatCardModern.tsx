import React from 'react';

interface StatCardModernProps {
  title: string;
  value: string | number;
  icon: React.ReactNode;
  change?: number;
  changeType?: 'increase' | 'decrease' | 'neutral';
  subtext?: string;
  colorClass?: string;
  accentColor?: string;
}

const StatCardModern: React.FC<StatCardModernProps> = ({
  title,
  value,
  icon,
  change,
  changeType = 'neutral',
  subtext,
  colorClass = 'bg-white',
  accentColor,
}) => {
  // Determine colors based on change type
  const changeColor =
    changeType === 'increase'
      ? 'text-emerald-600'
      : changeType === 'decrease'
      ? 'text-rose-600'
      : 'text-gray-500';
  
  const iconBgColor = {
    'bg-orange-50': 'bg-orange-100 text-orange-600',
    'bg-blue-50': 'bg-blue-100 text-blue-600',
    'bg-green-50': 'bg-green-100 text-green-600',
    'bg-red-50': 'bg-red-100 text-rose-600',
    'bg-yellow-50': 'bg-amber-100 text-amber-600',
    'bg-purple-50': 'bg-purple-100 text-purple-600',
  }[colorClass] || 'bg-gray-100 text-gray-600';

  const changeIcon =
    changeType === 'increase' ? '↑' : changeType === 'decrease' ? '↓' : '•';

  return (
    <div className={`rounded-2xl shadow-sm border p-5 flex flex-col gap-2 min-w-[180px] transition-all duration-200 hover:shadow-md ${colorClass}`}>
      <div className="flex items-center justify-between mb-2">
        <div className="flex items-center gap-3">
          <div className={`p-2.5 rounded-xl ${iconBgColor}`}>
            {icon}
          </div>
          <span className="text-sm font-semibold text-gray-700">{title}</span>
        </div>
      </div>
      <div className="flex items-end gap-2">
        <span className="text-3xl font-bold text-gray-900">{value}</span>
      </div>
      {(change !== undefined) && (
        <div className="flex items-center justify-between mt-1">
          <span className={`text-xs font-medium flex items-center gap-1 ${changeColor} bg-opacity-20 px-2 py-1 rounded-full`}>
            <span className="font-bold">{changeIcon}</span> {change}%
          </span>
          {subtext && <span className="text-xs text-gray-500">{subtext}</span>}
        </div>
      )}
    </div>
  );
};

export default StatCardModern;
