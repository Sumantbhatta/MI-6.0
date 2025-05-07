'use client';

import { useState, useEffect, useMemo } from 'react';
import { useQuery, useMutation, useQueryClient } from 'react-query';
import { Tabs, TabsContent, TabsList, TabsTrigger } from '@/components/ui/tabs';
import { Card, CardContent, CardDescription, CardHeader, CardTitle } from '@/components/ui/card';
import { Button } from '@/components/ui/button';
import { Dialog, DialogContent, DialogHeader, DialogTitle } from '@/components/ui/dialog';
import { Input } from '@/components/ui/input';
import { Clock, DollarSign, Fuel } from 'lucide-react';
import { LineChart, BarChart } from '@/components/ui/charts';
import DataTable from '@/components/DataTable';
import OvertimeReportForm from '@/components/OvertimeReportForm';
import PettyCashForm from '@/components/PettyCashForm';
import overtimeReportService, { OvertimeReport, OvertimeReportRequest } from '@/services/overtimeReportService';
import pettyCashService, { PettyCashTransaction, PettyCashTransactionRequest } from '@/services/pettyCashService';
import { toast } from 'sonner';
import {
  Select,
  SelectTrigger,
  SelectValue,
  SelectContent,
  SelectItem,
} from '@/components/ui/select';

