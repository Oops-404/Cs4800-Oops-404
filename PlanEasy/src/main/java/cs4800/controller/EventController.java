package cs4800.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cs4800.event.Event;
import cs4800.service.EventService;

/**
 * EventController is responsible for all REST API operations with Event data
 * 
 */
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/events")
public class EventController {
	
	private static final Logger log = Logger.getLogger(EventController.class.getName());

	@Autowired
	private EventService eventService;
	
	/**
	 * Create new event.
	 * 
	 * @param event
	 * @return the new event
	 */
	@PostMapping("/save")
	public Event save(@RequestBody Event event) {
		log.info("Saving event info...");
		return eventService.addEvent(event);
	}
	
	/**
	 * Update event information.
	 * 
	 * @param event
	 * @param eventId
	 * @return the updated event
	 */
	@PatchMapping("/update")
	public Event update(@RequestBody Event event, @RequestParam(name = "eventId") UUID eventId) {
		event.setEventId(eventId);
		log.info("Updating event info...");
		return eventService.updateEvent(event, eventId);
	}
	
	/**
	 * Get all events.
	 * 
	 * @return list of all events
	 */
	@GetMapping("/")
	public List<Event> getAllEvent() {
		log.info("Getting all events...");
		return eventService.getAllEvents();
	}
	
	/**
	 * Get single event.
	 * 
	 * @param eventId
	 * @return
	 */
	@GetMapping("/id")
	public Optional<Event> getEvent(@RequestParam(name = "eventId") UUID eventId) {
		log.info("Getting event with event ID: " + eventId);
		return eventService.getEvent(eventId);
	}
	
	/**
	 * Get all events containing __ in the name.
	 * 
	 * @param name - a substring of the event name
	 * @return list of events that match the query search
	 */
	@GetMapping("/name")
	public List<Event> getEventByName(@RequestParam(name = "name") String name) {
		log.info("Getting events with event name containing: " + name);
		return eventService.getEventsByName(name);
	}

	/**
	 * Get all events containing __ in the location.
	 * 
	 * @param location
	 * @return list of events that match the query search
	 */
	@GetMapping("/location")
	public List<Event> getEventByLocation(@RequestParam(name = "location") String location) {
		log.info("Getting events with event location containing: " + location);
		return eventService.getEventsByLocation(location);
	}
	
	/**
	 * Get all events that start on this date.
	 * 
	 * @param startDate - starting date of event (i.e. 2019-03-23)
	 * @return list of events that match the query search
	 */
	@GetMapping("/startDate") 
	public List<Event> getEventByStartDate(@RequestParam(name = "startDate") String startDate) {
		log.info("Getting events with event start date: " + startDate);
		DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localStartDate = LocalDate.parse(startDate, formatDate);
		return eventService.getEventsByStartDate(localStartDate);
	}
	
	/**
	 * Get all events that start at this time.
	 * 
	 * @param startTime - starting time of event (i.e. 4:00PM)
	 * @return list of events that match the query search
	 */
	@GetMapping("/startTime")	
	public List<Event> getEventByStartTime(@RequestParam(name = "startTime") String startTime) {
		log.info("Getting events with event start time: " + startTime);
		DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("h:mma");
		LocalTime localStartTime = LocalTime.parse(startTime, formatTime);
		return eventService.getEventsByStartTime(localStartTime);
	}
	
	@GetMapping("/startTime/morning")
	public List<Event> getEventsMorning() {
		log.info("Getting events that start in the morning...");
		return eventService.getEventsByStartTimeMorning();
	}
	
	@GetMapping("/startTime/afternoon")
	public List<Event> getEventsAfternoon() {
		log.info("Getting events that start in the afternoon...");
		return eventService.getEventsByStartTimeAfternoon();
	}
	
	@GetMapping("/startTime/evening")
	public List<Event> getEventsEvening() {
		log.info("Getting events that start in the evening...");
		return eventService.getEventsByStartTimeEvening();
	}
	
	@GetMapping("/startTime/night")
	public List<Event> getEventsNight() {
		log.info("Getting events that start at night...");
		return eventService.getEventsByStartTimeNight();
	}
	
	/**
	 * Get all events containing __ in the category
	 * 
	 * @param category
	 * @return list of events that match the query search
	 */
	@GetMapping("/category")
	public List<Event> getEventByCategory(@RequestParam(name = "category") String category) {
		log.info("Getting events with event category: " + category);
		return eventService.getEventsByCategory(category);
	}
	
	/**
	 * Delete an event by ID
	 * 
	 * @param eventId
	 */	
	@DeleteMapping("/delete")
	public void deleteEvent(@RequestParam(name = "eventId") UUID eventId) {
		log.info("Deleting event with event ID: " + eventId);
		eventService.deleteEvent(eventId);
	}
	
	/**
	 * Delete all events that have ended (end date < today's date)
	 */
	@DeleteMapping("/deleteEnded")
	public void deleteEventIfEnded() {
		LocalDate today = LocalDate.now();
		log.info("Deleting events that ended before: " + today);
		List<Event> toDelete = eventService.getEventsThatEnded(today);
		for (int i=0; i<toDelete.size(); i++) {
			UUID id = toDelete.get(i).getEventId();
			log.info("Deleting event that has ended with event ID: " + id);
			eventService.deleteEvent(id);
		}
	}
	
	/**
	 * Delete all events 
	 */
	@DeleteMapping("/deleteAll")
	public void deleteAll() {
		log.info("Deleting ALL events...");
		List<Event> toDelete = eventService.getAllEvents();
		for (int i=0; i<toDelete.size(); i++) {
			UUID id = toDelete.get(i).getEventId();
			log.info("Deleting event that has ended with event ID: " + id);
			eventService.deleteEvent(id);
		}
	}
}