import React from 'react';
import { Card, CardContent } from '@/components/ui/card';

import { ArrowUpRight, ArrowDownRight } from 'lucide-react';

interface StatCardProps {
  title: string;
  value: string | number;
  icon?: React.ReactNode;
  colorClass?: string;
  delta?: number; // change since last period
  deltaLabel?: string; // e.g., "since last month"
  subtitle?: string;
}

const StatCard: React.FC<StatCardProps> = ({
  title,
  value,
  icon,
  colorClass = 'bg-primary/10',
  delta,
  deltaLabel = '',
  subtitle = '',
}) => {
  let deltaColor = 'text-green-600';
  let DeltaIcon = ArrowUpRight;
  if (typeof delta === 'number' && delta < 0) {
    deltaColor = 'text-red-600';
    DeltaIcon = ArrowDownRight;
  }
  return (
    <Card className={`flex flex-col justify-between p-5 h-32 min-w-[170px] ${colorClass}`}>
      <div className="flex flex-row items-center gap-4">
        {icon && <div className="rounded-full p-3 bg-primary/20 text-primary">{icon}</div>}
        <div className="flex-1">
          <div className="text-xs text-muted-foreground font-semibold uppercase tracking-wide">{title}</div>
          <div className="text-3xl font-bold text-foreground leading-tight">{value}</div>
        </div>
      </div>
      <div className="flex items-center gap-2 mt-2">
        {typeof delta === 'number' && (
          <span className={`flex items-center text-xs font-medium ${deltaColor}`}>
            <DeltaIcon className="h-4 w-4 mr-1" />
            {delta > 0 ? '+' : ''}{delta}
          </span>
        )}
        {deltaLabel && <span className="text-xs text-muted-foreground ml-1">{deltaLabel}</span>}
        {subtitle && <span className="text-xs text-muted-foreground ml-1">{subtitle}</span>}
      </div>
    </Card>
  );
};

export default StatCard;
