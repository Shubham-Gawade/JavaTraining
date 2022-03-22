package com.xoriant.hibernateapp.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;

@Entity
//Case Sensitive
@NamedQuery(name = "findUserInfoById", query = "from UserInfo where userId=:userId")

//Case insensitive
@NamedNativeQuery(name ="findUserInfoByName", query = "select * from userinfo where userName=:userName", resultClass = UserInfo.class)
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
