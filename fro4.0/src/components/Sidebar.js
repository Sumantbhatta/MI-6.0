'use client';

import { useState, useEffect } from 'react';
import Link from 'next/link';
import { usePathname } from 'next/navigation';
import { cn } from '@/lib/utils';
import { Button } from '@/components/ui/button';
import { ScrollArea } from '@/components/ui/scroll-area';
import { Sheet, SheetContent, SheetTrigger } from '@/components/ui/sheet';

import { Separator } from '@/components/ui/separator';
import { 
    Menu, 
    ChevronLeft, 
    ChevronRight,
    LayoutDashboard,
    Briefcase,
    Wrench,
    Clock,
    Cog,
    FileText,
    FolderTree,
    Tag,
    Boxes,
    Building2,
    Users,
    UserSquare,
    Anchor,
    Clock4,
    Wallet,
    Package,
    ShoppingCart,
    ClipboardList
} from 'lucide-react';

const navItems = [
  { name: 'Projects', path: '/projects', icon: <FolderTree className="w-4 h-4" /> },
  { name: 'Financials', path: '/financials', icon: <Wallet className="w-4 h-4" /> },
  { name: 'Breakdown Incidents', path: '/incidents', icon: <FileText className="w-4 h-4" /> },
  {
    name: 'Equipment',
    icon: <Wrench className="w-4 h-4" />,
    children: [
      { name: 'Equipment', path: '/equipment', icon: <Wrench className="w-4 h-4" /> },
      { name: 'Utilization', path: '/equipment/utilization', icon: <Clock className="w-4 h-4" /> },
      { name: 'Categories', path: '/equipment/categories', icon: <Tag className="w-4 h-4" /> },
      { name: 'Mast Anchorage', path: '/equipment/mast-anchorage', icon: <Anchor className="w-4 h-4" /> },
    ],
  },
  { name: 'Makes', path: '/makes', icon: <Tag className="w-4 h-4" /> },
  { name: 'Materials Consumption', path: '/materials-consumption', icon: <ShoppingCart className="w-4 h-4" /> },
  { name: 'Models', path: '/models', icon: <Boxes className="w-4 h-4" /> },
  { name: 'Items', path: '/items', icon: <Package className="w-4 h-4" /> },
  {
    name: 'Maintenance',
    icon: <Cog className="w-4 h-4" />,
    children: [
      { name: 'Maintenance', path: '/maintenance', icon: <Cog className="w-4 h-4" /> },
      { name: 'Part Used', path: '/maintenance/parts-used', icon: <FileText className="w-4 h-4" /> },
      { name: 'Reading', path: '/maintenance/readings', icon: <FileText className="w-4 h-4" /> },
    ],
  },
  { name: 'Employees', path: '/employees', icon: <Users className="w-4 h-4" /> },
  { name: 'Employees Assignment', path: '/assignments', icon: <UserSquare className="w-4 h-4" /> },
  { name: 'Organization', path: '/organization', icon: <Building2 className="w-4 h-4" /> },
  { name: 'Stock Statement', path: '/stock-statement', icon: <ClipboardList className="w-4 h-4" /> },
];

