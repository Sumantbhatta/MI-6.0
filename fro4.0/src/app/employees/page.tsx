'use client';

import React from 'react';
import { useQuery, useMutation, useQueryClient } from 'react-query';
import { EmployeeDto, EmployeeRequestDto, employeeService } from '@/services/employeeService';
import EmployeeForm from '@/components/EmployeeForm';
import DataTable from '@/components/DataTable';
import {
  Dialog,
  DialogContent,
  DialogHeader,
  DialogTitle,
} from '@/components/ui/dialog';
import toast from 'react-hot-toast';
import { Select, SelectTrigger, SelectValue, SelectContent, SelectItem } from '@/components/ui/select';

export default function EmployeesPage() {
  const [search, setSearch] = React.useState("");
  const [open, setOpen] = React.useState(false);
  const [selectedEmployee, setSelectedEmployee] = React.useState<EmployeeDto | undefined>();
  const queryClient = useQueryClient();
  const [currentPage, setCurrentPage] = React.useState(1);
  const [rowsPerPage, setRowsPerPage] = React.useState(10);

  // Fetch employees with error handling
  const { data: employees = [], isLoading, isError } = useQuery(
    ['employees'], 
    employeeService.getAllEmployees,
    {
      onError: (error) => {
        console.error('Failed to fetch employees:', error);
        toast.error('Failed to load employees. Please try again later.');
      }
    }
  );

  // Create employee mutation
  const createMutation = useMutation(
    (data: EmployeeRequestDto) => employeeService.createEmployee(data),
    {
      onSuccess: () => {
        queryClient.invalidateQueries(['employees']);
        handleClose();
        toast.success('Employee created successfully!');
      },
      onError: (error) => {
        console.error('Failed to create employee:', error);
        toast.error('Failed to create employee. Please try again.');
      }
    }
  );

  // Update employee mutation
  const updateMutation = useMutation(
    ({ id, data }: { id: number; data: EmployeeRequestDto }) =>
      employeeService.updateEmployee(id, data),
    {
      onSuccess: () => {
        queryClient.invalidateQueries(['employees']);
        handleClose();
        toast.success('Employee updated successfully!');
      },
      onError: (error) => {
        console.error('Failed to update employee:', error);
        toast.error('Failed to update employee. Please try again.');
      }
    }
  );

  // Delete employee mutation
  const deleteMutation = useMutation(
    (id: number) => employeeService.deleteEmployee(id),
    {
      onSuccess: () => {
        queryClient.invalidateQueries(['employees']);
        toast.success('Employee deleted successfully!');
      },
      onError: (error) => {
        console.error('Failed to delete employee:', error);
        toast.error('Failed to delete employee. Please try again.');
      }
    }
  );

  const handleOpen = (employee?: EmployeeDto) => {
    setSelectedEmployee(employee);
    setOpen(true);
  };

  const handleClose = () => {
    setSelectedEmployee(undefined);
    setOpen(false);
  };

  const handleSubmit = (formData: EmployeeRequestDto) => {
    if (selectedEmployee) {
      updateMutation.mutate({ id: selectedEmployee.id, data: formData });
    } else {
      createMutation.mutate(formData);
    }
  };

  const handleDelete = (id: number) => {
    if (confirm('Are you sure you want to delete this employee?')) {
      deleteMutation.mutate(id);
    }
  };

  const columns = [
    { key: 'name', label: 'Name' },
    { key: 'department.name', label: 'Department' },
    { key: 'department.description', label: 'Department Description' },
    { key: 'designation.name', label: 'Designation' },
    { key: 'designation.description', label: 'Designation Description' },
    { key: 'remarks', label: 'Remarks' },
  ];

  // Filter employees by search
  const filteredEmployees = React.useMemo(() => {
    const s = search.toLowerCase();
    return employees.filter((emp: any) =>
      (emp.name?.toLowerCase() || "").includes(s) ||
      (emp.department?.name?.toLowerCase() || "").includes(s) ||
      (emp.department?.description?.toLowerCase() || "").includes(s) ||
      (emp.designation?.name?.toLowerCase() || "").includes(s) ||
      (emp.designation?.description?.toLowerCase() || "").includes(s) ||
      (emp.remarks?.toLowerCase() || "").includes(s)
    );
  }, [search, employees]);

  // Calculate pagination
  const totalRows = filteredEmployees.length;
  const totalPages = Math.ceil(totalRows / rowsPerPage);
  const paginatedEmployees = filteredEmployees.slice(
    (currentPage - 1) * rowsPerPage,
    currentPage * rowsPerPage
  );

  // Reset to first page if filteredEmployees or rowsPerPage changes
  React.useEffect(() => {
    setCurrentPage(1);
  }, [filteredEmployees, rowsPerPage]);

  if (isLoading) {
    return <div className="p-6">Loading employees...</div>;
  }

  if (isError) {
    return <div className="p-6 text-red-500">Error loading employees. Please try again later.</div>;
  }

  return (
    <div className="p-6">
      <div className="mb-4 max-w-sm">
        <input
          type="text"
          placeholder="Search employees..."
          className="w-full border rounded px-3 py-2"
          value={search}
          onChange={e => setSearch(e.target.value)}
        />
      </div>
      <DataTable
        title="Employees"
        columns={columns}
        data={paginatedEmployees}
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
        <DialogContent className="sm:max-w-[700px]">
          <DialogHeader>
            <DialogTitle>{selectedEmployee ? 'Edit Employee' : 'Add Employee'}</DialogTitle>
          </DialogHeader>
          <EmployeeForm
            employee={selectedEmployee}
            onSubmit={handleSubmit}
            onCancel={handleClose}
          />
        </DialogContent>
      </Dialog>
    </div>
  );
}
