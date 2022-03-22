package com.xoriant.xorbankonline.model;

import com.xoriant.xorbankonline.enums.AccountType;

public class SavingAccount extends Account {
	
	public SavingAccount() {
		// TODO Auto-generated constructor stub
	}
	private static final double interestRate=5;
	private static final double minimumBalance=200;
	private static final int transactionsLimit=10;
	private static final double transactionAmountLimit=10000;

}
