package cs4800.service;

import cs4800.event.Event;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EventService {
	
	Event save(Event event);
	
	Event update(Event event);
	
	List<Event> getAllEvent();
	
	void deleteEvent(UUID eventId);
	
	Optional<Event> getEvent(UUID eventId);

	// CUSTOM QUERIES 
	
	List<Event> getEventsByName(String name);
	
	List<Event> getEventsByLocation(String location);
	
	List<Event> getEventsByStartDate(LocalDate startDate);
	
	List<Event> getEventsByStartTime(LocalTime startTime);
	
	List<Event> getEventsByCategory(String category);
	
	List<Event> getEventsByEndDateBefore(LocalDate endDate);
}
