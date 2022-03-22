package com.xoriant.hibernateapp.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserInfo {

	@Id
	private int userId;
	
	//@Transient -> Not save into Database
	//Make the static variable Not save into Database
	private String userName;

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

	@Override
	public String toString() {
		return "UserInfo [userId=" + userId + ", userName=" + userName + "]";
	}
}