export default function FinancialsPage() {
  // Search state for overtime and petty cash
  const [overtimeSearch, setOvertimeSearch] = useState("");
  const [pettyCashSearch, setPettyCashSearch] = useState("");

  // Main state and data
  const [activeTab, setActiveTab] = useState('overtime');
  const [overtimeDialogOpen, setOvertimeDialogOpen] = useState(false);
  const [pettyCashDialogOpen, setPettyCashDialogOpen] = useState(false);
  const [selectedOvertimeReport, setSelectedOvertimeReport] = useState<OvertimeReport | undefined>();
  const [selectedTransaction, setSelectedTransaction] = useState<PettyCashTransaction | undefined>();
  const queryClient = useQueryClient();

  // Pagination state for Overtime
  const [overtimeCurrentPage, setOvertimeCurrentPage] = useState(1);
  const [overtimeRowsPerPage, setOvertimeRowsPerPage] = useState(10);
  // Pagination state for Petty Cash
  const [pettyCashCurrentPage, setPettyCashCurrentPage] = useState(1);
  const [pettyCashRowsPerPage, setPettyCashRowsPerPage] = useState(10);

  // Reset page when search or rowsPerPage changes (Overtime)
  useEffect(() => {
    setOvertimeCurrentPage(1);
  }, [overtimeSearch, overtimeRowsPerPage]);
  // Reset page when search or rowsPerPage changes (Petty Cash)
  useEffect(() => {
    setPettyCashCurrentPage(1);
  }, [pettyCashSearch, pettyCashRowsPerPage]);

  // Overtime data
  const { data: overtimeData } = useQuery(['overtimeReports'], () =>
    overtimeReportService.getAllOvertimeReports()
  );
  const overtimeReports = Array.isArray(overtimeData) ? overtimeData : [];

  // Petty cash data
  const { data: pettyCashData } = useQuery(['pettyCash'], () =>
    pettyCashService.getAllPettyCash()
  );
  const transactions = Array.isArray(pettyCashData) ? pettyCashData : [];

  // Filtered data for overtime table
  const filteredOvertimeReports = overtimeReports.filter((report: any) => {
    const search = overtimeSearch.toLowerCase();
    return (
      (report.employee?.name?.toLowerCase() || "").includes(search) ||
      (report.remarks?.toLowerCase() || "").includes(search) ||
      (report.date || "").toString().includes(search)
    );
  });

  // Filtered data for petty cash table
  const filteredPettyCashTransactions = transactions.filter((txn: any) => {
    const search = pettyCashSearch.toLowerCase();
    return (
      (txn.item?.code?.toLowerCase() || "").includes(search) ||
      (txn.project?.name?.toLowerCase() || "").includes(search) ||
      (txn.equipment?.name?.toLowerCase() || "").includes(search) ||
      (txn.purposeJustification?.toLowerCase() || "").includes(search) ||
      (txn.reportDate || "").toString().includes(search)
    );
  });

  // Calculate total overtime hours
  const totalOvertimeHours = overtimeReports.reduce((total, report) => total + (report.otHours || 0), 0);

  // Calculate total fuel consumption (assuming this is related to overtime)
  const totalFuelConsumption = overtimeReports.reduce((total, report) => {
    // This is a placeholder. In a real app, you'd have a proper fuel consumption field
    return total + 120; // Placeholder value matching the UI mockup
  }, 0);

  // Calculate total petty cash amount
  const totalPettyCashAmount = transactions.reduce((total, transaction) => total + (transaction.amountSpent || 0), 0);

  // Overtime mutations
  const createOvertimeMutation = useMutation(
    (data: OvertimeReportRequest) => overtimeReportService.createOvertimeReport(data),
    {
      onSuccess: () => {
        queryClient.invalidateQueries(['overtimeReports']);
        setOvertimeDialogOpen(false);
        toast.success('Overtime report created successfully');
      },
      onError: () => {
        toast.error('Failed to create overtime report');
      },
    }
  );

  const updateOvertimeMutation = useMutation(
    ({ id, data }: { id: number; data: OvertimeReportRequest }) => overtimeReportService.updateOvertimeReport(id, data),
    {
      onSuccess: () => {
        queryClient.invalidateQueries(['overtimeReports']);
        setOvertimeDialogOpen(false);
        toast.success('Overtime report updated successfully');
      },
      onError: () => {
        toast.error('Failed to update overtime report');
      },
    }
  );

  const deleteOvertimeMutation = useMutation(
    (id: number) => overtimeReportService.deleteOvertimeReport(id),
    {
      onSuccess: () => {
        queryClient.invalidateQueries(['overtimeReports']);
        toast.success('Overtime report deleted successfully');
      },
      onError: () => {
        toast.error('Failed to delete overtime report');
      },
    }
  );

  // Petty cash mutations
  const createPettyCashMutation = useMutation(
    (data: PettyCashTransactionRequest) => pettyCashService.createPettyCash(data),
    {
      onSuccess: () => {
        queryClient.invalidateQueries(['pettyCash']);
        setPettyCashDialogOpen(false);
        toast.success('Petty cash transaction created successfully');
      },
      onError: () => {
        toast.error('Failed to create petty cash transaction');
      },
    }
  );

  const updatePettyCashMutation = useMutation(
    ({ id, data }: { id: number; data: PettyCashTransactionRequest }) => pettyCashService.updatePettyCash(id, data),
    {
      onSuccess: () => {
        queryClient.invalidateQueries(['pettyCash']);
        setPettyCashDialogOpen(false);
        toast.success('Petty cash transaction updated successfully');
      },
      onError: () => {
        toast.error('Failed to update petty cash transaction');
      },
    }
  );

  const deletePettyCashMutation = useMutation(
    (id: number) => pettyCashService.deletePettyCash(id),
    {
      onSuccess: () => {
        queryClient.invalidateQueries(['pettyCash']);
        toast.success('Petty cash transaction deleted successfully');
      },
      onError: () => {
        toast.error('Failed to delete petty cash transaction');
      },
    }
  );

  // Overtime handlers
  const handleOpenOvertimeDialog = (report?: OvertimeReport) => {
    setSelectedOvertimeReport(report);
    setOvertimeDialogOpen(true);
  };

  const handleCloseOvertimeDialog = () => {
    setSelectedOvertimeReport(undefined);
    setOvertimeDialogOpen(false);
  };

  const handleSubmitOvertimeReport = async (data: OvertimeReportRequest) => {
    if (selectedOvertimeReport) {
      await updateOvertimeMutation.mutateAsync({ id: selectedOvertimeReport.id, data });
    } else {
      await createOvertimeMutation.mutateAsync(data);
    }
  };

  const handleDeleteOvertimeReport = async (id: number) => {
    if (window.confirm('Are you sure you want to delete this overtime report?')) {
      await deleteOvertimeMutation.mutateAsync(id);
    }
  };

  // Petty cash handlers
  const handleOpenPettyCashDialog = (transaction?: PettyCashTransaction) => {
    setSelectedTransaction(transaction);
    setPettyCashDialogOpen(true);
  };

  const handleClosePettyCashDialog = () => {
    setSelectedTransaction(undefined);
    setPettyCashDialogOpen(false);
  };

  const handleSubmitPettyCashTransaction = async (data: PettyCashTransactionRequest) => {
    if (selectedTransaction) {
      await updatePettyCashMutation.mutateAsync({ id: selectedTransaction.id, data });
    } else {
      await createPettyCashMutation.mutateAsync(data);
    }
  };

  const handleDeletePettyCashTransaction = async (id: number) => {
    if (window.confirm('Are you sure you want to delete this transaction?')) {
      await deletePettyCashMutation.mutateAsync(id);
    }
  };

  // Formatting functions
  const formatDate = (dateString: string) => {
    return new Date(dateString).toLocaleDateString('en-US', {
      year: 'numeric',
      month: 'short',
      day: 'numeric',
    });
  };

  const formatCurrency = (amount: number | null | undefined) => {
    if (amount === null || amount === undefined || isNaN(amount)) {
      return '-';
    }
    return new Intl.NumberFormat('en-IN', {
      style: 'currency',
      currency: 'INR',
      minimumFractionDigits: 0,
      maximumFractionDigits: 0,
    }).format(amount);
  };

  // Overtime table columns
  const overtimeColumns = [
    { key: 'employee.name', label: 'Employee' },
    { key: 'date', label: 'Date' },
    { key: 'presentDays', label: 'Present Days' },
    { key: 'otHours', label: 'OT Hours' },
    { key: 'remarks', label: 'Remarks' },
  ];

  const renderOvertimeCustomCell = (column: string, item: any) => {
    switch (column) {
      case 'employee.name':
        return item.employee && item.employee.name ? item.employee.name : '-';
      case 'date':
        return item.date ? formatDate(item.date) : '-';
      case 'presentDays':
        return item.presentDays !== undefined && item.presentDays !== null ? item.presentDays : '-';
      case 'otHours':
        return item.otHours !== undefined && item.otHours !== null ? item.otHours : '-';
      case 'remarks':
        return item.remarks || '-';
      default:
        return null;
    }
  };

  // Petty cash table columns
  const pettyCashColumns = [
    { key: 'reportDate', label: 'Date' },
    { key: 'project.name', label: 'Project' },
    { key: 'equipment.name', label: 'Equipment' },
    { key: 'item.code', label: 'Item Code' },
    { key: 'amountSpent', label: 'Amount' },
    { key: 'quantity', label: 'Quantity' },
    { key: 'cumulativeTotalAmount', label: 'Cumulative' },
    { key: 'purposeJustification', label: 'Purpose' },
  ];

  const renderPettyCashCustomCell = (column: string, item: any) => {
    if (column === 'item.code') {
      return item.item?.code || '';
    }
    if (column === 'project.name') {
      return item.project?.name || '';
    }
    if (column === 'equipment.name') {
      return item.equipment?.name || '';
    }
    if (column === 'reportDate') {
      return formatDate(item.reportDate);
    }
    if (column === 'amountSpent') {
      return formatCurrency(item.amountSpent);
    }
    if (column === 'cumulativeTotalAmount') {
      return formatCurrency(item.cumulativeTotalAmount);
    }
    if (column === 'quantity') {
      return typeof item.quantity === 'number' ? item.quantity : '';
    }
    if (column === 'purposeJustification') {
      return item.purposeJustification || '';
    }
    return null;
  };

  // Sample data for charts
  const overtimeByMachine = [
    { name: 'Tower Crane TC-01', hours: 6 },
    { name: 'Bulldozer BD-04', hours: 2 },
    { name: 'Forklift FL-06', hours: 1.5 },
  ];

  const overtimeTrend = [
    { date: '2024-01-15', hours: 3.5 },
    { date: '2024-01-18', hours: 2 },
    { date: '2024-01-20', hours: 1.5 },
    { date: '2024-01-22', hours: 2.5 },
  ];

  const pettyCashTrend = [
    { month: 'Jan', amount: 450 },
    { month: 'Feb', amount: 700 },
    { month: 'Mar', amount: 300 },
    { month: 'Apr', amount: 550 },
    { month: 'May', amount: 280 },
    { month: 'Jun', amount: 400 },
  ];

  // Overtime pagination logic
  const overtimeTotalPages = Math.max(1, Math.ceil(filteredOvertimeReports.length / overtimeRowsPerPage));
  const paginatedOvertimeReports = useMemo(() => {
    const start = (overtimeCurrentPage - 1) * overtimeRowsPerPage;
    return filteredOvertimeReports.slice(start, start + overtimeRowsPerPage);
  }, [filteredOvertimeReports, overtimeCurrentPage, overtimeRowsPerPage]);

  // Petty Cash pagination logic
  const pettyCashTotalPages = Math.max(1, Math.ceil(filteredPettyCashTransactions.length / pettyCashRowsPerPage));
  const paginatedPettyCashTransactions = useMemo(() => {
    const start = (pettyCashCurrentPage - 1) * pettyCashRowsPerPage;
    return filteredPettyCashTransactions.slice(start, start + pettyCashRowsPerPage);
  }, [filteredPettyCashTransactions, pettyCashCurrentPage, pettyCashRowsPerPage]);

  return (
    <div className="p-4 space-y-6">
      <div>
        <h1 className="text-2xl font-bold tracking-tight">Financials</h1>
        <p className="text-muted-foreground">Manage overtime and petty cash transactions</p>
      </div>

      {/* Summary Cards */}
      <div className="grid gap-4 md:grid-cols-3">
        <Card>
          <CardHeader className="flex flex-row items-center justify-between space-y-0 pb-2">
            <CardTitle className="text-sm font-medium">Total Overtime</CardTitle>
            <Clock className="h-4 w-4 text-muted-foreground" />
          </CardHeader>
          <CardContent>
            <div className="text-2xl font-bold">{totalOvertimeHours.toFixed(1)} hours</div>
            <p className="text-xs text-muted-foreground">Cumulative overtime hours</p>
          </CardContent>
        </Card>
        <Card>
          <CardHeader className="flex flex-row items-center justify-between space-y-0 pb-2">
            <CardTitle className="text-sm font-medium">Fuel Consumption</CardTitle>
            <Fuel className="h-4 w-4 text-muted-foreground" />
          </CardHeader>
          <CardContent>
            <div className="text-2xl font-bold">{totalFuelConsumption} liters</div>
            <p className="text-xs text-muted-foreground">Total fuel used during overtime</p>
          </CardContent>
        </Card>
        <Card>
          <CardHeader className="flex flex-row items-center justify-between space-y-0 pb-2">
            <CardTitle className="text-sm font-medium">Petty Cash</CardTitle>
            <DollarSign className="h-4 w-4 text-muted-foreground" />
          </CardHeader>
          <CardContent>
            <div className="text-2xl font-bold">{formatCurrency(totalPettyCashAmount)}</div>
            <p className="text-xs text-muted-foreground">Total petty cash expenses</p>
          </CardContent>
        </Card>
      </div>

      {/* Tabs for Overtime and Petty Cash */}
      <Tabs value={activeTab} onValueChange={setActiveTab} className="w-full">
        <TabsList className="grid w-full max-w-md grid-cols-2">
          <TabsTrigger value="overtime">Overtime</TabsTrigger>
          <TabsTrigger value="petty-cash">Petty Cash</TabsTrigger>
        </TabsList>

        {/* Overtime Tab Content */}
        <TabsContent value="overtime" className="space-y-6">
          {/* Overtime Charts */}
          <div className="grid gap-4 md:grid-cols-2">
            <Card>
              <CardHeader>
                <CardTitle>Overtime Hours by Machine</CardTitle>
                <CardDescription>Total overtime hours per machine</CardDescription>
              </CardHeader>
              <CardContent>
                <BarChart
                  data={overtimeByMachine}
                  index="name"
                  categories={["hours"]}
                  colors={["blue"]}
                  valueFormatter={(value: number) => `${value}`}
                  className="h-80"
                />
              </CardContent>
            </Card>
            <Card>
              <CardHeader>
                <CardTitle>Overtime Trend</CardTitle>
                <CardDescription>Overtime hours trend over time</CardDescription>
              </CardHeader>
              <CardContent>
                <LineChart
                  data={overtimeTrend}
                  index="date"
                  categories={["hours"]}
                  colors={["blue"]}
                  valueFormatter={(value: number) => `${value}`}
                  className="h-80"
                />
              </CardContent>
            </Card>
          </div>

          {/* Overtime Records Table */}
          <div className="bg-card rounded-lg border shadow-sm">
            <div className="p-4">
              <div className="flex items-center justify-between mb-4">
                <h3 className="text-lg font-semibold">Overtime Records</h3>
                <div className="flex gap-2">
                  <Button onClick={() => handleOpenOvertimeDialog()} className="bg-blue-600 hover:bg-blue-700">
                    Log Overtime
                  </Button>
                  
                </div>
              </div>
              <div className="mb-4">
                <Input
                  placeholder="Search overtime records..."
                  className="max-w-sm"
                  value={overtimeSearch}
                  onChange={e => setOvertimeSearch(e.target.value)}
                />
              </div>
              <DataTable
                title=""
                columns={overtimeColumns}
                data={paginatedOvertimeReports}
                onAdd={() => handleOpenOvertimeDialog()}
                onEdit={handleOpenOvertimeDialog}
                onDelete={handleDeleteOvertimeReport}
                renderCustomCell={renderOvertimeCustomCell}
                showTitle={false}
              />
              {/* Pagination Controls for Overtime */}
              <div className="flex flex-col md:flex-row items-center justify-between gap-2 mt-4">
                <div className="flex items-center gap-2">
                  <button
                    className="px-3 py-1 border rounded disabled:opacity-50"
                    onClick={() => setOvertimeCurrentPage((p) => Math.max(1, p - 1))}
                    disabled={overtimeCurrentPage === 1}
                  >
                    Previous
                  </button>
                  <span className="mx-2 text-sm">
                    Page {overtimeCurrentPage} of {overtimeTotalPages}
                  </span>
                  <button
                    className="px-3 py-1 border rounded disabled:opacity-50"
                    onClick={() => setOvertimeCurrentPage((p) => Math.min(overtimeTotalPages, p + 1))}
                    disabled={overtimeCurrentPage === overtimeTotalPages}
                  >
                    Next
                  </button>
                </div>
                <div className="flex items-center gap-2">
                  <span className="text-sm">Rows per page:</span>
                  <Select value={overtimeRowsPerPage.toString()} onValueChange={v => setOvertimeRowsPerPage(Number(v))}>
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
            </div>
          </div>
        </TabsContent>

        {/* Petty Cash Tab Content */}
        <TabsContent value="petty-cash" className="space-y-6">
          {/* Petty Cash Chart */}
          <Card>
            <CardHeader>
              <CardTitle>Monthly Petty Cash Expenses</CardTitle>
              <CardDescription>Expenses trend over time</CardDescription>
            </CardHeader>
            <CardContent>
              <LineChart
                data={pettyCashTrend}
                index="month"
                categories={["amount"]}
                colors={["emerald"]}
                valueFormatter={(value: number) => formatCurrency(value)}
                className="h-80"
              />
            </CardContent>
          </Card>

          {/* Petty Cash Transactions Table */}
          <div className="bg-card rounded-lg border shadow-sm">
            <div className="p-4">
              <div className="flex items-center justify-between mb-4">
                <h3 className="text-lg font-semibold">Petty Cash Transactions</h3>
                <div className="flex gap-2">
                  <Button onClick={() => handleOpenPettyCashDialog()} className="bg-blue-600 hover:bg-blue-700">
                    Add Transaction
                  </Button>
                  
                </div>
              </div>
              <div className="mb-4">
                <Input
                  placeholder="Search transactions..."
                  className="max-w-sm"
                  value={pettyCashSearch}
                  onChange={e => setPettyCashSearch(e.target.value)}
                />
              </div>
              <DataTable
                title=""
                columns={pettyCashColumns}
                data={paginatedPettyCashTransactions}
                onAdd={() => handleOpenPettyCashDialog()}
                onEdit={handleOpenPettyCashDialog}
                onDelete={handleDeletePettyCashTransaction}
                renderCustomCell={renderPettyCashCustomCell}
                showTitle={false}
              />
              {/* Pagination Controls for Petty Cash */}
              <div className="flex flex-col md:flex-row items-center justify-between gap-2 mt-4">
                <div className="flex items-center gap-2">
                  <button
                    className="px-3 py-1 border rounded disabled:opacity-50"
                    onClick={() => setPettyCashCurrentPage((p) => Math.max(1, p - 1))}
                    disabled={pettyCashCurrentPage === 1}
                  >
                    Previous
                  </button>
                  <span className="mx-2 text-sm">
                    Page {pettyCashCurrentPage} of {pettyCashTotalPages}
                  </span>
                  <button
                    className="px-3 py-1 border rounded disabled:opacity-50"
                    onClick={() => setPettyCashCurrentPage((p) => Math.min(pettyCashTotalPages, p + 1))}
                    disabled={pettyCashCurrentPage === pettyCashTotalPages}
                  >
                    Next
                  </button>
                </div>
                <div className="flex items-center gap-2">
                  <span className="text-sm">Rows per page:</span>
                  <Select value={pettyCashRowsPerPage.toString()} onValueChange={v => setPettyCashRowsPerPage(Number(v))}>
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
            </div>
          </div>
        </TabsContent>
      </Tabs>

      {/* Overtime Dialog */}
      <Dialog open={overtimeDialogOpen} onOpenChange={setOvertimeDialogOpen}>
        <DialogContent className="max-w-3xl max-h-[90vh] overflow-y-auto">
          <DialogHeader>
            <DialogTitle>
              {selectedOvertimeReport ? 'Edit Overtime Report' : 'Add Overtime Report'}
            </DialogTitle>
          </DialogHeader>
          <div className="mt-4">
            <OvertimeReportForm
              overtimeReport={selectedOvertimeReport}
              onSubmit={handleSubmitOvertimeReport}
              onCancel={handleCloseOvertimeDialog}
            />
          </div>
        </DialogContent>
      </Dialog>

      {/* Petty Cash Dialog */}
      <Dialog open={pettyCashDialogOpen} onOpenChange={setPettyCashDialogOpen}>
        <DialogContent className="max-w-3xl max-h-[90vh] overflow-y-auto">
          <DialogHeader>
            <DialogTitle>
              {selectedTransaction ? 'Edit Transaction' : 'Add Transaction'}
            </DialogTitle>
          </DialogHeader>
          <div className="mt-4">
            <PettyCashForm
              transaction={selectedTransaction}
              onSubmit={handleSubmitPettyCashTransaction}
              onCancel={handleClosePettyCashDialog}
            />
          </div>
        </DialogContent>
      </Dialog>
    </div>
  );
}
