package cs4800.event;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.UUID;
import java.util.logging.Logger;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

/*
 * This is an implementation of {@link EventInterface}
 * Event class that will hold all of the
 * information of an event
 */
@Getter
@Setter
@Document(collection = "test")
public class Event implements EventInterface {

	private static final Logger log = Logger.getLogger(Event.class.getName());
	
	@Id
	@Field(value = "eventId")
	private UUID eventId; // primary key

	//Name of the event
	@Field(value = "name")
	private String name = null;
	
	//Start date split into its components for easier manipulation
	@Field(value = "startDay")
	private int startDay = 1;
	@Field(value = "startMonth")
	private Month startMonth = null;
	@Field(value = "startYear")
	private int startYear = 0;
	
	@Field(value = "location")
	private String location = null;
	
	// Start date as a string for easier output
	@Field(value = "startDate")
	private LocalDate startDate = null;
	
	//End date split into its components for easier manipulation
	@Field(value = "endDay")
	private int endDay = 1;
	@Field(value = "endMonth")
	private Month endMonth = null;
	@Field(value = "endYear")
	private int endYear = 0;
	
	//End date as a string for easier output
	@Field(value = "endDate")
	private LocalDate endDate = null;
	
	//Start time split into its components for easier manipulation
	@Field(value = "startHour")
	private int startHour = 0;
	@Field(value = "startMinute")
	private int startMinute = 0;
	
	//Start time as a string for easier output
	@Field(value = "startTime")
	private String startTime = null;
	
	//End time split into its components for easier manipulation
	@Field(value = "endHour")
	private int endHour = 0;
	@Field(value = "endMinute")
	private int endMinute = 0;
	
	//End time as a string for easier output
	@Field(value = "endTime")
	private String endTime = null;
	
	@Field(value = "category")
	private String category = null;
	
	/**
	 * No args constructor
	 * 
	 */
	public Event() { 	}
	
	/**
	 * Constructor
	 * 
	 * @param name - name of event
	 */
	public Event(String name) {
		this.name = name;
	}

	/**
	 * Constructor
	 * 
	 * @param name - name of event
	 * @param category - category of the event
	 */
	public Event(String name, String category) {
		this.name = name;
		this.category = category;
	}
	
	/**
	 * Constructor
	 * 
	 * @param name - name of event
	 * @param startDate - start date of event (i.e. March 23, 2020)
	 * @param endDate - end date of event (i.e. November 1, 2019)
	 * @param location - location of event
	 */
	public Event(String name, String startDate, String endDate, String location) {
		
		this.name = name;
		this.eventId = UUID.randomUUID();
		
		DateTimeFormatter formatDate = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
		LocalDate localStartDate = LocalDate.parse(startDate, formatDate);
		LocalDate localEndDate = LocalDate.parse(endDate, formatDate);
		
		this.startYear = localStartDate.getYear();
		this.startMonth = localStartDate.getMonth();
		this.startDay = localStartDate.getDayOfMonth();
		
		this.endYear = localEndDate.getYear();
		this.endMonth = localEndDate.getMonth();
		this.endDay = localEndDate.getDayOfMonth();
		
		this.compileStartDate();
		this.compileEndDate();
		
		this.location = location;
	}
	
	/**
	 * Constructor
	 * 
	 * @param name - name of event
	 * @param startDate - start date of event (i.e. March 23, 2020)
	 * @param endDate - end date of event (i.e. November 1, 2019)
	 * @param location - location of event
	 * @param category - category of the event
	 */
	public Event(String name, String startDate, String endDate, String location, String category) {
		
		this.name = name;
		this.eventId = UUID.randomUUID();
		
		DateTimeFormatter formatDate = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
		LocalDate localStartDate = LocalDate.parse(startDate, formatDate);
		LocalDate localEndDate = LocalDate.parse(endDate, formatDate);
		
		this.startYear = localStartDate.getYear();
		this.startMonth = localStartDate.getMonth();
		this.startDay = localStartDate.getDayOfMonth();
		
		this.endYear = localEndDate.getYear();
		this.endMonth = localEndDate.getMonth();
		this.endDay = localEndDate.getDayOfMonth();
		
		this.compileStartDate();
		this.compileEndDate();
		
		this.location = location;
		
		this.category = category;
	}
	
