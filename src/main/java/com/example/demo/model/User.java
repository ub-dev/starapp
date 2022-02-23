package com.example.demo.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.Base64;

@Entity
@Table(name="users")
public class User {
	@Override
	public String toString() {
		return "User [id=" + username + ", name=" + name + ", password=" + password + ", status=" + status + ", role=" + role
				+ ", activeFrom=" + activeFrom + "]";
	}
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String username;
	@Column(name="name")
	private String name;
	
	private String password;
	private String status;
	private String role;
	private LocalDateTime activeFrom;
	public LocalDateTime getActiveFrom() {
		return activeFrom;
	}
	public void setActiveFrom(LocalDateTime activeFrom) {
		this.activeFrom = activeFrom;
	}
	public String getPassword() {
		return new String(Base64.getDecoder().decode(password));
	}
	public void setPassword(String password) {
		this.password = new String(Base64.getEncoder().encode((password).getBytes()));
	}
	public void setRole(String role) {
		this.role = role;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public String getRole() {
		return role;
	}
	public User()
	{
		
	}
	public String getStatus() {
		return status;
	}
	public User( String id,String name, String password, String role, String status,LocalDateTime activeFrom) {
		super();
		this.username=id;
		this.name = name;
		this.password = password;
		this.role = role;
		this.status=status;
		this.activeFrom = activeFrom;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
