package cs4800.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import cs4800.calendar.Calendar;

public interface CalendarService {
	
	/**
	 * Add a new calendar to the database.
	 * 
	 * @param calender
	 * @return calendar that was added
	 */
	Calendar addCalendar(Calendar calender);
	
	/**
	 * Update a calendar's information in the database.
	 * 
	 * @param calendar
	 * @param calendarId
	 * @return calendar that was updated
	 */
	Calendar updateCalendar(Calendar calendar, UUID calendarId);
	
	/**
	 * Get a calendar by calendar ID.
	 * 
	 * @param calendarId
	 * @return specific calendar
	 */
	Optional<Calendar> getCalendar(UUID calendarId);
	
	/**
	 * Get all calendars in the database.
	 * 
	 * @return list of all calendars
	 */
	List<Calendar> getAllCalendars();
	
	/**
	 * Delete a calendar from the database by calendar ID.
	 * 
	 * @param calendarId
	 */
	void deleteCalendar(UUID calendarId);
}
