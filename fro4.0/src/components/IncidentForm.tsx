import React from 'react';
import { useQuery } from 'react-query';
import { equipmentService } from '@/services/equipmentService';
import { projectService } from '@/services/projectService';
import { IncidentReport, IncidentReportRequest, IncidentType, IncidentStatus } from '@/services/incidentService';
import { Button } from '@/components/ui/button';
import { Input } from '@/components/ui/input';
import { Label } from '@/components/ui/label';
import { Textarea } from '@/components/ui/textarea';
import { Card, CardContent } from '@/components/ui/card';
import {
  Select,
  SelectContent,
  SelectItem,
  SelectTrigger,
  SelectValue,
} from '@/components/ui/select';



interface IncidentFormProps {
  incident?: IncidentReport;
  onSubmit: (incident: IncidentReportRequest) => void;
  onCancel: () => void;
}

// const incidentTypes: IncidentType[] = ['TYPE1', 'TYPE2', 'TYPE3'];
const incidentTypes: IncidentType[] = ['MECHANICAL_FAILURE', 'ELECTRICAL_FAILURE', 'MAINTENANCE_ISSUE', 'OPERATOR_ERROR', 'SAFETY_NEAR_MISS', 'UNAUTHORIZED_USE', 'ENVIRONMENTAL_DAMAGE', 'STRUCTURAL_FAILURE', 'PERFORMANCE_ISSUE', 'COMPLIANCE_BREACH'];
const incidentStatuses: IncidentStatus[] = ['OPEN', 'IN_PROGRESS', 'CLOSED', 'RESOLVED'];

