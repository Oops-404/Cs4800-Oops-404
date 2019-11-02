package cs4800.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import cs4800.user.User;

public interface UserService {

	User save(User user);
	
	User update(User user);
	
	List<User> getAllUser();
	
	void deleteUser(UUID userId);
	
	Optional<User> getUser(UUID userId);
	
}
