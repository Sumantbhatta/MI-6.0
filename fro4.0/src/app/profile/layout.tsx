import { Metadata } from 'next';

export const metadata: Metadata = {
  title: 'Profile',
  description: 'User profile page',
};


export default function ProfileLayout({children}) {
  return (
    <div className="flex-1 space-y-4 p-4 md:p-8 pt-6">
      {children}
    </div>
  );
}
