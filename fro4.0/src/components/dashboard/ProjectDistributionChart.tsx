import React from 'react';
import { PieChart, Pie, Cell, Legend, ResponsiveContainer, Tooltip } from 'recharts';

interface ProjectDistributionChartProps {
  projects: Array<{
    id: string | number;
    type?: string;
    location?: string;
  }>;
  by?: 'type' | 'location';
}

const COLORS = ['#3b82f6', '#f59e42', '#22c55e', '#eab308', '#a855f7', '#ef4444', '#06b6d4'];

const ProjectDistributionChart: React.FC<ProjectDistributionChartProps> = ({ projects, by = 'type' }) => {
  const counts: Record<string, number> = {};
  projects.forEach(p => {
    const key = (by === 'type' ? p.type : p.location) || 'Unknown';
    counts[key] = (counts[key] || 0) + 1;
  });
  const data = Object.keys(counts).map((key) => ({ name: key, value: counts[key] }));
  return (
    <div className="w-full h-72 flex flex-col items-center justify-center">
      <h2 className="text-xl font-bold mb-2">Project Distribution</h2>
      <div className="text-muted-foreground mb-4">Projects by {by}</div>
      {data.length === 0 ? (
        <div className="text-gray-400">No data</div>
      ) : (
        <ResponsiveContainer width="100%" height={220}>
          <PieChart>
            <Pie
              data={data}
              dataKey="value"
              nameKey="name"
              cx="50%"
              cy="50%"
              outerRadius={70}
              label={({ name, percent }) => `${name} ${(percent * 100).toFixed(0)}%`}
            >
              {data.map((entry, idx) => (
                <Cell key={`cell-${idx}`} fill={COLORS[idx % COLORS.length]} />
              ))}
            </Pie>
            <Tooltip />
            <Legend />
          </PieChart>
        </ResponsiveContainer>
      )}
    </div>
  );
};

export default ProjectDistributionChart;
