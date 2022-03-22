package com.xoriant.xorbankonline.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xoriant.xorbankonline.dao.CustomerDao;
import com.xoriant.xorbankonline.model.Account;
import com.xoriant.xorbankonline.model.Customer;
import com.xoriant.xorbankonline.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;
	
	@Override
	public Customer getCustomerDetails(long userId) {
		return customerDao.getCustomer(userId);
	}

	@Override
	public Account getAccountDetails(long accountNumber) {
		return customerDao.getAccount(accountNumber);
	}
	
}
