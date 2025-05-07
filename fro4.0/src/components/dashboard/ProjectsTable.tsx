import React from 'react';
import DataTable from '@/components/DataTable';
import { Project } from '@/services/projectService';

interface ProjectsTableProps {
  projects: Project[];
}

const columns = [
  { key: 'id', label: 'ID' },
  { key: 'name', label: 'Name' },
  { key: 'description', label: 'Description' },
  { key: 'location', label: 'Location' },
  { key: 'startDate', label: 'Start Date' },
  { key: 'endDate', label: 'End Date' },
  { key: 'status', label: 'Status' },
];

const ProjectsTable: React.FC<ProjectsTableProps> = ({ projects }) => {
  return (
    <DataTable
      title="Projects"
      columns={columns}
      data={projects}
      onAdd={() => {}}
      onEdit={() => {}}
      onDelete={() => {}}
      showTitle={false}
    />
  );
};

export default ProjectsTable;
