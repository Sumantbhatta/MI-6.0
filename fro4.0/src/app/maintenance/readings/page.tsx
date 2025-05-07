'use client';

import React, { useState } from 'react';
import { useQuery, useMutation, useQueryClient } from 'react-query';
import {
  Dialog,
  DialogContent,
  DialogHeader,
  DialogTitle,
} from '@/components/ui/dialog';
import { Button } from '@/components/ui/button';
import DataTable from '@/components/DataTable';
import MaintenanceReadingForm from '@/components/MaintenanceReadingForm';
import maintenanceReadingService, { MaintenanceReading, MaintenanceReadingRequest } from '@/services/maintenanceReadingService';
import maintenanceService from '@/services/maintenanceService';
import { toast } from 'sonner';
import Link from 'next/link';
import { Select, SelectTrigger, SelectValue, SelectContent, SelectItem } from '@/components/ui/select';

export default function MaintenanceReadingsPage() {
  const [search, setSearch] = useState("");
  const [open, setOpen] = useState(false);
  const [selectedReading, setSelectedReading] = useState<MaintenanceReading | undefined>();
  const queryClient = useQueryClient();
  const [currentPage, setCurrentPage] = useState(1);
  const [rowsPerPage, setRowsPerPage] = useState(10);

  const { data: readingsData } = useQuery(['maintenanceReadings'], () =>
    maintenanceReadingService.getAllMaintenanceReadings()
  );

  // Make sure we have the correct data structure
  const readings = readingsData?.data || [];

  // Fetch maintenance logs to get equipment information
  const { data: maintenanceLogsData } = useQuery(['maintenanceLogs'], () =>
    maintenanceService.getAllMaintenanceLogs()
  );
  const maintenanceLogs = maintenanceLogsData?.data || [];

  // Filter readings by search
  const filteredReadings = React.useMemo(() => {
    const s = search.toLowerCase();
    return readings.filter((reading: any) => {
      // Find the maintenance log for equipment name
      const maintenanceLogId = reading.maintenanceLog?.id;
      const maintenanceLog = maintenanceLogs.find((log: any) => log.id === maintenanceLogId);
      const equipmentName = maintenanceLog?.equipment?.name?.toLowerCase() || "";
      return (
        equipmentName.includes(s) ||
        [
          'airPressure','engineOil','engineTemperature','gearOil','greaseUsed','hsdUsed','hydraulicOil','hydraulicTemperature','oilPressure'
        ].some(field => (reading[field]?.toString() || "").includes(s))
      );
    });
  }, [search, readings, maintenanceLogs]);

  // Calculate pagination
  const totalRows = filteredReadings.length;
  const totalPages = Math.ceil(totalRows / rowsPerPage);
  const paginatedReadings = filteredReadings.slice(
    (currentPage - 1) * rowsPerPage,
    currentPage * rowsPerPage
  );

  // Reset to first page if filteredReadings or rowsPerPage changes
  React.useEffect(() => {
    setCurrentPage(1);
  }, [filteredReadings, rowsPerPage]);

  const createMutation = useMutation(
    (data: MaintenanceReadingRequest) => maintenanceReadingService.createMaintenanceReading(data),
    {
      onSuccess: () => {
        queryClient.invalidateQueries(['maintenanceReadings']);
        setOpen(false);
        toast.success('Maintenance reading created successfully');
      },
      onError: () => {
        toast.error('Failed to create maintenance reading');
      },
    }
  );

  const updateMutation = useMutation(
    ({ id, data }: { id: number; data: MaintenanceReadingRequest }) => maintenanceReadingService.updateMaintenanceReading(id, data),
    {
      onSuccess: () => {
        queryClient.invalidateQueries(['maintenanceReadings']);
        setOpen(false);
        toast.success('Maintenance reading updated successfully');
      },
      onError: () => {
        toast.error('Failed to update maintenance reading');
      },
    }
  );

  const deleteMutation = useMutation(
    (id: number) => maintenanceReadingService.deleteMaintenanceReading(id),
    {
      onSuccess: () => {
        queryClient.invalidateQueries(['maintenanceReadings']);
        toast.success('Maintenance reading deleted successfully');
      },
      onError: () => {
        toast.error('Failed to delete maintenance reading');
      },
    }
  );

  const handleOpen = (reading?: MaintenanceReading) => {
    setSelectedReading(reading);
    setOpen(true);
  };

  const handleClose = () => {
    setSelectedReading(undefined);
    setOpen(false);
  };

  const handleSubmit = async (data: MaintenanceReadingRequest) => {
    if (selectedReading) {
      await updateMutation.mutateAsync({ id: selectedReading.id, data });
    } else {
      await createMutation.mutateAsync(data);
    }
  };

  const handleDelete = async (id: number) => {
    console.log('Deleting reading with ID:', id);
    if (window.confirm('Are you sure you want to delete this reading?')) {
      try {
        await deleteMutation.mutateAsync(id);
        console.log('Delete successful');
      } catch (error) {
        console.error('Error deleting reading:', error);
        toast.error(`Delete failed: ${error instanceof Error ? error.message : 'Unknown error'}`);
      }
    }
  };

  const columns = [
    { key: 'maintenanceLog.id', label: 'Equipment' },
    { key: 'airPressure', label: 'Air Pressure' },
    { key: 'engineOil', label: 'Engine Oil' },
    { key: 'engineTemperature', label: 'Engine Temp' },
    { key: 'gearOil', label: 'Gear Oil' },
    { key: 'greaseUsed', label: 'Grease Used' },
    { key: 'hsdUsed', label: 'HSD Used' },
    { key: 'hydraulicOil', label: 'Hydraulic Oil' },
    { key: 'hydraulicTemperature', label: 'Hydraulic Temp' },
    { key: 'oilPressure', label: 'Oil Pressure' },
  ];

  const formatNumber = (num: number) => {
    if (num === undefined || num === null) return '';
    return new Intl.NumberFormat('en-IN', {
      minimumFractionDigits: 0,
      maximumFractionDigits: 2,
    }).format(num);
  };

  const renderCustomCell = (column: string, item: any) => {
    if (column === 'maintenanceLog.id') {
      // Find the maintenance log with this ID to display equipment info
      const maintenanceLogId = item.maintenanceLog?.id;
      const maintenanceLog = maintenanceLogs.find((log: any) => log.id === maintenanceLogId);
      if (maintenanceLog?.equipment?.name) {
        return `${maintenanceLog.equipment.name}`;
      } else {
        return `Unknown (Log ID: ${maintenanceLogId})`;
      }
    }
    // Handle all numeric columns
    if (['airPressure', 'engineOil', 'engineTemperature', 'gearOil', 'greaseUsed', 
         'hsdUsed', 'hydraulicOil', 'hydraulicTemperature', 'oilPressure'].includes(column)) {
      return formatNumber(item[column]);
    }
    return null;
  };

  return (
    <div className="p-4">
      <div className="flex gap-4 mb-4">
        <Button variant="outline" asChild>
          <Link href="/maintenance">Maintenance Logs</Link>
        </Button>
        <Button variant="outline" className="bg-background">
          Readings
        </Button>
        <Button variant="outline" asChild>
          <Link href="/maintenance/parts-used">Parts Used</Link>
        </Button>
      </div>
      
      <div className="mb-4 max-w-sm">
        <input
          type="text"
          placeholder="Search readings..."
          className="w-full border rounded px-3 py-2"
          value={search}
          onChange={e => setSearch(e.target.value)}
        />
      </div>
      <DataTable
        title="Maintenance Readings"
        columns={columns}
        data={paginatedReadings}
        onAdd={() => handleOpen()}
        onEdit={handleOpen}
        onDelete={handleDelete}
        renderCustomCell={renderCustomCell}
      />
      <div className="flex items-center justify-between mt-4 px-4 pb-4">
        <div className="flex items-center gap-2">
          <button
            className="px-3 py-1 border rounded disabled:opacity-50"
            onClick={() => setCurrentPage((p) => Math.max(1, p - 1))}
            disabled={currentPage === 1}
          >
            Previous
          </button>
          <span className="mx-2">Page {currentPage} of {totalPages || 1}</span>
          <button
            className="px-3 py-1 border rounded disabled:opacity-50"
            onClick={() => setCurrentPage((p) => Math.min(totalPages, p + 1))}
            disabled={currentPage === totalPages || totalPages === 0}
          >
            Next
          </button>
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

      <Dialog open={open} onOpenChange={setOpen}>
        <DialogContent className="max-w-3xl max-h-[90vh] overflow-y-auto">
          <DialogHeader>
            <DialogTitle>
              {selectedReading ? 'Edit Maintenance Reading' : 'Add Maintenance Reading'}
            </DialogTitle>
          </DialogHeader>
          <div className="mt-4">
            <MaintenanceReadingForm
              reading={selectedReading}
              onSubmit={handleSubmit}
              onCancel={handleClose}
            />
          </div>
        </DialogContent>
      </Dialog>
    </div>
  );
}
