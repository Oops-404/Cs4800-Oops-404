package cs4800.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cs4800.dao.EventDAO;
import cs4800.event.Event;

/*
 * EventService is responsible for all CRUD operations regarding event information
 */

@Service
public class EventServiceImpl implements EventService {

	@Autowired
	private EventDAO eventDAO;
	
	@Override
	public Event save(Event event) {
		return eventDAO.save(event);
	}

	@Override
	public Event update(Event event) {
		return eventDAO.save(event);
	}

	@Override
	public List<Event> getAllEvent() {
		return eventDAO.findAll();
	}

	@Override
	public void deleteEvent(UUID eventId) {
		eventDAO.deleteById(eventId);
	}

	@Override
	public Optional<Event> getEvent(UUID eventId) {
		return eventDAO.findById(eventId);
	}

	@Override
	public List<Event> getEventsByName(String name) {
		return eventDAO.findByNameContainingIgnoreCase(name);
	}

	@Override
	public List<Event> getEventsByLocation(String location) {
		return eventDAO.findByLocationContainingIgnoreCase(location);
	}

	@Override
	public List<Event> getEventsByStartDate(LocalDate startDate) {
		return eventDAO.findByStartDateGreaterThanEqual(startDate);
	}

	@Override
	public List<Event> getEventsByStartTime(LocalTime startTime) {
		return eventDAO.findByStartTimeGreaterThanEqual(startTime);
	}

	@Override
	public List<Event> getEventsByCategory(String category) {
		return eventDAO.findByCategoryIgnoreCase(category);
	}

	@Override
	public List<Event> getEventsByEndDateBefore(LocalDate endDate) {
		return eventDAO.FindByEndDateBefore(endDate);
	}
	
}
