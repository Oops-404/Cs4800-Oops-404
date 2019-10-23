package cs4800.service;

import org.bson.types.ObjectId;

import cs4800.event.Event;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;


public interface EventService {
		
	List<Event> getAllEvents();
	
	Event findBy_id(ObjectId _id);
	
	List<Event> findByEventNameLike(String name);
	
	List<Event> findByLocationLike(String location);
	    
    Event update(ObjectId _id, @Valid Event event);
    
    Event add(String name, LocalDate startDate, LocalDate endDate, int[] startTime, int[] endTime, String location);

	int delete(ObjectId _id);

}
