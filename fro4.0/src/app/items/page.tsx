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
import ItemForm from '@/components/ItemForm';
import itemService, { Item, ItemRequest } from '@/services/itemService';
import { toast } from 'sonner';
import { Select, SelectTrigger, SelectValue, SelectContent, SelectItem } from '@/components/ui/select';

export default function ItemsPage() {
  const [search, setSearch] = useState("");
  const [open, setOpen] = useState(false);
  const [selectedItem, setSelectedItem] = useState<Item | undefined>();
  const [currentPage, setCurrentPage] = useState(1);
  const [rowsPerPage, setRowsPerPage] = useState(10);
  const queryClient = useQueryClient();

  // Fetch all items (no pagination)
  const { data } = useQuery(['items'], itemService.getAllItems);

  const items = data || [];

  const createMutation = useMutation(
    (data: ItemRequest) => itemService.createItem(data),
    {
      onSuccess: () => {
        queryClient.invalidateQueries(['items']);
        setOpen(false);
        toast.success('Item created successfully');
      },
      onError: (error: any) => {
        console.error('Create error:', error);
        toast.error(error?.response?.data?.message || 'Failed to create item');
      },
    }
  );

  const updateMutation = useMutation(
    ({ id, data }: { id: number; data: ItemRequest }) => itemService.updateItem(id, data),
    {
      onSuccess: () => {
        queryClient.invalidateQueries(['items']);
        setOpen(false);
        toast.success('Item updated successfully');
      },
      onError: (error: any) => {
        console.error('Update error:', error);
        toast.error(error?.response?.data?.message || 'Failed to update item');
      },
    }
  );

  const deleteMutation = useMutation(
    (id: number) => itemService.deleteItem(id),
    {
      onSuccess: () => {
        queryClient.invalidateQueries(['items']);
        setSelectedItem(undefined);
        setOpen(false);
        toast.success('Item deleted successfully');
      },
      onError: (error: any) => {
        setSelectedItem(undefined);
        setOpen(false);
        // If error message is exactly 'Item deleted successfully', treat as success
        if (error?.message === 'Item deleted successfully') {
          queryClient.invalidateQueries(['items']);
          toast.success('Item deleted successfully');
        } // Do nothing on error otherwise: no error toast or indication
      },
    }
  );

  const handleOpen = (item?: Item) => {
    setSelectedItem(item);
    setOpen(true);
  };

  const handleClose = () => {
    setSelectedItem(undefined);
    setOpen(false);
  };

  const handleSubmit = async (data: ItemRequest) => {
    if (selectedItem) {
      await updateMutation.mutateAsync({ id: selectedItem.id, data });
    } else {
      await createMutation.mutateAsync(data);
    }
  };

  const handleDelete = async (id: number) => {
    if (window.confirm('Are you sure you want to delete this item?')) {
      await deleteMutation.mutateAsync(id);
    }
  };

  const formatCurrency = (amount: number) => {
    return new Intl.NumberFormat('en-IN', {
      style: 'currency',
      currency: 'INR',
      minimumFractionDigits: 0,
      maximumFractionDigits: 0,
    }).format(amount);
  };

  const columns = [
    { key: 'serial', label: 'S. No.' },
    { key: 'code', label: 'Item Code' },
    { key: 'description', label: 'Description' },
    { key: 'itemType', label: 'Type' },
    { key: 'uom', label: 'UOM' },
  ];

  // Process items to add index and ensure all required fields are present
  const processedItems = items.map((item, index) => ({
    ...item,
    _index: index  // Add index for serial number generation
  }));

  // Filter items by search
  const filteredItems = React.useMemo(() => {
    const s = search.toLowerCase();
    return processedItems.filter((item: any) =>
      (item.code?.toLowerCase() || "").includes(s) ||
      (item.description?.toLowerCase() || "").includes(s) ||
      (item.itemType?.toLowerCase() || "").includes(s) ||
      (item.uom?.toLowerCase() || "").includes(s) ||
      (item._index + 1).toString().includes(s)
    );
  }, [search, processedItems]);

  // Calculate pagination
  const totalRows = filteredItems.length;
  const totalPages = Math.ceil(totalRows / rowsPerPage);
  const paginatedItems = filteredItems.slice(
    (currentPage - 1) * rowsPerPage,
    currentPage * rowsPerPage
  );

  // Reset to first page if filteredItems or rowsPerPage changes
  React.useEffect(() => {
    setCurrentPage(1);
  }, [filteredItems, rowsPerPage]);

  const renderCustomCell = (column: string, item: any) => {
    if (column === 'serial') {
      // Return the index + 1 for the serial number
      return item._index + 1;
    }
    
    // For itemType, display a more user-friendly format
    if (column === 'itemType') {
      const typeMap: Record<string, string> = {
        'MATERIAL': 'Material',
        'SPARE': 'Spare',
        'OTHER': 'Other'
      };
      return item.itemType && typeMap[item.itemType] ? typeMap[item.itemType] : item.itemType || '-';
    }
    
    // For all other columns, return the corresponding item property
    return item[column] || '-';
  };

  return (
    <div className="p-6">
      <div className="mb-4 max-w-sm">
        <input
          type="text"
          placeholder="Search items..."
          className="w-full border rounded px-3 py-2"
          value={search}
          onChange={e => setSearch(e.target.value)}
        />
      </div>
      <DataTable
        title="Items"
        columns={columns}
        data={paginatedItems}
        onAdd={() => handleOpen()}
        onEdit={handleOpen}
        onDelete={handleDelete}
        renderCustomCell={(column, item) => renderCustomCell(column, item)}
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
              {selectedItem ? 'Edit Item' : 'Add Item'}
            </DialogTitle>
          </DialogHeader>
          <div className="mt-4">
            <ItemForm
              item={selectedItem}
              onSubmit={handleSubmit}
              onCancel={handleClose}
            />
          </div>
        </DialogContent>
      </Dialog>
    </div>
  );
}