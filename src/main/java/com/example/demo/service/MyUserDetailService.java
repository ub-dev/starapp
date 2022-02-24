package com.example.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

import java.util.Optional;
@Service //lets spring know this service exists and autowires it to the security configuration
public class MyUserDetailService implements UserDetailsService{

	@Autowired
	UserRepository userRepository;
	

	//when authentication takes place spring will call this service and return the user details using this method 
	@Override
	public MyUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = userRepository.findByUsername(username);
		user.orElseThrow(()-> new UsernameNotFoundException("Username: "+username+" was not found!"));	
		return user.map(MyUserDetails::new).get();
	}

}
