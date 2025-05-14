'use client';

import React, { useState } from 'react';
import { useParams, useRouter } from 'next/navigation';
import { useQuery } from 'react-query';
import { Equipment, equipmentService } from '@/services/equipmentService';
import { incidentService } from '@/services/incidentService';
import maintenanceService from '@/services/maintenanceService';
import { equipmentUtilizationService } from '@/services/equipmentUtilizationService';
import { Button } from '@/components/ui/button';
import { Card, CardContent, CardDescription, CardHeader, CardTitle } from '@/components/ui/card';
import { Tabs, TabsContent, TabsList, TabsTrigger } from '@/components/ui/tabs';
import { Badge } from '@/components/ui/badge';
import { Table, TableBody, TableCell, TableHead, TableHeader, TableRow } from '@/components/ui/table';
import { ChevronLeft, FileText, Tool, Clock, AlertTriangle, User, Edit, FolderTree, Calendar, Network } from 'lucide-react';

export default function EquipmentDetailPage() {
  const params = useParams();
  const router = useRouter();
  const [activeTab, setActiveTab] = useState('overview');
  const equipmentId = Number(params?.id);

  // Fetch equipment details
  const { data: equipment, isLoading: isLoadingEquipment } = useQuery(
    ['equipment', equipmentId],
    () => equipmentService.getEquipmentById(equipmentId),
    {
      enabled: !!equipmentId,
    }
  );

  // Fetch maintenance logs for this equipment
  const { data: maintenanceLogs = [], isLoading: isLoadingMaintenance } = useQuery(
    ['maintenanceLogs', equipmentId],
    async () => {
      const logs = await maintenanceService.getAllMaintenanceLogs();
      return logs.filter((log: any) => log.equipment?.id === equipmentId);
    },
    {
      enabled: !!equipmentId,
    }
  );

  // Fetch utilization data for this equipment
  const { data: utilizationData = [], isLoading: isLoadingUtilization } = useQuery(
    ['utilization', equipmentId],
    async () => {
      const utilizations = await equipmentUtilizationService.getAllUtilizations();
      return utilizations.filter((util: any) => util.equipment?.id === equipmentId);
    },
    {
      enabled: !!equipmentId,
    }
  );

  // Fetch incidents for this equipment
  const { data: incidents = [], isLoading: isLoadingIncidents } = useQuery(
    ['incidents', equipmentId],
    async () => {
      const allIncidents = await incidentService.getAllIncidents();
      return allIncidents.filter((incident: any) => incident.equipment?.id === equipmentId);
    },
    {
      enabled: !!equipmentId,
    }
  );

  const handleGoBack = () => {
    router.back();
  };

  const handleEditEquipment = () => {
    router.push(`/equipment?edit=${equipmentId}`);
  };

  if (isLoadingEquipment) {
    return (
      <div className="flex items-center justify-center h-screen">
        <div className="animate-spin rounded-full h-12 w-12 border-t-2 border-b-2 border-primary"></div>
      </div>
    );
  }

  if (!equipment) {
    return (
      <div className="p-6">
        <Button variant="outline" onClick={handleGoBack} className="mb-6">
          <ChevronLeft className="mr-2 h-4 w-4" /> Back to Equipment
        </Button>
        <Card>
          <CardContent className="pt-6">
            <div className="text-center py-10">
              <h2 className="text-xl font-semibold text-gray-700">Equipment not found</h2>
              <p className="text-muted-foreground mt-2">The equipment you are looking for does not exist or has been removed.</p>
            </div>
          </CardContent>
        </Card>
      </div>
    );
  }

  const formatDate = (dateString: string) => {
    if (!dateString) return '-';
    return new Date(dateString).toLocaleDateString('en-US', {
      year: 'numeric',
      month: 'short',
      day: 'numeric',
    });
  };

  return (
    <div className="p-6 space-y-6">
      {/* Header Row: Back, Name, Status, Actions */}
      <div className="flex flex-col md:flex-row md:items-center md:justify-between gap-4 mb-4">
        <div className="flex items-center gap-3 flex-wrap">
          <button
            onClick={handleGoBack}
            className="w-10 h-10 flex items-center justify-center bg-white rounded-lg shadow border border-gray-200 hover:bg-gray-50 transition"
            aria-label="Back"
          >
            <ChevronLeft className="h-4 w-4 text-black" />
          </button>
          <h1 className="text-2xl font-bold mr-2">{equipment.name}</h1>
        </div>
        <div className="flex items-center gap-2">
          <Button variant="outline">
            <FileText className="mr-2 h-4 w-4" /> Generate Report
          </Button>
          <Button variant="default" onClick={handleEditEquipment}>
            <Edit className="mr-2 h-4 w-4" /> Edit Equipment
          </Button>
        </div>
      </div>

      {/* Equipment Info Cards Row */}
      <div className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-4 gap-4 mt-4 mb-6">
        <Card className="flex flex-col justify-between">
          <CardHeader className="pb-2 flex flex-row items-center justify-between">
            <span className="text-xs text-muted-foreground">Asset Code</span>
            <FileText className="w-4 h-4 text-muted-foreground" />
          </CardHeader>
          <CardContent className="pt-0">
            <span className="text-lg font-semibold">{equipment.assetCode}</span>
          </CardContent>
        </Card>
        <Card className="flex flex-col justify-between">
          <CardHeader className="pb-2 flex flex-row items-center justify-between">
            <span className="text-xs text-muted-foreground">Category</span>
            <FolderTree className="w-4 h-4 text-muted-foreground" />
          </CardHeader>
          <CardContent className="pt-0">
            <span className="text-lg font-semibold">{equipment.category?.name}</span>
          </CardContent>
        </Card>
        <Card className="flex flex-col justify-between">
          <CardHeader className="pb-2 flex flex-row items-center justify-between">
            <span className="text-xs text-muted-foreground">Year</span>
            <Calendar className="w-4 h-4 text-muted-foreground" />
          </CardHeader>
          <CardContent className="pt-0">
            <span className="text-lg font-semibold">{equipment.yearOfManufacture}</span>
          </CardContent>
        </Card>
        <Card className="flex flex-col justify-between">
          <CardHeader className="pb-2 flex flex-row items-center justify-between">
            <span className="text-xs text-muted-foreground">Project</span>
            <Network className="w-4 h-4 text-muted-foreground" />
          </CardHeader>
          <CardContent className="pt-0">
            <span className="text-lg font-semibold truncate">{equipment.project?.name}</span>
          </CardContent>
        </Card>
      </div>

      <Tabs defaultValue="overview" value={activeTab} onValueChange={setActiveTab} className="w-full">
        <TabsList className="grid grid-cols-6 w-full">
          <TabsTrigger value="overview">Overview</TabsTrigger>
          <TabsTrigger value="specifications">Specifications</TabsTrigger>
          <TabsTrigger value="maintenance">Maintenance</TabsTrigger>
          <TabsTrigger value="utilization">Utilization</TabsTrigger>
          <TabsTrigger value="incidents">Incidents</TabsTrigger>
          <TabsTrigger value="technicians">Technicians</TabsTrigger>
        </TabsList>

        {/* Overview Tab */}
        <TabsContent value="overview" className="space-y-4">
          <Card>
            <CardHeader>
              <CardTitle>Equipment Information</CardTitle>
              <CardDescription>Detailed information about {equipment.name}</CardDescription>
            </CardHeader>
            <CardContent>
              <div className="grid grid-cols-2 gap-4">
                <div>
                  <h3 className="text-sm font-medium text-muted-foreground">Asset Code</h3>
                  <p className="text-base">{equipment.assetCode}</p>
                </div>
                <div>
                  <h3 className="text-sm font-medium text-muted-foreground">Year of Manufacture</h3>
                  <p className="text-base">{equipment.yearOfManufacture}</p>
                </div>
                <div>
                  <h3 className="text-sm font-medium text-muted-foreground">Category</h3>
                  <p className="text-base">{equipment.category?.name}</p>
                </div>
                <div>
                  <h3 className="text-sm font-medium text-muted-foreground">Model</h3>
                  <p className="text-base">{equipment.model?.name}</p>
                </div>
                <div>
                  <h3 className="text-sm font-medium text-muted-foreground">Project</h3>
                  <p className="text-base">{equipment.project?.name}</p>
                </div>
                <div>
                  <h3 className="text-sm font-medium text-muted-foreground">Vehicle Number</h3>
                  <p className="text-base">{equipment.vehicleNumber || '-'}</p>
                </div>
              </div>
            </CardContent>
          </Card>

          <div className="grid grid-cols-1 md:grid-cols-3 gap-4">
            <Card>
              <CardHeader className="pb-2">
                <CardTitle className="text-base">Maintenance Status</CardTitle>
                <CardDescription>Recent maintenance activities</CardDescription>
              </CardHeader>
              <CardContent>
                <div className="space-y-4">
                  {isLoadingMaintenance ? (
                    <div className="h-20 flex items-center justify-center">
                      <div className="animate-spin rounded-full h-6 w-6 border-t-2 border-b-2 border-primary"></div>
                    </div>
                  ) : maintenanceLogs && maintenanceLogs.length > 0 ? (
                    maintenanceLogs.slice(0, 2).map((log: any) => (
                      <div key={log.id} className="flex items-start gap-3">
                        <div className="bg-primary/10 p-2 rounded-full">
                          <Tool className="h-4 w-4 text-primary" />
                        </div>
                        <div>
                          <p className="text-sm font-medium">{log.typeOfMaintenance}</p>
                          <p className="text-xs text-muted-foreground">{formatDate(log.date)}</p>
                        </div>
                      </div>
                    ))
                  ) : (
                    <p className="text-sm text-muted-foreground">No maintenance records found</p>
                  )}
                </div>
              </CardContent>
            </Card>

            <Card>
              <CardHeader className="pb-2">
                <CardTitle className="text-base">Utilization</CardTitle>
                <CardDescription>Equipment usage statistics</CardDescription>
              </CardHeader>
              <CardContent>
                <div className="space-y-4">
                  {isLoadingUtilization ? (
                    <div className="h-20 flex items-center justify-center">
                      <div className="animate-spin rounded-full h-6 w-6 border-t-2 border-b-2 border-primary"></div>
                    </div>
                  ) : utilizationData && utilizationData.length > 0 ? (
                    <>
                      <div className="flex items-center justify-between">
                        <span className="text-sm font-medium">Utilization %</span>
                        <span className="text-sm">{utilizationData[0]?.utilizationPercentage}%</span>
                      </div>
                      <div className="flex items-center justify-between">
                        <span className="text-sm font-medium">Fuel Consumption</span>
                        <span className="text-sm">{utilizationData[0]?.avgFuelConsumption} L/hr</span>
                      </div>
                    </>
                  ) : (
                    <p className="text-sm text-muted-foreground">No utilization data found</p>
                  )}
                </div>
              </CardContent>
            </Card>

            <Card>
              <CardHeader className="pb-2">
                <CardTitle className="text-base">Recent Incidents</CardTitle>
                <CardDescription>Latest breakdown incidents</CardDescription>
              </CardHeader>
              <CardContent>
                <div className="space-y-4">
                  {isLoadingIncidents ? (
                    <div className="h-20 flex items-center justify-center">
                      <div className="animate-spin rounded-full h-6 w-6 border-t-2 border-b-2 border-primary"></div>
                    </div>
                  ) : incidents && incidents.length > 0 ? (
                    incidents.slice(0, 2).map((incident: any) => (
                      <div key={incident.id} className="flex items-start gap-3">
                        <div className="bg-red-100 p-2 rounded-full">
                          <AlertTriangle className="h-4 w-4 text-red-500" />
                        </div>
                        <div>
                          <p className="text-sm font-medium">{incident.incidentType}</p>
                          <p className="text-xs text-muted-foreground">{formatDate(incident.incidentDate)}</p>
                        </div>
                      </div>
                    ))
                  ) : (
                    <p className="text-sm text-muted-foreground">No incidents reported</p>
                  )}
                </div>
              </CardContent>
            </Card>
          </div>
        </TabsContent>

        {/* Specifications Tab */}
        <TabsContent value="specifications">
          <Card>
            <CardHeader>
              <CardTitle>Equipment Specifications</CardTitle>
              <CardDescription>Technical details of {equipment.name}</CardDescription>
            </CardHeader>
            <CardContent>
              <div className="grid grid-cols-2 gap-6">
                <div>
                  <h3 className="text-sm font-medium text-muted-foreground mb-2">Basic Information</h3>
                  <div className="space-y-2">
                    <div className="grid grid-cols-2 gap-2">
                      <span className="text-sm font-medium">Name:</span>
                      <span className="text-sm">{equipment.name}</span>
                    </div>
                    <div className="grid grid-cols-2 gap-2">
                      <span className="text-sm font-medium">Asset Code:</span>
                      <span className="text-sm">{equipment.assetCode}</span>
                    </div>
                    <div className="grid grid-cols-2 gap-2">
                      <span className="text-sm font-medium">Year:</span>
                      <span className="text-sm">{equipment.yearOfManufacture}</span>
                    </div>
                    <div className="grid grid-cols-2 gap-2">
                      <span className="text-sm font-medium">Category:</span>
                      <span className="text-sm">{equipment.category?.name}</span>
                    </div>
                    <div className="grid grid-cols-2 gap-2">
                      <span className="text-sm font-medium">Model:</span>
                      <span className="text-sm">{equipment.model?.name}</span>
                    </div>
                  </div>
                </div>
                <div>
                  <h3 className="text-sm font-medium text-muted-foreground mb-2">Assignment</h3>
                  <div className="space-y-2">
                    <div className="grid grid-cols-2 gap-2">
                      <span className="text-sm font-medium">Project:</span>
                      <span className="text-sm">{equipment.project?.name}</span>
                    </div>
                  </div>
                </div>
              </div>
            </CardContent>
          </Card>
        </TabsContent>

        {/* Maintenance Tab */}
        <TabsContent value="maintenance">
          <Card>
            <CardHeader className="flex flex-row items-center justify-between">
              <div>
                <CardTitle>Maintenance History</CardTitle>
                <CardDescription>Maintenance records for {equipment.name}</CardDescription>
              </div>
              <Button>Schedule Maintenance</Button>
            </CardHeader>
            <CardContent>
              {isLoadingMaintenance ? (
                <div className="h-40 flex items-center justify-center">
                  <div className="animate-spin rounded-full h-8 w-8 border-t-2 border-b-2 border-primary"></div>
                </div>
              ) : maintenanceLogs && maintenanceLogs.length > 0 ? (
                <Table>
                  <TableHeader>
                    <TableRow>
                      <TableHead>Type</TableHead>
                      <TableHead>Date</TableHead>
                      <TableHead>Service Date</TableHead>
                      <TableHead>Service Hours</TableHead>
                      <TableHead>Breakdown Synopsis</TableHead>
                      <TableHead>Operator</TableHead>
                      <TableHead>Cost</TableHead>
                    </TableRow>
                  </TableHeader>
                  <TableBody>
                    {maintenanceLogs.map((log: any) => (
                      <TableRow key={log.id}>
                        <TableCell>
                          <div className="flex items-center gap-2">
                            <div className={`p-1.5 rounded-full ${log.typeOfMaintenance === 'Preventive Maintenance' ? 'bg-blue-100' : 'bg-amber-100'}`}>
                              <Tool className={`h-3.5 w-3.5 ${log.typeOfMaintenance === 'Preventive Maintenance' ? 'text-blue-600' : 'text-amber-600'}`} />
                            </div>
                            <span>{log.typeOfMaintenance}</span>
                          </div>
                        </TableCell>
                        <TableCell>{formatDate(log.date)}</TableCell>
                        <TableCell>{formatDate(log.serviceDate)}</TableCell>
                        <TableCell>{log.serviceHours}</TableCell>
                        <TableCell className="max-w-[200px] truncate">{log.breakdownSynopsis}</TableCell>
                        <TableCell>{log.operatorName}</TableCell>
                        <TableCell>${log.balanceForService}</TableCell>
                      </TableRow>
                    ))}
                  </TableBody>
                </Table>
              ) : (
                <div className="text-center py-10">
                  <FileText className="h-10 w-10 text-muted-foreground mx-auto mb-3" />
                  <h3 className="text-lg font-medium">No maintenance records</h3>
                  <p className="text-sm text-muted-foreground mt-1">
                    There are no maintenance records for this equipment.
                  </p>
                </div>
              )}
            </CardContent>
          </Card>
        </TabsContent>

        {/* Utilization Tab */}
        <TabsContent value="utilization">
          <Card>
            <CardHeader className="flex flex-row items-center justify-between">
              <div>
                <CardTitle>Equipment Utilization</CardTitle>
                <CardDescription>Usage statistics for {equipment.name}</CardDescription>
              </div>
              <Button>Add Utilization Record</Button>
            </CardHeader>
            <CardContent>
              {isLoadingUtilization ? (
                <div className="h-40 flex items-center justify-center">
                  <div className="animate-spin rounded-full h-8 w-8 border-t-2 border-b-2 border-primary"></div>
                </div>
              ) : utilizationData && utilizationData.length > 0 ? (
                <Table>
                  <TableHeader>
                    <TableRow>
                      <TableHead>Month/Year</TableHead>
                      <TableHead>Starting Hours</TableHead>
                      <TableHead>Closing Hours</TableHead>
                      <TableHead>Target Hours</TableHead>
                      <TableHead>Availability Hours</TableHead>
                      <TableHead>Diesel Consumed (L)</TableHead>
                      <TableHead>Avg. Fuel Consumption</TableHead>
                      <TableHead>Utilization %</TableHead>
                    </TableRow>
                  </TableHeader>
                  <TableBody>
                    {utilizationData.map((util: any) => (
                      <TableRow key={util.id}>
                        <TableCell>{`${util.month}/${util.year}`}</TableCell>
                        <TableCell>{util.startingHoursKms}</TableCell>
                        <TableCell>{util.closingHoursKms}</TableCell>
                        <TableCell>{util.targetHoursKms}</TableCell>
                        <TableCell>{util.availabilityHours}</TableCell>
                        <TableCell>{util.dieselConsumedLtrs}</TableCell>
                        <TableCell>{util.avgFuelConsumption}</TableCell>
                        <TableCell>
                          <div className="flex items-center gap-2">
                            <div className="w-full bg-gray-200 rounded-full h-2.5">
                              <div 
                                className="bg-primary h-2.5 rounded-full" 
                                style={{ width: `${Math.min(util.utilizationPercentage, 100)}%` }}
                              ></div>
                            </div>
                            <span>{util.utilizationPercentage}%</span>
                          </div>
                        </TableCell>
                      </TableRow>
                    ))}
                  </TableBody>
                </Table>
              ) : (
                <div className="text-center py-10">
                  <Clock className="h-10 w-10 text-muted-foreground mx-auto mb-3" />
                  <h3 className="text-lg font-medium">No utilization data</h3>
                  <p className="text-sm text-muted-foreground mt-1">
                    There is no utilization data for this equipment.
                  </p>
                </div>
              )}
            </CardContent>
          </Card>
        </TabsContent>

        {/* Incidents Tab */}
        <TabsContent value="incidents">
          <Card>
            <CardHeader className="flex flex-row items-center justify-between">
              <div>
                <CardTitle>Breakdown Incidents</CardTitle>
                <CardDescription>Breakdown and duress incidents for {equipment.name}</CardDescription>
              </div>
              <Button>Report Incident</Button>
            </CardHeader>
            <CardContent>
              {isLoadingIncidents ? (
                <div className="h-40 flex items-center justify-center">
                  <div className="animate-spin rounded-full h-8 w-8 border-t-2 border-b-2 border-primary"></div>
                </div>
              ) : incidents && incidents.length > 0 ? (
                <Table>
                  <TableHeader>
                    <TableRow>
                      <TableHead>Date</TableHead>
                      <TableHead>Type</TableHead>
                      <TableHead>Status</TableHead>
                      <TableHead>Action Taken</TableHead>
                      <TableHead>Est. Completion</TableHead>
                      <TableHead>Project</TableHead>
                    </TableRow>
                  </TableHeader>
                  <TableBody>
                    {incidents.map((incident: any) => (
                      <TableRow key={incident.id}>
                        <TableCell>{formatDate(incident.incidentDate)}</TableCell>
                        <TableCell>{incident.incidentType}</TableCell>
                        <TableCell>
                          <Badge 
                            variant={
                              incident.status === 'OPEN' ? 'destructive' : 
                              incident.status === 'IN_PROGRESS' ? 'warning' : 
                              incident.status === 'RESOLVED' ? 'success' : 
                              'default'
                            }
                          >
                            {incident.status}
                          </Badge>
                        </TableCell>
                        <TableCell className="max-w-[300px] truncate">{incident.actionTaken}</TableCell>
                        <TableCell>{formatDate(incident.estimatedCompletionDate)}</TableCell>
                        <TableCell>{incident.project?.name}</TableCell>
                      </TableRow>
                    ))}
                  </TableBody>
                </Table>
              ) : (
                <div className="text-center py-10">
                  <AlertTriangle className="h-10 w-10 text-muted-foreground mx-auto mb-3" />
                  <h3 className="text-lg font-medium">No incidents reported</h3>
                  <p className="text-sm text-muted-foreground mt-1">
                    There are no breakdown incidents reported for this equipment.
                  </p>
                </div>
              )}
            </CardContent>
          </Card>
        </TabsContent>

        {/* Technicians Tab */}
        <TabsContent value="technicians">
          <Card>
            <CardHeader className="flex flex-row items-center justify-between">
              <div>
                <CardTitle>Assigned Technicians</CardTitle>
                <CardDescription>Technicians responsible for {equipment.name}</CardDescription>
              </div>
              <Button>Assign Technician</Button>
            </CardHeader>
            <CardContent>
              {/* Since we don't have a direct technician service, we'll use maintenance logs to show technicians */}
              {isLoadingMaintenance ? (
                <div className="h-40 flex items-center justify-center">
                  <div className="animate-spin rounded-full h-8 w-8 border-t-2 border-b-2 border-primary"></div>
                </div>
              ) : maintenanceLogs && maintenanceLogs.length > 0 ? (
                <div className="grid grid-cols-1 md:grid-cols-2 gap-4">
                  {/* Extract unique technicians from maintenance logs */}
                  {Array.from(new Set(maintenanceLogs.map((log: any) => log.operatorName)))
                    .filter(Boolean)
                    .map((technicianName: any, index) => (
                      <Card key={index} className="overflow-hidden">
                        <div className="flex">
                          <div className="bg-primary/10 p-4 flex items-center justify-center">
                            <User className="h-10 w-10 text-primary" />
                          </div>
                          <div className="p-4 flex-1">
                            <h3 className="font-medium">{technicianName}</h3>
                            <p className="text-sm text-muted-foreground">Maintenance Technician</p>
                            <div className="mt-2 flex justify-end">
                              <Button variant="outline" size="sm">View Profile</Button>
                            </div>
                          </div>
                        </div>
                      </Card>
                    ))}
                </div>
              ) : (
                <div className="text-center py-10">
                  <User className="h-10 w-10 text-muted-foreground mx-auto mb-3" />
                  <h3 className="text-lg font-medium">No technicians assigned</h3>
                  <p className="text-sm text-muted-foreground mt-1">
                    There are no technicians assigned to this equipment.
                  </p>
                </div>
              )}
            </CardContent>
          </Card>
        </TabsContent>
      </Tabs>
    </div>
  );
}
