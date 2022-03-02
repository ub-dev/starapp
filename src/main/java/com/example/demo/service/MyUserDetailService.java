package com.example.demo.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
@Service
public class MyUserDetailService implements UserDetailsService{

	@Autowired
	UserRepository userRepository;

	@Override
	public MyUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = userRepository.findByUsername(username);
		user.orElseThrow(()-> new UsernameNotFoundException("Username: "+username+" was not found!"));
		return user.map(MyUserDetails::new).get();
	}

}
