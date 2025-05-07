import React from 'react';
import DataTable from '@/components/DataTable';
import { Equipment } from '@/services/equipmentService';

interface EquipmentTableProps {
  equipment: Equipment[];
}

const columns = [
  { key: 'id', label: 'ID' },
  { key: 'name', label: 'Name' },
  { key: 'assetCode', label: 'Asset Code' },
  { key: 'yearOfManufacture', label: 'Year' },
  { key: 'category.name', label: 'Category' },
  { key: 'model.name', label: 'Model' },
  { key: 'project.name', label: 'Project' },
];

const EquipmentTable: React.FC<EquipmentTableProps> = ({ equipment }) => {
  // Flatten nested fields for DataTable
  const flatData = equipment.map(e => ({
    ...e,
    'category.name': e.category?.name,
    'model.name': e.model?.name,
    'project.name': e.project?.name,
  }));
  return (
    <DataTable
      title="Equipment"
      columns={columns}
      data={flatData}
      onAdd={() => {}}
      onEdit={() => {}}
      onDelete={() => {}}
      showTitle={false}
    />
  );
};

export default EquipmentTable;
