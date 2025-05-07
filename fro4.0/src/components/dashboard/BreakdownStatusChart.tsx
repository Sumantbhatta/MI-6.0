import React from 'react';
import { BarChart } from '@/components/ui/charts';

interface BreakdownStatusChartProps {
  incidents: { status: string }[];
}

const statusColors: Record<string, string> = {
  OPEN: '#ef4444',
  IN_PROGRESS: '#eab308',
  CLOSED: '#22c55e',
  RESOLVED: '#0ea5e9',
};

const BreakdownStatusChart: React.FC<BreakdownStatusChartProps> = ({ incidents }) => {
  const statusCounts = incidents.reduce((acc, incident) => {
    acc[incident.status] = (acc[incident.status] || 0) + 1;
    return acc;
  }, {} as Record<string, number>);

  const data = Object.keys(statusCounts).map((status) => ({
    status,
    count: statusCounts[status],
  }));

  return (
    <BarChart
      data={data}
      index="status"
      categories={["count"]}
      colors={Object.keys(statusCounts).map((status) => statusColors[status] || '#0ea5e9')}
      valueFormatter={(v) => `${v}`}
    />
  );
};

export default BreakdownStatusChart;
