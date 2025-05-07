import React from 'react';
import DataTable from '@/components/DataTable';
import { PettyCashTransaction } from '@/services/pettyCashService';
import { MaterialsConsumptionTransaction } from '@/services/materialsConsumptionService';

interface FinancialsTableProps {
  pettyCash: PettyCashTransaction[];
  materials: MaterialsConsumptionTransaction[];
}

const pettyCashColumns = [
  { key: 'id', label: 'ID' },
  { key: 'reportDate', label: 'Date' },
  { key: 'amountSpent', label: 'Amount Spent' },
  { key: 'purposeJustification', label: 'Purpose' },
  { key: 'project.name', label: 'Project' },
  { key: 'equipment.name', label: 'Equipment' },
  { key: 'item.code', label: 'Item Code' },
];

const materialsColumns = [
  { key: 'id', label: 'ID' },
  { key: 'issueDate', label: 'Date' },
  { key: 'quantity', label: 'Quantity' },
  { key: 'costPerUnit', label: 'Cost/Unit' },
  { key: 'totalCost', label: 'Total Cost' },
  { key: 'project.name', label: 'Project' },
  { key: 'equipment.name', label: 'Equipment' },
  { key: 'item.name', label: 'Item' },
];

const FinancialsTable: React.FC<FinancialsTableProps> = ({ pettyCash = [], materials = [] }) => {
  // Flatten nested fields for DataTable
  const flatPettyCash = Array.isArray(pettyCash) ? pettyCash.map(t => ({
    ...t,
    'project.name': t?.project?.name || 'N/A',
    'equipment.name': t?.equipment?.name || 'N/A',
    'item.code': t?.item?.code || 'N/A',
  })) : [];
  
  const flatMaterials = Array.isArray(materials) ? materials.map(t => ({
    ...t,
    'project.name': t?.project?.name || 'N/A',
    'equipment.name': t?.equipment?.name || 'N/A',
    'item.name': t?.item?.name || 'N/A',
  })) : [];
  return (
    <div className="space-y-8">
      <DataTable
        title="Petty Cash"
        columns={pettyCashColumns}
        data={flatPettyCash}
        onAdd={() => {}}
        onEdit={() => {}}
        onDelete={() => {}}
        showTitle={true}
      />
      <DataTable
        title="Materials Consumption"
        columns={materialsColumns}
        data={flatMaterials}
        onAdd={() => {}}
        onEdit={() => {}}
        onDelete={() => {}}
        showTitle={true}
      />
    </div>
  );
};

export default FinancialsTable;
