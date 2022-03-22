package com.xoriant.xorbankonline.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xoriant.xorbankonline.dao.CustomerDao;
import com.xoriant.xorbankonline.model.Account;
import com.xoriant.xorbankonline.model.BankTransaction;
import com.xoriant.xorbankonline.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	CustomerDao customerDao;

	@Override
	public List<Account> getAccountDetails(int id) {
		// TODO Auto-generated method stub
		return customerDao.getAccountDetails(id);
	}

	@Override
	public List<BankTransaction> getTransaction(int accountNumber) {
		// TODO Auto-generated method stub
		return customerDao.getTransaction(accountNumber);
	}

	@Override
	public List<BankTransaction> getTransactions() {
		// TODO Auto-generated method stub
		return customerDao.getTransactions();
	}

	@Override
	public List<BankTransaction> getMinistatement(int accountNumber) {
		// TODO Auto-generated method stub
		return customerDao.getMinistatement(accountNumber);
	}

}
