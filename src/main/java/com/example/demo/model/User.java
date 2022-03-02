package com.example.demo.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {
	@Override
	public String toString() {
		return "User [id=" + username + ", name=" + name + ", password=" + password + ", status=" + status + ", role=" + role
				+ ", activeFrom=" + activeFrom + "]";
	}
	@Id
	private String username;
	@Column(name="name")
	private String name;
	
	private String password;
	private String status;
	private String role;
	private LocalDate activeFrom;
	public LocalDate getActiveFrom() {
		return activeFrom;
	}
	public void setActiveFrom(LocalDate activeFrom) {
		this.activeFrom = activeFrom;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public User( String id,String name, String password, String role, String status,LocalDate activeFrom) {
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
