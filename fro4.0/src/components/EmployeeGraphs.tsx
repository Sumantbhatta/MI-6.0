import React, { useEffect, useState } from 'react';
import { Bar, Pie } from 'react-chartjs-2';
import {
  Chart as ChartJS,
  CategoryScale,
  LinearScale,
  BarElement,
  Title,
  Tooltip,
  Legend,
  ArcElement,
} from 'chart.js';
import { employeeService } from '@/services/employeeService';

ChartJS.register(CategoryScale, LinearScale, BarElement, Title, Tooltip, Legend, ArcElement);

// Helper to count occurrences
type CountMap = { [key: string]: number };
function countByKey(arr: string[]): CountMap {
  return arr.reduce((acc, curr) => {
    acc[curr] = (acc[curr] || 0) + 1;
    return acc;
  }, {} as CountMap);
}

// Props for customizing appearance
interface EmployeeGraphsProps {
  barColors?: string[];
  pieColors?: string[];
  barTitle?: string;
  pieTitle?: string;
}

const defaultBarColors = [
  'rgba(75, 192, 192, 0.7)',
  'rgba(255, 99, 132, 0.7)',
  'rgba(255, 206, 86, 0.7)',
  'rgba(54, 162, 235, 0.7)',
  'rgba(153, 102, 255, 0.7)',
];
const defaultPieColors = [
  'rgba(54, 162, 235, 0.7)',
  'rgba(255, 206, 86, 0.7)',
  'rgba(153, 102, 255, 0.7)',
  'rgba(255, 99, 132, 0.7)',
  'rgba(75, 192, 192, 0.7)',
];

const EmployeeGraphs: React.FC<EmployeeGraphsProps> = ({
  barColors = defaultBarColors,
  pieColors = defaultPieColors,
  barTitle = 'Employee vs Designation',
  pieTitle = 'Employee vs Department',
}) => {
  const [employees, setEmployees] = useState<any[]>([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState<string | null>(null);

  useEffect(() => {
    setLoading(true);
    employeeService
      .getAllEmployees()
      .then((data) => {
        setEmployees(data);
        setError(null);
      })
      .catch((err) => {
        setError('Failed to fetch employees');
        setEmployees([]);
      })
      .finally(() => setLoading(false));
  }, []);

  // Count designations and departments
  const designationCounts = countByKey(
    employees.map((e) => e.designation?.name || 'Unknown')
  );
  const departmentCounts = countByKey(
    employees.map((e) => e.department?.name || 'Unknown')
  );

  // Chart data
  const designationData = {
    labels: Object.keys(designationCounts),
    datasets: [
      {
        label: 'Number of Employees',
        data: Object.values(designationCounts),
        backgroundColor: barColors,
        borderRadius: 12,
        borderWidth: 1,
      },
    ],
  };

  const departmentData = {
    labels: Object.keys(departmentCounts),
    datasets: [
      {
        label: 'Number of Employees',
        data: Object.values(departmentCounts),
        backgroundColor: pieColors,
        borderWidth: 1,
      },
    ],
  };

  if (loading) return <div className="text-center py-8">Loading graphs...</div>;
  if (error) return <div className="text-center text-red-500 py-8">{error}</div>;

  return (
    <div className="grid grid-cols-1 md:grid-cols-2 gap-6 mb-6">
      <div className="bg-white rounded-xl shadow-md p-4 h-full">
        <h3 className="mb-3 font-semibold text-lg">{barTitle}</h3>
        <div className="w-full h-60">
          <Bar
            data={designationData}
            options={{
              responsive: true,
              maintainAspectRatio: false,
              plugins: {
                legend: { display: false },
                title: { display: false },
                tooltip: { enabled: true },
              },
              scales: {
                x: { grid: { display: false } },
                y: { beginAtZero: true, grid: { color: '#eee' } },
              },
            }}
            height={200}
          />
        </div>
      </div>
      <div className="bg-white rounded-xl shadow-md p-4 h-full">
        <h3 className="mb-3 font-semibold text-lg">{pieTitle}</h3>
        <div className="w-full h-60">
          <Pie
            data={departmentData}
            options={{
              responsive: true,
              maintainAspectRatio: false,
              plugins: {
                legend: { position: 'bottom', labels: { boxWidth: 18, font: { size: 13 } } },
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

export default EmployeeGraphs;
