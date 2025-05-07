'use client';

import React from 'react';
import { useQuery, useMutation, useQueryClient } from 'react-query';
import {
  Dialog,
  DialogContent,
  DialogHeader,
  DialogTitle,
} from '@/components/ui/dialog';
import DataTable from '@/components/DataTable';
import { Model, ModelRequest, modelService } from '@/services/modelService';
import ModelForm from '@/components/ModelForm';
import { Tooltip } from '@/components/ui/tooltip';
import { TooltipContent, TooltipProvider, TooltipTrigger } from '@/components/ui/tooltip';
import { toast } from 'sonner';
import { Select, SelectTrigger, SelectValue, SelectContent, SelectItem } from '@/components/ui/select';

export default function ModelsPage() {
  const [open, setOpen] = React.useState(false);
  const [selectedModel, setSelectedModel] = React.useState<Model | null>(null);
  const queryClient = useQueryClient();
  const [currentPage, setCurrentPage] = React.useState(1);
  const [rowsPerPage, setRowsPerPage] = React.useState(10);

  // Fetch models
  const { data: models = [], isLoading } = useQuery('models', modelService.getAllModels);

  // Calculate pagination
  const totalRows = models.length;
  const totalPages = Math.ceil(totalRows / rowsPerPage);
  const paginatedModels = models.slice(
    (currentPage - 1) * rowsPerPage,
    currentPage * rowsPerPage
  );

  // Reset to first page if models or rowsPerPage changes
  React.useEffect(() => {
    setCurrentPage(1);
  }, [models, rowsPerPage]);

  // Mutations with improved toast notifications
  const createMutation = useMutation(modelService.createModel, {
    onSuccess: (data) => {
      queryClient.invalidateQueries('models');
      handleClose();
      toast.success('Success', {
        description: 'Model created successfully',
        position: 'top-right',
      });
    },
    onError: (error: any) => {
      toast.error('Error', {
        description: error?.response?.data?.message || 'Failed to create model',
        position: 'top-right',
      });
    }
  });

  const updateMutation = useMutation(
    (data: { id: number; model: ModelRequest }) => modelService.updateModel(data.id, data.model),
    {
      onSuccess: (data) => {
        queryClient.invalidateQueries('models');
        handleClose();
        toast.success('Success', {
          description: 'Model updated successfully',
          position: 'top-right',
        });
      },
      onError: (error: any) => {
        toast.error('Error', {
          description: error?.response?.data?.message || 'Failed to update model',
          position: 'top-right',
        });
      }
    }
  );

  const deleteMutation = useMutation(modelService.deleteModel, {
    onSuccess: (data) => {
      queryClient.invalidateQueries('models');
      toast.success('Success', {
        description: 'Model deleted successfully',
        position: 'top-right',
      });
    },
    onError: (error: any) => {
      toast.error('Error', {
        description: error?.response?.data?.message || 'Failed to delete model',
        position: 'top-right',
      });
    }
  });

  const handleOpen = (model?: Model) => {
    setSelectedModel(model || null);
    setOpen(true);
  };

  const handleClose = () => {
    setSelectedModel(null);
    setOpen(false);
  };

  const handleSubmit = (modelData: ModelRequest) => {
    if (selectedModel?.id) {
      updateMutation.mutate({ id: selectedModel.id, model: modelData });
    } else {
      createMutation.mutate(modelData);
    }
  };

  const handleDelete = (id: number) => {
    if (confirm('Are you sure you want to delete this model?')) {
      deleteMutation.mutate(id);
    }
  };

  const columns = [
    { key: 'name', label: 'Name' },
    { key: 'make.name', label: 'Make' },
  ];

  const renderCustomCell = (column: string, item: any) => {
    if (column === 'name') {
      return item.name; // Explicitly return the name
    }
    if (column === 'make.name' && item.make) {
      return item.make.name;
    }
    // For debugging
    console.log('Rendering cell for column:', column, 'item:', item);
    return undefined; // Return undefined to use default rendering
  };

  if (isLoading) {
    return <div className="p-6">Loading...</div>;
  }

  const totalModels = models.length;

  return (
    <div className="p-6">
      <h1 className="text-2xl font-bold mb-4">Models</h1>
      <div className="flex gap-4 mb-4">
        <div className="bg-gradient-to-r from-indigo-100 to-indigo-200 rounded-lg shadow p-2 flex-1 min-w-[180px] flex items-center justify-between">
          <div>
            <div className="text-sm font-semibold">Total Models</div>
            <div className="text-xl font-bold">{totalModels}</div>
          </div>
          <div className="text-indigo-400 text-2xl">
            <span role="img" aria-label="model">🧩</span>
          </div>
        </div>
        <button
          className="flex items-center gap-1 bg-black hover:bg-gray-900 text-white font-bold py-1 px-3 rounded-md text-sm shadow-sm transition-all focus:outline-none focus:ring-2 focus:ring-gray-400"
          onClick={() => handleOpen()}
        >
          <span className="text-base font-bold">+</span>
          <span>Add Model</span>
        </button>
      </div>
      <div className="bg-white rounded-xl shadow-md border border-gray-100 overflow-hidden">
        <table className="min-w-full divide-y divide-gray-200">
          <thead className="bg-gray-50">
            <tr>
              <th scope="col" className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Model Name</th>
              <th scope="col" className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Make</th>
              <th scope="col" className="px-6 py-3 text-right text-xs font-medium text-gray-500 uppercase tracking-wider">Actions</th>
            </tr>
          </thead>
          <tbody className="bg-white divide-y divide-gray-200">
            {paginatedModels.map((model: any) => (
              <tr key={model.id} className="hover:bg-gray-50 transition-colors">
                <td className="px-6 py-3 whitespace-nowrap">
                  <div className="flex items-center">
                    <span className="text-indigo-500 mr-2">🧩</span>
                    <div className="font-medium text-gray-900">{model.name}</div>
                  </div>
                </td>
                <td className="px-6 py-3 whitespace-nowrap text-sm text-gray-500">
                  {model.make?.name || '-'}
                </td>
                <td className="px-6 py-3 whitespace-nowrap text-right text-sm font-medium">
                  <button
                    className="text-indigo-600 hover:text-indigo-900 mr-4"
                    onClick={() => handleOpen(model)}
                  >
                    Edit
                  </button>
                  <button
                    className="text-red-600 hover:text-red-900"
                    onClick={() => handleDelete(model.id)}
                  >
                    Delete
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
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
      </div>
      <Dialog open={open} onOpenChange={setOpen}>
        <DialogContent className="sm:max-w-[500px]">
          <DialogHeader>
            <DialogTitle>
              {selectedModel ? 'Edit Model' : 'Create Model'}
            </DialogTitle>
          </DialogHeader>
          <div className="mt-4">
            <ModelForm
              model={selectedModel || undefined}
              onSubmit={handleSubmit}
              onCancel={handleClose}
            />
          </div>
        </DialogContent>
      </Dialog>
    </div>
  );
}
