'use client';

import React, { useState } from 'react';
import { useQuery, useMutation, useQueryClient } from 'react-query';
import {
  Dialog,
  DialogContent,
  DialogHeader,
  DialogTitle,
} from '@/components/ui/dialog';
import DataTable from '@/components/DataTable';
import StockStatementGraphs from '@/components/StockStatementGraphs';
import StockStatementForm from '@/components/StockStatementForm';
import stockStatementService, { StockStatement, StockStatementRequest } from '@/services/stockStatementService';
import { toast } from 'sonner';
import {
  Select,
  SelectTrigger,
  SelectValue,
  SelectContent,
  SelectItem,
} from '@/components/ui/select';

export default function StockStatementPage() {

  const [search, setSearch] = useState("");
  const [open, setOpen] = useState(false);
  const [selectedStatement, setSelectedStatement] = useState<StockStatement | undefined>();
  const queryClient = useQueryClient();
  const [currentPage, setCurrentPage] = useState(1);
  const [rowsPerPage, setRowsPerPage] = useState(10);

  const { data: statements = [] } = useQuery(['stockStatements'], () =>
    stockStatementService.getAllStockStatements()
  );

  // Filter statements by search
  const filteredStatements = React.useMemo(() => {
    const s = search.toLowerCase();
    return (Array.isArray(statements) ? statements : []).filter((st: any) =>
      (st.project?.name?.toLowerCase() || "").includes(s) ||
      (st.equipment?.name?.toLowerCase() || "").includes(s) ||
      (st.item?.code?.toLowerCase() || "").includes(s) ||
      (`${st.month || ""}`.toLowerCase().includes(s) || `${st.year || ""}`.toLowerCase().includes(s)) ||
      (st.balance?.toString() || "").includes(s) ||
      (st.landedValue?.toString() || "").includes(s) ||
      (st.landedRate?.toString() || "").includes(s) ||
      (st.lastIssueOn ? new Date(st.lastIssueOn).toLocaleDateString('en-IN').toLowerCase().includes(s) : false) ||
      (st.lastReceiptOn ? new Date(st.lastReceiptOn).toLocaleDateString('en-IN').toLowerCase().includes(s) : false)
    );
  }, [search, statements]);

  // Reset page when search or rowsPerPage changes
  React.useEffect(() => {
    setCurrentPage(1);
  }, [search, rowsPerPage]);

  const totalPages = Math.max(1, Math.ceil(filteredStatements.length / rowsPerPage));
  const paginatedStatements = React.useMemo(() => {
    const start = (currentPage - 1) * rowsPerPage;
    return filteredStatements.slice(start, start + rowsPerPage);
  }, [filteredStatements, currentPage, rowsPerPage]);

  const createMutation = useMutation(
    (data: StockStatementRequest) => stockStatementService.createStockStatement(data),
    {
      onSuccess: () => {
        queryClient.invalidateQueries(['stockStatements']);
        setOpen(false);
        toast.success('Stock statement created successfully');
      },
      onError: () => {
        toast.error('Failed to create stock statement');
      },
    }
  );

  const updateMutation = useMutation(
    ({ id, data }: { id: number; data: StockStatementRequest }) => stockStatementService.updateStockStatement(id, data),
    {
      onSuccess: () => {
        queryClient.invalidateQueries(['stockStatements']);
        setOpen(false);
        toast.success('Stock statement updated successfully');
      },
      onError: () => {
        toast.error('Failed to update stock statement');
      },
    }
  );

  const deleteMutation = useMutation(
    (id: number) => stockStatementService.deleteStockStatement(id),
    {
      onSuccess: () => {
        queryClient.invalidateQueries(['stockStatements']);
        toast.success('Stock statement deleted successfully');
      },
      onError: () => {
        toast.error('Failed to delete stock statement');
      },
    }
  );

  const handleOpen = (statement?: StockStatement) => {
    setSelectedStatement(statement);
    setOpen(true);
  };

  const handleClose = () => {
    setSelectedStatement(undefined);
    setOpen(false);
  };

  const handleSubmit = async (data: StockStatementRequest) => {
    if (selectedStatement) {
      await updateMutation.mutateAsync({ id: selectedStatement.id, data });
    } else {
      await createMutation.mutateAsync(data);
    }
  };

  const handleDelete = async (id: number) => {
    if (window.confirm('Are you sure you want to delete this statement?')) {
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

  const formatCurrency = (amount: number) => {
    return new Intl.NumberFormat('en-IN', {
      style: 'currency',
      currency: 'INR',
      minimumFractionDigits: 0,
      maximumFractionDigits: 0,
    }).format(amount);
  };

  const getMonthName = (month: number) => {
    return new Date(2000, month - 1, 1).toLocaleString('default', { month: 'long' });
  };

  const columns = [
    { key: 'monthYear', label: 'Month/Year' },
    { key: 'project.name', label: 'Project' },
    { key: 'equipment.name', label: 'Equipment' },
    { key: 'item.code', label: 'Item Code' },
    { key: 'balance', label: 'Balance' },
    { key: 'landedValue', label: 'Landed Value' },
    { key: 'landedRate', label: 'Landed Rate' },
    { key: 'lastIssueOn', label: 'Last Issue' },
    { key: 'lastReceiptOn', label: 'Last Receipt' },
    // Add more columns here if you want to show more details
    // { key: 'id', label: 'ID' },
  ];

  const renderCustomCell = (column: string, item: any) => {
    if (column === 'monthYear') {
      return `${getMonthName(item.month)} ${item.year}`;
    }
    if (column === 'project.name') {
      return item.project?.name || '';
    }
    if (column === 'equipment.name') {
      return item.equipment?.name || '';
    }
    if (column === 'item.code') {
      return item.item?.code || '';
    }
    if (column === 'balance') {
      return typeof item.balance === 'number' ? item.balance : '';
    }
    if (column === 'landedValue') {
      return formatCurrency(item.landedValue);
    }
    if (column === 'landedRate') {
      return formatCurrency(item.landedRate);
    }
    if (column === 'lastIssueOn') {
      return formatDate(item.lastIssueOn);
    }
    if (column === 'lastReceiptOn') {
      return formatDate(item.lastReceiptOn);
    }
    return null;
  };

  return (
    <div className="p-4">
      <StockStatementGraphs />

      <div className="mb-4 max-w-sm">
        <input
          type="text"
          placeholder="Search stock statements..."
          className="w-full border rounded px-3 py-2"
          value={search}
          onChange={e => setSearch(e.target.value)}
        />
      </div>

      <DataTable
        title="Stock Statements"
        columns={columns}
        data={paginatedStatements}
        onAdd={() => handleOpen()}
        onEdit={handleOpen}
        onDelete={handleDelete}
        renderCustomCell={renderCustomCell}
      />

      {/* Pagination Controls */}
      <div className="flex flex-col md:flex-row items-center justify-between gap-2 mt-4">
        <div className="flex items-center gap-2">
          <button
            className="px-3 py-1 border rounded disabled:opacity-50"
            onClick={() => setCurrentPage((p) => Math.max(1, p - 1))}
            disabled={currentPage === 1}
          >
            Previous
          </button>
          <span className="mx-2 text-sm">
            Page {currentPage} of {totalPages}
          </span>
          <button
            className="px-3 py-1 border rounded disabled:opacity-50"
            onClick={() => setCurrentPage((p) => Math.min(totalPages, p + 1))}
            disabled={currentPage === totalPages}
          >
            Next
          </button>
        </div>
        <div className="flex items-center gap-2">
          <span className="text-sm">Rows per page:</span>
          <Select value={rowsPerPage.toString()} onValueChange={v => setRowsPerPage(Number(v))}>
            <SelectTrigger className="w-20">
              <SelectValue />
            </SelectTrigger>
            <SelectContent>
              {[5, 10, 20, 50, 100].map(num => (
                <SelectItem key={num} value={num.toString()}>{num}</SelectItem>
              ))}
            </SelectContent>
          </Select>
        </div>
      </div>

      <Dialog open={open} onOpenChange={setOpen}>
        <DialogContent className="max-w-3xl max-h-[90vh] overflow-y-auto">
          <DialogHeader>
            <DialogTitle>
              {selectedStatement ? 'Edit Stock Statement' : 'Add Stock Statement'}
            </DialogTitle>
          </DialogHeader>
          <div className="mt-4">
            <StockStatementForm
              statement={selectedStatement}
              onSubmit={handleSubmit}
              onCancel={handleClose}
            />
          </div>
        </DialogContent>
      </Dialog>
    </div>
  );
}
