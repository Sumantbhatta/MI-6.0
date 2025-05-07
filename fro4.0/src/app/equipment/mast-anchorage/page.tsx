'use client';

import React, { useState, useMemo } from 'react';
import { useQuery, useMutation, useQueryClient } from 'react-query';
import {
  Dialog,
  DialogContent,
  DialogHeader,
  DialogTitle,
} from '@/components/ui/dialog';
import DataTable from '@/components/DataTable';
import MastAnchorageForm from '@/components/MastAnchorageForm';
import mastAnchorageService, { MastAnchorageDetails, MastAnchorageRequest } from '@/services/mastAnchorageService';
import { toast } from 'sonner';
import { Select, SelectTrigger, SelectValue, SelectContent, SelectItem } from '@/components/ui/select';

export default function MastAnchoragePage() {
  const [search, setSearch] = useState("");
  const [open, setOpen] = useState(false);
  const [selectedMastAnchorage, setSelectedMastAnchorage] = useState<MastAnchorageDetails | undefined>();
  const queryClient = useQueryClient();
  const [currentPage, setCurrentPage] = useState(1);
  const [rowsPerPage, setRowsPerPage] = useState(10);

  const { data: mastAnchorages = [] } = useQuery(['mastAnchorages'], () =>
    mastAnchorageService.getAllMastAnchorage()
  );

  // Filter mast anchorages by search
  const filteredMastAnchorages = useMemo(() => {
    const s = search.toLowerCase();
    return mastAnchorages.filter((m: any) =>
      (m.project?.name?.toLowerCase() || "").includes(s) ||
      (m.equipment?.name?.toLowerCase() || "").includes(s) ||
      (m.location?.toLowerCase() || "").includes(s) ||
      (m.status?.toLowerCase() || "").includes(s) ||
      (m.totalAnchorageRequirement?.toString() || "").includes(s) ||
      (m.totalMastRequirement?.toString() || "").includes(s)
    );
  }, [search, mastAnchorages]);

  // Calculate pagination
  const totalRows = filteredMastAnchorages.length;
  const totalPages = Math.ceil(totalRows / rowsPerPage);
  const paginatedMastAnchorages = filteredMastAnchorages.slice(
    (currentPage - 1) * rowsPerPage,
    currentPage * rowsPerPage
  );

  // Reset to first page if filteredMastAnchorages or rowsPerPage changes
  React.useEffect(() => {
    setCurrentPage(1);
  }, [filteredMastAnchorages, rowsPerPage]);

  const createMutation = useMutation(
    (data: MastAnchorageRequest) => mastAnchorageService.createMastAnchorage(data),
    {
      onSuccess: () => {
        queryClient.invalidateQueries(['mastAnchorages']);
        setOpen(false);
        toast.success('Mast anchorage created successfully');
      },
      onError: () => {
        toast.error('Failed to create mast anchorage');
      },
    }
  );

  const updateMutation = useMutation(
    ({ id, data }: { id: number; data: MastAnchorageRequest }) => mastAnchorageService.updateMastAnchorage(id, data),
    {
      onSuccess: () => {
        queryClient.invalidateQueries(['mastAnchorages']);
        setOpen(false);
        toast.success('Mast anchorage updated successfully');
      },
      onError: () => {
        toast.error('Failed to update mast anchorage');
      },
    }
  );

  const deleteMutation = useMutation(
    (id: number) => mastAnchorageService.deleteMastAnchorage(id),
    {
      onSuccess: () => {
        queryClient.invalidateQueries(['mastAnchorages']);
        toast.success('Mast anchorage deleted successfully');
      },
      onError: () => {
        toast.error('Failed to delete mast anchorage');
      },
    }
  );

  const handleOpen = (mastAnchorage?: MastAnchorageDetails) => {
    setSelectedMastAnchorage(mastAnchorage);
    setOpen(true);
  };

  const handleClose = () => {
    setSelectedMastAnchorage(undefined);
    setOpen(false);
  };

  const handleSubmit = async (data: MastAnchorageRequest) => {
    if (selectedMastAnchorage) {
      await updateMutation.mutateAsync({ id: selectedMastAnchorage.id, data });
    } else {
      await createMutation.mutateAsync(data);
    }
  };

  const handleDelete = async (id: number) => {
    if (window.confirm('Are you sure you want to delete this mast anchorage?')) {
      await deleteMutation.mutateAsync(id);
    }
  };

  const columns = [
    { key: 'project.name', label: 'Project' },
    { key: 'equipment.name', label: 'Equipment' },
    { key: 'location', label: 'Location' },
    { key: 'status', label: 'Status' },
    { key: 'totalAnchorageRequirement', label: 'Total Anchorage' },
    { key: 'totalMastRequirement', label: 'Total Mast' },
  ];

  return (
    <div className="p-4">
      <div className="mb-4 max-w-sm">
        <input
          type="text"
          placeholder="Search mast anchorage..."
          className="w-full border rounded px-3 py-2"
          value={search}
          onChange={e => setSearch(e.target.value)}
        />
      </div>
      <DataTable
        title="Mast Anchorage"
        columns={columns}
        data={paginatedMastAnchorages}
        onAdd={() => handleOpen()}
        onEdit={handleOpen}
        onDelete={handleDelete}
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
              {selectedMastAnchorage ? 'Edit Mast Anchorage' : 'Add Mast Anchorage'}
            </DialogTitle>
          </DialogHeader>
          <div className="mt-4">
            <MastAnchorageForm
              mastAnchorage={selectedMastAnchorage}
              onSubmit={handleSubmit}
              onCancel={handleClose}
            />
          </div>
        </DialogContent>
      </Dialog>
    </div>
  );
}
