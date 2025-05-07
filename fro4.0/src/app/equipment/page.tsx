'use client';

import React from 'react';
import { useRouter } from 'next/navigation';
import { useQuery, useMutation, useQueryClient } from 'react-query';
import { Equipment, equipmentService } from '@/services/equipmentService';
import DataTable from '@/components/DataTable';
import {
  Dialog,
  DialogContent,
  DialogHeader,
  DialogTitle,
} from '@/components/ui/dialog';
import EquipmentForm from '@/components/EquipmentForm';
import EquipmentView from '@/components/EquipmentView';
import { Select, SelectTrigger, SelectValue, SelectContent, SelectItem } from '@/components/ui/select';

export default function EquipmentPage() {
  const [search, setSearch] = React.useState("");
  const [open, setOpen] = React.useState(false);
  const [selectedEquipment, setSelectedEquipment] = React.useState<Equipment | undefined>();
  const queryClient = useQueryClient();
  const router = useRouter();
  const [currentPage, setCurrentPage] = React.useState(1);
  const [rowsPerPage, setRowsPerPage] = React.useState(10);

  const { data: equipment = [] } = useQuery(['equipment'], () =>
    equipmentService.getAllEquipment()
  );

  // Filter equipment by search
  const filteredEquipment = React.useMemo(() => {
    const s = search.toLowerCase();
    return equipment.filter((eq: any) =>
      (eq.name?.toLowerCase() || "").includes(s) ||
      (eq.assetCode?.toLowerCase() || "").includes(s) ||
      (eq.yearOfManufacture?.toString() || "").includes(s) ||
      (eq.category?.name?.toLowerCase() || "").includes(s) ||
      (eq.model?.name?.toLowerCase() || "").includes(s) ||
      (eq.project?.name?.toLowerCase() || "").includes(s)
    );
  }, [equipment, search]);

  // Calculate pagination
  const totalRows = filteredEquipment.length;
  const totalPages = Math.ceil(totalRows / rowsPerPage);
  const paginatedEquipment = filteredEquipment.slice(
    (currentPage - 1) * rowsPerPage,
    currentPage * rowsPerPage
  );

  // Reset to first page if filteredEquipment or rowsPerPage changes
  React.useEffect(() => {
    setCurrentPage(1);
  }, [filteredEquipment, rowsPerPage]);

  const createMutation = useMutation(
    (data: any) => equipmentService.createEquipment(data),
    {
      onSuccess: () => {
        queryClient.invalidateQueries(['equipment']);
        handleClose();
      },
    }
  );

  const updateMutation = useMutation(
    ({ id, data }: { id: number; data: any }) =>
      equipmentService.updateEquipment(id, data),
    {
      onSuccess: () => {
        queryClient.invalidateQueries(['equipment']);
        handleClose();
      },
    }
  );

  const deleteMutation = useMutation(
    (id: number) => equipmentService.deleteEquipment(id),
    {
      onSuccess: () => {
        queryClient.invalidateQueries(['equipment']);
      },
    }
  );

  const handleOpen = (equipment?: Equipment) => {
    setSelectedEquipment(equipment);
    setOpen(true);
  };

  const handleClose = () => {
    setSelectedEquipment(undefined);
    setOpen(false);
  };

  const handleSubmit = (data: any) => {
    if (selectedEquipment) {
      updateMutation.mutate({ id: selectedEquipment.id, data });
    } else {
      createMutation.mutate(data);
    }
  };

  const handleDelete = (id: number) => {
    if (confirm('Are you sure you want to delete this equipment?')) {
      deleteMutation.mutate(id);
    }
  };

  const handleViewMore = (equipment: Equipment) => {
    router.push(`/equipment/${equipment.id}`);
  };

  const columns = [
    { key: 'name', label: 'Name' },
    { key: 'assetCode', label: 'Asset Code' },
    { key: 'yearOfManufacture', label: 'Year' },
    { key: 'category.name', label: 'Category' },
    { key: 'model.name', label: 'Model' },
    { key: 'project.name', label: 'Project' },
  ];

  return (
    <div className="p-4">
      <div className="mb-4 max-w-sm">
        <input
          type="text"
          placeholder="Search equipment..."
          className="w-full border rounded px-3 py-2"
          value={search}
          onChange={e => setSearch(e.target.value)}
        />
      </div>
      <EquipmentView
        equipment={paginatedEquipment}
        onEdit={handleOpen}
        onDelete={handleDelete}
        onViewMore={handleViewMore}
        onAdd={() => handleOpen()}
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
        <DialogContent>
          <DialogHeader>
            <DialogTitle>
              {selectedEquipment ? 'Edit Equipment' : 'Add Equipment'}
            </DialogTitle>
          </DialogHeader>
          <EquipmentForm
            equipment={selectedEquipment}
            onSubmit={handleSubmit}
            onCancel={handleClose}
          />
        </DialogContent>
      </Dialog>
    </div>
  );
}
