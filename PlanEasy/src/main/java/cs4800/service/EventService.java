package cs4800.service;

import cs4800.event.Event;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EventService {
	
	/**
	 * Add a new event to the database.
	 * 
	 * @param event
	 * @return event that has been added
	 */
	Event addEvent(Event event);
	
	/**
	 * Update an event's information in the database.
	 * 
	 * @param event
	 * @param eventId
	 * @return event that has been updated
	 */
	Event updateEvent(Event event, UUID eventId);
	
	/**
	 * Get an event by event ID.
	 * 
	 * @param eventId
	 * @return specific event
	 */
	Optional<Event> getEvent(UUID eventId);
	
	/**
	 * Get all events in the database.
	 * 
	 * @return list of all events
	 */
	List<Event> getAllEvents();
	
	/**
	 * Delete an event from the database by event ID.
	 * 
	 * @param eventId
	 */
	void deleteEvent(UUID eventId);
	
	// CUSTOM QUERIES 
	
	/**
	 * Query for events by event name.
	 * 
	 * @param name
	 * @return list of events
	 */
	List<Event> getEventsByName(String name);
	
	/**
	 * Query for events by event location.
	 * 
	 * @param location
	 * @return list of events
	 */
	List<Event> getEventsByLocation(String location);
	
	/**
	 * Query for events by event by start date.
	 * 
	 * @param startDate
	 * @return list of events
	 */
	List<Event> getEventsByStartDate(LocalDate startDate);
	
	/**
	 * Query for events by event start time.
	 * 
	 * @param startTime
	 * @return list of events
	 */
	List<Event> getEventsByStartTime(LocalTime startTime);
	
	/**
	 * Query for events by event category.
	 * 
	 * @param category
	 * @return list of events
	 */
	List<Event> getEventsByCategory(String category);
	
	/**
	 * Query for events by event end date.
	 * 
	 * @param endDate
	 * @return list of events
	 */
	List<Event> getEventsByEndDateLessThan(LocalDate endDate);
}
