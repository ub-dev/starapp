package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
	public List<User> getDefaultUsers() {
		List<User> list=userRepository.findAll();
        return list;
	}

	@Override
	public List<User> getSortedUsers(String field,String sortDirection) {
		Sort sort=sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(field).ascending():Sort.by(field).descending();
		return this.userRepository.findAll(sort);

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
