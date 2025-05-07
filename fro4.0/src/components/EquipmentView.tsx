'use client';

import React, { useState } from 'react';
import { Equipment } from '@/services/equipmentService';
import { Button } from '@/components/ui/button';
import { Card, CardContent, CardHeader, CardTitle } from '@/components/ui/card';
import { Table, TableBody, TableCell, TableHead, TableHeader, TableRow } from '@/components/ui/table';
import { Grid, List, Edit, Trash2, Eye } from 'lucide-react';

interface EquipmentViewProps {
  equipment: Equipment[];
  onEdit: (equipment: Equipment) => void;
  onDelete: (id: number) => void;
  onViewMore: (equipment: Equipment) => void;
  onAdd: () => void;
}

const EquipmentView: React.FC<EquipmentViewProps> = ({
  equipment,
  onEdit,
  onDelete,
  onViewMore,
  onAdd,
}) => {
  const [viewMode, setViewMode] = useState<'grid' | 'table'>('grid');

  const columns = [
    { key: 'name', label: 'Name' },
    { key: 'assetCode', label: 'Asset Code' },
    { key: 'yearOfManufacture', label: 'Year' },
    { key: 'category.name', label: 'Category' },
    { key: 'model.name', label: 'Model' },
    { key: 'project.name', label: 'Project' },
  ];

  return (
    <div className="space-y-4">
      <div className="flex flex-col md:flex-row md:justify-between md:items-center gap-2 md:gap-0">
        <h2 className="text-2xl font-bold">Equipment</h2>
        <div className="flex flex-col sm:flex-row gap-2 items-stretch sm:items-center w-full md:w-auto mt-2 md:mt-0">
          <Button
            className="bg-black text-white hover:bg-gray-900 w-full sm:w-auto"
            onClick={onAdd}
          >
            + Add Equipment
          </Button>
          <div className="flex gap-2">
            <Button
              variant={viewMode === 'grid' ? 'default' : 'outline'}
              onClick={() => setViewMode('grid')}
              className="flex items-center gap-2"
            >
              <Grid className="h-4 w-4" />
              Grid
            </Button>
            <Button
              variant={viewMode === 'table' ? 'default' : 'outline'}
              onClick={() => setViewMode('table')}
              className="flex items-center gap-2"
            >
              <List className="h-4 w-4" />
              Table
            </Button>
          </div>
        </div>
      </div>

      {viewMode === 'grid' ? (
        <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-4">
          {equipment.map((item) => (
            <Card key={item.id} className="hover:shadow-lg transition-shadow">
              <CardHeader>
                <CardTitle className="text-lg">{item.name}</CardTitle>
              </CardHeader>
              <CardContent>
                <div className="space-y-2">
                  <div className="grid grid-cols-2 gap-2 text-sm">
                    <span className="font-medium">Asset Code:</span>
                    <span>{item.assetCode}</span>
                    <span className="font-medium">Year:</span>
                    <span>{item.yearOfManufacture}</span>
                    <span className="font-medium">Category:</span>
                    <span>{item.category?.name}</span>
                    <span className="font-medium">Model:</span>
                    <span>{item.model?.name}</span>
                    <span className="font-medium">Project:</span>
                    <span>{item.project?.name || 'None'}</span>
                  </div>
                  <div className="flex justify-end gap-2 mt-4">
                    <Button
                      variant="outline"
                      size="sm"
                      onClick={() => onViewMore(item)}
                      className="flex items-center gap-1"
                    >
                      <Eye className="h-4 w-4" />
                      View
                    </Button>
                    <Button
                      variant="outline"
                      size="sm"
                      onClick={() => onEdit(item)}
                      className="flex items-center gap-1"
                    >
                      <Edit className="h-4 w-4" />
                      Edit
                    </Button>
                    <Button
                      variant="destructive"
                      size="sm"
                      onClick={() => onDelete(item.id)}
                      className="flex items-center gap-1"
                    >
                      <Trash2 className="h-4 w-4" />
                      Delete
                    </Button>
                  </div>
                </div>
              </CardContent>
            </Card>
          ))}
        </div>
      ) : (
        <div className="border rounded-lg">
          <Table>
            <TableHeader>
              <TableRow>
                {columns.map((column) => (
                  <TableHead key={column.key}>{column.label}</TableHead>
                ))}
                <TableHead className="text-right">Actions</TableHead>
              </TableRow>
            </TableHeader>
            <TableBody>
              {equipment.map((item) => (
                <TableRow key={item.id}>
                  {columns.map((column) => (
                    <TableCell key={column.key}>
                      {column.key.includes('.')
                        ? item[column.key.split('.')[0]]?.[column.key.split('.')[1]]
                        : item[column.key]}
                    </TableCell>
                  ))}
                  <TableCell className="text-right">
                    <div className="flex justify-end gap-2">
                      <Button
                        variant="outline"
                        size="sm"
                        onClick={() => onViewMore(item)}
                        className="flex items-center gap-1"
                      >
                        <Eye className="h-4 w-4" />
                        View
                      </Button>
                      <Button
                        variant="outline"
                        size="sm"
                        onClick={() => onEdit(item)}
                        className="flex items-center gap-1"
                      >
                        <Edit className="h-4 w-4" />
                        Edit
                      </Button>
                      <Button
                        variant="destructive"
                        size="sm"
                        onClick={() => onDelete(item.id)}
                        className="flex items-center gap-1"
                      >
                        <Trash2 className="h-4 w-4" />
                        Delete
                      </Button>
                    </div>
                  </TableCell>
                </TableRow>
              ))}
            </TableBody>
          </Table>
        </div>
      )}
    </div>
  );
};

export default EquipmentView; 