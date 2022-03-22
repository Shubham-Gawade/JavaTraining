package com.xoriant.xorbankonline.service;

import java.util.List;

import com.xoriant.xorbankonline.model.Account;
import com.xoriant.xorbankonline.model.Customer;
import com.xoriant.xorbankonline.model.PersonInfo;

public interface ManagerService {

	List<PersonInfo> getCustomers(int id);

	void addCustomer(Customer c);

	void addAccount(Account account,int id);

	void deleteAccount(long accountNumber);

	void deleteCustomer(int customerId);
	
}
