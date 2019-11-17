package cs4800.dao;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import cs4800.user.User;

/**
 * User Data Access Object (DAO)
 * 
 */
@Repository
public interface UserDAO extends MongoRepository<User, UUID> {

    User findByEmail(String email);
    
    void deleteByEmail(String email);
}
