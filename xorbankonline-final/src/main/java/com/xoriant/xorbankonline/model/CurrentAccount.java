package com.xoriant.xorbankonline.model;

import com.xoriant.xorbankonline.enums.AccountType;

public class CurrentAccount extends Account {
//	public CurrentAccount(long accountNumber, AccountType accountType, double balance, Branch branch) {
//		super(accountNumber, accountType, balance, branch);
//		
//	}
	public CurrentAccount() {
		super();
		// TODO Auto-generated constructor stub
	}
	private static final int transactionsLimit=5;
	private static final double minimumBalance=500;
	private static final double transactionAmountLimit=5000;
	
	

}
