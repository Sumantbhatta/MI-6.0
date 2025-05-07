'use client';

import React from 'react';
import { useQuery, useMutation, useQueryClient } from 'react-query';
import {
  Dialog,
  DialogContent,
  DialogHeader,
  DialogTitle,
} from '@/components/ui/dialog';
import { Button } from '@/components/ui/button';
import { Card, CardContent, CardHeader, CardTitle } from '@/components/ui/card';
import DataTable from '@/components/DataTable';
import { Project, projectService } from '@/services/projectService';
import ProjectForm from '@/components/ProjectForm';
import { Badge, Input, Select, SelectTrigger, SelectContent, SelectItem, SelectValue } from '@/components/ui';
import { toast } from 'react-hot-toast';
import { FileText, Download } from 'lucide-react';

const getStatusColor = (status: string) => {
  switch (status.toUpperCase()) {
    case 'COMPLETED':
      return 'bg-green-500 hover:bg-green-600';
    case 'IN_PROGRESS':
      return 'bg-yellow-500 hover:bg-yellow-600';
    case 'PENDING':
      return 'bg-gray-500 hover:bg-gray-600';
    default:
      return 'bg-gray-500 hover:bg-gray-600';
  }
};

export default function ProjectsPage() {
  const [open, setOpen] = React.useState(false);
  const [selectedProject, setSelectedProject] = React.useState<Project | null>(null);
  const queryClient = useQueryClient();

  // Fetch projects data
  const { data: projects, isLoading, isError, error } = useQuery(
    'projects', 
    projectService.getAllProjects,
    {
      onError: (err: any) => {
        console.error('Failed to fetch projects:', err);
        toast.error('Failed to load projects. Please try again later.');
      }
    }
  );

  // Create project mutation
  const createMutation = useMutation(projectService.createProject, {
    onSuccess: () => {
      queryClient.invalidateQueries('projects');
      handleClose();
      toast.success('Project created successfully!');
    },
    onError: (err: any) => {
      console.error('Failed to create project:', err);
      toast.error('Failed to create project. Please try again.');
    }
  });

  // Update project mutation
  const updateMutation = useMutation(
    (data: { id: number; project: Project }) => projectService.updateProject(data.id, data.project),
    {
      onSuccess: () => {
        queryClient.invalidateQueries('projects');
        handleClose();
        toast.success('Project updated successfully!');
      },
      onError: (err: any) => {
        console.error('Failed to update project:', err);
        toast.error('Failed to update project. Please try again.');
      }
    }
  );

  // Delete project mutation
  const deleteMutation = useMutation(projectService.deleteProject, {
    onSuccess: () => {
      queryClient.invalidateQueries('projects');
      toast.success('Project deleted successfully!');
    },
    onError: (err: any) => {
      console.error('Failed to delete project:', err);
      toast.error('Failed to delete project. Please try again.');
    }
  });

  const handleOpen = (project?: Project) => {
    setSelectedProject(project || null);
    setOpen(true);
  };

  const handleClose = () => {
    setSelectedProject(null);
    setOpen(false);
  };

  const handleSubmit = (project: Project) => {
    if (selectedProject?.id) {
      updateMutation.mutate({ id: selectedProject.id, project });
    } else {
      createMutation.mutate(project);
    }
  };

  const handleDelete = (id: number) => {
    if (confirm('Are you sure you want to delete this project?')) {
      deleteMutation.mutate(id);
    }
  };

  const columns = [
    { key: 'name', label: 'Name' },
    { key: 'description', label: 'Description' },
    { key: 'location', label: 'Location' },
    { key: 'startDate', label: 'Start Date' },
    { key: 'endDate', label: 'End Date' },
    { key: 'status', label: 'Status' },
  ];

  // Search and status filter state
  const [search, setSearch] = React.useState("");
  const [statusFilter, setStatusFilter] = React.useState("all");

  // Sorting state
  const [sortKey, setSortKey] = React.useState<string>('name');
  const [sortDirection, setSortDirection] = React.useState<'asc' | 'desc'>('asc');

  // Filter and sort projects by search and status
  const filteredProjects = React.useMemo(() => {
    let list = (projects || []).filter((p: any) => {
      const q = search.toLowerCase();
      const matchesSearch =
        p.name?.toLowerCase().includes(q) ||
        p.description?.toLowerCase().includes(q) ||
        p.location?.toLowerCase().includes(q) ||
        p.status?.toLowerCase().includes(q);
      const matchesStatus =
        statusFilter === "all" ||
        (statusFilter === "active" && p.status?.toLowerCase() === "active") ||
        (statusFilter === "planning" && p.status?.toLowerCase() === "planning") ||
        (statusFilter === "completed" && p.status?.toLowerCase() === "completed");
      return matchesSearch && matchesStatus;
    });
    // Sort
    if (sortKey) {
      list = [...list].sort((a, b) => {
        let aValue = a[sortKey];
        let bValue = b[sortKey];
        // Handle date columns
        if (sortKey === 'startDate' || sortKey === 'endDate') {
          aValue = new Date(aValue).getTime();
          bValue = new Date(bValue).getTime();
        } else {
          aValue = (aValue || '').toString().toLowerCase();
          bValue = (bValue || '').toString().toLowerCase();
        }
        if (aValue < bValue) return sortDirection === 'asc' ? -1 : 1;
        if (aValue > bValue) return sortDirection === 'asc' ? 1 : -1;
        return 0;
      });
    }
    return list;
  }, [projects, search, statusFilter, sortKey, sortDirection]);

  const renderCustomCell = (column: string, item: any) => {
    if (column === 'startDate' || column === 'endDate') {
      return new Date(item[column]).toLocaleDateString();
    }
    if (column === 'status') {
      return (
        <Badge className={`${getStatusColor(item.status)} capitalize min-w-[100px] justify-center`}>
          {item.status}
        </Badge>
      );
    }
    return item[column];
  };

  // Pagination state
  const [currentPage, setCurrentPage] = React.useState(1);
  const [rowsPerPage, setRowsPerPage] = React.useState(10);

  // Calculate pagination
  const totalRows = filteredProjects.length;
  const totalPages = Math.ceil(totalRows / rowsPerPage);
  const paginatedProjects = filteredProjects.slice(
    (currentPage - 1) * rowsPerPage,
    currentPage * rowsPerPage
  );

  // Reset to first page if filteredProjects or rowsPerPage changes
  React.useEffect(() => {
    setCurrentPage(1);
  }, [filteredProjects, rowsPerPage]);

  if (isLoading) {
    return <div className="p-6">Loading projects...</div>;
  }

  if (isError) {
    return <div className="p-6 text-red-500">Error loading projects. Please try again later.</div>;
  }

  return (
    <div className="space-y-6 p-6">
      <div className="flex items-center justify-between">
        <div>
          <h1 className="text-2xl font-bold tracking-tight">Projects</h1>
          <p className="text-muted-foreground">Manage and monitor all construction projects</p>
        </div>
        <div className="flex items-center gap-2">
          <Button onClick={() => handleOpen()} className="gap-2">
            <span className="hidden sm:inline">Add Project</span>
            <span className="sm:hidden">+</span>
          </Button>
        </div>
      </div>

      {/* Project Status Cards */}
      <div className="grid gap-4 md:grid-cols-3">
        <Card>
          <CardHeader className="pb-2">
            <CardTitle className="text-sm font-medium">Active Projects</CardTitle>
            <p className="text-xs text-muted-foreground">Currently ongoing projects</p>
          </CardHeader>
          <CardContent>
            <div className="flex items-center gap-2">
              <div className="rounded-full bg-blue-100 p-2">
                <FileText className="h-4 w-4 text-blue-500" />
              </div>
              <div className="text-2xl font-bold">{filteredProjects.filter((p: any) => p.status?.toLowerCase() === 'active').length}</div>
            </div>
          </CardContent>
        </Card>
        
        <Card>
          <CardHeader className="pb-2">
            <CardTitle className="text-sm font-medium">Planning Phase</CardTitle>
            <p className="text-xs text-muted-foreground">Projects in planning stage</p>
          </CardHeader>
          <CardContent>
            <div className="flex items-center gap-2">
              <div className="rounded-full bg-purple-100 p-2">
                <FileText className="h-4 w-4 text-purple-500" />
              </div>
              <div className="text-2xl font-bold">{filteredProjects.filter((p: any) => p.status?.toLowerCase() === 'planning').length}</div>
            </div>
          </CardContent>
        </Card>
        
        <Card>
          <CardHeader className="pb-2">
            <CardTitle className="text-sm font-medium">Completed</CardTitle>
            <p className="text-xs text-muted-foreground">Successfully completed projects</p>
          </CardHeader>
          <CardContent>
            <div className="flex items-center gap-2">
              <div className="rounded-full bg-green-100 p-2">
                <FileText className="h-4 w-4 text-green-500" />
              </div>
              <div className="text-2xl font-bold">{filteredProjects.filter((p: any) => p.status?.toLowerCase() === 'completed').length}</div>
            </div>
          </CardContent>
        </Card>
      </div>

      {/* Projects List */}
      <Card>
        <CardHeader>
          <CardTitle className="text-base font-medium">Projects List</CardTitle>
          <p className="text-xs text-muted-foreground">All construction projects</p>
        </CardHeader>
        <CardContent className="p-0">
          {/* Search and Status Filter Controls */}
          <div className="flex flex-col md:flex-row md:items-center md:justify-between gap-2 p-4 pb-0 mb-4">
            <Input
              type="text"
              className="w-full md:w-1/3"
              placeholder="Search projects..."
              value={search}
              onChange={e => setSearch(e.target.value)}
            />
            <div className="flex flex-col md:flex-row md:items-center gap-2 mt-2 md:mt-0">
              <Select value={statusFilter} onValueChange={setStatusFilter}>
                <SelectTrigger className="w-[160px]">
                  <SelectValue placeholder="All Statuses" />
                </SelectTrigger>
                <SelectContent>
                  <SelectItem value="all">All Statuses</SelectItem>
                  <SelectItem value="active">Active</SelectItem>
                  <SelectItem value="planning">Planning</SelectItem>
                  <SelectItem value="completed">Completed</SelectItem>
                </SelectContent>
              </Select>
            </div>
          </div>
          <div className="overflow-x-auto">
            <DataTable
              title="Projects"
              columns={columns}
              data={paginatedProjects}
              onAdd={() => handleOpen()}
              onEdit={handleOpen}
              onDelete={handleDelete}
              renderCustomCell={renderCustomCell}
            />
          </div>
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
        </CardContent>
      </Card>

      <Dialog open={open} onOpenChange={setOpen}>
        <DialogContent className="sm:max-w-[500px]">
          <DialogHeader>
            <DialogTitle>
              {selectedProject ? 'Edit Project' : 'Create Project'}
            </DialogTitle>
          </DialogHeader>
          <div className="mt-4">
            <ProjectForm
              project={selectedProject || undefined}
              onSubmit={handleSubmit}
              onCancel={handleClose}
            />
          </div>
        </DialogContent>
      </Dialog>
    </div>
  );
}
