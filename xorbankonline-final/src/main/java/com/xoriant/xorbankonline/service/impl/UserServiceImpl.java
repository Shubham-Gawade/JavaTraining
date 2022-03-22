package com.xoriant.xorbankonline.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xoriant.xorbankonline.dao.UserDao;
import com.xoriant.xorbankonline.model.BankTransaction;
import com.xoriant.xorbankonline.model.PersonInfo;
import com.xoriant.xorbankonline.model.User;
import com.xoriant.xorbankonline.model.UserDetailsDTO;
import com.xoriant.xorbankonline.service.UserService;


@Service
public class UserServiceImpl implements UserService {
	@Autowired
	public UserDao userDao;

	@Override
	public User checkUser(String username,String password) {
		// TODO Auto-generated method stub
		return userDao.checkUser(username,password);
	}

	@Override
	public UserDetailsDTO getUserDetails(int id) {
		// TODO Auto-generated method stub
		return userDao.getUserDetails(id);
	}

	@Override
	public User getUser(int id) {
		// TODO Auto-generated method stub
		return userDao.getUser(id);
	}

	@Override
	public PersonInfo getallDetails(int id) {
		// TODO Auto-generated method stub
		return userDao.getallDetails(id);
	}

	@Override
	public void updateDetails(PersonInfo info,int id) {
		// TODO Auto-generated method stub
		 userDao.updateDetails(info,id);
	}

	@Override
	public String transact(BankTransaction bankTransaction, long senderAccountNumber, long receiverAccountNumber) {
		// TODO Auto-generated method stub
		return userDao.transact(bankTransaction,senderAccountNumber,receiverAccountNumber);
	}

	
}
