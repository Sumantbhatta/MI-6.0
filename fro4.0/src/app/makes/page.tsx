'use client';

import React from 'react';
import { useQuery, useMutation, useQueryClient } from 'react-query';
import {
  Dialog,
  DialogContent,
  DialogHeader,
  DialogTitle,
} from '@/components/ui/dialog';
import DataTable from '@/components/DataTable';
import { Make, makeService } from '@/services/makeService';
import MakeForm from '@/components/MakeForm';
import { Select, SelectTrigger, SelectValue, SelectContent, SelectItem } from '@/components/ui/select';

export default function MakesPage() {
  const [search, setSearch] = React.useState("");
  const [open, setOpen] = React.useState(false);
  const [selectedMake, setSelectedMake] = React.useState<Make | null>(null);
  const queryClient = useQueryClient();
  const [currentPage, setCurrentPage] = React.useState(1);
  const [rowsPerPage, setRowsPerPage] = React.useState(10);

  // Fetch makes
  const { data: makesData, isLoading } = useQuery('makes', makeService.getAllMakes);
  const makes = makesData?.data || [];

  // Filter makes by search
  const filteredMakes = React.useMemo(() => {
    const s = search.toLowerCase();
    return makes.filter((make: any) =>
      (make.name?.toLowerCase() || "").includes(s) ||
      (make.id?.toString() || "").includes(s)
    );
  }, [makes, search]);

  // Calculate pagination
  const totalRows = filteredMakes.length;
  const totalPages = Math.ceil(totalRows / rowsPerPage);
  const paginatedMakes = filteredMakes.slice(
    (currentPage - 1) * rowsPerPage,
    currentPage * rowsPerPage
  );

  // Reset to first page if filteredMakes or rowsPerPage changes
  React.useEffect(() => {
    setCurrentPage(1);
  }, [filteredMakes, rowsPerPage]);

  // Mutations
  const createMutation = useMutation(makeService.createMake, {
    onSuccess: () => {
      queryClient.invalidateQueries('makes');
      handleClose();
    },
  });

  const updateMutation = useMutation(
    (data: { id: number; make: Make }) => makeService.updateMake(data.id, data.make),
    {
      onSuccess: () => {
        queryClient.invalidateQueries('makes');
        handleClose();
      },
    }
  );

  const deleteMutation = useMutation(makeService.deleteMake, {
    onSuccess: () => {
      queryClient.invalidateQueries('makes');
    },
  });

  const handleOpen = (make?: Make) => {
    setSelectedMake(make || null);
    setOpen(true);
  };

  const handleClose = () => {
    setSelectedMake(null);
    setOpen(false);
  };

  const handleSubmit = (make: Make) => {
    if (selectedMake?.id) {
      updateMutation.mutate({ id: selectedMake.id, make });
    } else {
      createMutation.mutate(make);
    }
  };

  const handleDelete = (id: number) => {
    if (confirm('Are you sure you want to delete this make?')) {
      deleteMutation.mutate(id);
    }
  };

  const columns = [
    { key: 'id', label: 'ID' },
    { key: 'name', label: 'Name' },
  ];

  if (isLoading) {
    return <div className="p-6">Loading...</div>;
  }

  // Summary card data
  const totalMakes = makes.length;

  return (
    <div className="p-6">
      <h1 className="text-2xl font-bold mb-4">Makes</h1>
      <div className="flex gap-4 mb-6">
        <div className="bg-white rounded-lg shadow p-4 flex-1 min-w-[180px] flex items-center justify-between">
          <div>
            <div className="text-lg font-semibold">Total Makes</div>
            <div className="text-2xl font-bold mt-2">{totalMakes}</div>
          </div>
          <div className="text-gray-400 text-3xl">
            <span role="img" aria-label="makes">🏷️</span>
          </div>
        </div>
      </div>
      <div className="bg-white rounded-lg shadow p-4">
        <div className="flex items-center mb-2">
          <div className="text-lg font-semibold">Makes</div>
        </div>
        <div className="mb-4 max-w-sm">
          <input
            type="text"
            placeholder="Search makes..."
            className="w-full border rounded px-3 py-2"
            value={search}
            onChange={e => setSearch(e.target.value)}
          />
        </div>
        <DataTable
          title=""
          columns={columns}
          data={paginatedMakes}
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
      </div>
      <Dialog open={open} onOpenChange={setOpen}>
        <DialogContent className="sm:max-w-[500px]">
          <DialogHeader>
            <DialogTitle>
              {selectedMake ? 'Edit Make' : 'Create Make'}
            </DialogTitle>
          </DialogHeader>
          <div className="mt-4">
            <MakeForm
              make={selectedMake || undefined}
              onSubmit={handleSubmit}
              onCancel={handleClose}
            />
          </div>
        </DialogContent>
      </Dialog>
    </div>
  );
}
