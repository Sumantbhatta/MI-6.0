import React from 'react';
import { PieChart, Pie, Cell, Legend, ResponsiveContainer } from 'recharts';

interface ProjectProgressPieProps {
  data: { status: string; value: number }[];
}

const COLORS = ['#22c55e', '#3b82f6', '#eab308'];
const LABELS = ['Completed', 'In Progress', 'Planning'];

const ProjectProgressPie: React.FC<ProjectProgressPieProps> = ({ data }) => {
  return (
    <ResponsiveContainer width="100%" height={220}>
      <PieChart>
        <Pie
          data={data}
          dataKey="value"
          nameKey="status"
          cx="50%"
          cy="50%"
          outerRadius={70}
          label={({ percent, status }) => `${LABELS[status] || status} ${(percent * 100).toFixed(0)}%`}
        >
          {data.map((entry, idx) => (
            <Cell key={`cell-${idx}`} fill={COLORS[idx % COLORS.length]} />
          ))}
        </Pie>
        <Legend />
      </PieChart>
    </ResponsiveContainer>
  );
};

export default ProjectProgressPie;
