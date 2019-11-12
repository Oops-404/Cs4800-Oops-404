package cs4800.service;

import java.util.List;
import cs4800.user.User;

public interface UserService {

	User save(User user);
	
	User update(User user);
	
	List<User> getAllUsers();
	
	void deleteUserByEmail(String email);
	
	User getUserByEmail(String email);
	
}