function SidebarGroup({ item, isOpen, isCollapsed, currentPath, toggleGroup }) {
  const parentMainRoute = item.children[0]?.path;
  const isParentActive = currentPath === parentMainRoute;
  
  return (
    <div className="mb-1">
      <div
        className={cn(
          "flex items-center gap-3 rounded-lg px-3 py-2 text-sm cursor-pointer select-none transition-all duration-300 group/item",
          isCollapsed && "justify-center px-0",
          isParentActive
            ? "bg-gradient-to-r from-blue-500/10 to-indigo-500/10 text-blue-700 shadow-sm"
            : "text-gray-600 hover:bg-gradient-to-r hover:from-blue-500/5 hover:to-indigo-500/5 hover:text-blue-600"
        )}
        onClick={toggleGroup}
      >
        <div className={cn(
          "p-1.5 rounded-md transition-all duration-300 shadow-sm",
          isParentActive
            ? "bg-gradient-to-br from-blue-500 to-indigo-600 text-white shadow-blue-500/20"
            : "bg-blue-50 text-blue-600 shadow-blue-100 group-hover/item:bg-gradient-to-br group-hover/item:from-blue-500 group-hover/item:to-indigo-600 group-hover/item:text-white"
        )}>
          {item.icon}
        </div>
        {!isCollapsed && <span>{item.name}</span>}
        {!isCollapsed && (
          <ChevronRight
            className={cn(
              "ml-auto h-4 w-4 transition-transform duration-300",
              isOpen ? "rotate-90" : "rotate-0"
            )}
          />
        )}
      </div>
      {!isCollapsed && isOpen && (
        <div className="ml-7 mt-1 space-y-1">
          {item.children.map((child) => {
            const isChildActive = currentPath === child.path;
            return (
              <Link
                key={child.name}
                href={child.path}
                className={cn(
                  "flex items-center gap-2 rounded-lg px-2 py-1 text-sm transition-all duration-300 group/item",
                  isChildActive
                    ? "bg-gradient-to-r from-blue-500/10 to-indigo-500/10 text-blue-700 shadow-sm"
                    : "text-gray-600 hover:bg-gradient-to-r hover:from-blue-500/5 hover:to-indigo-500/5 hover:text-blue-600"
                )}
              >
                <div className={cn(
                  "p-1 rounded-md transition-all duration-300 shadow-sm",
                  isChildActive
                    ? "bg-gradient-to-br from-blue-500 to-indigo-600 text-white shadow-blue-500/20"
                    : "bg-blue-50 text-blue-600 shadow-blue-100 group-hover/item:bg-gradient-to-br group-hover/item:from-blue-500 group-hover/item:to-indigo-600 group-hover/item:text-white"
                )}>
                  {child.icon}
                </div>
                {child.name}
              </Link>
            );
          })}
        </div>
      )}
    </div>
  );
}

export default function Sidebar() {
  const [isCollapsed, setIsCollapsed] = useState(false);
  const [isMobileOpen, setIsMobileOpen] = useState(false);
  const pathname = usePathname();

  // Collapse sidebar on mobile
  useEffect(() => {
    const handleResize = () => {
      if (window.innerWidth < 1024) {
        setIsCollapsed(true);
      }
    };
    handleResize();
    window.addEventListener('resize', handleResize);
    return () => window.removeEventListener('resize', handleResize);
  }, []);

  const toggleSidebar = () => setIsCollapsed((c) => !c);

  return (
    <>
      {/* Mobile Sidebar Trigger */}
      <Button
        variant="ghost"
        className="lg:hidden fixed top-4 left-4 z-40 px-2 py-2"
        onClick={() => setIsMobileOpen(true)}
      >
        <Menu className="h-6 w-6" />
      </Button>

      {/* Mobile Sidebar */}
      <Sheet open={isMobileOpen} onOpenChange={setIsMobileOpen}>
        <SheetContent side="left" className="p-0 w-72">
          <SidebarContent isCollapsed={false} currentPath={pathname} />
        </SheetContent>
      </Sheet>

      {/* Desktop Sidebar */}
      <div
        className={cn(
          "hidden lg:block border-r bg-background border-border/50 transition-all h-[calc(100vh-3rem)] fixed left-0 z-30",
          isCollapsed ? "w-20" : "w-72"
        )}
      >
        <SidebarContent isCollapsed={isCollapsed} currentPath={pathname} />
        {/* Toggle Button */}
        <Button
          variant="ghost"
          size="icon"
          className="absolute top-4 -right-4 h-8 w-8 rounded-full border shadow-md bg-background z-50"
          onClick={toggleSidebar}
        >
          {isCollapsed ? <ChevronRight className="h-4 w-4" /> : <ChevronLeft className="h-4 w-4" />}
        </Button>
      </div>
      {/* Spacer div to push content over */}
      <div
        className={cn(
          "hidden lg:block transition-all flex-none",
          isCollapsed ? "w-20" : "w-72"
        )}
      />
    </>
  );
}

