package cs4800.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cs4800.calendar.Calendar;
import cs4800.service.CalendarService;

/**
 * CalendarController is responsible for all REST API operations with Calendar data
 * 
 */
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/calendar")
public class CalendarController {
	
	private static final Logger log = Logger.getLogger(CalendarController.class.getName());

	@Autowired
	private CalendarService calendarService;
	
	/**
	 * Create new calendar.
	 * 
	 * @param calendar
	 * @return new calendar
	 */
	@PostMapping("/save")
	public Calendar save(@RequestBody Calendar calendar) {
		log.info("Saving calendar info...");
		return calendarService.addCalendar(calendar);
	}

	/**
	 * Update calendar information.
	 * 
	 * @param calendar
	 * @param calendarId
	 * @return updated calendar
	 */
	@PatchMapping("/update")
	public Calendar update(@RequestBody Calendar calendar, @RequestParam(name = "calendarId") UUID calendarId) {
		calendar.setCalendarId(calendarId);
		log.info("Updating calendar info...");
		return calendarService.updateCalendar(calendar, calendarId);
	}
	
	/**
	 * Add event to the calendar.
	 * 
	 * @param calendar
	 * @param calendarId
	 * @param eventId
	 * @return updated calendar
	 */
	@PatchMapping("/addEvent")
	public Calendar addEvent(@RequestBody Calendar calendar, @RequestParam(name = "calendarId") UUID calendarId, @RequestParam(name = "eventId") UUID eventId) {
		calendar.addEventToCalendar(eventId);
		log.info("Adding event to calendar...");
		return calendarService.addEventToCalendar(calendar, calendarId, eventId);
	}
	
	/**
	 * Get all calendars.
	 * 
	 * @return list of all calendars
	 */
	@GetMapping("/")
	public List<Calendar> getAllCalendars() {
		log.info("Getting all calendars...");
		return calendarService.getAllCalendars();
	}
	
	/**
	 * Get single calendar.
	 * 
	 * @param calendarId
	 * @return
	 */
	@GetMapping("/id")
	public Optional<Calendar> getCalendar(@RequestParam(name = "calendarId") UUID calendarId) {
		log.info("Getting calendar with calendar ID: " + calendarId);
		return calendarService.getCalendar(calendarId);
	}
	
	/**
	 * Delete an calendar by ID
	 * 
	 * @param calendarId
	 */	
	@DeleteMapping("/delete")
	public void deleteCalendar(@RequestParam(name = "calendarId") UUID calendarId) {
		log.info("Deleting calendar with calendar ID: " + calendarId);
		calendarService.deleteCalendar(calendarId);	
	}
	
	/**
	 * Add event to the calendar.
	 * 
	 * @param calendar
	 * @param calendarId
	 * @param eventId
	 * @return updated calendar
	 */
	@DeleteMapping("/deleteEvent")
	public void deleteEvent(@RequestParam(name = "calendarId") UUID calendarId, @RequestParam(name = "eventId") UUID eventId) {
		log.info("Deleting event from calendar ID: " + calendarId + " with event ID: " + eventId);
		calendarService.removeEventFromCalendar(calendarId, eventId);
	}
		
}
