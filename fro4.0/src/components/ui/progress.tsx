import * as React from "react";

interface ProgressProps extends React.HTMLAttributes<HTMLDivElement> {
  value: number;
  max?: number;
  className?: string;
}

const Progress = React.forwardRef<HTMLDivElement, ProgressProps>(
  ({ value, max = 100, className = "" }, ref) => {
    return (
      <div
        ref={ref}
        className={`relative w-full h-2 rounded-full bg-gray-200 overflow-hidden ${className}`}
        role="progressbar"
        aria-valuenow={value}
        aria-valuemax={max}
        aria-valuemin={0}
      >
        <div
          className="absolute left-0 top-0 h-full bg-blue-500 transition-all"
          style={{ width: `${Math.min(Math.max(value, 0), max) / max * 100}%` }}
        />
      </div>
    );
  }
);
Progress.displayName = "Progress";

export { Progress };
