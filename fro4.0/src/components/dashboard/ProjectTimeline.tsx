import React from 'react';
import { Progress } from '@/components/ui/progress';
import { Badge } from '@/components/ui/badge';

interface ProjectTimelineProps {
  projects: Array<{
    id: string | number;
    name: string;
    startDate: string;
    endDate: string;
    status: string;
    progress?: number;
  }>;
}

function getStatusBadge(project: any) {
  const now = Date.now();
  const end = new Date(project.endDate).getTime();
  const progress = typeof project.progress === 'number' ? project.progress : getProgress(project);
  if (project.status === 'COMPLETED') return <Badge className="bg-green-100 text-green-700">On Track</Badge>;
  if (now > end && project.status !== 'COMPLETED') return <Badge className="bg-yellow-100 text-yellow-800">Delayed</Badge>;
  if (progress < 50 && project.status !== 'COMPLETED') return <Badge className="bg-red-100 text-red-700">At Risk</Badge>;
  return <Badge className="bg-blue-100 text-blue-700">On Track</Badge>;
}

function getProgress(project: any) {
  if (typeof project.progress === 'number') return project.progress;
  // Estimate progress by date
  const start = new Date(project.startDate).getTime();
  const end = new Date(project.endDate).getTime();
  const now = Date.now();
  if (now < start) return 0;
  if (now > end) return 100;
  return Math.floor(((now - start) / (end - start)) * 100);
}

const ProjectTimeline: React.FC<ProjectTimelineProps> = ({ projects }) => {
  return (
    <div className="space-y-6">
      <h2 className="text-2xl font-bold">Project Timeline</h2>
      <div className="text-muted-foreground mb-4">Current status and deadlines of active projects</div>
      <div className="space-y-6">
        {projects.map((project) => (
          <div key={project.id} className="pb-2 border-b last:border-none">
            <div className="flex items-center justify-between">
              <div className="font-semibold text-lg">{project.name}</div>
              <div>{getStatusBadge(project)}</div>
            </div>
            <div className="flex items-center gap-2 mt-2">
              <Progress value={getProgress(project)} className="w-full h-2 bg-gray-200" />
              <span className="text-sm font-medium text-gray-600">{getProgress(project)}%</span>
            </div>
            <div className="flex gap-8 text-xs text-muted-foreground mt-1">
              <span>Start: {project.startDate?.slice(0, 10)}</span>
              <span>End: {project.endDate?.slice(0, 10)}</span>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
};

export default ProjectTimeline;
