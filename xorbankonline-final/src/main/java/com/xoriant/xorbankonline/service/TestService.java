package com.xoriant.xorbankonline.service;

import java.util.List;

import com.xoriant.xorbankonline.model.PersonInfo;
import com.xoriant.xorbankonline.model.User;

public interface TestService {
	public List<User> getUsers();
	public List<PersonInfo> getPersonInfo();
	public User getUser(String username,String password);
}
