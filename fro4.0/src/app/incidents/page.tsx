'use client';

import React, { useState } from 'react';
import { useQuery, useMutation, useQueryClient } from 'react-query';
import { IncidentReport, incidentService } from '@/services/incidentService';
import { Card, CardContent, CardDescription, CardHeader, CardTitle } from '@/components/ui/card';
import { Button } from '@/components/ui/button';
import { Input } from '@/components/ui/input';
import { Dialog, DialogContent, DialogHeader, DialogTitle } from '@/components/ui/dialog';
import { Badge } from '@/components/ui/badge';
import { BarChart } from '@/components/ui/charts';
import { Search, Plus } from 'lucide-react';
import { toast } from 'sonner';
import IncidentForm from '@/components/IncidentForm';

export default function BreakdownManagementPage() {
  const [search, setSearch] = useState("");

  const [open, setOpen] = useState(false);
  const [selectedIncident, setSelectedIncident] = useState<IncidentReport | undefined>();
  const queryClient = useQueryClient();

  // Fetch all incidents
  const { data: incidents = [] } = useQuery(['incidents'], incidentService.getAllIncidents);
  
  // Process incidents to add index for serial number generation
  const processedIncidents = React.useMemo(() => {
    return incidents.map((incident, index) => ({
      ...incident,
      _index: index
    }));
  }, [incidents]);

  // Filter processedIncidents by search
  const filteredIncidents = React.useMemo(() => {
    const s = search.toLowerCase();
    return processedIncidents.filter(incident =>
      (incident.equipment?.name?.toLowerCase() || "").includes(s) ||
      (incident.incidentDetails?.toLowerCase() || "").includes(s) ||
      (incident.actionTaken?.toLowerCase() || "").includes(s) ||
      (incident.status?.toLowerCase() || "").includes(s) ||
      (incident.project?.name?.toLowerCase() || "").includes(s) ||
      (incident.incidentDate || "").toString().includes(s)
    );
  }, [search, processedIncidents]);

  const createMutation = useMutation(
    (data: any) => incidentService.createIncident(data),
    {
      onSuccess: (data) => {
        queryClient.invalidateQueries(['incidents']);
        handleClose();
        toast.success('Success', {
          description: 'Incident report created successfully',
          position: 'top-right',
        });
      },
      onError: (error: any) => {
        toast.error('Error', {
          description: error?.response?.data?.message || 'Failed to create incident report',
          position: 'top-right',
        });
      }
    }
  );

  const updateMutation = useMutation(
    ({ id, data }: { id: number; data: any }) =>
      incidentService.updateIncident(id, data),
    {
      onSuccess: (data) => {
        queryClient.invalidateQueries(['incidents']);
        handleClose();
        toast.success('Success', {
          description: 'Incident report updated successfully',
          position: 'top-right',
        });
      },
      onError: (error: any) => {
        toast.error('Error', {
          description: error?.response?.data?.message || 'Failed to update incident report',
          position: 'top-right',
        });
      }
    }
  );

  const deleteMutation = useMutation(
    (id: number) => incidentService.deleteIncident(id),
    {
      onSuccess: (data) => {
        queryClient.invalidateQueries(['incidents']);
        toast.success('Success', {
          description: 'Incident report deleted successfully',
          position: 'top-right',
        });
      },
      onError: (error: any) => {
        toast.error('Error', {
          description: error?.response?.data?.message || 'Failed to delete incident report',
          position: 'top-right',
        });
      }
    }
  );

  const handleOpen = (incident?: IncidentReport) => {
    setSelectedIncident(incident);
    setOpen(true);
  };

  const handleClose = () => {
    setSelectedIncident(undefined);
    setOpen(false);
  };

  const handleSubmit = (data: any) => {
    if (selectedIncident) {
      updateMutation.mutate({ id: selectedIncident.id!, data });
    } else {
      createMutation.mutate(data);
    }
  };

  const handleDelete = (id: number) => {
    if (confirm('Are you sure you want to delete this incident report?')) {
      deleteMutation.mutate(id);
    }
  };

  const getStatusColor = (status: string): 'default' | 'destructive' | 'outline' | 'secondary' => {
    switch (status) {
      case 'OPEN':
        return 'destructive';
      case 'IN_PROGRESS':
        return 'secondary';
      case 'CLOSED':
        return 'default';
      case 'RESOLVED':
        return 'default';
      default:
        return 'secondary';
    }
  };

  const formatDate = (dateString: string) => {
    if (!dateString) return '-';
    return new Date(dateString).toLocaleDateString('en-US', {
      year: 'numeric',
      month: 'short',
      day: 'numeric',
    });
  };

  // Calculate breakdown statistics
  const breakdownStats = {
    open: processedIncidents.filter(i => i.status === 'OPEN').length,
    inProgress: processedIncidents.filter(i => i.status === 'IN_PROGRESS').length,
    closed: processedIncidents.filter(i => i.status === 'CLOSED').length,
    resolved: processedIncidents.filter(i => i.status === 'RESOLVED').length
  };

  // Create data for charts
  const statusData = [
    { name: 'Open', count: breakdownStats.open },
    { name: 'In Progress', count: breakdownStats.inProgress },
    { name: 'Closed', count: breakdownStats.closed },
    { name: 'Resolved', count: breakdownStats.resolved }
  ];

  // Breakdown by machine type (using equipment names as machine types)
  const machineBreakdowns = processedIncidents.reduce((acc: Record<string, number>, incident) => {
    const machineName = incident.equipment?.name || 'Unknown';
    acc[machineName] = (acc[machineName] || 0) + 1;
    return acc;
  }, {});

  const machineTypeData = Object.entries(machineBreakdowns).map(([name, count]) => ({
    name,
    count
  })).slice(0, 3); // Limit to top 3 for display

  const handleEdit = (incident: IncidentReport) => {
    handleOpen(incident);
  };

  return (
    <div className="p-6 space-y-6">
      <div>
        <h1 className="text-2xl font-bold tracking-tight">Breakdown Management</h1>
        <p className="text-muted-foreground">Log and track machine breakdown incidents</p>
      </div>

      <div className="grid gap-4 md:grid-cols-2">
        {/* Breakdown Status Chart */}
        <Card>
          <CardHeader className="pb-2">
            <CardTitle className="text-base">Breakdown Status</CardTitle>
            <CardDescription>Current status of all breakdown incidents</CardDescription>
          </CardHeader>
          <CardContent>
            <BarChart
              data={statusData}
              index="name"
              categories={["count"]}
              colors={["blue"]}
              valueFormatter={(value: number) => `${value}`}
              className="h-80"
            />
          </CardContent>
        </Card>

        {/* Breakdowns by Machine Type */}
        <Card>
          <CardHeader className="pb-2">
            <CardTitle className="text-base">Breakdowns by Machine Type</CardTitle>
            <CardDescription>Distribution of breakdowns across machine types</CardDescription>
          </CardHeader>
          <CardContent>
            <BarChart
              data={machineTypeData}
              index="name"
              categories={["count"]}
              colors={["blue"]}
              valueFormatter={(value: number) => `${value}`}
              className="h-80"
            />
          </CardContent>
        </Card>
      </div>

      {/* Breakdown Incidents Table */}
      <div className="bg-card rounded-lg border shadow-sm">
        <div className="p-4">
          <div className="flex items-center justify-between mb-4">
            <h3 className="text-lg font-semibold">Breakdown Incidents</h3>
            <Button onClick={() => handleOpen()} className="bg-blue-600 hover:bg-blue-700">
              <Plus className="h-4 w-4 mr-2" /> Report Breakdown
            </Button>
          </div>
          <div className="mb-4 relative">
            <Search className="absolute left-3 top-1/2 transform -translate-y-1/2 text-muted-foreground h-4 w-4" />
            <Input
              placeholder="Search breakdowns..."
              className="pl-10 max-w-sm"
              value={search}
              onChange={e => setSearch(e.target.value)}
            />
          </div>
          
          <div className="rounded-md border">
            <div className="overflow-x-auto">
              <table className="w-full caption-bottom text-sm">
                <thead className="[&_tr]:border-b">
                  <tr className="border-b transition-colors hover:bg-muted/50 data-[state=selected]:bg-muted">
                    <th className="h-12 px-4 text-left align-middle font-medium text-muted-foreground">ID</th>
                    <th className="h-12 px-4 text-left align-middle font-medium text-muted-foreground">Machine</th>
                    <th className="h-12 px-4 text-left align-middle font-medium text-muted-foreground">Report Date</th>
                    <th className="h-12 px-4 text-left align-middle font-medium text-muted-foreground">Description</th>
                    <th className="h-12 px-4 text-left align-middle font-medium text-muted-foreground">Status</th>
                    <th className="h-12 px-4 text-left align-middle font-medium text-muted-foreground">Assigned To</th>
                    <th className="h-12 px-4 text-left align-middle font-medium text-muted-foreground">Actions</th>
                  </tr>
                </thead>
                <tbody className="[&_tr:last-child]:border-0">
                  {filteredIncidents.map((incident) => (
                    <tr 
                      key={incident.id} 
                      className="border-b transition-colors hover:bg-muted/50 data-[state=selected]:bg-muted"
                    >
                      <td className="p-4 align-middle">{`B${String(incident._index + 1).padStart(3, '0')}`}</td>
                      <td className="p-4 align-middle">{incident.equipment?.name || '-'}</td>
                      <td className="p-4 align-middle">{formatDate(incident.incidentDate)}</td>
                      <td className="p-4 align-middle max-w-[250px] truncate">{incident.incidentDetails || incident.actionTaken || '-'}</td>
                      <td className="p-4 align-middle">
                        <Badge variant={getStatusColor(incident.status)}>
                          {incident.status.replace('_', ' ')}
                        </Badge>
                      </td>
                      <td className="p-4 align-middle">{incident.project?.name || '-'}</td>
                      <td className="p-4 align-middle">
                        <div className="flex gap-2">
                          <Button 
                            variant="destructive" 
                            size="sm" 
                            onClick={() => handleDelete(incident.id)}
                          >
                            Delete
                          </Button>
                          <Button 
                            variant="outline" 
                            size="sm" 
                            onClick={() => handleEdit(incident)}
                          >
                            Update
                          </Button>
                        </div>
                      </td>
                    </tr>
                  ))}
                </tbody>
              </table>
            </div>
          </div>
        </div>
      </div>

      {/* Incident Form Dialog */}
      <Dialog open={open} onOpenChange={setOpen}>
        <DialogContent className="max-w-3xl max-h-[90vh] overflow-y-auto">
          <DialogHeader>
            <DialogTitle>
              {selectedIncident ? 'Edit Breakdown Incident' : 'Report Breakdown Incident'}
            </DialogTitle>
          </DialogHeader>
          <div className="mt-4">
            <IncidentForm
              incident={selectedIncident}
              onSubmit={handleSubmit}
              onCancel={handleClose}
            />
          </div>
        </DialogContent>
      </Dialog>
    </div>
  );
}