const IncidentForm: React.FC<IncidentFormProps> = ({ incident, onSubmit, onCancel }) => {
  const [formData, setFormData] = React.useState<IncidentReportRequest>({
    incidentDate: incident?.incidentDate || new Date().toISOString().split('T')[0],
    closeDate: incident?.closeDate || '',
    estimatedCompletionDate: incident?.estimatedCompletionDate || '',
    incidentType: incident?.incidentType || 'MECHANICAL_FAILURE',
    equipmentId: incident?.equipment?.id || 0,
    projectId: incident?.project?.id || 0,
    actionTaken: incident?.actionTaken || '',
    incidentDetails: incident?.incidentDetails || '',
    status: incident?.status || 'OPEN',
  });

  const { data: equipment = [] } = useQuery(['equipment'], () => equipmentService.getAllEquipment());
  const { data: projects = [] } = useQuery(['projects'], () => projectService.getAllProjects());

  const equipmentList = Array.isArray(equipment) ? equipment : [];
  const projectList = Array.isArray(projects) ? projects : [];

  const handleChange = (e: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement | HTMLSelectElement>) => {
    const { name, value } = e.target;
    let newValue: string | number = value;
    
    // Convert to numbers for these fields
    if (['equipmentId', 'projectId'].includes(name)) {
      newValue = value === '' ? '' : parseInt(value, 10);
    }
    
    setFormData((prev) => ({
      ...prev,
      [name]: newValue,
    }));
  };

  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault();
    onSubmit(formData);
  };

  return (
    <form onSubmit={handleSubmit} className="mt-4">
      <Card className="mb-6">
        <CardContent className="pt-6 space-y-6">
          <div className="grid grid-cols-1 md:grid-cols-2 gap-6">
            <div className="space-y-2">
              <Label htmlFor="incidentDate">Incident Date *</Label>
              <Input
                id="incidentDate"
                type="date"
                name="incidentDate"
                value={formData.incidentDate}
                onChange={handleChange}
                required
              />
            </div>
            <div className="space-y-2">
              <Label htmlFor="incidentType">Incident Type *</Label>
              <Select 
                name="incidentType" 
                value={formData.incidentType} 
                onValueChange={(value) => {
                  setFormData(prev => ({
                    ...prev,
                    incidentType: value as IncidentType
                  }));
                }}
              >
                <SelectTrigger>
                  <SelectValue placeholder="Select incident type" />
                </SelectTrigger>
                <SelectContent>
                  {incidentTypes.map((type) => (
                    <SelectItem key={type} value={type}>{type}</SelectItem>
                  ))}
                </SelectContent>
              </Select>
            </div>
          </div>
          <div className="grid grid-cols-1 md:grid-cols-2 gap-6">
            <div className="space-y-2">
              <Label htmlFor="estimatedCompletionDate">Estimated Completion Date *</Label>
              <Input
                id="estimatedCompletionDate"
                type="date"
                name="estimatedCompletionDate"
                value={formData.estimatedCompletionDate}
                onChange={handleChange}
                required
              />
            </div>
            <div className="space-y-2">
              <Label htmlFor="closeDate">Closed Date</Label>
              <Input
                id="closedDate"
                type="date"
                name="closedDate"
                value={formData.closeDate}
                onChange={handleChange}
              />
            </div>
          </div>
          <div className="grid grid-cols-1 md:grid-cols-2 gap-6">
            <div className="space-y-2">
              <Label htmlFor="equipmentId">Equipment *</Label>
              <Select 
                name="equipmentId" 
                value={formData.equipmentId.toString()} 
                onValueChange={(value) => {
                  setFormData(prev => ({
                    ...prev,
                    equipmentId: parseInt(value)
                  }));
                }}
                disabled={!equipmentList.length}
              >
                <SelectTrigger>
                  <SelectValue placeholder="Select equipment" />
                </SelectTrigger>
                <SelectContent>
                  {equipmentList.map((item) => (
                    <SelectItem key={item.id} value={item.id.toString()}>{item.name}</SelectItem>
                  ))}
                </SelectContent>
              </Select>
            </div>
            <div className="space-y-2">
              <Label htmlFor="projectId">Project *</Label>
              <Select 
                name="projectId" 
                value={formData.projectId.toString()} 
                onValueChange={(value) => {
                  setFormData(prev => ({
                    ...prev,
                    projectId: parseInt(value)
                  }));
                }}
                disabled={!projectList.length}
              >
                <SelectTrigger>
                  <SelectValue placeholder="Select project" />
                </SelectTrigger>
                <SelectContent>
                  {projectList.map((project) => (
                    <SelectItem key={project.id} value={project.id.toString()}>{project.name}</SelectItem>
                  ))}
                </SelectContent>
              </Select>
            </div>
          </div>
          <div className="grid grid-cols-1 md:grid-cols-2 gap-6">
            <div className="space-y-2">
              <Label htmlFor="status">Status *</Label>
              <Select 
                name="status" 
                value={formData.status} 
                onValueChange={(value) => {
                  setFormData(prev => ({
                    ...prev,
                    status: value as IncidentStatus
                  }));
                }}
              >
                <SelectTrigger>
                  <SelectValue placeholder="Select status" />
                </SelectTrigger>
                <SelectContent>
                  {incidentStatuses.map((status) => (
                    <SelectItem key={status} value={status}>{status}</SelectItem>
                  ))}
                </SelectContent>
              </Select>
            </div>
          </div>
          <div className="space-y-2">
            <Label htmlFor="actionTaken">Action Taken *</Label>
            <Textarea
              id="actionTaken"
              name="actionTaken"
              value={formData.actionTaken}
              onChange={handleChange}
              rows={3}
              required
            />
          </div>
          <div className="space-y-2">
            <Label htmlFor="incidentDetails">Incident Details</Label>
            <Textarea
              id="incidentDetails"
              name="incidentDetails"
              value={formData.incidentDetails}
              onChange={handleChange}
              rows={3}
            />
          </div>

          <div className="flex justify-end gap-4 pt-4">
            <Button variant="outline" onClick={onCancel} type="button">
              Cancel
            </Button>
            <Button type="submit" className="bg-blue-600 hover:bg-blue-700">
              {incident ? 'Update' : 'Create'}
            </Button>
          </div>
        </CardContent>
      </Card>
    </form>
  );
};

export default IncidentForm;
