package cs4800.event;

/*
 * This is an implementation of {@link EventInterface} 
 * Event class that will hold all of the
 * information of an event
 */

public class Event implements EventInterface {

	
	//Start date split into its components for easier manipulation
	private int startDay = 0;
	private int startMonth = 0;
	private int startYear = 0;
	
	// Start date as a string for easier output
	private String startDate = null;
	
	//End date split into its components for easier manipulation
	private int endDay = 0;
	private int endMonth = 0;
	private int endYear = 0;
	
	//End date as a string for easier output
	private String endDate = null;
	
	//Start time split into its components for easier manipulation
	private int startHour = 0;
	private int startMinute = 0;
	private int startSecond = 0;
	
	//Start time as a string for easier output
	private String startTime = null;
	
	//End time split into its components for easier manipulation
	private int endHour = 0;
	private int endMinute = 0;
	private int endSecond = 0;
	
	//End time as a string for easier output
	private String endTime = null;
	
	//Name of the event
	private String name = null;
	
	
	/*
	 * Constructor so that each new event must have a name
	 */
	public Event(String name) {
		
		this.name = name;
	}
	
	@Override
	public String getName() {
		
		return name;
	}

	@Override
	public void setName(String name) {
		
		this.name = name;
	}

	@Override
	public void deleteEvent() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int[] getStartDate() {

		int[] date = {startDay, startMonth, startYear};
		
		return date;
	}

	@Override
	public int[] getEndDate() {

		int[] date = {endDay, endMonth, endYear};
		
		return date;
	}
	
	@Override
	public int[] getStartTime() {
		
		int[] time = {startHour, startMinute, startSecond};
		
		return time;
	}


	@Override
	public int[] getEndTime() {

		int[] time = {endHour, endMinute, endSecond};
		
		return time;
	}

	@Override
	public void setStartDate(int day, int month, int year) {
		
		this.startDay = day;
		this.startMonth = month;
		this.startYear = year;
		
		this.startDate = this.compileStartDate();
		
	}
	
	@Override
	public void setEndDate(int day, int month, int year) {
		
		this.endDay = day;
		this.endMonth = month;
		this.endYear = year;
		
		this.endDate = this.compileEndDate();
	}

	@Override
	public void setStartTime(int hour, int min, int sec) {
		
		this.startHour = hour;
		this.startMinute = min;
		this.startSecond = sec;
		
		this.startTime = this.compileStartTime();
	}

	@Override
	public void setEndTime(int hour, int min, int sec) {
		
		this.endHour = hour;
		this.endMinute = min;
		this.endSecond = sec;
		
		this.endTime = this.compileEndTime();
	}
	
	@Override
	public String toString() {
		String DateAndTime = ("Date: " + startDate + "   Time: " + startTime + "\n" +
				"Date: " + endDate + "   Time: " + endTime);
		
		return DateAndTime;
	}
	
	/*
	 * Puts each component of the start date into a string
	 * 
	 * @return start date as a string
	 */
	private String compileStartDate() {
		String startDate = (this.startMonth + "/" + this.startDay + 
				"/" + this.startYear);
		
		return startDate;
	}
	
	/*
	 * Puts each component of the end date into a string
	 * 
	 * @return end date as a string
	 */
	private String compileEndDate() {
		String endDate = (this.endMonth + "/" + this.endDay + 
				"/" + this.endYear);
		
		return endDate;
	}
	
	/*
	 * Puts each component of the start time into a string
	 * 
	 * @return start time as a string
	 */
	private String compileStartTime() {
		String startTime = (this.startHour + ":" + this.startMinute + ":" + this.startSecond);
		
		return startTime;
	}
	
	/*
	 * Puts each component of the end time into a string
	 * 
	 * @return end time as a string
	 */
	private String compileEndTime() {
		String startTime = (this.endHour + ":" + this.endMinute + ":" + this.endSecond);
		
		return startTime;
	}

}
