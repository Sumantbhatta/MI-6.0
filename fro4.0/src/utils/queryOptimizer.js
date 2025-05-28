import { supabase } from '@/lib/supabase';

export const queryOptimizer = {
  // Optimized profile queries
  async getProfileByEmail(email) {
    const { data, error } = await supabase
      .from('profiles')
      .select('*')
      .eq('email', email)
      .single();
    return { data, error };
  },

  // Optimized project queries
  async getActiveProjects(userId) {
    const { data, error } = await supabase
      .from('projects')
      .select('*')
      .eq('user_id', userId)
      .eq('status', 'active')
      .order('created_at', { ascending: false });
    return { data, error };
  },

  // Optimized equipment queries
  async getAvailableEquipment(category) {
    const { data, error } = await supabase
      .from('equipment')
      .select('*')
      .eq('category', category)
      .eq('availability', true)
      .order('name');
    return { data, error };
  },

  // Optimized materials queries
  async getLowStockMaterials() {
    const { data, error } = await supabase
      .from('materials')
      .select('*')
      .lt('stock_level', 10)
      .order('stock_level');
    return { data, error };
  },

  // Optimized search queries
  async searchProjects(query) {
    const { data, error } = await supabase
      .from('projects')
      .select('*')
      .textSearch('name', query)
      .order('created_at', { ascending: false });
    return { data, error };
  },

  // Optimized incident queries
  async getRecentIncidents(limit = 10) {
    const { data, error } = await supabase
      .from('incidents')
      .select('*')
      .order('created_at', { ascending: false })
      .limit(limit);
    return { data, error };
  },

  // Optimized overtime queries
  async getUserOvertime(userId, startDate, endDate) {
    const { data, error } = await supabase
      .from('overtime')
      .select('*')
      .eq('user_id', userId)
      .gte('date', startDate)
      .lte('date', endDate)
      .order('date');
    return { data, error };
  },

  // Optimized audit log queries
  async getAuditLogs(entityType, entityId) {
    const { data, error } = await supabase
      .from('audit_logs')
      .select('*')
      .eq('entity_type', entityType)
      .eq('entity_id', entityId)
      .order('created_at', { ascending: false });
    return { data, error };
  },

  // Optimized notification queries
  async getUnreadNotifications(userId) {
    const { data, error } = await supabase
      .from('notifications')
      .select('*')
      .eq('user_id', userId)
      .eq('is_read', false)
      .order('created_at', { ascending: false });
    return { data, error };
  },

  // Batch operations
  async batchUpdateEquipmentStatus(equipmentIds, status) {
    const { data, error } = await supabase
      .from('equipment')
      .update({ status })
      .in('id', equipmentIds);
    return { data, error };
  },

  // Optimized relationship queries
  async getProjectEquipment(projectId) {
    const { data, error } = await supabase
      .from('project_equipment')
      .select(`
        *,
        equipment:equipment_id (*)
      `)
      .eq('project_id', projectId);
    return { data, error };
  }
};

// Usage example:
/*
import { queryOptimizer } from '@/utils/queryOptimizer';

// Get active projects
const { data: projects, error } = await queryOptimizer.getActiveProjects(userId);

// Search for equipment
const { data: equipment } = await queryOptimizer.getAvailableEquipment('construction');

// Get low stock materials
const { data: lowStock } = await queryOptimizer.getLowStockMaterials();
*/ 