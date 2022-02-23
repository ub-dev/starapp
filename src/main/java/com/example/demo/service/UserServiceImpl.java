package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	
	@Override
	public void saveUser(User user) {
		System.out.println("saving in service");
		this.userRepository.save(user);
	}

	@Override
	public User getUserById(String id) {
		Optional<User> optional=userRepository.findById(id);
		User user=null;
		if(optional.isPresent())
		{
			user=optional.get();
		}
		return user;
		}

	@Override
	public void deleteUserById(String id) {
		System.out.println("deleted");
		this.userRepository.deleteById(id);
	}

	@Override
	public void updateUser(User newuser,String id) {
		System.out.println("update in service");
	Optional<User> optional=userRepository.findById(id);	
	User user=null;
	if(optional.isPresent())
	{
	   	user=optional.get();
	   	user.setName(newuser.getName());
		user.setRole(newuser.getRole());
		user.setStatus("Active");
		userRepository.save(user);
	}
		
	}

		

	@Override
	public Page<User> getDefaultUsers(int offset, int pageSize) {
		Page<User> list=userRepository.findAll(PageRequest.of(offset, pageSize));
        return list;
	}

	@Override
	public Page<User> getSortedUsers(int offset, int pageSize, String field,String sortDirection) {
		Sort sort=sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(field).ascending():Sort.by(field).descending();
		Pageable pageable=PageRequest.of(offset, pageSize,sort);
		return this.userRepository.findAll(pageable);
		
	}

	@Override
	public void confirmUser(User newuser, String id) {
		Optional<User> optional=userRepository.findById(id);	
		User user=null;
		if(optional.isPresent())
		{
		   	user=optional.get();
		   	user.setName(newuser.getName());
			user.setRole(newuser.getRole());
			user.setStatus("Inactive");
			userRepository.save(user);
		}

	}
	
}
