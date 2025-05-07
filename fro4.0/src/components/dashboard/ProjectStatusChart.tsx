import React from 'react';
import { BarChart } from '@/components/ui/charts';

interface ProjectStatusChartProps {
  projects: { status: string }[];
}

const statusColors: Record<string, string> = {
  COMPLETED: '#22c55e',
  IN_PROGRESS: '#eab308',
  PENDING: '#64748b',
};

const ProjectStatusChart: React.FC<ProjectStatusChartProps> = ({ projects }) => {
  const statusCounts = projects.reduce((acc, project) => {
    acc[project.status] = (acc[project.status] || 0) + 1;
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

export default ProjectStatusChart;
