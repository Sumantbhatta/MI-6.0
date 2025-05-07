'use client';

import React, { useState, useMemo, useEffect } from 'react';
import { useQuery, useMutation, useQueryClient } from 'react-query';
import {
  Dialog,
  DialogContent,
  DialogHeader,
  DialogTitle,
} from '@/components/ui/dialog';
import DataTable from '@/components/DataTable';
import EquipmentUtilizationForm from '@/components/EquipmentUtilizationForm';
import { EquipmentUtilization, equipmentUtilizationService } from '@/services/equipmentUtilizationService';
import { toast } from 'sonner';
import { Button } from '@/components/ui/button';
import { Grid, List, Eye } from 'lucide-react';
import { Select, SelectTrigger, SelectValue, SelectContent, SelectItem } from '@/components/ui/select';

export default function EquipmentUtilizationPage() {
  const [search, setSearch] = useState("");
  const [open, setOpen] = useState(false);
  const [viewMoreOpen, setViewMoreOpen] = useState(false);
  const [selectedUtilization, setSelectedUtilization] = useState<EquipmentUtilization | undefined>();
  const [viewMode, setViewMode] = useState<'table' | 'grid'>('table');
  const queryClient = useQueryClient();
  const [currentPage, setCurrentPage] = useState(1);
  const [rowsPerPage, setRowsPerPage] = useState(10);

  const { data: utilizations = [] } = useQuery(['utilizations'], () =>
    equipmentUtilizationService.getAllUtilizations()
  );

  // Filter utilizations by search
  const filteredUtilizations = useMemo(() => {
    const s = search.toLowerCase();
    return utilizations.filter((u: any) =>
      (u.equipment?.name?.toLowerCase() || "").includes(s) ||
      (u.project?.name?.toLowerCase() || "").includes(s) ||
      (u.month?.toString() || "").includes(s) ||
      (u.year?.toString() || "").includes(s) ||
      (u.status?.toLowerCase() || "").includes(s)
    );
  }, [search, utilizations]);

  // Calculate pagination
  const totalRows = filteredUtilizations.length;
  const totalPages = Math.ceil(totalRows / rowsPerPage);
  const paginatedUtilizations = filteredUtilizations.slice(
    (currentPage - 1) * rowsPerPage,
    currentPage * rowsPerPage
  );

  // Reset to first page if search/filter changes
  useEffect(() => {
    setCurrentPage(1);
  }, [search, rowsPerPage, utilizations]);

  const createMutation = useMutation(
    (data: any) => equipmentUtilizationService.createUtilization(data),
    {
      onSuccess: () => {
        queryClient.invalidateQueries(['utilizations']);
        setOpen(false);
        toast.success('Equipment utilization created successfully');
      },
      onError: () => {
        toast.error('Failed to create equipment utilization');
      },
    }
  );

  const updateMutation = useMutation(
    ({ id, data }: { id: number; data: any }) =>
      equipmentUtilizationService.updateUtilization(id, data),
    {
      onSuccess: () => {
        queryClient.invalidateQueries(['utilizations']);
        setOpen(false);
        toast.success('Equipment utilization updated successfully');
      },
      onError: () => {
        toast.error('Failed to update equipment utilization');
      },
    }
  );

  const deleteMutation = useMutation(
    (id: number) => equipmentUtilizationService.deleteUtilization(id),
    {
      onSuccess: () => {
        queryClient.invalidateQueries(['utilizations']);
        toast.success('Equipment utilization deleted successfully');
      },
      onError: () => {
        toast.error('Failed to delete equipment utilization');
      },
    }
  );

  const handleOpen = (utilization?: EquipmentUtilization) => {
    setSelectedUtilization(utilization);
    setOpen(true);
  };

  const handleClose = () => {
    setSelectedUtilization(undefined);
    setOpen(false);
  };

  const handleSubmit = (data: any) => {
    if (selectedUtilization) {
      updateMutation.mutate({ id: selectedUtilization.id!, data });
    } else {
      createMutation.mutate(data);
    }
  };

  const handleDelete = (id: number) => {
    if (window.confirm('Are you sure you want to delete this utilization record?')) {
      deleteMutation.mutate(id);
    }
  };

  const handleViewMore = (utilization: EquipmentUtilization) => {
    setSelectedUtilization(utilization);
    setViewMoreOpen(true);
  };

  const columns = [
    { key: 'equipment.name', label: 'Equipment' },
    { key: 'project.name', label: 'Project' },
    { key: 'monthYear', label: 'Month/Year' },
    { key: 'startingHoursKms', label: 'Starting Hours' },
    { key: 'targetHoursKms', label: 'Target Hours' },
    { key: 'closingHoursKms', label: 'Closing Hours' },
    { key: 'utilizationPercentage', label: 'Utilization %' },
  ];

  const renderCustomCell = (column: string, item: any) => {
    if (column === 'equipment.name') return item.equipment?.name || '';
    if (column === 'project.name') return item.project?.name || '';
    if (column === 'monthYear') return `${item.month ?? ''}/${item.year ?? ''}`;
    if (column === 'utilizationPercentage') return item.utilizationPercentage != null ? `${item.utilizationPercentage}%` : '';
    return item[column.split('.').pop()!] ?? '';
  };

  const renderGridView = () => (
    <div className="space-y-4">
      <div className="flex justify-end">
        <Button onClick={() => handleOpen()}>
          Add New Utilization
        </Button>
      </div>
      <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-4">
        {filteredUtilizations.map((item: any) => (
          <div key={item.id} className="border rounded-lg p-4 shadow-sm bg-white">
            <h3 className="font-semibold text-lg mb-2">{item.equipment?.name}</h3>
            <div className="space-y-2">
              <p><span className="font-medium">Project:</span> {item.project?.name}</p>
              <p><span className="font-medium">Month/Year:</span> {item.month}/{item.year}</p>
              <p><span className="font-medium">Starting Hours:</span> {item.startingHoursKms}</p>
              <p><span className="font-medium">Target Hours:</span> {item.targetHoursKms}</p>
              <p><span className="font-medium">Closing Hours:</span> {item.closingHoursKms}</p>
              <p><span className="font-medium">Utilization:</span> {item.utilizationPercentage}%</p>
            </div>
            <div className="mt-4 flex gap-2">
              <Button variant="outline" size="sm" onClick={() => handleViewMore(item)}>
                View More
              </Button>
              <Button variant="outline" size="sm" onClick={() => handleOpen(item)}>
                Edit
              </Button>
              <Button variant="outline" size="sm" onClick={() => handleDelete(item.id)}>
                Delete
              </Button>
            </div>
          </div>
        ))}
      </div>
    </div>
  );

  return (
    <div className="p-4">
      <div className="flex justify-between items-center mb-4">
        <div className="max-w-sm">
          <input
            type="text"
            placeholder="Search utilization..."
            className="w-full border rounded px-3 py-2"
            value={search}
            onChange={e => setSearch(e.target.value)}
          />
        </div>
        <div className="flex gap-2">
          <Button
            variant={viewMode === 'table' ? 'default' : 'outline'}
            size="sm"
            onClick={() => setViewMode('table')}
          >
            <List className="h-4 w-4 mr-2" />
            Table
          </Button>
          <Button
            variant={viewMode === 'grid' ? 'default' : 'outline'}
            size="sm"
            onClick={() => setViewMode('grid')}
          >
            <Grid className="h-4 w-4 mr-2" />
            Grid
          </Button>
        </div>
      </div>

      {viewMode === 'table' ? (
        <>
          <DataTable
            title="Equipment Utilization"
            columns={columns}
            data={paginatedUtilizations}
            onAdd={() => handleOpen()}
            onEdit={handleOpen}
            onDelete={handleDelete}
            onViewMore={handleViewMore}
            renderCustomCell={renderCustomCell}
          />
          <div className="flex items-center justify-between mt-4">
            <div className="flex items-center gap-2">
              <Button
                variant="outline"
                size="sm"
                onClick={() => setCurrentPage((p) => Math.max(1, p - 1))}
                disabled={currentPage === 1}
              >
                Previous
              </Button>
              <span className="mx-2">Page {currentPage} of {totalPages || 1}</span>
              <Button
                variant="outline"
                size="sm"
                onClick={() => setCurrentPage((p) => Math.min(totalPages, p + 1))}
                disabled={currentPage === totalPages || totalPages === 0}
              >
                Next
              </Button>
            </div>
            <div className="flex items-center gap-2">
              <span>Rows per page:</span>
              <Select value={String(rowsPerPage)} onValueChange={v => setRowsPerPage(Number(v))}>
                <SelectTrigger className="w-[80px]">
                  <SelectValue />
                </SelectTrigger>
                <SelectContent>
                  <SelectItem value="5">5</SelectItem>
                  <SelectItem value="10">10</SelectItem>
                  <SelectItem value="20">20</SelectItem>
                  <SelectItem value="50">50</SelectItem>
                </SelectContent>
              </Select>
            </div>
          </div>
        </>
      ) : (
        renderGridView()
      )}

      <Dialog open={open} onOpenChange={setOpen}>
        <DialogContent className="max-w-3xl max-h-[90vh] overflow-y-auto">
          <DialogHeader>
            <DialogTitle>
              {selectedUtilization ? 'Edit Utilization' : 'Add Utilization'}
            </DialogTitle>
          </DialogHeader>
          <div className="mt-4">
            <EquipmentUtilizationForm
              utilization={selectedUtilization}
              onSubmit={handleSubmit}
              onCancel={handleClose}
            />
          </div>
        </DialogContent>
      </Dialog>

      <Dialog open={viewMoreOpen} onOpenChange={setViewMoreOpen}>
        <DialogContent className="max-w-3xl">
          <DialogHeader>
            <DialogTitle>Utilization Details</DialogTitle>
          </DialogHeader>
          {selectedUtilization && (
            <div className="mt-4 space-y-4">
              <div className="grid grid-cols-2 gap-4">
                <div>
                  <h3 className="font-semibold mb-2">Equipment Information</h3>
                  <p><span className="font-medium">Name:</span> {selectedUtilization.equipment?.name}</p>
                  <p><span className="font-medium">ID:</span> {selectedUtilization.equipment?.id}</p>
                </div>
                <div>
                  <h3 className="font-semibold mb-2">Project Information</h3>
                  <p><span className="font-medium">Name:</span> {selectedUtilization.project?.name}</p>
                  <p><span className="font-medium">ID:</span> {selectedUtilization.project?.id}</p>
                </div>
              </div>
              <div className="grid grid-cols-2 gap-4">
                <div>
                  <h3 className="font-semibold mb-2">Time Period</h3>
                  <p><span className="font-medium">Month:</span> {selectedUtilization.month}</p>
                  <p><span className="font-medium">Year:</span> {selectedUtilization.year}</p>
                </div>
                <div>
                  <h3 className="font-semibold mb-2">Hours Information</h3>
                  <p><span className="font-medium">Starting Hours:</span> {selectedUtilization.startingHoursKms}</p>
                  <p><span className="font-medium">Target Hours:</span> {selectedUtilization.targetHoursKms}</p>
                  <p><span className="font-medium">Closing Hours:</span> {selectedUtilization.closingHoursKms}</p>
                  <p><span className="font-medium">Availability Hours:</span> {selectedUtilization.availabilityHours}</p>
                </div>
              </div>
              <div>
                <h3 className="font-semibold mb-2">Utilization Details</h3>
                <p><span className="font-medium">Utilization Percentage:</span> {selectedUtilization.utilizationPercentage}%</p>
                <p><span className="font-medium">Diesel Consumed:</span> {selectedUtilization.dieselConsumedLtrs} L</p>
                <p><span className="font-medium">Average Fuel Consumption:</span> {selectedUtilization.avgFuelConsumption}</p>
                <p><span className="font-medium">Remarks:</span> {selectedUtilization.remarks}</p>
              </div>
            </div>
          )}
        </DialogContent>
      </Dialog>
    </div>
  );
}
