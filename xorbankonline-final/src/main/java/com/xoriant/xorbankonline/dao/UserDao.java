package com.xoriant.xorbankonline.dao;

import java.util.List;
import java.util.Map;

import com.xoriant.xorbankonline.model.BankTransaction;
import com.xoriant.xorbankonline.model.PersonInfo;
import com.xoriant.xorbankonline.model.User;
import com.xoriant.xorbankonline.model.UserDetailsDTO;


public interface UserDao {

	public User checkUser(String username,String password);

	public UserDetailsDTO getUserDetails(int id);

	public User getUser(int id);

	PersonInfo getallDetails(int id);

	public void updateDetails(PersonInfo info,int id);

	public String transact(BankTransaction bankTransaction, long senderAccountNumber, long receiverAccountNumber);

	
	
}
