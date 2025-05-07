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
import MaintenancePartUsedForm from '@/components/MaintenancePartUsedForm';
import maintenancePartUsedService, { MaintenancePartUsed, MaintenancePartUsedRequest } from '@/services/maintenancePartUsedService';
import maintenanceService, { MaintenanceLog } from '@/services/maintenanceService';
import { toast } from 'sonner';
import Link from 'next/link';
import { Select, SelectTrigger, SelectValue, SelectContent, SelectItem } from '@/components/ui/select';

export default function MaintenancePartsUsedPage() {
  const [search, setSearch] = useState("");
  const [open, setOpen] = useState(false);
  const [selectedPartUsed, setSelectedPartUsed] = useState<MaintenancePartUsed | undefined>();
  const queryClient = useQueryClient();
  const [currentPage, setCurrentPage] = useState(1);
  const [rowsPerPage, setRowsPerPage] = useState(10);

  const { data: partsUsedData } = useQuery(['maintenancePartsUsed'], () =>
    maintenancePartUsedService.getAllMaintenancePartUsed()
  );

  // Fetch maintenance logs to get equipment information
  const { data: maintenanceLogsData } = useQuery(['maintenanceLogs'], () =>
    maintenanceService.getAllMaintenanceLogs()
  );
  const maintenanceLogs = maintenanceLogsData?.data || [];

  // Make sure we have the correct data structure
  const partsUsed = partsUsedData?.data || [];

  // Filter parts used by search
  const filteredPartsUsed = React.useMemo(() => {
    const s = search.toLowerCase();
    return partsUsed.filter((part: any) => {
      // Find the maintenance log for equipment name
      const maintenanceLogId = part.maintenanceLog?.id;
      const maintenanceLog = maintenanceLogs.find((log: any) => log.id === maintenanceLogId);
      const equipmentName = maintenanceLog?.equipment?.name?.toLowerCase() || "";
      return (
        equipmentName.includes(s) ||
        (part.item?.code?.toLowerCase() || "").includes(s) ||
        (part.quantity?.toString() || "").includes(s)
      );
    });
  }, [search, partsUsed, maintenanceLogs]);

  // Calculate pagination
  const totalRows = filteredPartsUsed.length;
  const totalPages = Math.ceil(totalRows / rowsPerPage);
  const paginatedPartsUsed = filteredPartsUsed.slice(
    (currentPage - 1) * rowsPerPage,
    currentPage * rowsPerPage
  );

  // Reset to first page if filteredPartsUsed or rowsPerPage changes
  React.useEffect(() => {
    setCurrentPage(1);
  }, [filteredPartsUsed, rowsPerPage]);

  const createMutation = useMutation(
    (data: MaintenancePartUsedRequest) => maintenancePartUsedService.createMaintenancePartUsed(data),
    {
      onSuccess: () => {
        queryClient.invalidateQueries(['maintenancePartsUsed']);
        setOpen(false);
        toast.success('Part used record created successfully');
      },
      onError: () => {
        toast.error('Failed to create part used record');
      },
    }
  );

  const updateMutation = useMutation(
    ({ id, data }: { id: number; data: MaintenancePartUsedRequest }) => maintenancePartUsedService.updateMaintenancePartUsed(id, data),
    {
      onSuccess: () => {
        queryClient.invalidateQueries(['maintenancePartsUsed']);
        setOpen(false);
        toast.success('Part used record updated successfully');
      },
      onError: () => {
        toast.error('Failed to update part used record');
      },
    }
  );

  const deleteMutation = useMutation(
    (id: number) => maintenancePartUsedService.deleteMaintenancePartUsed(id),
    {
      onSuccess: () => {
        queryClient.invalidateQueries(['maintenancePartsUsed']);
        toast.success('Part used record deleted successfully');
      },
      onError: () => {
        toast.error('Failed to delete part used record');
      },
    }
  );

  const handleOpen = (partUsed?: MaintenancePartUsed) => {
    setSelectedPartUsed(partUsed);
    setOpen(true);
  };

  const handleClose = () => {
    setSelectedPartUsed(undefined);
    setOpen(false);
  };

  const handleSubmit = async (data: MaintenancePartUsedRequest) => {
    if (selectedPartUsed) {
      await updateMutation.mutateAsync({ id: selectedPartUsed.id, data });
    } else {
      await createMutation.mutateAsync(data);
    }
  };

  const handleDelete = async (id: number) => {
    if (window.confirm('Are you sure you want to delete this part used record?')) {
      await deleteMutation.mutateAsync(id);
    }
  };

  const formatNumber = (num: number) => {
    return new Intl.NumberFormat('en-IN', {
      minimumFractionDigits: 0,
      maximumFractionDigits: 2,
    }).format(num);
  };

  const columns = [
    { key: 'maintenanceLog.id', label: 'Equipment' },
    { key: 'item.code', label: 'Item Code' },
    { key: 'quantity', label: 'Quantity' },
  ];

  const renderCustomCell = (column: string, item: any) => {
    if (column === 'quantity') {
      return formatNumber(item.quantity);
    }
    if (column === 'item.code') {
      return item.item?.code || '';
    }
    if (column === 'maintenanceLog.id') {
      // Find the maintenance log with this ID to display equipment info
      const maintenanceLogId = item.maintenanceLog?.id;
      const maintenanceLog = maintenanceLogs.find((log: MaintenanceLog) => log.id === maintenanceLogId);
      if (maintenanceLog?.equipment?.name) {
        return `${maintenanceLog.equipment.name}`;
      } else {
        return `Unknown (Log ID: ${maintenanceLogId})`;
      }
    }
    return null;
  };

  return (
    <div className="p-4">
      <div className="flex gap-4 mb-4">
        <Button variant="outline" asChild>
          <Link href="/maintenance">Maintenance Logs</Link>
        </Button>
        <Button variant="outline" asChild>
          <Link href="/maintenance/readings">Readings</Link>
        </Button>
        <Button variant="outline" className="bg-background">
          Parts Used
        </Button>
      </div>
      
      <div className="mb-4 max-w-sm">
        <input
          type="text"
          placeholder="Search parts used..."
          className="w-full border rounded px-3 py-2"
          value={search}
          onChange={e => setSearch(e.target.value)}
        />
      </div>
      <DataTable
        title="Parts Used"
        columns={columns}
        data={paginatedPartsUsed}
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
              {selectedPartUsed ? 'Edit Part Used' : 'Add Part Used'}
            </DialogTitle>
          </DialogHeader>
          <div className="mt-4">
            <MaintenancePartUsedForm
              partUsed={selectedPartUsed}
              onSubmit={handleSubmit}
              onCancel={handleClose}
            />
          </div>
        </DialogContent>
      </Dialog>
    </div>
  );
}
