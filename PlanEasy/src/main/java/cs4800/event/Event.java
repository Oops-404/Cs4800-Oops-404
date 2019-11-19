package cs4800.event;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.UUID;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonFormat;

/*
 * This is an implementation of {@link EventInterface}
 * Event class that will hold all of the
 * information of an event
 */
@Document(collection = "event")
public class Event implements EventInterface {
	
	@Id
	@Field(value = "eventId")
	private UUID eventId = UUID.randomUUID(); // primary key
	
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
	@JsonFormat(pattern = "EEEE, MMM dd, yyyy")
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
	@JsonFormat(pattern = "EEEE, MMM dd, yyyy")

	private LocalDate endDate = null;
	
	//Start time split into its components for easier manipulation
	@Field(value = "startHour")
	private int startHour = 0;
	@Field(value = "startMinute")
	private int startMinute = 0;
	
	//Start time as a string for easier output
	@Field(value = "startTime")
	@JsonFormat(pattern = "h:mm a")
	private LocalTime startTime = null;
	
	//End time split into its components for easier manipulation
	@Field(value = "endHour")
	private int endHour = 0;
	@Field(value = "endMinute")
	private int endMinute = 0;
	
	//End time as a string for easier output
	@Field(value = "endTime")
	@JsonFormat(pattern = "h:mm a")
	private LocalTime endTime = null;
	
	@Field(value = "category")
	private String category = null;
	
