package com.example.demo.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.model.User;


public class MyUserDetails implements UserDetails { // represents our current

	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private String status;
	private String role;


	@Override
	public String toString() {
		return "MyUserDetails [userId=" + username + ", password=" + password + ", isActive=" + status + ", role="
				+ role + ", user=" + user + ", authorities=" + authorities + "]";
	}

	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	private List<GrantedAuthority> authorities; // contains list of authorities granted for the current user of type Granted Authorities

	 public MyUserDetails(User user) {
		this.username = user.getUsername();
		this.password = user.getPassword();
		this.status=user.getStatus();
		this.setRole(user.getRole());
		this.user = user;
		this.authorities = Arrays.stream(user.getRole().split(",")).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}



	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public  String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String getUsername() {
		return username;
	}

}