	/**
	 * Constructor
	 * 
	 * @param name - name of event
	 * @param startDate - start date of event (i.e. March 23, 2020)
	 * @param endDate - end date of event (i.e. November 1, 2019)
	 * @param startTime - start time of event (i.e. 5:00 PM)
	 * @param endTime - end time of event (i.e. 10:30 AM)
	 * @param location - location of event
	 */
	public Event(String name, String startDate, String endDate, String startTime, String endTime, String location) {
		
		this.name = name;
		this.eventId = UUID.randomUUID();
				DateTimeFormatter formatDate = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);

		LocalDate localStartDate = LocalDate.parse(startDate, formatDate);
		LocalDate localEndDate = LocalDate.parse(endDate, formatDate);
		
		this.startYear = localStartDate.getYear();
		this.startMonth = localStartDate.getMonth();
		this.startDay = localStartDate.getDayOfMonth();
		
		this.endYear = localEndDate.getYear();
		this.endMonth = localEndDate.getMonth();
		this.endDay = localEndDate.getDayOfMonth();
		
		DateTimeFormatter formatTime = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
		LocalTime localStartTime = LocalTime.parse(startTime, formatTime);
		LocalTime localEndtime = LocalTime.parse(endTime, formatTime);
		
		this.startHour = localStartTime.getHour();
		this.startMinute = localStartTime.getMinute();
		
		this.endHour = localEndtime.getHour();
		this.endMinute = localEndtime.getMinute();
		
		this.compileStartDate();
		this.compileEndDate();
//		this.compileStartTime();
//		this.compileEndTime();
		
