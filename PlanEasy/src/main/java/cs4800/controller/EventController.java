package cs4800.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cs4800.event.Event;
import cs4800.service.EventService;

/**
 * EventController is responsible for all REST API operations with Event data
 * 
 */
@RestController
@RequestMapping("/events")
public class EventController {
	
	private static final Logger log = Logger.getLogger(EventController.class.getName());

	@Autowired
	private EventService eventService;
	
	//CREATE AN EVENT	
	@PostMapping("/save")
	public Event save(@RequestBody Event event) {
		log.info("Saving event info...");
		return eventService.save(event);
	}
	
	//UPDATE AN EVENT
	@PutMapping("/update")
	public Event update(@RequestBody Event event) {
		log.info("Updating event info...");
		return eventService.save(event);
	}
	
	//GET ALL EVENTS
	@GetMapping("/all")
	public List<Event> getAllEvent() {
		log.info("Getting all events...");
		return eventService.getAllEvent();
	}
	
	
	//RETRIEVE SINGLE EVENT
	@GetMapping("/id/{eventId}")
	public Optional<Event> getEvent(@PathVariable(name = "eventId") UUID eventId) {
		log.info("Getting event with event ID: " + eventId);
		return eventService.getEvent(eventId);
	}
	
	//GET ALL EVENTS CONTAINING __ IN THE NAME
	@GetMapping("/name/{name}")
	public List<Event> getEventByName(@PathVariable(name = "name") String name) {
		log.info("Getting event with event name containing: " + name);
		return eventService.getEventsByName(name);
	}
	

	//GET ALL EVENTS CONTAINING __ IN THE LOCATION
	@GetMapping("/location/{location}")
	public List<Event> getEventByLocation(@PathVariable(name = "location") String location) {
		log.info("Getting event with event location containing: " + location);
		return eventService.getEventsByLocation(location);
	}
	
	//GET ALL EVENTS STARTING ON THIS DATE
	@GetMapping("/startDate/{startDate}")
	public List<Event> getEventByStartDate(@PathVariable(name = "startDate") String startDate) {
		log.info("Getting event with event start date: " + startDate);
		DateTimeFormatter formatDate = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
		LocalDate localStartDate = LocalDate.parse(startDate, formatDate);
		return eventService.getEventsByStartDate(localStartDate);
	}
	
	//GET ALL EVENTS STARTING AT THIS TIME
	@GetMapping("/startTime/{startTime}")
	public List<Event> getEventByStartTime(@PathVariable(name = "startTime") String startTime) {
		log.info("Getting event with event start time: " + startTime);
		DateTimeFormatter formatTime = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
		LocalTime localStartTime = LocalTime.parse(startTime, formatTime);
		return eventService.getEventsByStartTime(localStartTime);
	}
	
	//GET ALL EVENTS CONTAINING __ IN THE CATEGORY
	@GetMapping("/category/{category}")
	public List<Event> getEventByCategory(@PathVariable(name = "category") String category) {
		log.info("Getting event with event category: " + category);
		return eventService.getEventsByCategory(category);
	}
	
	//DELETE AN EVENT
	@DeleteMapping("/delete/{eventId}")
	public void deleteEvent(@PathVariable(name = "eventId") UUID eventId) {
		log.info("Deleting event with event ID: " + eventId);
		eventService.deleteEvent(eventId);
	}
	
	//DELETE ALL EVENTS THAT HAVE ENDED (END DATE < TODAY'S DATE)
	@DeleteMapping("/delete")
	public void deleteEventIfEnded() {
		List<Event> toDelete = eventService.getEventByEndDate();
		for (int i=0; i<toDelete.size(); i++) {
			UUID id = toDelete.get(i).getEventId();
			log.info("Deleting event that has ended with event ID: " + id);
			eventService.deleteEvent(id);
		}
	}

}