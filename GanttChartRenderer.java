

import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class GanttChartRenderer extends DefaultTableCellRenderer  {
	
	private GanttChartModel gcmodel;
	
	public GanttChartRenderer(GanttChartModel _gcmodel){
		gcmodel  = _gcmodel;
	}

	 public Component getTableCellRendererComponent(JTable table, Object value, boolean   isSelected, boolean hasFocus, int row, int column) 
	 { 
	     Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); 

	     if (! table.isRowSelected(row))
	     {
	         if( gcmodel.isBlockRendered(row, column) )
	             c.setBackground(new java.awt.Color(0, 0, 255));
	         else
	             c.setBackground(table.getBackground());
	     }

	     return c; 
	 } 
}
