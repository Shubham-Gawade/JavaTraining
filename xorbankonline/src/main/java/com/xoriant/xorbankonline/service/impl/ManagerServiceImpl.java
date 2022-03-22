package com.xoriant.xorbankonline.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xoriant.xorbankonline.dao.ManagerDao;
import com.xoriant.xorbankonline.model.Account;
import com.xoriant.xorbankonline.model.Branch;
import com.xoriant.xorbankonline.model.Customer;
import com.xoriant.xorbankonline.model.Manager;
import com.xoriant.xorbankonline.model.Transactions;
import com.xoriant.xorbankonline.service.ManagerService;

@Service
public class ManagerServiceImpl implements ManagerService {

	@Autowired
	private ManagerDao managerDao;
	
	@Override
	public boolean addCustomer(Customer customer) {	
		return managerDao.addCustomer(customer);
	}

	@Override
	public boolean addAccount(Account account) {
		return managerDao.addAccount(account);
	}

	@Override
	public List<Customer> getAllCustomerDetails() {
		return managerDao.getAllCustomerDetails();
	}

	@Override
	public Account getAccountDetails(long accountNumber) {
		return managerDao.getAccountDetails(accountNumber);
	}

	@Override
	public Customer getCustomer(long customerId) {
		return managerDao.getCustomer(customerId);
	}

	@Override
	public Manager getManagerDetails(long managerId) {
		return managerDao.getManagerDetails(managerId);
	}

	@Override
	public Branch getBranch(long managerId) {
		return managerDao.getBranch(managerId);
	}

	@Override
	public boolean deleteAccount(long accountNumber) {
		return managerDao.deleteAccount(accountNumber);
	}

	@Override
	public boolean deleteCustomer(long customerId) {
		return managerDao.deleteCustomer(customerId);
	}

	@Override
	public Account getAccount(long accountNumber) {
		return managerDao.getAccount(accountNumber);
	}

	@Override
	public boolean makeTransaction(Transactions transaction) {
		return managerDao.makeTransaction(transaction);
	}
}
