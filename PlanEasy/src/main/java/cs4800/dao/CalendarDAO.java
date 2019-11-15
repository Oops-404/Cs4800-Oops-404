package cs4800.dao;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import cs4800.calendar.Calendar;

/**
 * Calendar Data Access Object (DAO)
 * 
 */
public interface CalendarDAO extends MongoRepository<Calendar, UUID> {
	
}
