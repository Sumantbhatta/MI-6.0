import React from 'react';
import DataTable from '@/components/DataTable';
import { IncidentReport } from '@/services/incidentService';

interface BreakdownsTableProps {
  incidents: IncidentReport[];
}

const columns = [
  { key: 'id', label: 'ID' },
  { key: 'incidentDate', label: 'Incident Date' },
  { key: 'incidentType', label: 'Type' },
  { key: 'status', label: 'Status' },
  { key: 'equipment.name', label: 'Equipment' },
  { key: 'project.name', label: 'Project' },
  { key: 'actionTaken', label: 'Action Taken' },
];

const BreakdownsTable: React.FC<BreakdownsTableProps> = ({ incidents }) => {
  // Flatten nested fields for DataTable
  const flatData = incidents.map(i => ({
    ...i,
    'equipment.name': i.equipment?.name,
    'project.name': i.project?.name,
  }));
  return (
    <DataTable
      title="Breakdowns"
      columns={columns}
      data={flatData}
      onAdd={() => {}}
      onEdit={() => {}}
      onDelete={() => {}}
      showTitle={false}
    />
  );
};

export default BreakdownsTable;
