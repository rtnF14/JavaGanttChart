# JavaGanttChart
Open source java gantt chart library. 

![alt-text](https://github.com/adipurnama141/JavaGanttChart/blob/master/ganttchart.PNG?raw=true)

## How to use
First, include all of these file to your project (GanttChart.java , GanttChartModel.java, GanttChartRenderer.java) ,
then here is an example code to display your predefined Gantt Chart.

GanttChartModel gcModel = new GanttChartModel();

gcModel.addTask("Project Initialization", 1, 2);

gcModel.addTask("Kickstart Meeting", 3, 1);

GanttChart gc = new GanttChart(gcModel);


Your predefined Gantt Chart is stored inside GanttChartModel class. You can add new task by using addTask method.
addTask takes three arguments, 
  1.  Task Name
  2.  Task Start Time
  3.  Task Duration
  
After this, you can display your GanttChart by constructing a GanttChart class. It takes one argument, that is GanttChartModel (where you stored the definition of Gantt Chart Table)