function SidebarContent({ isCollapsed, currentPath }) {
  const [openGroups, setOpenGroups] = useState({});

  const toggleGroup = (groupName) => {
    setOpenGroups(prev => ({
      ...prev,
      [groupName]: !prev[groupName]
    }));
  };

  return (
    <div className={cn(
      "flex flex-col h-full relative overflow-hidden",
      "bg-gradient-to-br from-slate-50 via-white to-blue-50/30"
    )}>
      {/* Decorative Background Elements */}
      <div className="absolute inset-0 overflow-hidden pointer-events-none">
        <div className="absolute -top-24 -right-24 w-48 h-48 bg-blue-200/20 rounded-full blur-3xl animate-pulse" />
        <div className="absolute top-1/2 -right-12 w-24 h-24 bg-indigo-200/20 rounded-full blur-2xl animate-pulse" style={{ animationDelay: '1s' }} />
        <div className="absolute -bottom-12 -right-12 w-32 h-32 bg-purple-200/20 rounded-full blur-2xl animate-pulse" style={{ animationDelay: '2s' }} />
      </div>

      {/* Logo Section with Enhanced Design */}
      <Link
        href="/dashboard"
        className={cn(
          "flex h-16 items-center border-b border-blue-100/50 px-4 transition-all duration-300 cursor-pointer group relative overflow-hidden",
          isCollapsed ? "justify-center" : "gap-2",
          currentPath === "/dashboard" ? "bg-gradient-to-r from-blue-500/10 to-indigo-500/10" : "hover:bg-gradient-to-r hover:from-blue-500/5 hover:to-indigo-500/5"
        )}
        aria-label="Go to Dashboard"
      >
        <div className="relative z-10 flex items-center gap-2">
          <div className={cn(
            "p-2 rounded-lg transition-all duration-300 shadow-lg",
            currentPath === "/dashboard" 
              ? "bg-gradient-to-br from-blue-500 to-indigo-600 shadow-blue-500/20" 
              : "bg-gradient-to-br from-blue-400 to-indigo-500 shadow-blue-400/20 group-hover:from-blue-500 group-hover:to-indigo-600"
          )}>
            <LayoutDashboard className={cn(
              "h-5 w-5 transition-all duration-300",
              "text-white"
            )}/>
          </div>
          {!isCollapsed && (
            <span className="text-lg font-semibold bg-gradient-to-r from-blue-600 to-indigo-600 bg-clip-text text-transparent">
              Dashboard
            </span>
          )}
        </div>
      </Link>

      {/* Navigation Items with Enhanced Design */}
      <ScrollArea className="flex-1 px-3 py-4">
        <div className="space-y-1">
          {navItems.map((item) => {
            if (item.children) {
              return (
                <SidebarGroup
                  key={item.name}
                  item={item}
                  isCollapsed={isCollapsed}
                  currentPath={currentPath}
                  isOpen={openGroups[item.name]}
                  toggleGroup={() => toggleGroup(item.name)}
                />
              );
            }
            const isActive = currentPath === item.path;
            return (
              <Link
                key={item.name}
                href={item.path}
                className={cn(
                  "flex items-center gap-3 rounded-lg px-3 py-2 text-sm transition-all duration-300 group/item",
                  isActive
                    ? "bg-gradient-to-r from-blue-500/10 to-indigo-500/10 text-blue-700 shadow-sm"
                    : "text-gray-600 hover:bg-gradient-to-r hover:from-blue-500/5 hover:to-indigo-500/5 hover:text-blue-600"
                )}
              >
                <div className={cn(
                  "p-1.5 rounded-md transition-all duration-300 shadow-sm",
                  isActive
                    ? "bg-gradient-to-br from-blue-500 to-indigo-600 text-white shadow-blue-500/20"
                    : "bg-blue-50 text-blue-600 shadow-blue-100 group-hover/item:bg-gradient-to-br group-hover/item:from-blue-500 group-hover/item:to-indigo-600 group-hover/item:text-white"
                )}>
                  {item.icon}
                </div>
                {!isCollapsed && <span>{item.name}</span>}
              </Link>
            );
          })}
        </div>
      </ScrollArea>

      {/* Bottom Decoration */}
      <div className="p-4 border-t border-blue-100/50">
        <div className="h-1 w-full bg-[#ffbd2b] rounded-full animate-pulse" />
      </div>
    </div>
  );
}
