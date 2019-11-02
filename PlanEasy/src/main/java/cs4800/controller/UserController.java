package cs4800.controller;

import java.util.Optional;
import java.util.UUID;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cs4800.service.UserService;
import cs4800.user.User;

@RestController
@RequestMapping("/user")
public class UserController {

	private static final Logger log = Logger.getLogger(UserController.class.getName());
	
	@Autowired
	private UserService userService;
	
	/*
	 * POST
	 */
	
	@PostMapping("/save")
	public User save(@RequestBody User user) {
		log.info("Saving event info...");
		return userService.save(user);
	}
	
	/*
	 * PUT
	 */
	
	@PutMapping("/update")
	public User update(@RequestBody User user) {
		log.info("Updating event info...");
		return userService.save(user);
	}
	
	/*
	 * GET
	 */
		
	@GetMapping("/{userId}")
	public Optional<User> getEvent(@PathVariable(name = "userId") UUID userId) {
		log.info("Getting event with user ID: " + userId);
		return userService.getUser(userId);
	}
	
	/*
	 * DELETE
	 */
	
	@DeleteMapping("/delete/{userId}")
	public void deleteUser(@PathVariable(name = "userId") UUID userId) {
		log.info("Deleting event with user ID: " + userId);
		userService.deleteUser(userId);
	}
}
