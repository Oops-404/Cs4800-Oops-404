package cs4800.controller;

import java.util.List;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cs4800.event.Event;
import cs4800.repository.EventRepository;

@RestController
@RequestMapping("/events")
public class EventController {
	@Autowired
	private EventRepository repository;
	
	/*
	 * GET
	 */
	
	// get all events
	@RequestMapping(value = "/events", method = RequestMethod.GET)
	public List<Event> getAllEvents() {
		return repository.findAll();
	}

	// get specific event by ID
	@RequestMapping(value = "/events/{id}", method = RequestMethod.GET)
	public Event getEventBy_id(@PathVariable("_id") ObjectId _id) {
	  return repository.findBy_id(_id);
	}
	
	// get list of events by name
	@RequestMapping(value = "/events/{name}", method = RequestMethod.GET)
	public List<Event> getEventByNameLike(@PathVariable("name") String name) {
		return repository.findByEventNameLike(name);
	}
	
	// get list of events by location
	@RequestMapping(value = "/events/{location}", method = RequestMethod.GET)
	public List<Event> getByLocationLike(@PathVariable("location") String location) {
		return repository.findByLocationLike(location);
	}
	
	/*
	 * PUT
	 */
	
	// update specific event's info
	@RequestMapping(value = "/events/{_id}", method = RequestMethod.PUT)
	public Event updateEvent(@PathVariable("_id") ObjectId _id, @Valid @RequestBody Event event) {
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
	
	/*
	 * POST
	 */
	
	// insert event
	@RequestMapping(value = "/events/", method = RequestMethod.POST)
	public Event createEvent(@Valid @RequestBody Event event) {
		event.set_id(ObjectId.get());
		repository.save(event);
		return event;
	}
	
	/*
	 * DELETE
	 */
	
	// delete event
	@RequestMapping(value = "/events/{id}", method = RequestMethod.DELETE)
	public void deleteEvent(@PathVariable ObjectId id) {
		repository.delete(repository.findBy_id(id));
	}
	
}