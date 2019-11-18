package cs4800.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongodb.MongoException;

import cs4800.calendar.Calendar;
import cs4800.dao.CalendarDAO;

@Service
public class CalendarServiceImpl implements CalendarService {

	@Autowired
	private CalendarDAO calendarDAO;
	
	@Override
	public Calendar addCalendar(Calendar calendar) {
		return calendarDAO.save(calendar);
	}

	@Override
	public Calendar updateCalendar(Calendar calendar, UUID calendarId) {
		if (calendarDAO.findById(calendarId).isPresent()) {
			Calendar c = calendarDAO.findById(calendarId).get();
			
			c.setMonth(calendar.getMonth().getValue());
			c.setDay(calendar.getDay());
			c.setYear(calendar.getYear());
			
			return calendarDAO.save(c);
		}
		else {
			throw new MongoException("Record not found");
		}
	}
	
	@Override
	public Calendar addEventToCalendar(Calendar calendar, UUID calendarId, UUID eventId) {
		if (calendarDAO.findById(calendarId).isPresent()) {
			Calendar c = calendarDAO.findById(calendarId).get();
			
			c.addEventToCalendar(eventId);
			
			return calendarDAO.save(c);
		}
		else {
			throw new MongoException("Record not found");
		}
	}
	
	@Override
	public void removeEventFromCalendar(UUID calendarId, UUID eventId) {
		if (calendarDAO.findById(calendarId).isPresent()) {
			Calendar c = calendarDAO.findById(calendarId).get();
			
			c.removeEventFromCalendar(eventId);	
			
			calendarDAO.save(c);
		}
		else {
			throw new MongoException("Record not found");
		}
	}

	@Override
	public Optional<Calendar> getCalendar(UUID calendarId) {
		return calendarDAO.findById(calendarId);
	}

	@Override
	public List<Calendar> getAllCalendars() {
		return calendarDAO.findAll();
	}

	@Override
	public void deleteCalendar(UUID calendarId) {
		calendarDAO.deleteById(calendarId);
	}

}
