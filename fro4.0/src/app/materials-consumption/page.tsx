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
import MaterialsConsumptionGraphs from '@/components/MaterialsConsumptionGraphs';
import MaterialsConsumptionForm from '@/components/MaterialsConsumptionForm';
import materialsConsumptionService, { MaterialsConsumptionTransaction, MaterialsConsumptionTransactionRequest } from '@/services/materialsConsumptionService';
import { toast } from 'sonner';
import { Select, SelectTrigger, SelectValue, SelectContent, SelectItem } from '@/components/ui/select';

export default function MaterialsConsumptionPage() {
  const [search, setSearch] = useState("");
  const [open, setOpen] = useState(false);
  const [selectedTransaction, setSelectedTransaction] = useState<MaterialsConsumptionTransaction | undefined>();
  const [currentPage, setCurrentPage] = useState(1);
  const [rowsPerPage, setRowsPerPage] = useState(10);
  const queryClient = useQueryClient();

  const { data } = useQuery(['materials-consumption', currentPage], () =>
    materialsConsumptionService.getAllTransactions(currentPage, rowsPerPage)
  );

  const transactions = data?.data || [];

  // Filter transactions by search
  const filteredTransactions = React.useMemo(() => {
    const s = search.toLowerCase();
    return transactions.filter((t: any) =>
      (t.project?.name?.toLowerCase() || "").includes(s) ||
      (t.equipment?.name?.toLowerCase() || "").includes(s) ||
      (t.item?.code?.toLowerCase() || "").includes(s) ||
      (t.quantity?.toString() || "").includes(s) ||
      (t.costPerUnit?.toString() || "").includes(s) ||
      (t.totalCost?.toString() || "").includes(s) ||
      (t.issueDate || "").toString().includes(s)
    );
  }, [search, transactions]);

  // Calculate pagination
  const totalRows = filteredTransactions.length;
  const totalPages = Math.ceil(totalRows / rowsPerPage);
  const paginatedTransactions = filteredTransactions.slice(
    (currentPage - 1) * rowsPerPage,
    currentPage * rowsPerPage
  );

  // Reset to first page if filteredTransactions or rowsPerPage changes
  React.useEffect(() => {
    setCurrentPage(1);
  }, [filteredTransactions, rowsPerPage]);

  const createMutation = useMutation(
    (data: MaterialsConsumptionTransactionRequest) => materialsConsumptionService.createTransaction(data),
    {
      onSuccess: () => {
        queryClient.invalidateQueries(['materials-consumption']);
        setOpen(false);
        toast.success('Transaction created successfully');
      },
      onError: (error: any) => {
        console.error('Create error:', error);
        toast.error(error?.response?.data?.message || 'Failed to create transaction');
      },
    }
  );

  const updateMutation = useMutation(
    ({ id, data }: { id: number; data: MaterialsConsumptionTransactionRequest }) => materialsConsumptionService.updateTransaction(id, data),
    {
      onSuccess: () => {
        queryClient.invalidateQueries(['materials-consumption']);
        setOpen(false);
        toast.success('Transaction updated successfully');
      },
      onError: (error: any) => {
        console.error('Update error:', error);
        toast.error(error?.response?.data?.message || 'Failed to update transaction');
      },
    }
  );

  const deleteMutation = useMutation(
    (id: number) => materialsConsumptionService.deleteTransaction(id),
    {
      onSuccess: () => {
        queryClient.invalidateQueries(['materials-consumption']);
        toast.success('Transaction deleted successfully');
      },
      onError: (error: any) => {
        console.error('Delete error:', error);
        toast.error(error?.response?.data?.message || 'Failed to delete transaction');
      },
    }
  );

  const handleOpen = (transaction?: MaterialsConsumptionTransaction) => {
    setSelectedTransaction(transaction);
    setOpen(true);
  };

  const handleClose = () => {
    setSelectedTransaction(undefined);
    setOpen(false);
  };

  const handleSubmit = async (data: MaterialsConsumptionTransactionRequest) => {
    if (selectedTransaction) {
      await updateMutation.mutateAsync({ id: selectedTransaction.id, data });
    } else {
      await createMutation.mutateAsync(data);
    }
  };

  const handleDelete = async (id: number) => {
    if (window.confirm('Are you sure you want to delete this transaction?')) {
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

  const formatDate = (dateString: string) => {
    return new Date(dateString).toLocaleDateString('en-IN', {
      year: 'numeric',
      month: 'short',
      day: 'numeric',
    });
  };

  const columns = [
    { key: 'issueDate', label: 'Issue Date' },
    { key: 'project.name', label: 'Project' },
    { key: 'equipment.name', label: 'Equipment' },
    { key: 'item.code', label: 'Item Code' },
    // { key: 'item.description', label: 'Description' }, // Uncomment if you want description
    { key: 'quantity', label: 'Quantity' },
    { key: 'costPerUnit', label: 'Cost/Unit' },
    { key: 'totalCost', label: 'Total Cost' },
  ];

  const renderCustomCell = (column: string, item: any) => {
    if (column === 'issueDate') {
      return formatDate(item.issueDate);
    }
    if (column === 'costPerUnit') {
      return formatCurrency(item.costPerUnit);
    }
    if (column === 'totalCost') {
      return formatCurrency(item.totalCost);
    }
    return null;
  };
  return (
    <div className="p-4">
      <MaterialsConsumptionGraphs />
      <div className="my-4 max-w-sm">
        <input
          type="text"
          placeholder="Search materials consumption..."
          className="w-full border rounded px-3 py-2"
          value={search}
          onChange={e => setSearch(e.target.value)}
        />
      </div>
      <DataTable
        title="Materials Consumption"
        columns={columns}
        data={paginatedTransactions}
        onAdd={() => handleOpen()}
        onEdit={handleOpen}
        onDelete={handleDelete}
        renderCustomCell={(column, item) => {
          if (column === 'project.name') {
            return item.project?.name || '';
          }
          if (column === 'equipment.name') {
            return item.equipment?.name || '';
          }
          if (column === 'item.code') {
            return item.item?.code || '';
          }
          // Uncomment if you want to show description
          // if (column === 'item.description') {
          //   return item.item?.description || '';
          // }
          if (column === 'costPerUnit' || column === 'totalCost') {
            return formatCurrency(item[column]);
          }
          if (column === 'issueDate') {
            return formatDate(item.issueDate);
          }
          if (column === 'quantity') {
            return typeof item.quantity === 'number' ? item.quantity : '';
          }
          return null;
        }}
      />

      <div className="flex items-center justify-between mt-4 px-4 pb-4">
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

      <Dialog open={open} onOpenChange={setOpen}>
        <DialogContent className="max-w-3xl max-h-[90vh] overflow-y-auto">
          <DialogHeader>
            <DialogTitle>
              {selectedTransaction ? 'Edit Transaction' : 'Add Transaction'}
            </DialogTitle>
          </DialogHeader>
          <div className="mt-4">
            <MaterialsConsumptionForm
              transaction={selectedTransaction}
              onSubmit={handleSubmit}
              onCancel={handleClose}
            />
          </div>
        </DialogContent>
      </Dialog>
    </div>
  );
}
