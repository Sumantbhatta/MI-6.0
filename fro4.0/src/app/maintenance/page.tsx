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
import MaintenanceForm from '@/components/MaintenanceForm';
import maintenanceService, { MaintenanceLog, MaintenanceLogRequest } from '@/services/maintenanceService';
import { toast } from 'sonner';
import Link from 'next/link';
import { Select, SelectTrigger, SelectValue, SelectContent, SelectItem } from '@/components/ui/select';

export default function MaintenancePage() {
  const [search, setSearch] = useState("");
  const [open, setOpen] = useState(false);
  const [selectedMaintenance, setSelectedMaintenance] = useState<MaintenanceLog | undefined>();
  const queryClient = useQueryClient();
  const [currentPage, setCurrentPage] = useState(1);
  const [rowsPerPage, setRowsPerPage] = useState(10);

  const { data: maintenanceData } = useQuery(['maintenanceLogs'], () =>
    maintenanceService.getAllMaintenanceLogs()
  );

  // Make sure we have the correct data structure
  const maintenanceLogs = maintenanceData?.data || [];

  // Filter maintenance logs by search
  const filteredLogs = React.useMemo(() => {
    const s = search.toLowerCase();
    return maintenanceLogs.filter((log: any) =>
      (log.date || "").toString().toLowerCase().includes(s) ||
      (log.equipment?.name?.toLowerCase() || "").includes(s) ||
      (log.typeOfMaintenance?.toLowerCase() || "").includes(s) ||
      (log.serviceDate || "").toString().toLowerCase().includes(s) ||
      (log.startReading?.toString() || "").includes(s) ||
      (log.closeReading?.toString() || "").includes(s) ||
      (log.serviceHours?.toString() || "").includes(s)
    );
  }, [search, maintenanceLogs]);

  // Calculate pagination
  const totalRows = filteredLogs.length;
  const totalPages = Math.ceil(totalRows / rowsPerPage);
  const paginatedLogs = filteredLogs.slice(
    (currentPage - 1) * rowsPerPage,
    currentPage * rowsPerPage
  );

  // Reset to first page if filteredLogs or rowsPerPage changes
  React.useEffect(() => {
    setCurrentPage(1);
  }, [filteredLogs, rowsPerPage]);

  const createMutation = useMutation(
    (data: MaintenanceLogRequest) => maintenanceService.createMaintenanceLog(data),
    {
      onSuccess: () => {
        queryClient.invalidateQueries(['maintenanceLogs']);
        setOpen(false);
        toast.success('Maintenance log created successfully');
      },
      onError: () => {
        toast.error('Failed to create maintenance log');
      },
    }
  );

  const updateMutation = useMutation(
    ({ id, data }: { id: number; data: MaintenanceLogRequest }) => maintenanceService.updateMaintenanceLog(id, data),
    {
      onSuccess: () => {
        queryClient.invalidateQueries(['maintenanceLogs']);
        setOpen(false);
        toast.success('Maintenance log updated successfully');
      },
      onError: () => {
        toast.error('Failed to update maintenance log');
      },
    }
  );

  const deleteMutation = useMutation(
    (id: number) => maintenanceService.deleteMaintenanceLog(id),
    {
      onSuccess: () => {
        queryClient.invalidateQueries(['maintenanceLogs']);
        toast.success('Maintenance log deleted successfully');
      },
      onError: () => {
        toast.error('Failed to delete maintenance log');
      },
    }
  );

  const handleOpen = (maintenance?: MaintenanceLog) => {
    setSelectedMaintenance(maintenance);
    setOpen(true);
  };

  const handleClose = () => {
    setSelectedMaintenance(undefined);
    setOpen(false);
  };

  const handleSubmit = async (data: MaintenanceLogRequest) => {
    if (selectedMaintenance) {
      await updateMutation.mutateAsync({ id: selectedMaintenance.id, data });
    } else {
      await createMutation.mutateAsync(data);
    }
  };

  const handleDelete = async (id: number) => {
    if (window.confirm('Are you sure you want to delete this maintenance log?')) {
      await deleteMutation.mutateAsync(id);
    }
  };

  const formatDate = (dateString: string) => {
    return new Date(dateString).toLocaleDateString('en-US', {
      year: 'numeric',
      month: 'short',
      day: 'numeric',
    });
  };

  const columns = [
    { key: 'date', label: 'Date' },
    { key: 'equipment.name', label: 'Equipment' },
    { key: 'typeOfMaintenance', label: 'Type' },
    { key: 'serviceDate', label: 'Service Date' },
    { key: 'startReading', label: 'Start Reading' },
    { key: 'closeReading', label: 'Close Reading' },
    { key: 'serviceHours', label: 'Service Hours' },
  ];

  const renderCustomCell = (column: string, item: any) => {
    if (column === 'date' || column === 'serviceDate') {
      return formatDate(item[column]);
    }
    if (column === 'equipment.name') {
      return item.equipment?.name || '';
    }
    if (column === 'typeOfMaintenance') {
      return item.typeOfMaintenance
        ? item.typeOfMaintenance.charAt(0).toUpperCase() + item.typeOfMaintenance.slice(1).toLowerCase()
        : '';
    }
    if (column === 'startReading' || column === 'closeReading' || column === 'serviceHours') {
      return typeof item[column] === 'number' ? item[column] : '';
    }
    return null;
  };

  return (
    <div className="p-4">
      <div className="flex gap-4 mb-4">
        <Button variant="outline" className="bg-background">
          Maintenance Logs
        </Button>
        <Button variant="outline" asChild>
          <Link href="/maintenance/readings">Readings</Link>
        </Button>
        <Button variant="outline" asChild>
          <Link href="/maintenance/parts-used">Parts Used</Link>
        </Button>
      </div>
      
      <div className="mb-4 max-w-sm">
        <input
          type="text"
          placeholder="Search maintenance logs..."
          className="w-full border rounded px-3 py-2"
          value={search}
          onChange={e => setSearch(e.target.value)}
        />
      </div>
      <DataTable
        title="Maintenance Logs"
        columns={columns}
        data={paginatedLogs}
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
        <DialogContent className="max-w-4xl max-h-[90vh] overflow-y-auto">
          <DialogHeader>
            <DialogTitle>
              {selectedMaintenance ? 'Edit Maintenance Log' : 'Add Maintenance Log'}
            </DialogTitle>
          </DialogHeader>
          <div className="mt-4">
            <MaintenanceForm
              maintenance={selectedMaintenance}
              onSubmit={handleSubmit}
              onCancel={handleClose}
            />
          </div>
        </DialogContent>
      </Dialog>
    </div>
  );
}
