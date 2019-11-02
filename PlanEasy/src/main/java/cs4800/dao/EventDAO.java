package cs4800.dao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import cs4800.event.Event;

/**
 * Event Data Access Object (DAO)
 * 
 */
@Repository
public interface EventDAO extends MongoRepository<Event, UUID> {
	
	/**
	 * Get all events containing this string in the event name
	 * 
	 * @param name - part of event name
	 * @return list of events
	 */
	List<Event> findByNameContainingIgnoreCase(String name);
	
	/**
	 * Get all events containing this string in the event location
	 * 
	 * @param location - part of event location
	 * @return list of events
	 */
	List<Event> findByLocationContainingIgnoreCase(String location);
	
	/**
	 * Get all events that start on this date or later
	 * 
	 * @param startDate - starting date of event
	 * @return list of events
	 */
	List<Event> findByStartDateGreaterThanEqual(LocalDate startDate);
	
	/**
	 * Get all events that start at this time or later
	 * 
	 * @param startTime - starting time of event
	 * @return list of events
	 */
	List<Event> findByStartTimeGreaterThanEqual(LocalTime startTime);
	
	/**
	 * Get all events that start at this time or later
	 * 
	 * @param category - starting time of event
	 * @return list of events
	 */
	List<Event> findByCategoryIgnoreCase(String category);
	
	/**
	 * Get all events that ended before this date 
	 * (for deletion to save storage)
	 * 
	 * @param endDate - ending date of event
	 * @return list of events
	 */
	List<Event> findByEndDateLessThan(LocalDate endDate);
}