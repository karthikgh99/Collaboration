package com.coll.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="userdata")
public class User {

	@Column(nullable=false, unique=true)
	private String username;
	
	@Column(nullable=false)
	private String name;
	
	@Column(nullable=false)
	private String password;
	
	@Id
	@Column
	private String emailid;
	
	@Column
	private String role;
	
	@Column
	private String status;
	
	@Column
	private boolean isonline;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isIsonline() {
		return isonline;
	}

	public void setIsonline(boolean isonline) {
		this.isonline = isonline;
	}

	
}