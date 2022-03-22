package com.xoriant.xorbankonline.dao;

import com.xoriant.xorbankonline.model.Account;
import com.xoriant.xorbankonline.model.Customer;

public interface CustomerDao {

	public Customer getCustomer(long userId);

	public Account getAccount(long accountNumber);

}
