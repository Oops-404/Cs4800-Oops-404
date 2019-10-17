package cs4800.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import cs4800.event.Event;

import java.util.List;

import javax.validation.Valid;

@Repository
public interface EventRepository extends MongoRepository<Event, String> {
		
	Event findBy_id(ObjectId _id);
	
	List<Event> findByEventNameLike(String name);
	
	List<Event> findByLocationLike(String location);

	Event updateEvent(ObjectId _id, @Valid Event event);

}
