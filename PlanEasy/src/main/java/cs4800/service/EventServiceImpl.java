package cs4800.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongodb.MongoException;

import cs4800.dao.EventDAO;
import cs4800.event.Event;

@Service
public class EventServiceImpl implements EventService {

	@Autowired
	private EventDAO eventDAO;
	
	@Override
	public Event addEvent(Event event) {
		return eventDAO.save(event);
	}

	@Override
	public Event updateEvent(Event event, UUID eventId) {
		if (eventDAO.findById(eventId).isPresent()) {
			
            Event e = eventDAO.findById(eventId).get();
            
            e.setName(event.getName());
            e.setLocation(event.getLocation());
            e.setCategory(event.getCategory());
            e.setStartDate(event.getStartDate().toString());
            e.setEndDate(event.getEndDate().toString());
            e.setStartTime(event.getStartTime().toString());
            e.setEndTime(event.getEndTime().toString());
            
            return eventDAO.save(e);
        }
        else {
            throw new MongoException("Record not found");
        }
   	}

	@Override
	public List<Event> getAllEvents() {
		return eventDAO.findAllByOrderByStartDateAsc();
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
		return eventDAO.findByNameContainingIgnoreCaseOrderByStartDateAsc(name);
	}

	@Override
	public List<Event> getEventsByLocation(String location) {
		return eventDAO.findByLocationContainingIgnoreCaseOrderByStartDateAsc(location);
	}

	@Override
	public List<Event> getEventsByStartDate(LocalDate startDate) {
		return eventDAO.findByStartDateGreaterThanEqualOrderByStartDateAsc(startDate);
	}

	@Override
	public List<Event> getEventsByStartTime(LocalTime startTime) {
		return eventDAO.findByStartTimeGreaterThanEqualOrderByStartTimeAsc(startTime);
	}
	
	@Override
	public List<Event> getEventsByStartTimeMorning() {
		DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("h:mm a");
		LocalTime startTime = LocalTime.parse("5:00 AM", formatTime);
		return eventDAO.findByStartTimeGreaterThanEqualOrderByStartTimeAsc(startTime);
	}
	
	@Override
	public List<Event> getEventsByStartTimeAfternoon() {
		DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("h:mm a");
		LocalTime startTime = LocalTime.parse("12:00 PM", formatTime);		
		return eventDAO.findByStartTimeGreaterThanEqualOrderByStartTimeAsc(startTime);
	}
	
	@Override
	public List<Event> getEventsByStartTimeEvening() {
		DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("h:mm a");
		LocalTime startTime = LocalTime.parse("5:00 PM", formatTime);		
		return eventDAO.findByStartTimeGreaterThanEqualOrderByStartTimeAsc(startTime);
	}

	@Override
	public List<Event> getEventsByStartTimeNight() {
		DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("h:mm a");
		LocalTime startTime = LocalTime.parse("8:00 PM", formatTime);		
		return eventDAO.findByStartTimeGreaterThanEqualOrderByStartTimeAsc(startTime);
	}

	@Override
	public List<Event> getEventsByCategory(String category) {
		return eventDAO.findByCategoryIgnoreCaseOrderByStartDateAsc(category);
	}

	@Override
	public List<Event> getEventsThatEnded(LocalDate endDate) {
		return eventDAO.findByEndDateBefore(endDate);
	}
	
}
