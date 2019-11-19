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
	 * Get all events sorted by start date ascending.
	 * 
	 * @return list of all events
	 */
	List<Event> findAllByOrderByStartDateAsc();
	
	/**
	 * Get all events containing this string in the event name
	 * 
	 * @param name - part of event name
	 * @return list of events
	 */
	List<Event> findByNameContainingIgnoreCaseOrderByStartDateAsc(String name);
	
	/**
	 * Get all events containing this string in the event location
	 * 
	 * @param location - part of event location
	 * @return list of events
	 */
	List<Event> findByLocationContainingIgnoreCaseOrderByStartDateAsc(String location);
	
	/**
	 * Get all events that start on this date or later
	 * 
	 * @param startDate - starting date of event
	 * @return list of events
	 */
	List<Event> findByStartDateGreaterThanEqualOrderByStartDateAsc(LocalDate startDate);
	
	/**
	 * Get all events that start at this time or later
	 * 
	 * @param startTime - starting time of event
	 * @return list of events
	 */
	List<Event> findByStartTimeGreaterThanEqualOrderByStartTimeAsc(LocalTime startTime);
	
	/**
	 * Get all events that start at this time or later
	 * 
	 * @param category - starting time of event
	 * @return list of events
	 */
	List<Event> findByCategoryIgnoreCaseOrderByStartDateAsc(String category);
	
	/**
	 * Get all events that ended before this date 
	 * 
	 * @param endDate - ending date of event
	 * @return list of events
	 */
	List<Event> findByEndDateBefore(LocalDate endDate);
}
