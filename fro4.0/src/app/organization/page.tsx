"use client";

import React, { useState, useMemo } from "react";
import { useQuery, useMutation, useQueryClient } from "react-query";
import { Card, CardContent, CardHeader, CardTitle, CardDescription } from "@/components/ui/card";
import { Tabs, TabsContent, TabsList, TabsTrigger } from "@/components/ui/tabs";
import { Input } from "@/components/ui/input";
import { BarChart } from "@/components/ui/charts";
import { EmployeeDto, employeeService } from "@/services/employeeService";
import DataTable from "@/components/DataTable";
import DepartmentForm from "@/components/DepartmentForm";
import DesignationForm from "@/components/DesignationForm";
import { Dialog, DialogContent, DialogHeader, DialogTitle } from "@/components/ui/dialog";
import { DepartmentDto, DepartmentRequestDto, departmentService } from "@/services/departmentService";
import { DesignationDto, DesignationRequestDto, designationService } from "@/services/designationService";
import toast from "react-hot-toast";
import { Select, SelectTrigger, SelectValue, SelectContent, SelectItem } from '@/components/ui/select';

export default function OrganizationPage() {
  const [activeTab, setActiveTab] = useState("departments");
  const [departmentDialogOpen, setDepartmentDialogOpen] = useState(false);
  const [designationDialogOpen, setDesignationDialogOpen] = useState(false);
  const [selectedDepartment, setSelectedDepartment] = useState<DepartmentDto | undefined>();
  const [selectedDesignation, setSelectedDesignation] = useState<DesignationDto | undefined>();
  const [deptSearch, setDeptSearch] = useState("");
  const [desigSearch, setDesigSearch] = useState("");
  const queryClient = useQueryClient();
  const [deptCurrentPage, setDeptCurrentPage] = useState(1);
  const [deptRowsPerPage, setDeptRowsPerPage] = useState(10);
  const [desigCurrentPage, setDesigCurrentPage] = useState(1);
  const [desigRowsPerPage, setDesigRowsPerPage] = useState(10);

  // Fetch departments
  const { data: departments = [], isLoading: deptLoading } = useQuery([
    "departments",
  ], departmentService.getAllDepartments);

  // Fetch designations
  const { data: designations = [], isLoading: desigLoading } = useQuery([
    "designations",
  ], designationService.getAllDesignations);

  // Fetch employees
  const { data: employees = [] } = useQuery([
    "employees",
  ], employeeService.getAllEmployees);

  // Mutations for departments
  const createDeptMutation = useMutation(
    (data: DepartmentRequestDto) => departmentService.createDepartment(data),
    {
      onSuccess: () => {
        queryClient.invalidateQueries(["departments"]);
        setDepartmentDialogOpen(false);
        toast.success("Department created successfully!");
      },
      onError: () => toast.error("Failed to create department."),
    }
  );
  const updateDeptMutation = useMutation(
    ({ id, data }: { id: number; data: DepartmentRequestDto }) =>
      departmentService.updateDepartment(id, data),
    {
      onSuccess: () => {
        queryClient.invalidateQueries(["departments"]);
        setDepartmentDialogOpen(false);
        toast.success("Department updated successfully!");
      },
      onError: () => toast.error("Failed to update department."),
    }
  );

  // Mutations for designations
  const createDesigMutation = useMutation(
    (data: DesignationRequestDto) => designationService.createDesignation(data),
    {
      onSuccess: () => {
        queryClient.invalidateQueries(["designations"]);
        setDesignationDialogOpen(false);
        toast.success("Designation created successfully!");
      },
      onError: () => toast.error("Failed to create designation."),
    }
  );
  const updateDesigMutation = useMutation(
    ({ id, data }: { id: number; data: DesignationRequestDto }) =>
      designationService.updateDesignation(id, data),
    {
      onSuccess: () => {
        queryClient.invalidateQueries(["designations"]);
        setDesignationDialogOpen(false);
        toast.success("Designation updated successfully!");
      },
      onError: () => toast.error("Failed to update designation."),
    }
  );

  // Filtering
  const filteredDepartments = useMemo(
    () =>
      departments.filter((d: DepartmentDto) =>
        d.name.toLowerCase().includes(deptSearch.toLowerCase())
      ),
    [departments, deptSearch]
  );
  const filteredDesignations = useMemo(
    () =>
      designations.filter((d: DesignationDto) =>
        d.name.toLowerCase().includes(desigSearch.toLowerCase())
      ),
    [designations, desigSearch]
  );

  // Chart data: count employees per department and per designation (ALWAYS show all, not filtered)
  const deptChartData = departments.map((d: DepartmentDto) => ({
    name: d.name,
    Employees: employees.filter((e: EmployeeDto) => e.department?.id === d.id).length,
  }));
  const desigChartData = designations.map((d: DesignationDto) => ({
    name: d.name,
    Employees: employees.filter((e: EmployeeDto) => e.designation?.id === d.id).length,
  }));

  // DataTable columns (no Employees column)
  const deptColumns = [
    { key: "name", label: "Department Name" },
    { key: "description", label: "Description" },
  ];
  const desigColumns = [
    { key: "name", label: "Designation Name" },
    { key: "description", label: "Description" },
  ];

  // Pagination for departments
  const deptTotalRows = filteredDepartments.length;
  const deptTotalPages = Math.ceil(deptTotalRows / deptRowsPerPage);
  const paginatedDepartments = filteredDepartments.slice(
    (deptCurrentPage - 1) * deptRowsPerPage,
    deptCurrentPage * deptRowsPerPage
  );
  React.useEffect(() => { setDeptCurrentPage(1); }, [filteredDepartments, deptRowsPerPage]);

  // Pagination for designations
  const desigTotalRows = filteredDesignations.length;
  const desigTotalPages = Math.ceil(desigTotalRows / desigRowsPerPage);
  const paginatedDesignations = filteredDesignations.slice(
    (desigCurrentPage - 1) * desigRowsPerPage,
    desigCurrentPage * desigRowsPerPage
  );
  React.useEffect(() => { setDesigCurrentPage(1); }, [filteredDesignations, desigRowsPerPage]);

  return (
    <div className="p-6 space-y-6">
      {/* Summary Cards */}
      <div className="grid grid-cols-1 md:grid-cols-2 gap-6">
        <Card>
          <CardHeader>
            <CardTitle>Total Departments</CardTitle>
            <CardDescription>Count of all departments</CardDescription>
          </CardHeader>
          <CardContent>
            <div className="text-3xl font-bold">{departments.length}</div>
          </CardContent>
        </Card>
        <Card>
          <CardHeader>
            <CardTitle>Total Designations</CardTitle>
            <CardDescription>Count of all designations</CardDescription>
          </CardHeader>
          <CardContent>
            <div className="text-3xl font-bold">{designations.length}</div>
          </CardContent>
        </Card>
      </div>

      {/* Department and Designation Graphs Side by Side */}
      <div className="grid grid-cols-1 md:grid-cols-2 gap-6 mb-6">
        <Card>
          <CardHeader>
            <CardTitle>Departments</CardTitle>
            <CardDescription>Employee count by department</CardDescription>
          </CardHeader>
          <CardContent className="h-[300px]">
            <BarChart
              data={deptChartData}
              index="name"
              categories={["Employees"]}
              colors={["#0ea5e9"]}
              valueFormatter={(v) => `${v}`}
            />
          </CardContent>
        </Card>
        <Card>
          <CardHeader>
            <CardTitle>Designations</CardTitle>
            <CardDescription>Employee count by designation</CardDescription>
          </CardHeader>
          <CardContent className="h-[300px]">
            <BarChart
              data={desigChartData}
              index="name"
              categories={["Employees"]}
              colors={["#f59e42"]}
              valueFormatter={(v) => `${v}`}
            />
          </CardContent>
        </Card>
      </div>
      
      {/* Tabs for Departments/Designations Tables */}
      <Tabs value={activeTab} onValueChange={setActiveTab} className="w-full">
        <TabsList className="mb-4">
          <TabsTrigger value="departments">Departments</TabsTrigger>
          <TabsTrigger value="designations">Designations</TabsTrigger>
        </TabsList>
        <TabsContent value="departments">
          <Input
            placeholder="Search Departments..."
            value={deptSearch}
            onChange={(e) => setDeptSearch(e.target.value)}
            className="max-w-xs mb-4"
          />
          <DataTable
            title="Departments"
            columns={deptColumns}
            data={paginatedDepartments}
            onAdd={() => {
              setSelectedDepartment(undefined);
              setDepartmentDialogOpen(true);
            }}
            onEdit={(item) => {
              setSelectedDepartment(item);
              setDepartmentDialogOpen(true);
            }}
            onDelete={() => toast("Delete not implemented in demo")}
          />
          <div className="flex items-center justify-between mt-4 px-4 pb-4">
            <div className="flex items-center gap-2">
              <button
                className="px-3 py-1 border rounded disabled:opacity-50"
                onClick={() => setDeptCurrentPage((p) => Math.max(1, p - 1))}
                disabled={deptCurrentPage === 1}
              >
                Previous
              </button>
              <span className="mx-2">Page {deptCurrentPage} of {deptTotalPages || 1}</span>
              <button
                className="px-3 py-1 border rounded disabled:opacity-50"
                onClick={() => setDeptCurrentPage((p) => Math.min(deptTotalPages, p + 1))}
                disabled={deptCurrentPage === deptTotalPages || deptTotalPages === 0}
              >
                Next
              </button>
            </div>
            <div className="flex items-center gap-2">
              <span>Rows per page:</span>
              <Select value={String(deptRowsPerPage)} onValueChange={v => setDeptRowsPerPage(Number(v))}>
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
          {/* Department Dialog */}
          <Dialog open={departmentDialogOpen} onOpenChange={setDepartmentDialogOpen}>
            <DialogContent>
              <DialogHeader>
                <DialogTitle>{selectedDepartment ? "Edit Department" : "Add Department"}</DialogTitle>
              </DialogHeader>
              <DepartmentForm
                department={selectedDepartment}
                onSubmit={(data) => {
                  if (selectedDepartment) {
                    updateDeptMutation.mutate({ id: selectedDepartment.id, data });
                  } else {
                    createDeptMutation.mutate(data);
                  }
                }}
                onCancel={() => setDepartmentDialogOpen(false)}
              />
            </DialogContent>
          </Dialog>
        </TabsContent>
        <TabsContent value="designations">
          <Input
            placeholder="Search Designations..."
            value={desigSearch}
            onChange={(e) => setDesigSearch(e.target.value)}
            className="max-w-xs mb-4"
          />
          <DataTable
            title="Designations"
            columns={desigColumns}
            data={paginatedDesignations}
            onAdd={() => {
              setSelectedDesignation(undefined);
              setDesignationDialogOpen(true);
            }}
            onEdit={(item) => {
              setSelectedDesignation(item);
              setDesignationDialogOpen(true);
            }}
            onDelete={() => toast("Delete not implemented in demo")}
          />
          <div className="flex items-center justify-between mt-4 px-4 pb-4">
            <div className="flex items-center gap-2">
              <button
                className="px-3 py-1 border rounded disabled:opacity-50"
                onClick={() => setDesigCurrentPage((p) => Math.max(1, p - 1))}
                disabled={desigCurrentPage === 1}
              >
                Previous
              </button>
              <span className="mx-2">Page {desigCurrentPage} of {desigTotalPages || 1}</span>
              <button
                className="px-3 py-1 border rounded disabled:opacity-50"
                onClick={() => setDesigCurrentPage((p) => Math.min(desigTotalPages, p + 1))}
                disabled={desigCurrentPage === desigTotalPages || desigTotalPages === 0}
              >
                Next
              </button>
            </div>
            <div className="flex items-center gap-2">
              <span>Rows per page:</span>
              <Select value={String(desigRowsPerPage)} onValueChange={v => setDesigRowsPerPage(Number(v))}>
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
          {/* Designation Dialog */}
          <Dialog open={designationDialogOpen} onOpenChange={setDesignationDialogOpen}>
            <DialogContent>
              <DialogHeader>
                <DialogTitle>{selectedDesignation ? "Edit Designation" : "Add Designation"}</DialogTitle>
              </DialogHeader>
              <DesignationForm
                designation={selectedDesignation}
                onSubmit={(data) => {
                  if (selectedDesignation) {
                    updateDesigMutation.mutate({ id: selectedDesignation.id, data });
                  } else {
                    createDesigMutation.mutate(data);
                  }
                }}
                onCancel={() => setDesignationDialogOpen(false)}
              />
            </DialogContent>
          </Dialog>
        </TabsContent>
      </Tabs>
    </div>
  );
}
