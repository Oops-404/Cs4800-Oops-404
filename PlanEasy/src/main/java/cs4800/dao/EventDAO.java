package cs4800.dao;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import cs4800.event.Event;

/**
 * Event Data Access Object (DAO)
 * 
 */
@Repository
public interface EventDAO extends MongoRepository<Event, UUID> {

}
