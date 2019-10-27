package cs4800.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import cs4800.event.Event;

@Repository
public interface EventRepository extends MongoRepository<Event, String> {
	
	void delete(ObjectId _id);
	
	Event findBy_id(ObjectId _id);
	
	@Query(value = "{ 'name' : ?0 }")
	List<Event> findByName(String name);
	
	@Query(value = "{ 'location' : ?0 }")
	List<Event> findByLocation(String location);
	
	@Query(value = "{ 'start_date' : ?0 }")
	List<Event> findByStartDate(String start_date);
	
	@Query(value = "{ 'start_time' : ?0 }")
	List<Event> findByStartTime(String start_time);

}
