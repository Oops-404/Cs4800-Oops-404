package cs4800.controller;

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

@RestController
@RequestMapping("/events")
public class EventController {
	
	private static final Logger log = Logger.getLogger(EventController.class.getName());

	@Autowired
	private EventService eventService;
	
	@PostMapping("/save")
	public Event save(@RequestBody Event event) {
		log.info("Saving event info...");
		return eventService.save(event);
	}
	
	@PutMapping("/update")
	public Event update(@RequestBody Event event) {
		log.info("Updating event info...");
		return eventService.save(event);
	}
	
	@GetMapping("/all")
	public List<Event> getAllEvent() {
		log.info("Getting all events...");
		return eventService.getAllEvent();
	}
	
	@GetMapping("/{eventId}")
	public Optional<Event> getEvent(@PathVariable(name = "eventId") UUID eventId) {
		log.info("Getting event with event ID: " + eventId);
		return eventService.getEvent(eventId);
	}
	
	@DeleteMapping("/delete/{eventId}")
	public void deleteEvent(@PathVariable(name = "eventId") UUID eventId) {
		log.info("Deleting event with event ID: " + eventId);
		eventService.deleteEvent(eventId);
	}
	
}