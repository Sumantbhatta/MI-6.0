import React from 'react';
import { PieChart, Pie, Cell, Legend, ResponsiveContainer, Tooltip } from 'recharts';

interface IncidentTypesPieChartProps {
  incidents: Array<{ incidentType?: string }>;
}

const COLORS = ['#ef4444', '#eab308', '#3b82f6', '#a855f7', '#22c55e'];

const IncidentTypesPieChart: React.FC<IncidentTypesPieChartProps> = ({ incidents }) => {
  const counts: Record<string, number> = {};
  incidents.forEach(inc => {
    const type = inc.incidentType || 'Unknown';
    counts[type] = (counts[type] || 0) + 1;
  });
  const data = Object.keys(counts).map((key) => ({ name: key, value: counts[key] }));
  return (
    <div className="w-full h-72 flex flex-col items-center justify-center">
      <h2 className="text-xl font-bold mb-2">Incident Types</h2>
      <div className="text-muted-foreground mb-4">Breakdown by category</div>
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

export default IncidentTypesPieChart;
