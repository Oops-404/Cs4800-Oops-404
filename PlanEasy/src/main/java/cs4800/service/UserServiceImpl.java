package cs4800.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		return userDAO.save(user);
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
