package cs4800.event;

import java.time.LocalDate;
import java.time.Month;

/*
 * This is an implementation of {@link EventInterface} 
 * Event class that will hold all of the
 * information of an event
 * 
 * Time will be saved in a 24 hour format
 */

public class Event implements EventInterface {

	
	//Start date split into its components for easier manipulation
	private int startDay = 1;
	private Month startMonth = Month.JANUARY;
	private int startYear = 2019;
	
	// Start date as a string for easier output
	private String startDate = null;
	
	//End date split into its components for easier manipulation
	private int endDay = 1;
	private Month endMonth = Month.JANUARY;
	private int endYear = 2019;
	
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
	public LocalDate getStartDate() {

		LocalDate date = LocalDate.of(startYear, startMonth, startDay);
		
		return date;
	}

	@Override
	public LocalDate getEndDate() {

		LocalDate date = LocalDate.of(endDay, endMonth, endYear);
		
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
	public void setStartDate(int day, Month month, int year) {
		
		this.startDay = day;
		this.startMonth = month;
		this.startYear = year;
		
		if(day > month.length(LocalDate.of(startYear, month, startDay).isLeapYear())) {
			System.err.println("Day is out of bounds setting to end of month");
			this.startDay = month.length(LocalDate.of(startDay, month.getValue(), startYear).isLeapYear());
		}
		else if(day < 0 ) {
			System.err.println("Day is out of bounds setting to start of month");
			this.startDay = 1;
		}
		
		this.startDate = this.compileStartDate();
		
	}
	
	@Override
	public void setEndDate(int day, Month month, int year) {
		
		this.endDay = day;
		this.endMonth = month;
		this.endYear = year;
		
		if(day > month.length(LocalDate.of(startYear, month.getValue(), startDay).isLeapYear())) {
			System.err.println("Day is out of bounds setting to end of month");
			this.startDay = month.length(LocalDate.of(startDay, month.getValue(), startYear).isLeapYear());
		}
		else if(day < 0 ) {
			System.err.println("Day is out of bounds setting to start of month");
			this.startDay = 1;
		}
		
		this.endDate = this.compileEndDate();
	}

	@Override
	public void setStartTime(int hour, int min, int sec) {
		
		this.startHour = hour;
		this.startMinute = min;
		this.startSecond = sec;
		
		if(startHour > 23 ) {
			System.err.println("Start hour is too large setting to 23");
			this.startHour = 23;
		}
		else if(startHour < 0) {
			System.err.println("Start hour is too small setting to 0");
			this.startHour = 0;
		}
		
		if(startMinute > 59) {
			System.err.println("Start minute is too large setting to 59");
			this.startMinute = 59;
		}
		else if(startMinute < 0) {
			System.err.println("Start minute is too small setting to 0");
			this.startMinute = 0;
		}
		
		if(startSecond > 59) {
			System.err.println("Start second is too large setting to 59");
			this.startSecond = 59;
		}
		else if(startSecond < 0) {
			System.err.println("Start second is too small setting to 0");
			this.startSecond = 0;
		}
		
		this.startTime = this.compileStartTime();
	}

	@Override
	public void setEndTime(int hour, int min, int sec) {
		
		this.endHour = hour;
		this.endMinute = min;
		this.endSecond = sec;
		
		if(endHour > 23 ) {
			System.err.println("End hour is too large setting to 23");
			this.endHour = 23;
		}
		else if(endHour < 0) {
			System.err.println("End hour is too small setting to 0");
			this.endHour = 0;
		}
		
		if(endMinute > 59) {
			System.err.println("End minute is too large setting to 59");
			this.endMinute = 59;
		}
		else if(endMinute < 0) {
			System.err.println("End minute is too small setting to 0");
			this.endMinute = 0;
		}
		
		if(endSecond > 59) {
			System.err.println("End second is too large setting to 59");
			this.endSecond = 59;
		}
		else if(endSecond < 0) {
			System.err.println("End second is too small setting to 0");
			this.endSecond = 0;
		}
		
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
		String startDate = (this.startMonth.getValue() + "/" + this.startDay + 
				"/" + this.startYear);
		
		return startDate;
	}
	
	/*
	 * Puts each component of the end date into a string
	 * 
	 * @return end date as a string
	 */
	private String compileEndDate() {
		String endDate = (this.endMonth.getValue() + "/" + this.endDay + 
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
