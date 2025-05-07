import React from 'react';
import { PieChart, Pie, Cell, Legend, ResponsiveContainer, Tooltip } from 'recharts';

interface EquipmentStatusChartProps {
  equipment: Array<{ status?: string }>;
}

const STATUS_COLORS = ['#22c55e', '#3b82f6', '#eab308', '#ef4444', '#64748b'];

const EquipmentStatusChart: React.FC<EquipmentStatusChartProps> = ({ equipment }) => {
  const counts: Record<string, number> = {};
  equipment.forEach(eq => {
    const status = eq.status || 'Unknown';
    counts[status] = (counts[status] || 0) + 1;
  });
  const data = Object.keys(counts).map((key) => ({ name: key, value: counts[key] }));
  return (
    <div className="w-full h-72 flex flex-col items-center justify-center">
      <h2 className="text-xl font-bold mb-2">Equipment Status</h2>
      <div className="text-muted-foreground mb-4">Current operational status</div>
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
                <Cell key={`cell-${idx}`} fill={STATUS_COLORS[idx % STATUS_COLORS.length]} />
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

export default EquipmentStatusChart;
