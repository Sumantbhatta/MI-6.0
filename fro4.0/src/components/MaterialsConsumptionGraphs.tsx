import React, { useEffect, useState } from 'react';
import { Bar, Pie } from 'react-chartjs-2';
import {
  Chart as ChartJS,
  CategoryScale,
  LinearScale,
  BarElement,
  ArcElement,
  Title,
  Tooltip,
  Legend,
} from 'chart.js';
import materialsConsumptionService from '@/services/materialsConsumptionService';

ChartJS.register(CategoryScale, LinearScale, BarElement, ArcElement, Title, Tooltip, Legend);

const MaterialsConsumptionGraphs: React.FC = () => {
  const [data, setData] = useState<any[]>([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState<string | null>(null);

  useEffect(() => {
    materialsConsumptionService.getAllTransactions(0, 1000)
      .then((res: any) => {
        setData(res.data || []);
        setError(null);
      })
      .catch(() => setError('Failed to fetch materials consumption data'))
      .finally(() => setLoading(false));
  }, []);

  if (loading) return <div className="text-center py-8">Loading graphs...</div>;
  if (error) return <div className="text-center text-red-500 py-8">{error}</div>;
  if (!data.length) return <div className="text-center py-8">No data available.</div>;

  // 1. Bar: Total Quantity by Item
  const quantityByItem: { [item: string]: number } = {};
  // 2. Pie: Total Cost by Project
  const costByProject: { [project: string]: number } = {};

  data.forEach((tx) => {
    const item = tx.item?.code || 'Unknown';
    const project = tx.project?.name || 'Unknown';
    quantityByItem[item] = (quantityByItem[item] || 0) + (tx.quantity || 0);
    costByProject[project] = (costByProject[project] || 0) + (tx.totalCost || 0);
  });

  const barData = {
    labels: Object.keys(quantityByItem),
    datasets: [
      {
        label: 'Total Quantity',
        data: Object.values(quantityByItem),
        backgroundColor: 'rgba(54, 162, 235, 0.7)',
        borderRadius: 8,
        borderWidth: 1,
      },
    ],
  };

  const pieData = {
    labels: Object.keys(costByProject),
    datasets: [
      {
        label: 'Total Cost',
        data: Object.values(costByProject),
        backgroundColor: [
          'rgba(255, 99, 132, 0.7)',
          'rgba(54, 162, 235, 0.7)',
          'rgba(255, 206, 86, 0.7)',
          'rgba(75, 192, 192, 0.7)',
          'rgba(153, 102, 255, 0.7)',
          'rgba(255, 159, 64, 0.7)',
        ],
        borderWidth: 1,
      },
    ],
  };

  return (
    <div className="grid grid-cols-1 md:grid-cols-2 gap-6 mb-6">
      <div className="bg-white rounded-xl shadow-md p-4 h-full">
        <h3 className="mb-3 font-semibold text-lg">Total Quantity by Item</h3>
        <div className="w-full h-60">
          <Bar
            data={barData}
            options={{
              responsive: true,
              maintainAspectRatio: false,
              plugins: {
                legend: { position: 'bottom', labels: { font: { size: 14 } } },
                title: { display: false },
                tooltip: { enabled: true },
              },
              scales: {
                x: { grid: { display: false }, ticks: { font: { size: 13 } } },
                y: { beginAtZero: true, grid: { color: '#eee' }, ticks: { font: { size: 13 } } },
              },
            }}
            height={200}
          />
        </div>
      </div>
      <div className="bg-white rounded-xl shadow-md p-4 h-full">
        <h3 className="mb-3 font-semibold text-lg">Total Cost by Project</h3>
        <div className="w-full h-60">
          <Pie
            data={pieData}
            options={{
              responsive: true,
              maintainAspectRatio: false,
              plugins: {
                legend: { position: 'bottom', labels: { font: { size: 14 } } },
                title: { display: false },
                tooltip: { enabled: true },
              },
            }}
            height={200}
          />
        </div>
      </div>
    </div>
  );
};

export default MaterialsConsumptionGraphs;
