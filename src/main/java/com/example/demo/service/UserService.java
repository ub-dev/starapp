package com.example.demo.service;

import java.util.List;

import com.example.demo.model.User;

public interface UserService {
	public void saveUser(User user);
	User getUserById(String id);
	void deleteUserById(String id);
	public void updateUser(User user,String id);
	public void confirmUser(User user,String id);

	public  List<User> getDefaultUsers();
	public List<User> getSortedUsers(String field,String sortDirection);

}
