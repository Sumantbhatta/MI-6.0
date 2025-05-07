import React from 'react';
import { PieChart, Pie, Cell, ResponsiveContainer, Legend, Tooltip } from 'recharts';

interface BudgetItem {
  name: string;
  value: number;
}

interface BudgetAllocationChartProps {
  data?: BudgetItem[];
}

const COLORS = ['#a78bfa', '#fbbf24', '#6366f1', '#6ee7b7', '#f43f5e'];

const BudgetAllocationChart: React.FC<BudgetAllocationChartProps> = ({ data = [] }) => {
  // Use provided data or fallback to empty array
  const chartData = data.length > 0 ? data : [
    { name: 'Materials', value: 0 },
    { name: 'Petty Cash', value: 0 },
    { name: 'Maintenance', value: 0 },
    { name: 'Overtime', value: 0 },
  ];

  const totalBudget = chartData.reduce((sum, item) => sum + item.value, 0);

  if (totalBudget === 0) {
    return (
      <div className="flex flex-col items-center justify-center h-full text-muted-foreground">
        <span className="text-lg">No budget data available</span>
      </div>
    );
  }

  return (
    <ResponsiveContainer width="100%" height={300}>
      <PieChart>
        <Pie
          data={chartData}
          cx="50%"
          cy="50%"
          labelLine={false}
          outerRadius={80}
          fill="#8884d8"
          dataKey="value"
          label={({ name, percent }) => `${name}: ${(percent * 100).toFixed(0)}%`}
        >
          {chartData.map((entry, index) => (
            <Cell key={`cell-${index}`} fill={COLORS[index % COLORS.length]} />
          ))}
        </Pie>
        <Tooltip formatter={(value) => `₹${value.toLocaleString()}`} />
        <Legend />
      </PieChart>
    </ResponsiveContainer>
  );
};

export default BudgetAllocationChart;
