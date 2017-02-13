import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import org.compiere.util.CLogger;
import org.compiere.util.DB;

public class GanttChartModel {
	private List<String> tasks;
	private List<Integer> start;
	private List<Integer> duration;
	private int nTask;
	private int endTime;
	
	public GanttChartModel() {
		tasks = new ArrayList<>();
		start = new ArrayList<>();
		duration  = new ArrayList<>();
		nTask = 0;
		endTime = 0;
	}
	
	public GanttChartModel(String query) {
		tasks = new ArrayList<>();
		start = new ArrayList<>();
		duration  = new ArrayList<>();
		nTask = 0;
		endTime = 0;
		
		try {
			PreparedStatement pstmt = DB.prepareStatement(query, null);
			ResultSet rs = pstmt.executeQuery();

			// Iterate over the query result
	        while(rs.next()) {
	        	
	        	String ActivityName = rs.getString("name");
	        	int StartTime = rs.getInt("start");
	        	int Duration = rs.getInt("taskduration");
	        	
	        	addTask(ActivityName, StartTime, Duration);
	        	
	        }
			
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			CLogger.getCLogger(getClass()).log(Level.SEVERE, "Query Error");
		}
		
	}
	
	public int getEndTime(){
		return endTime;
	}
	
	public String[] getColumnNames() {
		List<String> listColumn = new ArrayList<>();
		listColumn.add("Task List");
		for( int i = 1  ; i <= endTime ; i++){
			listColumn.add(String.valueOf(i));
		}
		return listColumn.toArray(new String[0]);
	}
	
	public Object[][] getData() {
		
		Object[][] dataObject = new Object[nTask][endTime+1];
		
		//pertama baris
		//kedua kolom
		
		for (int i = 0 ; i<= nTask - 1 ; i++) {
			List<String> temp = new ArrayList<>();
			temp.add(tasks.get(i));
			for (int j = 1 ; j <= endTime ; j++){
				temp.add(null);
			}
			dataObject[i] = temp.toArray(new String[0]);
		}
		
		return dataObject;
		
	}
	
	public void addTask(String _task, int _start, int _duration ){
		int taskEndTime = _start + _duration -1;
		if (taskEndTime > endTime) {
			endTime = taskEndTime;
		}
		nTask++;
		tasks.add(_task);
		start.add(new Integer(_start));
		duration.add(new Integer(_duration));
		
		
	}
	
	public boolean isBlockRendered(int taskID, int timeID){
		int startTask = start.get(taskID);
		int endTask = startTask + duration.get(taskID) - 1;
		if ((timeID >= startTask) && (timeID <= endTask)){
			return true;
		}
		else {
			return false;
		}
	}

}
