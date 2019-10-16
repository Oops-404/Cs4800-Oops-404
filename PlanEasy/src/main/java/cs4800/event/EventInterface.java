package cs4800.event;

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
	 * @param start day
	 * @param start month
	 * @param start year
	 */
	public void setStartDate(int day, Month month, int year);
	
	
	/*
	 * Sets the end date of the event
	 * 
	 * @param end day
	 * @param end month
	 * @param end year
	 */
	public void setEndDate(int day, Month month, int year);

	/*
	 * Sets the start time for the event
	 * 
	 * @param start hour
	 * @param start minute
	 * @param start second
	 */
	public void setStartTime(int hour, int min, int sec);
	
	
	/*
	 * Sets the end time for the event
	 * 
	 * @param end hour
	 * @param end minute
	 * @param end second
	 */
	public void setEndTime(int hour, int min, int sec);
	
	/*
	 * Gets the start date of the event
	 * 
	 * @return an int[] with [0] being day
	 * 		   [1] being month and [2] being year
	 */
	public int[] getStartDate();
	
	
	/*
	 * Gets the end date of the event
	 * 
	 * @return an int[] with [0] being day
	 * 		   [1] being month and [2] being year
	 */
	public int[] getEndDate();
	
	
	/*
	 * Gets the start time of the event
	 * 
	 * @return an int[] with [0] being hour
	 * 		   [1] being minute and [2] being second
	 */
	public int[] getStartTime();
	
	/*
	 * Gets the end time of the event
	 * 
	 * @return an int[] with [0] being hour
	 * 		   [1] being minute and [2] being second
	 */
	public int[] getEndTime();

}
