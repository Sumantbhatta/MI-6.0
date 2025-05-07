import React from 'react';

interface FinancialStatusCardProps {
  title: string;
  value: string | number;
  subtitle: string;
  valueClass?: string;
  subtitleClass?: string;
  icon?: React.ReactNode;
}

const FinancialStatusCard: React.FC<FinancialStatusCardProps> = ({
  title,
  value,
  subtitle,
  valueClass = '',
  subtitleClass = '',
  icon,
}) => (
  <div className="rounded-2xl border bg-white p-6 flex flex-col items-center justify-center min-w-[220px] shadow-sm">
    <div className="text-lg font-semibold text-gray-900 mb-1 flex items-center gap-2">
      {title} {icon && <span className="text-xl text-gray-300">{icon}</span>}
    </div>
    <div className={`text-4xl font-bold mb-1 ${valueClass}`}>{value}</div>
    <div className={`text-sm mt-1 ${subtitleClass}`}>{subtitle}</div>
  </div>
);

export default FinancialStatusCard;
