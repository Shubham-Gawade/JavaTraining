package com.xoriant.hibernateapp.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserInfo {

	@Id
	private int userId;
	private String userName;
	
	//Do not create parameterized constructor
	//bcoz hibernate proxy design pattern
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
