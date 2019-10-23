package cs4800.event;

import java.time.LocalDate;
import java.time.Month;

import javax.persistence.Entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/*
 * This is an implementation of {@link EventInterface} 
 * Event class that will hold all of the
 * information of an event
 * 
 * Time will be saved in a 24 hour format
 */

@Entity
@Document (collection = "test")
public class Event implements EventInterface {

	@Id
	private ObjectId _id; // primary key
	
	//Start date split into its components for easier manipulation
	@Field(value = "start_day")
	private int startDay = 1;
	@Field(value = "start_month")
	private Month startMonth = Month.JANUARY;
	@Field(value = "start_year")
	private int startYear = 2019;
	
	@Field(value = "location")
	private String location = null;
	
	// Start date as a string for easier output
	@Field(value = "start_date")
	private String startDate = null;
	
	//End date split into its components for easier manipulation
	@Field(value = "end_day")
	private int endDay = 1;
	@Field(value = "end_month")
	private Month endMonth = Month.JANUARY;
	@Field(value = "end_year")
	private int endYear = 2019;
	
	//End date as a string for easier output
	@Field(value = "end_date")
	private String endDate = null;
	
	//Start time split into its components for easier manipulation
	@Field(value = "start_hour")
	private int startHour = 0;
	@Field(value = "start_minute")
	private int startMinute = 0;
	@Field(value = "start_second")
	private int startSecond = 0;
	
	//Start time as a string for easier output
	@Field(value = "start_time")
	private String startTime = null;
	
	//End time split into its components for easier manipulation
	@Field(value = "end_hour")
	private int endHour = 0;
	@Field(value = "end_minute")
	private int endMinute = 0;
	@Field(value = "end_second")
	private int endSecond = 0;
	
	//End time as a string for easier output
	@Field(value = "end_time")
	private String endTime = null;
	
	//Name of the event
	@Field(value = "name")
	private String name = null;
	
	
	/*
	 * Constructor so that each new event must have a name
	 */
	public Event(String name) {
		
		this.name = name;
	}
	
	public Event(String name, LocalDate startDate, LocalDate endDate) {
		
		this.name = name;
		
		this.startYear = startDate.getYear();
		this.startMonth = startDate.getMonth();
		this.startDay = startDate.getDayOfMonth();
		
		this.endYear = endDate.getYear();
		this.endMonth = endDate.getMonth();
		this.endDay = startDate.getDayOfMonth();
		
		this.compileStartDate();
		this.compileEndDate();
	}
	
	public Event(String name, LocalDate startDate, LocalDate endDate, String startTime, String endTime, String location) {
		
		this.name = name;
		
		this.startYear = startDate.getYear();
		this.startMonth = startDate.getMonth();
		this.startDay = startDate.getDayOfMonth();
		
		this.endYear = endDate.getYear();
		this.endMonth = endDate.getMonth();
		this.endDay = startDate.getDayOfMonth();
		
		String start[] = startTime.split(":");
		String end[] = endTime.split(":");
		
		this.startHour = Integer.parseInt(start[0]);
		this.startMinute = Integer.parseInt(start[1]);
		this.startSecond = Integer.parseInt(start[2]);
		
		this.endHour = Integer.parseInt(end[0]);
		this.endMinute = Integer.parseInt(end[1]);
		this.endSecond = Integer.parseInt(end[2]);
		
		this.compileStartDate();
		this.compileEndDate();
		this.compileStartTime();
		this.compileEndTime();
		
		this.location = location;
	}
	
	public Event(String name, LocalDate startDate, LocalDate endDate, int[] startTime, int[] endTime, String location) {
		
		this.name = name;
		
		this.startYear = startDate.getYear();
		this.startMonth = startDate.getMonth();
		this.startDay = startDate.getDayOfMonth();
		
		this.endYear = endDate.getYear();
		this.endMonth = endDate.getMonth();
		this.endDay = startDate.getDayOfMonth();

		this.startHour = startTime[0];
		this.startMinute = startTime[1];
		this.startSecond = startTime[2];
		
		this.endHour = endTime[0];
		this.endMinute = endTime[1];
		this.endSecond = endTime[2];
		
		this.compileStartDate();
		this.compileEndDate();
		this.compileStartTime();
		this.compileEndTime();
		
		this.location = location;
	}
	
	@Override
	public ObjectId get_id() {
		
		return _id;
		
	}
	
	@Override
	public void set_id(ObjectId _id) {
		
		this._id = _id;
		
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
	public void setStartDate(LocalDate start) {
		
		this.startDay = start.getDayOfMonth();
		this.startMonth = start.getMonth();
		this.startYear = start.getYear();
		
		if(start.getDayOfMonth() > start.getMonth().length(start.isLeapYear())) {
			System.err.println("Day is out of bounds setting to end of month");
			this.startDay = start.getMonth().length(start.isLeapYear());
		}
		else if(start.getDayOfMonth() < 0 ) {
			System.err.println("Day is out of bounds setting to start of month");
			this.startDay = 1;
		}
		
		this.startDate = this.compileStartDate();
		
	}
	
	@Override
	public void setEndDate(LocalDate end) {
		
		this.endDay = end.getDayOfMonth();
		this.endMonth = end.getMonth();
		this.endYear = end.getYear();
		
		if(end.getDayOfMonth() > end.getMonth().length(end.isLeapYear())) {
			System.err.println("Day is out of bounds setting to end of month");
			this.startDay = end.getMonth().length(end.isLeapYear());
		}
		else if(end.getDayOfMonth() < 0 ) {
			System.err.println("Day is out of bounds setting to start of month");
			this.startDay = 1;
		}
		
		this.endDate = this.compileEndDate();
	}

	@Override
	public void setStartTime(int start[]) {
		
		this.startHour = start[0];
		this.startMinute = start[1];
		this.startSecond = start[2];
		
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
	public void setEndTime(int[] end) {
		
		this.endHour = end[0];
		this.endMinute = end[1];
		this.endSecond = end[2];
		
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

	/*
	 * Get location of event
	 * 
	 * @return event location
	 */
	public String getLocation() {
		// TODO Auto-generated method stub
		return location;
	}
	
	/*
	 * Set location of event
	 * 
	 * @param event location
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	

}
