import React from 'react';
import { Badge } from '@/components/ui/badge';
import { IncidentReport } from '@/services/incidentService';
import { AlertCircle, Wrench, CheckCircle2 } from 'lucide-react';

const statusColors: Record<string, string> = {
  OPEN: 'bg-red-100 text-red-600',
  IN_PROGRESS: 'bg-yellow-100 text-yellow-800',
  RESOLVED: 'bg-green-100 text-green-700',
  CLOSED: 'bg-gray-200 text-gray-700',
};

const statusIcons: Record<string, React.ReactNode> = {
  OPEN: <AlertCircle className="h-4 w-4 text-red-500" />,
  IN_PROGRESS: <Wrench className="h-4 w-4 text-yellow-600" />,
  RESOLVED: <CheckCircle2 className="h-4 w-4 text-green-600" />,
  CLOSED: <CheckCircle2 className="h-4 w-4 text-gray-500" />,
};

interface RecentIncidentsListProps {
  incidents: IncidentReport[];
}

const RecentIncidentsList: React.FC<RecentIncidentsListProps> = ({ incidents }) => {
  return (
    <div className="space-y-3">
      {incidents.slice(0, 5).map((incident) => (
        <div key={incident.id} className="flex items-center gap-3 p-3 rounded-lg bg-muted/50">
          <div>{statusIcons[incident.status] || <AlertCircle className="h-4 w-4" />}</div>
          <div className="flex-1">
            <div className="font-medium text-sm">{incident.equipment?.name || 'Equipment'}</div>
            <div className="text-xs text-muted-foreground">{incident.incidentDetails || incident.incidentType}</div>
            <div className="text-xs text-muted-foreground mt-1">
              <span className="font-semibold">{incident.project?.name}</span> &middot; {incident.incidentDate}
            </div>
          </div>
          <Badge className={`ml-2 ${statusColors[incident.status] || 'bg-gray-200 text-gray-700'}`}>{incident.status.replace('_', ' ')}</Badge>
        </div>
      ))}
    </div>
  );
};

export default RecentIncidentsList;
