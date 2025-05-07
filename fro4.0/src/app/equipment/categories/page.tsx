'use client';

import React, { useMemo } from 'react';
import { useQuery, useMutation, useQueryClient } from 'react-query';
import {
  Dialog,
  DialogContent,
  DialogHeader,
  DialogTitle,
} from '@/components/ui/dialog';
import DataTable from '@/components/DataTable';
import { Category, CategoryRequest, categoryService } from '@/services/categoryService';
import CategoryForm from '@/components/CategoryForm';
import { Tooltip } from '@/components/ui/tooltip';
import { TooltipContent, TooltipProvider, TooltipTrigger } from '@/components/ui/tooltip';
import { Select, SelectTrigger, SelectValue, SelectContent, SelectItem } from '@/components/ui/select';

export default function CategoriesPage() {
  const [search, setSearch] = React.useState("");
  const [open, setOpen] = React.useState(false);
  const [selectedCategory, setSelectedCategory] = React.useState<Category | null>(null);
  const queryClient = useQueryClient();
  const [currentPage, setCurrentPage] = React.useState(1);
  const [rowsPerPage, setRowsPerPage] = React.useState(10);

  // Fetch categories
  const { data: categoriesData = [], isLoading } = useQuery(['categories'], categoryService.getAllCategories);
  // Reset IDs for display only (after deletion or fetch)
  const categoriesRaw = categoriesData.slice().sort((a: { id?: number }, b: { id?: number }) => (a.id ?? 0) - (b.id ?? 0));
  const categories = categoriesRaw.map((cat: any, idx: number) => ({ ...cat, displayId: idx + 1 }));

  // Filter categories by search
  const filteredCategories = React.useMemo(() => {
    const s = search.toLowerCase();
    return categories.filter((cat: any) =>
      (cat.name?.toLowerCase() || "").includes(s) ||
      (cat.displayId?.toString() || "").includes(s)
    );
  }, [categories, search]);

  // Calculate pagination
  const totalRows = filteredCategories.length;
  const totalPages = Math.ceil(totalRows / rowsPerPage);
  const paginatedCategories = filteredCategories.slice(
    (currentPage - 1) * rowsPerPage,
    currentPage * rowsPerPage
  );

  // Reset to first page if filteredCategories or rowsPerPage changes
  React.useEffect(() => {
    setCurrentPage(1);
  }, [filteredCategories, rowsPerPage]);

  // Mutations
  const createMutation = useMutation(categoryService.createCategory, {
    onSuccess: () => {
      queryClient.invalidateQueries(['categories']);
      handleClose();
    },
  });

  const updateMutation = useMutation(
    (data: { id: number; category: CategoryRequest }) => categoryService.updateCategory(data.id, data.category),
    {
      onSuccess: () => {
        queryClient.invalidateQueries(['categories']);
        handleClose();
      },
    }
  );

  const deleteMutation = useMutation(categoryService.deleteCategory, {
    onSuccess: () => {
      queryClient.invalidateQueries(['categories']);
    },
  });

  const handleOpen = (category?: Category) => {
    setSelectedCategory(category || null);
    setOpen(true);
  };

  const handleClose = () => {
    setSelectedCategory(null);
    setOpen(false);
  };

  const handleSubmit = (categoryData: CategoryRequest) => {
    if (selectedCategory?.id) {
      updateMutation.mutate({ id: selectedCategory.id, category: categoryData });
    } else {
      createMutation.mutate(categoryData);
    }
  };

  const handleDelete = (id: number) => {
    if (confirm('Are you sure you want to delete this category?')) {
      deleteMutation.mutate(id);
    }
  };

  const columns = [
    { key: 'displayId', label: 'ID' },
    { key: 'name', label: 'Name' },
  ];

  const renderCustomCell = (column: string, item: any) => {
    if (column === 'displayId') {
      return <span style={{ padding: '0 12px' }}>{item.displayId}</span>;
    }
    if (column === 'name') {
      return <span style={{ padding: '0 12px' }}>{item.name}</span>;
    }
    return null;
  };


  if (isLoading) {
    return <div className="p-6">Loading...</div>;
  }

  return (
    <div className="p-6">
      <div className="mb-4 max-w-sm">
        <input
          type="text"
          placeholder="Search categories..."
          className="w-full border rounded px-3 py-2"
          value={search}
          onChange={e => setSearch(e.target.value)}
        />
      </div>
      <DataTable
        title="Equipment Category"
        columns={columns}
        data={paginatedCategories}
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
        <DialogContent className="sm:max-w-[500px]">
          <DialogHeader>
            <DialogTitle>
              {selectedCategory ? 'Edit Category' : 'Create Category'}
            </DialogTitle>
          </DialogHeader>
          <div className="mt-4">
            <CategoryForm
              category={selectedCategory || undefined}
              onSubmit={handleSubmit}
              onCancel={handleClose}
            />
          </div>
        </DialogContent>
      </Dialog>
    </div>
  );
}