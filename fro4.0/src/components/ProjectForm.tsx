import React from 'react';
import { Input } from '@/components/ui/input';
import { Textarea } from '@/components/ui/textarea';
import { Button } from '@/components/ui/button';
import { Card, CardHeader, CardTitle, CardContent } from '@/components/ui/card';
import { Label } from '@/components/ui/label';
// Removed all MUI imports
import { Project } from '@/services/projectService';
import { Select, SelectTrigger, SelectContent, SelectItem, SelectValue } from "@/components/ui/select";

const gridClass = "grid gap-6";
const gridItemClass = "w-full";
const dateFieldsClass = "grid grid-cols-1 md:grid-cols-2 gap-6";

interface ProjectFormProps {
  project?: Project;
  onSubmit: (project: Project) => void;
  onCancel: () => void;
}

const ProjectForm: React.FC<ProjectFormProps> = ({ project, onSubmit, onCancel }) => {
  const [formData, setFormData] = React.useState<Project>({
    name: project?.name || '',
    description: project?.description || '',
    location: project?.location || '',
    startDate: project?.startDate || '',
    endDate: project?.endDate || '',
    status: project?.status || 'PENDING'
  });

  // Debug log to check initial status value
  React.useEffect(() => {
    console.log('Initial form data:', formData);
  }, []);

  // Handle text and date inputs
  const handleInputChange = (e: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement>) => {
    const { name, value } = e.target;
    console.log(`Input change - ${name}: ${value}`);
    setFormData(prev => ({ ...prev, [name]: value }));
  };

  // Handle direct status change
  const handleStatusChange = (status: string) => {
    console.log(`Direct status change: ${status}`);
    setFormData(prev => ({ ...prev, status }));
  };

  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault();
    console.log('Submitting form data:', formData);
    onSubmit(formData);
  };

  return (
    <form onSubmit={handleSubmit} className="mt-2">
      <Card className="p-4 mb-6">
        <CardHeader className="p-0 mb-4">
          <CardTitle>{project ? 'Edit Project Details' : 'New Project Details'}</CardTitle>
        </CardHeader>
        <div className={gridClass}>
          <div className={gridItemClass}>
            <Label htmlFor="name">Project Name *</Label>
            <Input
              id="name"
              name="name"
              required
              value={formData.name}
              onChange={handleInputChange}
              className="mt-1"
            />
          </div>
          <div className={gridItemClass}>
            <Label htmlFor="description">Description *</Label>
            <Textarea
              id="description"
              name="description"
              required
              value={formData.description}
              onChange={handleInputChange}
              className="mt-1"
              rows={3}
            />
          </div>
          <div className={gridItemClass}>
            <Label htmlFor="location">Location *</Label>
            <Input
              id="location"
              name="location"
              required
              value={formData.location}
              onChange={handleInputChange}
              className="mt-1"
            />
          </div>
          <div className={dateFieldsClass}>
            <div>
              <Label htmlFor="startDate">Start Date *</Label>
              <Input
                id="startDate"
                name="startDate"
                type="date"
                required
                value={formData.startDate}
                onChange={handleInputChange}
                className="mt-1"
              />
            </div>
            <div>
              <Label htmlFor="endDate">End Date *</Label>
              <Input
                id="endDate"
                name="endDate"
                type="date"
                required
                value={formData.endDate}
                onChange={handleInputChange}
                className="mt-1"
              />
            </div>
          </div>
          <div className={gridItemClass}>
            <Label htmlFor="status">Status *</Label>
            <Select
              name="status"
              value={formData.status}
              onValueChange={(value: string) => {
                setFormData(prev => ({ ...prev, status: value }));
              }}
              required
            >
              <SelectTrigger className="w-full mt-1">
                <SelectValue placeholder="Select status" />
              </SelectTrigger>
              <SelectContent>
                <SelectItem value="ACTIVE">Active</SelectItem>
                <SelectItem value="PLANNING">Planning</SelectItem>
                <SelectItem value="COMPLETED">Completed</SelectItem>
              </SelectContent>
            </Select>
          </div>
          <div className={gridItemClass + ' flex gap-4 justify-end mt-2'}>
            <Button type="button" variant="outline" onClick={onCancel}>
              Cancel
            </Button>
            <Button type="submit" variant="default">
              {project ? 'Update' : 'Create'} Project
            </Button>
          </div>
        </div>
      </Card>
    </form>
  );
};

export default ProjectForm;