		this.location = location;
	}
	
	/**
	 * Constructor
	 * 
	 * @param name - name of event
	 * @param startDate - start date of event (i.e. March 23, 2020)
	 * @param endDate - end date of event (i.e. November 1, 2019)
	 * @param startTime - start time of event (i.e. 5:00 PM)
	 * @param endTime - end time of event (i.e. 10:30 AM)
	 * @param location - location of event
	 * @param category - category of the event
	 */
	public Event(String name, String startDate, String endDate, String startTime, String endTime, String location, String category) {
		
		this.name = name;
		this.eventId = UUID.randomUUID();
		
		DateTimeFormatter formatDate = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
		LocalDate localStartDate = LocalDate.parse(startDate, formatDate);
		LocalDate localEndDate = LocalDate.parse(endDate, formatDate);
		
		this.startYear = localStartDate.getYear();
		this.startMonth = localStartDate.getMonth();
		this.startDay = localStartDate.getDayOfMonth();
		
		this.endYear = localEndDate.getYear();
		this.endMonth = localEndDate.getMonth();
		this.endDay = localEndDate.getDayOfMonth();
		
		DateTimeFormatter formatTime = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
		LocalTime localStartTime = LocalTime.parse(startTime, formatTime);
		LocalTime localEndtime = LocalTime.parse(endTime, formatTime);
		
		this.startHour = localStartTime.getHour();
		this.startMinute = localStartTime.getMinute();
		
		this.endHour = localEndtime.getHour();
		this.endMinute = localEndtime.getMinute();
		
		this.compileStartDate();
		this.compileEndDate();
//		this.compileStartTime();
//		this.compileEndTime();
		
		this.location = location;
		
		this.category = category;
	}
			
	@Override
	public UUID getEventId() {
		
		return eventId;
		
	}
	
	@Override
	public void setEventId(UUID eventId) {
		
		this.eventId = eventId;
		
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
		
		int[] time = {startHour, startMinute};
		
		return time;
	}

	@Override
	public int[] getEndTime() {

		int[] time = {endHour, endMinute};
		
		return time;
	}

	@Override
	public void setStartDate(String start) {
		
		DateTimeFormatter formatDate = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
		LocalDate localStartDate = LocalDate.parse(start, formatDate);
		this.startDate = localStartDate;
		
		this.startYear = localStartDate.getYear();
		this.startMonth = localStartDate.getMonth();
		this.startDay = localStartDate.getDayOfMonth();
		
//		
//		if(localStartDate.getDayOfMonth() > localStartDate.getMonth().length(localStartDate.isLeapYear())) {
//			log.severe("Day is out of bounds setting to end of month");
//			this.startDay = localStartDate.getMonth().length(localStartDate.isLeapYear());
//		}
//		else if(localStartDate.getDayOfMonth() < 0 ) {
//			log.severe("Day is out of bounds setting to start of month");
//			this.startDay = 1;
//		}
//		
//		this.startDate = this.compileStartDate();
		
	}
	
	@Override
	@JsonIgnore
	public void setEndDate(String end) {
		
		DateTimeFormatter formatDate = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
		LocalDate localEndDate = LocalDate.parse(end, formatDate);
		this.endDate = localEndDate;
		
		this.startYear = localEndDate.getYear();
		this.startMonth = localEndDate.getMonth();
		this.startDay = localEndDate.getDayOfMonth();
		
//		if(localEndDate.getDayOfMonth() > localEndDate.getMonth().length(localEndDate.isLeapYear())) {
//			log.severe("Day is out of bounds setting to end of month");
//			this.startDay = localEndDate.getMonth().length(localEndDate.isLeapYear());
//		}
//		else if(localEndDate.getDayOfMonth() < 0 ) {
//			log.severe("Day is out of bounds setting to start of month");
//			this.startDay = 1;
//		}
//		
//		this.endDate = this.compileEndDate();
	}

	@Override
	public void setStartTime(int start[]) {
		
		this.startHour = start[0];
		this.startMinute = start[1];
		
		if(startHour > 23 ) {
			log.severe("Start hour is too large setting to 23");
			this.startHour = 23;
		}
		else if(startHour < 0) {
			log.severe("Start hour is too small setting to 0");
			this.startHour = 0;
		}
		
		if(startMinute > 59) {
			log.severe("Start minute is too large setting to 59");
			this.startMinute = 59;
		}
		else if(startMinute < 0) {
			log.severe("Start minute is too small setting to 0");
			this.startMinute = 0;
		}
		
//		this.startTime = this.compileStartTime();
	}

	@Override
	public void setEndTime(int[] end) {
		
		this.endHour = end[0];
		this.endMinute = end[1];
		
		if(endHour > 23 ) {
			log.severe("End hour is too large setting to 23");
			this.endHour = 23;
		}
		else if(endHour < 0) {
			log.severe("End hour is too small setting to 0");
			this.endHour = 0;
		}
		
		if(endMinute > 59) {
			log.severe("End minute is too large setting to 59");
			this.endMinute = 59;
		}
		else if(endMinute < 0) {
			log.severe("End minute is too small setting to 0");
			this.endMinute = 0;
		}
		
//		this.endTime = this.compileEndTime();
	}
	
	@Override
	public String DateTimeToString() {
		String DateAndTime = ("Date: " + startDate + "   Time: " + startTime + "\n" +
				"Date: " + endDate + "   Time: " + endTime);
		
		return DateAndTime;
	}

	@Override
	public String getLocation() {
		return location;
	}
	
	@Override
	public void setLocation(String location) {
		this.location = location;
	}
	
	@Override
	public String getCategory() {
		return category;
	}
	
	@Override
	public void setCategory(String category) {
		this.category = category;
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
	
	@Override
	public String toString() {
		return "Event { "
				+ "id=" + eventId + '\''
				+ ", name=" + name + '\''
				+ ", startDay=" + startDay + '\''
				+ ", startMonth=" + startMonth + '\''
				+ ", startYear=" + startYear + '\''
				+ ", location=" + location + '\''
				+ ", endDay=" + endDay + '\''
				+ ", endMonth=" + endMonth + '\''
				+ ", endYear=" + endYear + '\''
				+ ", startHour=" + startHour + '\''
				+ ", startMinute=" + startMinute + '\''
				+ ", endHour=" + endHour + '\''
				+ ", endMinute=" + endMinute + '\''
				+ ", category=" + category + '\''
				+ " }";
	}
	
//	/*
//	 * Puts each component of the start time into a string
//	 * 
//	 * @return start time as a string
//	 */
//	@JsonIgnore
//	private String compileStartTime() {
//		String startTime = (this.startHour + ":" + this.startMinute + ":" + this.startSecond);
//		
//		return startTime;
//	}
//	
//	/*
//	 * Puts each component of the end time into a string
//	 * 
//	 * @return end time as a string
//	 */
//	@JsonIgnore
//	private String compileEndTime() {
//		String startTime = (this.endHour + ":" + this.endMinute + ":" + this.endSecond);
//		
//		return startTime;
//	}
	
}
