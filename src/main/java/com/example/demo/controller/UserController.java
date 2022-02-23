package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/userapi")
public class UserController {
	
	@Autowired
	private UserService userService;
	
@GetMapping("/get/{offset}/{PageSize}")
	public Page<User> getUsers(@PathVariable(value="offset") int offset,@PathVariable(value="PageSize") int PageSize){
	//System.out.println("i'm here");
	Page<User> list=userService.getDefaultUsers(offset,PageSize);
	      return list;
}

@GetMapping("/get/{offset}/{PageSize}/{field}/{sortingDirection}")
public Page<User> getSortedUsers(@PathVariable(value="offset") int offset,@PathVariable(value="PageSize") int PageSize,@PathVariable(value="field") String field ,@PathVariable(value="sortingDirection") String sortingDirection){
//System.out.println("i'm here");
Page<User> list=userService.getSortedUsers(offset,PageSize,field,sortingDirection);
      return list;
}
	

			
@PostMapping("/user")
public void saveUser(@RequestBody User user)
{
	System.out.println("save in controller");
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
