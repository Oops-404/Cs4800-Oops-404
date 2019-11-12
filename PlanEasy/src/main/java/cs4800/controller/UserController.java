package cs4800.controller;

import java.util.List;
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
	
	//CREATE A USER
	@PostMapping("/save")
	public User save(@RequestBody User user) {
		log.info("Saving user info...");
		return userService.save(user);
	}
	
	//UPDATE USER INFO
	@PutMapping("/update")
	public User update(@RequestBody User user) {
		log.info("Updating user info...");
		return userService.save(user);
	}
	
	//GET ALL USERS
	@GetMapping("/all")
	public List<User> getAllUsers() {
		log.info("Getting all users...");
		return userService.getAllUsers();
	}
	
	//GET USER BY EMAIL
	@GetMapping("/{userEmail}")
	public User getUserByEmail(@PathVariable(name = "userEmail") String email) {
		log.info("Getting user with email: " + email);
		return userService.getUserByEmail(email);
	}
	
	//DELETE A USER
	@DeleteMapping("/delete/{userEmail}")
	public void deleteUser(@PathVariable(name = "userEmail") String email) {
		log.info("Deleting user with email: " + email);
		userService.deleteUserByEmail(email);
	}
}