	@Field(value = "description")
	private String description = null;
	
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
	 * @param startDate - start date of event (i.e. March 23, 2020)
	 * @param endDate - end date of event (i.e. November 1, 2019)
	 * @param location - location of event
	 */
	public Event(String name, String startDate, String endDate, String location) {
		
		this.name = name;
		
		DateTimeFormatter formatDate = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
		LocalDate localStartDate = LocalDate.parse(startDate, formatDate);
		LocalDate localEndDate = LocalDate.parse(endDate, formatDate);
		
		this.startDate = localStartDate;
		this.startYear = localStartDate.getYear();
		this.startMonth = localStartDate.getMonth();
		this.startDay = localStartDate.getDayOfMonth();
		
		this.endDate = localEndDate;
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
	 */
	public Event(String name, String startDate, String endDate, String location, String description) {
		
		this.name = name;
		
		DateTimeFormatter formatDate = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
		LocalDate localStartDate = LocalDate.parse(startDate, formatDate);
		LocalDate localEndDate = LocalDate.parse(endDate, formatDate);
		
		this.startDate = localStartDate;
		this.startYear = localStartDate.getYear();
		this.startMonth = localStartDate.getMonth();
		this.startDay = localStartDate.getDayOfMonth();
		
		this.endDate = localEndDate;
		this.endYear = localEndDate.getYear();
		this.endMonth = localEndDate.getMonth();
		this.endDay = localEndDate.getDayOfMonth();
		
		this.compileStartDate();
		this.compileEndDate();
		
		this.location = location;
		
		this.description = description;
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
	public Event(String name, String startDate, String endDate, String location, String category, String description) {
		
		this.name = name;
		
		DateTimeFormatter formatDate = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
		LocalDate localStartDate = LocalDate.parse(startDate, formatDate);
		LocalDate localEndDate = LocalDate.parse(endDate, formatDate);
		
		this.startDate = localStartDate;
		this.startYear = localStartDate.getYear();
		this.startMonth = localStartDate.getMonth();
		this.startDay = localStartDate.getDayOfMonth();
		
		this.endDate = localEndDate;
		this.endYear = localEndDate.getYear();
		this.endMonth = localEndDate.getMonth();
		this.endDay = localEndDate.getDayOfMonth();
		
		this.location = location;
		
		this.category = category;
		
		this.description = description;
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
		
		DateTimeFormatter formatDate = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
		LocalDate localStartDate = LocalDate.parse(startDate, formatDate);
		LocalDate localEndDate = LocalDate.parse(endDate, formatDate);
		
		this.startDate = localStartDate;
		this.startYear = localStartDate.getYear();
		this.startMonth = localStartDate.getMonth();
		this.startDay = localStartDate.getDayOfMonth();
		
		this.endDate = localEndDate;
		this.endYear = localEndDate.getYear();
		this.endMonth = localEndDate.getMonth();
		this.endDay = localEndDate.getDayOfMonth();
		
		DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("h:mm a");
		LocalTime localStartTime = LocalTime.parse(startTime, formatTime);
		LocalTime localEndTime = LocalTime.parse(endTime, formatTime);
		
		this.startTime = localStartTime;
		this.startHour = localStartTime.getHour();
		this.startMinute = localStartTime.getMinute();
		
		this.endTime = localEndTime;
		this.endHour = localEndTime.getHour();
		this.endMinute = localEndTime.getMinute();

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
	 * @param category - category of the event
	 */
	public Event(String name, String startDate, String endDate, String startTime, String endTime, String location, String category, String description) {
		
		this.name = name;
		
		DateTimeFormatter formatDate = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
		LocalDate localStartDate = LocalDate.parse(startDate, formatDate);
		LocalDate localEndDate = LocalDate.parse(endDate, formatDate);
		
		this.startDate = localStartDate;
		this.startYear = localStartDate.getYear();
		this.startMonth = localStartDate.getMonth();
		this.startDay = localStartDate.getDayOfMonth();
		
		this.endDate = localEndDate;
		this.endYear = localEndDate.getYear();
		this.endMonth = localEndDate.getMonth();
		this.endDay = localEndDate.getDayOfMonth();
		
		DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("h:mm a");
		LocalTime localStartTime = LocalTime.parse(startTime, formatTime);
		LocalTime localEndTime = LocalTime.parse(endTime, formatTime);
		
		this.startTime = localStartTime;
		this.startHour = localStartTime.getHour();
		this.startMinute = localStartTime.getMinute();
		
		this.endTime = localEndTime;
		this.endHour = localEndTime.getHour();
		this.endMinute = localEndTime.getMinute();

		this.location = location;
		
		this.category = category;
		
		this.description = description;
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
	public void setStartTime(String start) {
		
		DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("h:mm a");
		LocalTime localStartTime = LocalTime.parse(start, formatTime);
		this.startTime = localStartTime;
		this.startHour = localStartTime.getHour();
		this.startMinute = localStartTime.getMinute();
	}

	@Override
	public LocalTime getStartTime() {
		return startTime;
	}

	@Override
	public LocalTime getEndTime() {
		return endTime;
	}	
	
	@Override
	public void setEndTime(String end) {
		
		DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("h:mm a");
		LocalTime localEndTime = LocalTime.parse(end, formatTime);
		this.endTime = localEndTime;
		this.endHour = localEndTime.getHour();
		this.endMinute = localEndTime.getMinute();
	}
	
	@Override
	public LocalDate getStartDate() {
		return startDate;
	}
	
	@Override
	public void setStartDate(String start) {
		
		DateTimeFormatter formatDate = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
		LocalDate localStartDate = LocalDate.parse(start, formatDate);
		this.startDate = localStartDate;
		
		this.startYear = localStartDate.getYear();
		this.startMonth = localStartDate.getMonth();
		this.startDay = localStartDate.getDayOfMonth();
		
	}
	
	@Override
	public LocalDate getEndDate() {
		return endDate;
	}
	
	@Override
	public void setEndDate(String end) {
		
		DateTimeFormatter formatDate = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
		LocalDate localEndDate = LocalDate.parse(end, formatDate);
		this.endDate = localEndDate;
		
		this.endYear = localEndDate.getYear();
		this.endMonth = localEndDate.getMonth();
		this.endDay = localEndDate.getDayOfMonth();

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
	
	@Override
	public String getDescription() {
		return description;
	}
	
	@Override
	public void setDescription(String description) {
		this.description = description;
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
}
