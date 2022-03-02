package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@RestController
//@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@CrossOrigin
@RequestMapping("/userapi")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepository;
	// @Autowired
	// private AllowanceService allowanceService;

	
	@GetMapping("/test")
	public String test() {
		return "Get works...!";
	}
	
	@GetMapping("/getall")
	public List<User> getUsers() {
		List<User> list = userService.getDefaultUsers();
		return list;
	}
	@GetMapping("/get/{field}/{sortingDirection}")
	public List<User> getSortedUsers(@PathVariable(value = "field") String field,
			@PathVariable(value = "sortingDirection") String sortingDirection) {
		List<User> list = userService.getSortedUsers(field, sortingDirection);
		return list;
	}

	@Autowired
	private PasswordEncoder passwordEncoder;

	@PostMapping("/user")
	public String saveUser(@RequestBody User user) {
		if(userRepository.existsById(user.getUsername())) {
			return "User Already Exists!";
		}
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userService.saveUser(user);
		return "New User created with username: "+user.getUsername();
	}
	@GetMapping("/userexists/{username}")
	public boolean checkUserExits(@PathVariable(value="username") String username) {
		if(userRepository.existsByUsername(username))
			return true;
		else return false;
		
	}

	@GetMapping("/users/{id}")
	public User getUser(@PathVariable(value = "id") String id) {
		return userService.getUserById(id);
	}

	@PutMapping("/updateUser/{id}")
	public void updateUser(@RequestBody User user, @PathVariable(value = "id") String id) {
		userService.updateUser(user, id);
	}

	@GetMapping("/deleteuser/{id}")
	public String deleteUser(@PathVariable(value = "id") String id) {
		this.userService.deleteUserById(id);
		return "deleted";
	}

	@PutMapping("/confirmUser/{id}")
	public void confirmUser(@RequestBody User user, @PathVariable(value = "id") String id) {
		userService.confirmUser(user, id);
	}

}
