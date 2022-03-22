package com.xoriant.xorbankonline.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xoriant.xorbankonline.dao.UserDao;
import com.xoriant.xorbankonline.model.User;
import com.xoriant.xorbankonline.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public User getUser(String userName, String password) {
		return userDao.getUser(userName,password);
	}
	
}
