-- Create indexes for profiles table
CREATE INDEX IF NOT EXISTS idx_profiles_email ON profiles(email);
CREATE INDEX IF NOT EXISTS idx_profiles_role ON profiles(role);
CREATE INDEX IF NOT EXISTS idx_profiles_email_confirmed ON profiles(email_confirmed_at);

-- Create indexes for projects table
CREATE INDEX IF NOT EXISTS idx_projects_status ON projects(status);
CREATE INDEX IF NOT EXISTS idx_projects_created_at ON projects(created_at);
CREATE INDEX IF NOT EXISTS idx_projects_user_id ON projects(user_id);

-- Create indexes for equipment table
CREATE INDEX IF NOT EXISTS idx_equipment_status ON equipment(status);
CREATE INDEX IF NOT EXISTS idx_equipment_category ON equipment(category);
CREATE INDEX IF NOT EXISTS idx_equipment_availability ON equipment(availability);

-- Create indexes for materials table
CREATE INDEX IF NOT EXISTS idx_materials_category ON materials(category);
CREATE INDEX IF NOT EXISTS idx_materials_stock_level ON materials(stock_level);
CREATE INDEX IF NOT EXISTS idx_materials_last_restocked ON materials(last_restocked_at);

-- Create indexes for incidents table
CREATE INDEX IF NOT EXISTS idx_incidents_status ON incidents(status);
CREATE INDEX IF NOT EXISTS idx_incidents_created_at ON incidents(created_at);
CREATE INDEX IF NOT EXISTS idx_incidents_severity ON incidents(severity);

-- Create indexes for overtime table
CREATE INDEX IF NOT EXISTS idx_overtime_user_id ON overtime(user_id);
CREATE INDEX IF NOT EXISTS idx_overtime_date ON overtime(date);
CREATE INDEX IF NOT EXISTS idx_overtime_status ON overtime(status);

-- Create composite indexes for common query patterns
CREATE INDEX IF NOT EXISTS idx_projects_user_status ON projects(user_id, status);
CREATE INDEX IF NOT EXISTS idx_equipment_category_status ON equipment(category, status);
CREATE INDEX IF NOT EXISTS idx_materials_category_stock ON materials(category, stock_level);

-- Create partial indexes for active records
CREATE INDEX IF NOT EXISTS idx_active_projects ON projects(status) WHERE status = 'active';
CREATE INDEX IF NOT EXISTS idx_available_equipment ON equipment(availability) WHERE availability = true;
CREATE INDEX IF NOT EXISTS idx_low_stock_materials ON materials(stock_level) WHERE stock_level < 10;

-- Create indexes for full-text search
CREATE INDEX IF NOT EXISTS idx_projects_search ON projects USING GIN (to_tsvector('english', name || ' ' || description));
CREATE INDEX IF NOT EXISTS idx_equipment_search ON equipment USING GIN (to_tsvector('english', name || ' ' || description));
CREATE INDEX IF NOT EXISTS idx_materials_search ON materials USING GIN (to_tsvector('english', name || ' ' || description));

-- Create indexes for foreign key relationships
CREATE INDEX IF NOT EXISTS idx_project_equipment_project_id ON project_equipment(project_id);
CREATE INDEX IF NOT EXISTS idx_project_materials_project_id ON project_materials(project_id);
CREATE INDEX IF NOT EXISTS idx_incident_equipment_incident_id ON incident_equipment(incident_id);

-- Create indexes for audit trails
CREATE INDEX IF NOT EXISTS idx_audit_logs_entity_type ON audit_logs(entity_type);
CREATE INDEX IF NOT EXISTS idx_audit_logs_created_at ON audit_logs(created_at);
CREATE INDEX IF NOT EXISTS idx_audit_logs_user_id ON audit_logs(user_id);

-- Create indexes for notifications
CREATE INDEX IF NOT EXISTS idx_notifications_user_id ON notifications(user_id);
CREATE INDEX IF NOT EXISTS idx_notifications_read_status ON notifications(is_read);
CREATE INDEX IF NOT EXISTS idx_notifications_created_at ON notifications(created_at);

-- Add comments for documentation
COMMENT ON INDEX idx_profiles_email IS 'Index for quick email lookups during authentication';
COMMENT ON INDEX idx_projects_status IS 'Index for filtering projects by status';
COMMENT ON INDEX idx_equipment_category IS 'Index for filtering equipment by category';
COMMENT ON INDEX idx_materials_stock_level IS 'Index for monitoring stock levels';
COMMENT ON INDEX idx_incidents_severity IS 'Index for prioritizing incident response';
COMMENT ON INDEX idx_overtime_user_date IS 'Index for tracking user overtime'; 