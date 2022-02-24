package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/userapi")
public class UserController {

	@Autowired
	private UserService userService;
	//@Autowired
	//private AllowanceService allowanceService;


@GetMapping("/get")
	public List<User> getUsers(){
	System.out.println("i'm here");
	List<User> list=userService.getDefaultUsers();
	      return list;
}

@GetMapping("/get/{field}/{sortingDirection}")
public List<User> getSortedUsers(@PathVariable(value="field") String field ,@PathVariable(value="sortingDirection") String sortingDirection){
//System.out.println("i'm here");
List<User> list=userService.getSortedUsers(field,sortingDirection);
      return list;
}

@Autowired
private PasswordEncoder	passwordEncoder	;
@PostMapping("/user")
public void saveUser(@RequestBody User user)
{
	System.out.println("save in controller");
	System.out.println(user.getPassword());

	user.setPassword(passwordEncoder.encode(user.getPassword()));
	System.out.println(user.getPassword());
	userService.saveUser(user);
	}


@GetMapping("/users/{id}")
public User getUser(@PathVariable(value="id") String id)
{
	System.out.println("getting by id");
	return userService.getUserById(id);
}


@PutMapping("/user/{id}")
public void updateUser(@RequestBody User user,@PathVariable(value="id") String id)
{
	System.out.println("update in controller");
	userService.updateUser(user,id);
	}


@GetMapping("/deleteuser/{id}")
public String deleteUser(@PathVariable(value="id") String id)
{
	System.out.println("controller call");
	 this.userService.deleteUserById(id);
           return "deleted";
}


@PutMapping("/confirmUser/{id}")
public void confirmUser(@RequestBody User user,@PathVariable(value="id") String id)
{
	System.out.println("update in controller");
	userService.confirmUser(user,id);
	}


}
