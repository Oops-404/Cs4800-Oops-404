package cs4800.service;

import java.util.List;
import java.util.Optional;
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
	public User save(User user) {
		return userDAO.save(user);
	}

	@Override
	public User update(User user) {
		return userDAO.save(user);
	}

	@Override
	public List<User> getAllUser() {
		return userDAO.findAll();
	}

	@Override
	public void deleteUser(UUID userId) {
		userDAO.deleteById(userId);
	}

	@Override
	public Optional<User> getUser(UUID userId) {
		return userDAO.findById(userId);
	}
}
