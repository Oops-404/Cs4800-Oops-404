package cs4800.service;

import java.util.List;
import java.util.UUID;

import cs4800.user.User;

public interface UserService {

	/**
	 * Add user to the database.
	 * 
	 * @param user
	 * @return new user
	 */
	User addUser(User user);
	
	/**
	 * Update user's information in the database.
	 * 
	 * @param user
	 * @param userId
	 * @return updated user
	 */
	User updateUser(User user, UUID userId);
	
	/**
	 * Add a calendar to a user.
	 * @param userId
	 * @param calendarId
	 * @return updated user
	 */
	User addCalendarToUser(UUID userId, UUID calendarId);
	
	/**
	 * Get all users in the database.
	 * 
	 * @return list of all users
	 */
	List<User> getAllUsers();
	
	/**
	 * Query for a user by email.
	 * 
	 * @param email
	 * @return user
	 */
	User getUserByEmail(String email);
	
	/**
	 * Delete a user from the database by email.
	 * 
	 * @param email
	 */
	void deleteUserByEmail(String email);	
}
