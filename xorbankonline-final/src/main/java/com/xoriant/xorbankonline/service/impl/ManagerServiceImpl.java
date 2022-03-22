package com.xoriant.xorbankonline.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xoriant.xorbankonline.dao.ManagerDao;
import com.xoriant.xorbankonline.model.Account;
import com.xoriant.xorbankonline.model.Customer;
import com.xoriant.xorbankonline.model.PersonInfo;
import com.xoriant.xorbankonline.service.ManagerService;
@Service
public class ManagerServiceImpl implements ManagerService {
	@Autowired
	public ManagerDao managerDao;

	@Override
	public List<PersonInfo> getCustomers(int id) {
		// TODO Auto-generated method stub
		return managerDao.getCustomers(id);
	}

	@Override
	public void addCustomer(Customer c) {
		// TODO Auto-generated method stub
		managerDao.addCustomer(c);
	}

	@Override
	public void addAccount(Account account,int id) {
		// TODO Auto-generated method stub
		managerDao.addAccount(account,id);
	}

	@Override
	public void deleteAccount(long accountNumber) {
		// TODO Auto-generated method stub
		managerDao.deleteAccount(accountNumber);
	}

	@Override
	public void deleteCustomer(int customerId) {
		// TODO Auto-generated method stub
		managerDao.deleteCustomer(customerId);
	}


}
