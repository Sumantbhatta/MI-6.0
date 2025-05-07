import React from 'react';
import { BarChart } from '@/components/ui/charts';

// Example props: { data: [{ month: 'Jan', Heavy: 80, Light: 60, Vehicles: 90 }, ...] }
interface EquipmentUtilizationChartProps {
  data: { month: string; [category: string]: number | string }[];
}

const EquipmentUtilizationChart: React.FC<EquipmentUtilizationChartProps> = ({ data }) => {
  return (
    <BarChart
      data={data}
      index="month"
      categories={["Heavy Equipment", "Light Equipment", "Vehicles"]}
      colors={["#6366f1", "#38bdf8", "#4ade80"]}
      valueFormatter={(v) => `${v}%`}
    />
  );
};

export default EquipmentUtilizationChart;
