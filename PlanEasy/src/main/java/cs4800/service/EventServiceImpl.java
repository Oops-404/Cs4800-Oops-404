package cs4800.service;

import java.time.LocalDate;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cs4800.event.Event;
import cs4800.repository.EventRepository;

/*
 * EventService is responsible for all CRUD operations
 */

@Service
public class EventServiceImpl implements EventService {

	@Autowired
	private EventRepository repository;
	
	public List<Event> getAllEvents() {
		return repository.findAll();
	}
	
	/**
	 * Get event by ID
	 * 
	 * @param _id unique event ID
	 * @return event
	 */
	public Event findBy_id(ObjectId _id) {
		Event event = repository.findBy_id(_id);
		return event;
	}
	
	/**
	 * Get list of events that contain this name
	 * 
	 * @param name name (or part of name) of event
	 * @return list of events
	 */
	public List<Event> findByEventNameLike(String name) {
		List<Event> eventList = repository.findByName(name);
		return eventList;
	}
	
	/**
	 * Get list of events that contain this location
	 * 
	 * @param location location of event
	 * @return list of events
	 */
	@Override
	public List<Event> findByLocationLike(String location) {
		List<Event> eventList = repository.findByLocation(location);
		return eventList;
	}
	
	/**
	 * Update event's attributes
	 * 
	 * @param _id unique event ID
	 * @param event event object
	 * @return event
	 */
	@Override
	public Event update(ObjectId _id, Event event) {
		if (event.getName() != null) {
			event.setName(event.getName());
		}
		if (event.getLocation() != null) {
			event.setLocation(event.getLocation());
		}
		if (event.getStartDate() != null) {
			event.setStartDate(event.getStartDate());
		}
		if (event.getEndDate() != null) {
			event.setEndDate(event.getEndDate());
		}
		if (event.getStartTime() != null) {
			event.setStartTime(event.getStartTime());
		}
		if (event.getEndTime() != null) {
			event.setEndTime(event.getEndTime());
		}
		
		repository.save(event);
		return event;
	}
	
	/**
	 * Add event to the database
	 * 
	 * @param name name of event
	 * @param startDate starting date of event
	 * @param endDate ending date of event
	 * @param startTime starting time of event
	 * @param endTime ending time of event
	 * @param location location of event
	 * @return event
	 */
	@Override
	public Event add(String name, LocalDate startDate, LocalDate endDate, int[] startTime, int[] endTime, String location) {
		Event event = new Event(name, startDate, endDate, startTime, endTime, location);
		
		repository.save(event);
		return event;
	}
	
	/**
	 * Delete event from the database
	 * 
	 * @param _id unique event ID
	 * @return 1 if event has been successfully deleted
	 */
	@Override
	public int delete(ObjectId _id) {
		Event event = repository.findBy_id(_id);
		if (event != null) {
			repository.delete(event);
			return 1;
		}
		else {
			return -1;
		}
	}
	
}
