package cs4800.event;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public interface EventInterface {
	
	/**
	 * Set unique event id
	 * 
	 * @param eventId - id of event
	 */
	void setEventId(UUID eventId);
	
	/**
	 * Get unique event id
	 * 
	 * @return id of event
	 */
	UUID getEventId();
	
	/**
	 * Get the name of the event
	 * 
	 * @return name of event
	 */
	public String getName();
	
	/**
	 * Used to change the name of 
	 * the event at later time
	 * 
	 * @param name - name of event
	 */
	public void setName(String name);
		
	/**
	 * Set location of an event
	 * 
	 * @param location - location of event
	 */
	public void setLocation(String location);
	
	/**
	 * Get location of an event
	 * 
	 * @return location of event
	 */
	public String getLocation();
	
	/**
	 * Sets the start date of the event
	 * 
	 * @param start - event start date
	 */
	public void setStartDate(String start);
	
	
	/**
	 * Sets the end date of the event
	 * 
	 * @param end - event end date
	 */
	public void setEndDate(String end);

	/**
	 * Sets the start time for the event
	 * 
	 * @param start - start time (i.e. 1:30 PM)
	 */
	public void setStartTime(String start);
	
	
	/**
	 * Sets the end time for the event
	 * 
	 * @param end - end time (i.e. 4:00 PM)
	 */
	public void setEndTime(String end);
	
	/**
	 * Gets the start date of the event
	 * 
	 * @return start date of the event
	 */
	public LocalDate getStartDate();
	
	
	/**
	 * Gets the end date of the event
	 * 
	 * @return end date of the event
	 */
	public LocalDate getEndDate();
	
	
	/**
	 * Gets the start time of the event
	 * 
	 * @return LocalTime start time of the event
	 */
	public LocalTime getStartTime();
	
	/**
	 * Gets the end time of the event
	 * 
	 * @return LocalTime end time of the event
	 */
	public LocalTime getEndTime();

	/**
	 * Gets category of the event
	 * 
	 * @return category of event
	 */
	String getCategory();

	/**
	 * Set the category of an event
	 * 
	 * @param category - category of event
	 */
	void setCategory(String category);

	String getDescription();

	void setDescription(String description);

}
