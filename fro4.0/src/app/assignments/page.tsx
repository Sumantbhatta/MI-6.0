// File: src/app/assignments/page.tsx
'use client';

import React from 'react';
import EmployeeGraphs from '@/components/EmployeeGraphs';
import { Card, CardHeader, CardTitle, CardDescription, CardContent } from '@/components/ui/card';
import { useQuery, useMutation, useQueryClient } from 'react-query';
import { EmployeeAssignmentDto, EmployeeAssignmentRequestDto, employeeAssignmentService } from '@/services/employeeAssignmentService';
import DataTable from '@/components/DataTable';
import {
  Dialog,
  DialogContent,
  DialogHeader,
  DialogTitle,
} from '@/components/ui/dialog';
import toast from 'react-hot-toast';
import EmployeeAssignmentForm from '@/components/EmployeeAssignmentForm';
import { Select, SelectTrigger, SelectValue, SelectContent, SelectItem } from '@/components/ui/select';

export default function AssignmentsPage() {
  const [search, setSearch] = React.useState("");
  const [open, setOpen] = React.useState(false);
  const [selectedAssignment, setSelectedAssignment] = React.useState<EmployeeAssignmentDto | undefined>();
  const queryClient = useQueryClient();
  const [currentPage, setCurrentPage] = React.useState(1);
  const [rowsPerPage, setRowsPerPage] = React.useState(10);

  // Fetch employee assignments with error handling
  const { data: assignments = [], isLoading, isError } = useQuery(
    ['employeeAssignments'], 
    employeeAssignmentService.getAllEmployeeAssignments,
    {
      onError: (error) => {
        console.error('Failed to fetch employee assignments:', error);
        toast.error('Failed to load employee assignments. Please try again later.');
      }
    }
  );

  // Create employee assignment mutation
  const createMutation = useMutation(
    (data: EmployeeAssignmentRequestDto) => employeeAssignmentService.createEmployeeAssignment(data),
    {
      onSuccess: () => {
        queryClient.invalidateQueries(['employeeAssignments']);
        handleClose();
        toast.success('Employee assignment created successfully!');
      },
      onError: (error) => {
        console.error('Failed to create employee assignment:', error);
        toast.error('Failed to create employee assignment. Please try again.');
      }
    }
  );

  // Update employee assignment mutation
  const updateMutation = useMutation(
    ({ id, data }: { id: number; data: EmployeeAssignmentRequestDto }) =>
      employeeAssignmentService.updateEmployeeAssignment(id, data),
    {
      onSuccess: () => {
        queryClient.invalidateQueries(['employeeAssignments']);
        handleClose();
        toast.success('Employee assignment updated successfully!');
      },
      onError: (error) => {
        console.error('Failed to update employee assignment:', error);
        toast.error('Failed to update employee assignment. Please try again.');
      }
    }
  );

  // Delete employee assignment mutation
  const deleteMutation = useMutation(
    (id: number) => employeeAssignmentService.deleteEmployeeAssignment(id),
    {
      onSuccess: () => {
        queryClient.invalidateQueries(['employeeAssignments']);
        toast.success('Employee assignment deleted successfully!');
      },
      onError: (error) => {
        console.error('Failed to delete employee assignment:', error);
        toast.error('Failed to delete employee assignment. Please try again.');
      }
    }
  );

  const handleOpen = (assignment?: EmployeeAssignmentDto) => {
    setSelectedAssignment(assignment);
    setOpen(true);
  };

  const handleClose = () => {
    setSelectedAssignment(undefined);
    setOpen(false);
  };

  const handleSubmit = (formData: EmployeeAssignmentRequestDto) => {
    if (selectedAssignment) {
      updateMutation.mutate({ id: selectedAssignment.id, data: formData });
    } else {
      createMutation.mutate(formData);
    }
  };

  const handleDelete = (id: number) => {
    if (confirm('Are you sure you want to delete this assignment?')) {
      deleteMutation.mutate(id);
    }
  };

  const columns = [
    { key: 'employee.name', label: 'Employee' },
    { key: 'project.name', label: 'Project' },
    { key: 'joiningDate', label: 'Joining Date' },
    { key: 'equipment.name', label: 'Equipment' },
  ];

  const renderCustomCell = (column: string, item: any) => {
    if (column === 'joiningDate') {
      return new Date(item.joiningDate).toLocaleDateString();
    }
    
    if (column === 'employee.name' && item.employee) {
      return item.employee.name;
    }
    
    if (column === 'project.name' && item.project) {
      return item.project.name;
    }
    
    if (column === 'equipment.name' && item.equipment) {
      return item.equipment.name;
    }
    
    return null;
  };

  // Filter assignments by search
  const filteredAssignments = React.useMemo(() => {
    const s = search.toLowerCase();
    return assignments.filter((a: any) =>
      (a.employee?.name?.toLowerCase() || "").includes(s) ||
      (a.project?.name?.toLowerCase() || "").includes(s) ||
      (a.equipment?.name?.toLowerCase() || "").includes(s) ||
      (a.joiningDate || "").toString().toLowerCase().includes(s)
    );
  }, [search, assignments]);

  // Calculate pagination
  const totalRows = filteredAssignments.length;
  const totalPages = Math.ceil(totalRows / rowsPerPage);
  const paginatedAssignments = filteredAssignments.slice(
    (currentPage - 1) * rowsPerPage,
    currentPage * rowsPerPage
  );

  // Reset to first page if filteredAssignments or rowsPerPage changes
  React.useEffect(() => {
    setCurrentPage(1);
  }, [filteredAssignments, rowsPerPage]);

  if (isLoading) {
    return <div className="p-6">Loading employee assignments...</div>;
  }

  if (isError) {
    return <div className="p-6 text-red-500">Error loading employee assignments. Please try again later.</div>;
  }

  return (
    <div className="p-6">
      <div className="mb-4 max-w-sm">
        <input
          type="text"
          placeholder="Search assignments..."
          className="w-full border rounded px-3 py-2"
          value={search}
          onChange={e => setSearch(e.target.value)}
        />
      </div>
      {/* Employee Graphs in dashboard card style */}
      <Card className="mb-8">
        <CardHeader>
          <CardTitle>Employee Analytics</CardTitle>
          <CardDescription>Overview of employee distribution by designation and department</CardDescription>
        </CardHeader>
        <CardContent>
          <EmployeeGraphs />
        </CardContent>
      </Card>
      <DataTable
        title="Employee Assignments"
        columns={columns}
        data={paginatedAssignments}
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
        <DialogContent className="sm:max-w-[700px]">
          <DialogHeader>
            <DialogTitle>{selectedAssignment ? 'Edit Assignment' : 'New Assignment'}</DialogTitle>
          </DialogHeader>
          <EmployeeAssignmentForm
            assignment={selectedAssignment}
            onSubmit={handleSubmit}
            onCancel={handleClose}
          />
        </DialogContent>
      </Dialog>
    </div>
  );
}