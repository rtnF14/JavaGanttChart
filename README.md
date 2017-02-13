# JavaGanttChart
Open source java gantt chart library. 

## How to use
Here is an example how to use 

GanttChartModel gcModel = new GanttChartModel();

gcModel.addTask("Inisialisasi Project", 1, 2);

gcModel.addTask("Kickstart Meeting", 3, 1);

GanttChart gc = new GanttChart(gcModel);


addTask takes three arguments, 
  1.  Task Name
  2.  Task Start Time
  3.  Task Duration
