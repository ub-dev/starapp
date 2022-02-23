package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.demo.model.User;

public interface UserService {
	public void saveUser(User user);
	User getUserById(String id);
	void deleteUserById(String id);
	public void updateUser(User user,String id);
	public void confirmUser(User user,String id);
	
	public  Page<User> getDefaultUsers(int offset,int pageSize);
	public Page<User> getSortedUsers(int offset,int pageSize,String field,String sortDirection);

}
