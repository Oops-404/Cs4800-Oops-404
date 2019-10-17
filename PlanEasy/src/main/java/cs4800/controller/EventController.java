package cs4800.controller;

import java.util.List;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import cs4800.event.Event;
import cs4800.service.EventService;

@RestController
@RequestMapping("events")
public class EventController {
	
	private static final Logger log = Logger.getLogger(EventController.class.getName());

	@Autowired
	private EventService eventService;
	
	/*
	 * GET / RETRIEVE 
	 */
	
	// get all events
	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public List<Event> getAllEvents() {
		log.info("Getting all events");
		return eventService.getAllEvents();
	}

	// get specific event by ID
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Event getEventBy_id(@PathVariable("_id") ObjectId _id) {
		log.info("Gettings event with _id: " + _id);
		return eventService.getEventBy_id(_id);
	}
	
	// get list of events by name
	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	@ResponseBody
	public List<Event> getEventByNameLike(@PathVariable("name") String name) {
		log.info("Getting events with name containing: " + name);
		return eventService.getEventByNameLike(name);
	}
	
	// get list of events by location
	@RequestMapping(value = "/{location}", method = RequestMethod.GET)
	@ResponseBody
	public List<Event> getByLocationLike(@PathVariable("location") String location) {
		log.info("Gettings events with location containing: " + location);
		return eventService.getByLocationLike(location);
	}
	
	/*
	 * PUT / UPDATE 
	 */
	
	// update specific event's info
	@RequestMapping(value = "/{_id}", method = RequestMethod.PUT)
	@ResponseBody
	public void updateEvent(@PathVariable("_id") ObjectId _id, @Valid @RequestBody Event event) {
		if(eventService.updateEvent(_id, event) != null) {
			log.info("Event info has been updated");
		}
		else {
			log.info("Event info could NOT be updated");
		}
	}
	
	/*
	 * POST / CREATE 
	 */
	
	// insert event
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public void addEvent(@Valid @RequestBody Event event) {
		if (event.get_id() != null) {
			log.info("Event has been added");
		}
		log.info("Event could NOT be added");
	}
	
	/*
	 * DELETE
	 */
	
	// delete event
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteEvent(@PathVariable ObjectId _id) {
		log.info("");
		if (eventService.deleteEvent(_id) == 1) {
			log.info("Event has been deleted");
		}
		else {
			log.info("Event could NOT be deleted");
		}
	}
	
}