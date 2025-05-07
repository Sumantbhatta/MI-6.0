'use client';

import React, { useState, useEffect } from 'react';
import { Card, CardContent, CardHeader, CardTitle } from '@/components/ui/card';
import { Button } from '@/components/ui/button';
import { Input } from '@/components/ui/input';
import { Select, SelectContent, SelectItem, SelectTrigger, SelectValue } from '@/components/ui/select';
import { Table, TableBody, TableCell, TableHead, TableHeader, TableRow } from '@/components/ui/table';
import { Badge } from '@/components/ui/badge';
import { useToast } from '@/components/ui/use-toast';
import { format } from 'date-fns';
import { CalendarIcon, Search, Filter } from 'lucide-react';
import { Calendar } from '@/components/ui/calendar';
import { Popover, PopoverContent, PopoverTrigger } from '@/components/ui/popover';
import { cn } from '@/lib/utils';
import { useRouter } from 'next/navigation';

interface EquipmentUtilization {
  id: string;
  equipmentId: string;
  equipmentName: string;
  projectId: string;
  projectName: string;
  startDate: string;
  endDate: string;
  status: 'ACTIVE' | 'COMPLETED' | 'PLANNED';
  utilizationPercentage: number;
}

export default function EquipmentUtilization() {
  const [utilizations, setUtilizations] = useState<EquipmentUtilization[]>([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState<string | null>(null);
  const [searchTerm, setSearchTerm] = useState('');
  const [statusFilter, setStatusFilter] = useState<string>('all');
  const [dateRange, setDateRange] = useState<{
    from: Date | undefined;
    to: Date | undefined;
  }>({
    from: undefined,
    to: undefined,
  });
  const [viewMode, setViewMode] = useState<'grid' | 'table'>('grid');
  const [expandedItems, setExpandedItems] = useState<Set<string>>(new Set());
  const { toast } = useToast();
  const router = useRouter();

  useEffect(() => {
    fetchUtilizations();
  }, []);

  const fetchUtilizations = async () => {
    try {
      const response = await fetch('/api/equipment/utilization');
      if (!response.ok) {
        throw new Error('Failed to fetch equipment utilization data');
      }
      const data = await response.json();
      setUtilizations(data);
    } catch (err) {
      setError(err instanceof Error ? err.message : 'An error occurred');
      toast({
        title: 'Error',
        description: 'Failed to fetch equipment utilization data',
        variant: 'destructive',
      });
    } finally {
      setLoading(false);
    }
  };

  const toggleExpand = (id: string) => {
    setExpandedItems(prev => {
      const newSet = new Set(prev);
      if (newSet.has(id)) {
        newSet.delete(id);
      } else {
        newSet.add(id);
      }
      return newSet;
    });
  };

  const getStatusColor = (status: string) => {
    switch (status) {
      case 'ACTIVE':
        return 'bg-green-500';
      case 'COMPLETED':
        return 'bg-blue-500';
      case 'PLANNED':
        return 'bg-yellow-500';
      default:
        return 'bg-gray-500';
    }
  };

  const filteredUtilizations = utilizations.filter(utilization => {
    const matchesSearch = 
      utilization.equipmentName.toLowerCase().includes(searchTerm.toLowerCase()) ||
      utilization.projectName.toLowerCase().includes(searchTerm.toLowerCase());
    
    const matchesStatus = statusFilter === 'all' || utilization.status === statusFilter;
    
    const matchesDateRange = (!dateRange.from || new Date(utilization.startDate) >= dateRange.from) &&
      (!dateRange.to || new Date(utilization.endDate) <= dateRange.to);

    return matchesSearch && matchesStatus && matchesDateRange;
  });

  if (loading) {
    return (
      <div className="flex items-center justify-center min-h-screen">
        <div className="animate-spin rounded-full h-8 w-8 border-b-2 border-gray-900"></div>
      </div>
    );
  }

  if (error) {
    return (
      <div className="flex items-center justify-center min-h-screen">
        <div className="text-red-500">{error}</div>
      </div>
    );
  }

  return (
    <div className="container mx-auto p-6">
      <div className="flex justify-between items-center mb-6">
        <h1 className="text-2xl font-bold">Equipment Utilization</h1>
        <div className="flex gap-4">
          <Button
            variant={viewMode === 'grid' ? 'default' : 'outline'}
            onClick={() => setViewMode('grid')}
          >
            Grid View
          </Button>
          <Button
            variant={viewMode === 'table' ? 'default' : 'outline'}
            onClick={() => setViewMode('table')}
          >
            Table View
          </Button>
        </div>
      </div>

      <div className="flex flex-col md:flex-row gap-4 mb-6">
        <div className="flex-1">
          <div className="relative">
            <Search className="absolute left-2 top-2.5 h-4 w-4 text-muted-foreground" />
            <Input
              placeholder="Search equipment or project..."
              value={searchTerm}
              onChange={(e) => setSearchTerm(e.target.value)}
              className="pl-8"
            />
          </div>
        </div>
        <Select value={statusFilter} onValueChange={setStatusFilter}>
          <SelectTrigger className="w-[180px]">
            <SelectValue placeholder="Filter by status" />
          </SelectTrigger>
          <SelectContent>
            <SelectItem value="all">All Status</SelectItem>
            <SelectItem value="ACTIVE">Active</SelectItem>
            <SelectItem value="COMPLETED">Completed</SelectItem>
            <SelectItem value="PLANNED">Planned</SelectItem>
          </SelectContent>
        </Select>
        <Popover>
          <PopoverTrigger asChild>
            <Button
              variant="outline"
              className={cn(
                'w-[240px] justify-start text-left font-normal',
                !dateRange.from && 'text-muted-foreground'
              )}
            >
              <CalendarIcon className="mr-2 h-4 w-4" />
              {dateRange.from ? (
                dateRange.to ? (
                  <>
                    {format(dateRange.from, 'LLL dd, y')} -{' '}
                    {format(dateRange.to, 'LLL dd, y')}
                  </>
                ) : (
                  format(dateRange.from, 'LLL dd, y')
                )
              ) : (
                <span>Pick a date range</span>
              )}
            </Button>
          </PopoverTrigger>
          <PopoverContent className="w-auto p-0" align="start">
            <Calendar
              initialFocus
              mode="range"
              defaultMonth={dateRange.from}
              selected={dateRange}
              onSelect={setDateRange}
              numberOfMonths={2}
            />
          </PopoverContent>
        </Popover>
      </div>

      {viewMode === 'grid' ? (
        <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">
          {filteredUtilizations.map((utilization) => (
            <Card key={utilization.id} className="overflow-hidden">
              <CardHeader className="pb-2">
                <CardTitle className="text-lg">{utilization.equipmentName}</CardTitle>
                <Badge className={getStatusColor(utilization.status)}>
                  {utilization.status}
                </Badge>
              </CardHeader>
              <CardContent>
                <div className="space-y-2">
                  <p className="text-sm text-muted-foreground">
                    Project: {utilization.projectName}
                  </p>
                  <p className="text-sm text-muted-foreground">
                    Period: {format(new Date(utilization.startDate), 'MMM dd, yyyy')} -{' '}
                    {format(new Date(utilization.endDate), 'MMM dd, yyyy')}
                  </p>
                  <div className="w-full bg-gray-200 rounded-full h-2.5">
                    <div
                      className="bg-blue-600 h-2.5 rounded-full"
                      style={{ width: `${utilization.utilizationPercentage}%` }}
                    ></div>
                  </div>
                  <p className="text-sm text-right">
                    {utilization.utilizationPercentage}% Utilization
                  </p>
                  <Button
                    variant="outline"
                    className="w-full"
                    onClick={() => toggleExpand(utilization.id)}
                  >
                    {expandedItems.has(utilization.id) ? 'Show Less' : 'View More'}
                  </Button>
                  {expandedItems.has(utilization.id) && (
                    <div className="mt-4 space-y-2">
                      <p className="text-sm">
                        <span className="font-semibold">Equipment ID:</span> {utilization.equipmentId}
                      </p>
                      <p className="text-sm">
                        <span className="font-semibold">Project ID:</span> {utilization.projectId}
                      </p>
                    </div>
                  )}
                </div>
              </CardContent>
            </Card>
          ))}
        </div>
      ) : (
        <div className="border rounded-lg">
          <Table>
            <TableHeader>
              <TableRow>
                <TableHead>Equipment</TableHead>
                <TableHead>Project</TableHead>
                <TableHead>Start Date</TableHead>
                <TableHead>End Date</TableHead>
                <TableHead>Status</TableHead>
                <TableHead>Utilization</TableHead>
                <TableHead>Actions</TableHead>
              </TableRow>
            </TableHeader>
            <TableBody>
              {filteredUtilizations.map((utilization) => (
                <TableRow key={utilization.id}>
                  <TableCell>{utilization.equipmentName}</TableCell>
                  <TableCell>{utilization.projectName}</TableCell>
                  <TableCell>
                    {format(new Date(utilization.startDate), 'MMM dd, yyyy')}
                  </TableCell>
                  <TableCell>
                    {format(new Date(utilization.endDate), 'MMM dd, yyyy')}
                  </TableCell>
                  <TableCell>
                    <Badge className={getStatusColor(utilization.status)}>
                      {utilization.status}
                    </Badge>
                  </TableCell>
                  <TableCell>
                    <div className="w-full bg-gray-200 rounded-full h-2.5">
                      <div
                        className="bg-blue-600 h-2.5 rounded-full"
                        style={{ width: `${utilization.utilizationPercentage}%` }}
                      ></div>
                    </div>
                    <span className="text-sm">{utilization.utilizationPercentage}%</span>
                  </TableCell>
                  <TableCell>
                    <Button
                      variant="outline"
                      size="sm"
                      onClick={() => toggleExpand(utilization.id)}
                    >
                      {expandedItems.has(utilization.id) ? 'Show Less' : 'View More'}
                    </Button>
                  </TableCell>
                </TableRow>
              ))}
            </TableBody>
          </Table>
        </div>
      )}
    </div>
  );
} 