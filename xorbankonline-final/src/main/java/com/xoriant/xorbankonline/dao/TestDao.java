package com.xoriant.xorbankonline.dao;

import java.util.List;

import com.xoriant.xorbankonline.model.PersonInfo;
import com.xoriant.xorbankonline.model.User;

public interface TestDao {
	public List<User> getUsers();
	public List<PersonInfo> getPersonInfo();
	public User getUser(String username,String password);
}
