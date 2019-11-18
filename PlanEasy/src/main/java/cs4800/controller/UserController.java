package cs4800.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cs4800.service.UserService;
import cs4800.user.User;

/**
 * UserController is responsible for all REST API operations with User data
 * 
 */
@RestController
@RequestMapping("/user")
public class UserController {

	private static final Logger log = Logger.getLogger(UserController.class.getName());
	
	@Autowired
	private UserService userService;
	
	/**
	 * Create a user.
	 * 
	 * @param user
	 * @return the new user
	 */
	@PostMapping("/save")
	public User save(@RequestBody User user) {
		log.info("Saving user info...");
		return userService.addUser(user);
	}
	
	/**
	 * Update user info.
	 * 
	 * @param user
	 * @param userId
	 * @return
	 */
	@PatchMapping("/save/{userId}")
	public User update(@RequestBody User user, @PathVariable(name = "userId") UUID userId) {
		user.setUserId(userId);
		log.info("Updating user info...");
		return userService.updateUser(user, userId);
	}

	/**
	 * Add calendar to a user.
	 * @param user
	 * @param userId
	 * @param calendarId
	 * @return updated user
	 */
	@PatchMapping("/addCalendar/{userId}")
	public User addCalendar(@RequestBody User user, @PathVariable(name = "userId") UUID userId, @PathVariable(name = "calendarId") UUID calendarId) {
		user.addCalendar(calendarId);
		log.info("Adding calendar to user...");
		return userService.addCalendarToUser(user, userId, calendarId);
	}
	
	/**
	 * Get all users.
	 * 
	 * @return list of all users
	 */
	@GetMapping("/all")
	public List<User> getAllUsers() {
		log.info("Getting all users...");
		return userService.getAllUsers();
	}
	
	/**
	 * Get user by user ID.
	 * 
	 * @param userId
	 * @return specific user
	 */
	@GetMapping("/{userId}")
	public Optional<User> getUser(@PathVariable(name = "userId") UUID userId) {
		log.info("Getting user with user ID: " + userId);
		return userService.getUser(userId);
	}
	
	/**
	 * Get user by email.
	 * 
	 * @param email
	 * @return specific user
	 */
	@GetMapping("/{userEmail}")
	public User getUserByEmail(@PathVariable(name = "userEmail") String email) {
		log.info("Getting user with email: " + email);
		return userService.getUserByEmail(email);
	}
	
	/**
	 * Delete a user by email.
	 * 
	 * @param email
	 */
	@DeleteMapping("/delete/{userEmail}")
	public void deleteUser(@PathVariable(name = "userEmail") String email) {
		log.info("Deleting user with email: " + email);
		userService.deleteUserByEmail(email);
	}
}
