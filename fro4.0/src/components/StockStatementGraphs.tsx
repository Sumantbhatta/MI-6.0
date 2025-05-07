import React, { useEffect, useState } from 'react';
import { Bar } from 'react-chartjs-2';
import {
  Chart as ChartJS,
  CategoryScale,
  LinearScale,
  BarElement,
  Title,
  Tooltip,
  Legend,
} from 'chart.js';
import stockStatementService from '@/services/stockStatementService';

ChartJS.register(CategoryScale, LinearScale, BarElement, Title, Tooltip, Legend);

interface EquipmentBalance {
  equipment: string;
  count: number;
  totalBalance: number;
}

const StockStatementGraphs: React.FC = () => {
  const [data, setData] = useState<EquipmentBalance[]>([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState<string | null>(null);

  useEffect(() => {
    stockStatementService.getAllStockStatements()
      .then((statements) => {
        const equipmentMap: { [name: string]: EquipmentBalance } = {};
        statements.forEach((s: any) => {
          const eq = s.equipment?.name || 'Unknown';
          if (!equipmentMap[eq]) {
            equipmentMap[eq] = { equipment: eq, count: 0, totalBalance: 0 };
          }
          equipmentMap[eq].count += 1;
          equipmentMap[eq].totalBalance += typeof s.balance === 'number' ? s.balance : 0;
        });
        setData(Object.values(equipmentMap));
        setError(null);
      })
      .catch(() => setError('Failed to fetch stock statements'))
      .finally(() => setLoading(false));
  }, []);

  if (loading) return <div className="text-center py-8">Loading graphs...</div>;
  if (error) return <div className="text-center text-red-500 py-8">{error}</div>;
  if (!data.length) return <div className="text-center py-8">No stock statement data available.</div>;

  // Equipment vs Count
  const equipmentLabels = data.map((d) => d.equipment);
  const countData = data.map((d) => d.count);
  const balanceData = data.map((d) => d.totalBalance);

  return (
    <div className="grid grid-cols-1 md:grid-cols-2 gap-6 mb-6">
      <div className="bg-white rounded-xl shadow-md p-4 h-full">
        <h3 className="mb-3 font-semibold text-lg">Equipment vs Count</h3>
        <div className="w-full h-60">
          <Bar
            data={{
              labels: equipmentLabels,
              datasets: [
                {
                  label: 'Statements',
                  data: countData,
                  backgroundColor: 'rgba(54, 162, 235, 0.7)',
                  borderRadius: 8,
                  borderWidth: 1,
                },
              ],
            }}
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
        <h3 className="mb-3 font-semibold text-lg">Equipment vs Balance</h3>
        <div className="w-full h-60">
          <Bar
            data={{
              labels: equipmentLabels,
              datasets: [
                {
                  label: 'Balance',
                  data: balanceData,
                  backgroundColor: 'rgba(75, 192, 192, 0.7)',
                  borderRadius: 8,
                  borderWidth: 1,
                },
              ],
            }}
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
    </div>
  );
};

export default StockStatementGraphs;
