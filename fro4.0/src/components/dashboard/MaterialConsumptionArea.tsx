import React from 'react';
import { AreaChart, Area, XAxis, YAxis, CartesianGrid, Tooltip, ResponsiveContainer, Legend } from 'recharts';

interface MaterialConsumptionAreaProps {
  data: { month: string; [material: string]: number | string }[];
}

const COLORS = ['#6366f1', '#38bdf8', '#4ade80'];
const MATERIALS = ['Concrete', 'Steel', 'Timber'];

const MaterialConsumptionArea: React.FC<MaterialConsumptionAreaProps> = ({ data }) => {
  return (
    <ResponsiveContainer width="100%" height={220}>
      <AreaChart data={data} margin={{ top: 10, right: 30, left: 0, bottom: 0 }}>
        <CartesianGrid strokeDasharray="3 3" />
        <XAxis dataKey="month" />
        <YAxis />
        <Tooltip />
        <Legend />
        {MATERIALS.map((mat, idx) => (
          <Area key={mat} type="monotone" dataKey={mat} stackId="1" stroke={COLORS[idx]} fill={COLORS[idx]} />
        ))}
      </AreaChart>
    </ResponsiveContainer>
  );
};

export default MaterialConsumptionArea;
