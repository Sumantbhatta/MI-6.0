import React from 'react';

interface FinancialStatCardProps {
  title: string;
  value: string | number;
  icon: React.ReactNode;
  bgClass?: string;
}

const FinancialStatCard: React.FC<FinancialStatCardProps> = ({ title, value, icon, bgClass = 'bg-white' }) => (
  <div className={`rounded-2xl border p-6 min-w-[220px] ${bgClass} flex flex-col gap-2 shadow-sm`}
       style={{ boxShadow: '0 2px 8px 0 rgba(0,0,0,0.02)' }}>
    <div className="flex items-center justify-between mb-2">
      <span className="text-xs font-semibold uppercase text-gray-500 tracking-wide">{title}</span>
      <span className="text-2xl text-gray-300">{icon}</span>
    </div>
    <div className="flex items-end gap-2">
      <span className="text-3xl font-bold text-gray-900">{value}</span>
    </div>
  </div>
);

export default FinancialStatCard;
