package cs4800.event;

import java.time.LocalDate;
import java.time.Month;

public interface EventInterface {
	
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
	public LocalDate getStartDate();
	
	
	/*
	 * Gets the end date of the event
	 * 
	 * @return an int[] with [0] being day
	 * 		   [1] being month and [2] being year
	 */
	public LocalDate getEndDate();
	
	
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
