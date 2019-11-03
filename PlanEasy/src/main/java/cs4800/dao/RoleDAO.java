package cs4800.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import cs4800.security.Role;

/**
 * Role Data Access Object (DAO)
 * 
 */

@Repository
public interface RoleDAO extends MongoRepository<Role, String>{
	
	Role findByRole(String role);

}
