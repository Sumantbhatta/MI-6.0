import React from 'react';

interface MaintenanceScheduleListProps {
  maintenance: Array<{
    id: number;
    equipment?: { name?: string };
    typeOfMaintenance?: string;
    date?: string;
    assignedTo?: string;
    status?: string;
    dueDate?: string;
  }>;
}

const MaintenanceScheduleList: React.FC<MaintenanceScheduleListProps> = ({ maintenance }) => {
  return (
    <div className="space-y-4">
      <h2 className="text-xl font-bold mb-2">Maintenance Schedule</h2>
      <div className="text-muted-foreground mb-4">Upcoming maintenance tasks</div>
      {maintenance.length === 0 ? (
        <div className="text-gray-400">No upcoming maintenance</div>
      ) : (
        <div className="space-y-3">
          {maintenance.map((task) => (
            <div key={task.id} className="flex flex-col gap-1 p-3 rounded-lg bg-muted/50 border">
              <div className="flex items-center gap-2">
                <span className="font-semibold text-base">{task.equipment?.name || 'Equipment'}</span>
                <span className="text-xs px-2 py-0.5 rounded bg-blue-100 text-blue-700 ml-auto">{task.status || 'Scheduled'}</span>
              </div>
              <div className="flex gap-2 text-xs text-muted-foreground">
                <span>{task.typeOfMaintenance || 'Preventive'}</span>
                <span>Due: {task.dueDate || task.date}</span>
                {task.assignedTo && <span>Assigned to: {task.assignedTo}</span>}
              </div>
            </div>
          ))}
        </div>
      )}
    </div>
  );
};

export default MaintenanceScheduleList;
