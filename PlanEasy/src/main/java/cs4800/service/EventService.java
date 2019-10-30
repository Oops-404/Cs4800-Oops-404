package cs4800.service;

import cs4800.event.Event;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EventService {
	
	Event save(Event event);
	
	Event update(Event event);
	
	List<Event> getAllEvent();
	
	void deleteEvent(UUID eventId);
	
	Optional<Event> getEvent(UUID eventId);

}
