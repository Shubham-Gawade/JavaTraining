package com.xoriant.xorbankonline.service;

import java.util.List;

import com.xoriant.xorbankonline.model.Account;
import com.xoriant.xorbankonline.model.Branch;
import com.xoriant.xorbankonline.model.Customer;
import com.xoriant.xorbankonline.model.Manager;
import com.xoriant.xorbankonline.model.Transactions;

public interface ManagerService {

	public boolean addCustomer(Customer customer);

	public boolean addAccount(Account account);

	public List<Customer> getAllCustomerDetails();

	public Account getAccountDetails(long accountNumber);

	public Customer getCustomer(long customerId);

	public Manager getManagerDetails(long managerId);

	public Branch getBranch(long managerId);

	public boolean deleteAccount(long accountNumber);

	public boolean deleteCustomer(long customerId);

	public Account getAccount(long accountNumber);

	public boolean makeTransaction(Transactions transaction);
}
