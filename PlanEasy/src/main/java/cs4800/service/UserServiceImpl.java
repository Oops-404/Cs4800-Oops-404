package cs4800.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongodb.MongoException;

import cs4800.dao.UserDAO;
import cs4800.user.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	@Override
	public User addUser(User user) {
		return userDAO.save(user);
	}

	@Override
	public User updateUser(User user, UUID userId) {
		if (userDAO.findById(userId).isPresent()) {
			User u = userDAO.findById(userId).get();
			
			u.setEmail(user.getEmail());
			u.setPassword(user.getPassword());
			u.setName(user.getName());
			u.setRoles(user.getRoles());
			
			return userDAO.save(u);
        }
        else {
            throw new MongoException("Record not found");
        }
	}
	
	@Override
	public User addCalendarToUser(User user, UUID userId, UUID calendarId) {
		if (userDAO.findById(userId).isPresent()) {
			User u = userDAO.findById(userId).get();
			
			u.addCalendar(calendarId);
			
			return userDAO.save(u);
        }
        else {
            throw new MongoException("Record not found");
        }
	}

	@Override
	public Optional<User> getUser(UUID userId) {
		return userDAO.findById(userId);
	}
	
	@Override
	public List<User> getAllUsers() {
		return userDAO.findAll();
	}

	@Override
	public void deleteUserByEmail(String email) {
		userDAO.deleteByEmail(email);
	}

	@Override
	public User getUserByEmail(String email) {
		return userDAO.findByEmail(email);
	}
}
