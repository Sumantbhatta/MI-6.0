import React from 'react';
import { BarChart, ResponsiveContainer, Bar, XAxis, YAxis, Tooltip, Legend } from 'recharts';

interface FinancialData {
  month: string;
  [key: string]: string | number;
}

interface FinancialOverviewChartProps {
  data?: FinancialData[];
}

const COLORS = {
  'Materials': '#a78bfa', // purple
  'Petty Cash': '#fbbf24', // orange
  'Maintenance': '#6366f1', // blue
  'Overtime': '#6ee7b7', // green
};

const FinancialOverviewChart: React.FC<FinancialOverviewChartProps> = ({ data = [] }) => {
  // Use provided data or fallback to empty array
  const chartData = data.length > 0 ? data : [
    { month: 'Jan', 'Materials': 0, 'Petty Cash': 0, 'Maintenance': 0 },
    { month: 'Feb', 'Materials': 0, 'Petty Cash': 0, 'Maintenance': 0 },
    { month: 'Mar', 'Materials': 0, 'Petty Cash': 0, 'Maintenance': 0 },
    { month: 'Apr', 'Materials': 0, 'Petty Cash': 0, 'Maintenance': 0 },
    { month: 'May', 'Materials': 0, 'Petty Cash': 0, 'Maintenance': 0 },
    { month: 'Jun', 'Materials': 0, 'Petty Cash': 0, 'Maintenance': 0 },
  ];
  
  return (
  <ResponsiveContainer width="100%" height={300}>
    <BarChart data={chartData} stackOffset="sign">
      <XAxis dataKey="month" />
      <YAxis />
      <Tooltip formatter={(value) => `₹${value.toLocaleString()}`} />
      <Legend />
      <Bar dataKey="Materials" stackId="a" fill={COLORS['Materials']} />
      <Bar dataKey="Petty Cash" stackId="a" fill={COLORS['Petty Cash']} />
      <Bar dataKey="Maintenance" stackId="a" fill={COLORS['Maintenance']} />
    </BarChart>
  </ResponsiveContainer>
  );
};

export default FinancialOverviewChart;
