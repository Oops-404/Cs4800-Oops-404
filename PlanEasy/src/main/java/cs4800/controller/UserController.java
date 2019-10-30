package cs4800.controller;

import java.util.List;
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
	
	@PostMapping("/save")
	public User save(@RequestBody User user) {
		log.info("Saving event info...");
		return userService.save(user);
	}
	
	@PutMapping("/update")
	public User update(@RequestBody User user) {
		log.info("Updating event info...");
		return userService.save(user);
	}
	
	@GetMapping("/all")
	public List<User> getAllEvent() {
		log.info("Getting all events...");
		return userService.getAllUser();
	}
	
	@GetMapping("/{eventId}")
	public Optional<User> getEvent(@PathVariable(name = "eventId") UUID userId) {
		log.info("Getting event with event ID: " + userId);
		return userService.getUser(userId);
	}
	
	@DeleteMapping("/delete/{eventId}")
	public void deleteUser(@PathVariable(name = "eventId") UUID userId) {
		log.info("Deleting event with event ID: " + userId);
		userService.deleteUser(userId);
	}
}
