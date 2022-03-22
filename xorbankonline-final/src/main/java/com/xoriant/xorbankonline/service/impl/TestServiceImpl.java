package com.xoriant.xorbankonline.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xoriant.xorbankonline.dao.TestDao;
import com.xoriant.xorbankonline.model.PersonInfo;
import com.xoriant.xorbankonline.model.User;
import com.xoriant.xorbankonline.service.TestService;

@Service
public class TestServiceImpl implements TestService {

	@Autowired
	TestDao testDao;
	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return testDao.getUsers();
		
	}
	public List<PersonInfo> getPersonInfo(){
		return testDao.getPersonInfo();
	}
	@Override
	public User getUser(String username, String password) {
		// TODO Auto-generated method stub
		return testDao.getUser(username, password);
	}
}
