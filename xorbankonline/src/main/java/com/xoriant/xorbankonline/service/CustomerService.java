package com.xoriant.xorbankonline.service;

import com.xoriant.xorbankonline.model.Account;
import com.xoriant.xorbankonline.model.Customer;

public interface CustomerService {

	public Customer getCustomerDetails(long userId);

	public Account getAccountDetails(long accountNumber);
}
