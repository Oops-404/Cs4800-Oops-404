package cs4800.event;

import java.time.LocalDate;
import java.time.Month;

import org.bson.types.ObjectId;

public interface EventInterface {
	
	/*
	 * Set unique event id
	 * 
	 * @param id of event
	 */
	void set_id(ObjectId _id);
	
	/*
	 * Get unique event id
	 * 
	 * @return id of event
	 */
	ObjectId get_id();
	
	/*
	 * Get the name of the event
	 * 
	 * @return event name
	 */
	public String getName();
	
	/*
	 * Used to change the name of 
	 * the event at later time
	 * 
	 * @param name of event
	 */
	public void setName(String name);
	
	/*
	 * Used to delete the event 
	 * currently unimplemented 
	 */
	public void deleteEvent();
	
	/*
	 * 
	 */
	public void setLocation(String location);
	
	/*
	 * 
	 */
	public String getLocation();
	
	/*
	 * Sets the start date of the event
	 * 
	 * @param LocalDate for event start
	 */
	public void setStartDate(LocalDate start);
	
	
	/*
	 * Sets the end date of the event
	 * 
	 * @param LocalDate for event end
	 */
	public void setEndDate(LocalDate end);

	/*
	 * Sets the start time for the event
	 * 
	 * @param int[] with [0] being hour
	 * [1] being minute and [2] being second
	 */
	public void setStartTime(int[] start);
	
	
	/*
	 * Sets the end time for the event
	 * 
	 * @param int[] with [0] being hour
	 * [1] being minute and [2] being second
	 */
	public void setEndTime(int[] end);
	
	/*
	 * Gets the start date of the event
	 * 
	 * @return LocalDate with the startDate of the event
	 */
	public LocalDate getStartDate();
	
	
	/*
	 * Gets the end date of the event
	 * 
	 * @return LocalDate with the end date of the event
	 */
	public LocalDate getEndDate();
	
	
	/*
	 * Gets the start time of the event
	 * 
	 * @return int[] with [0] being hour
	 * 		   [1] being minute and [2] being second
	 */
	public int[] getStartTime();
	
	/*
	 * Gets the end time of the event
	 * 
	 * @return int[] with [0] being hour
	 * 		   [1] being minute and [2] being second
	 */
	public int[] getEndTime();

}
