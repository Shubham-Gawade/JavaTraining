package com.xoriant.xorbankonline.service;

import java.util.List;

import com.xoriant.xorbankonline.model.Account;
import com.xoriant.xorbankonline.model.BankTransaction;

public interface CustomerService {

	List<Account> getAccountDetails(int id);

	List<BankTransaction> getTransaction(int accountNumber);

	List<BankTransaction> getTransactions();

	List<BankTransaction> getMinistatement(int accountNumber);

}
