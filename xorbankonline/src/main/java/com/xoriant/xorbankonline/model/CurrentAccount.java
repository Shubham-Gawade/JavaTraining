package com.xoriant.xorbankonline.model;

import javax.persistence.Entity;

import com.xoriant.xorbankonline.enums.AccountType;

@Entity
public class CurrentAccount extends Account {
	private int transactionsLimit;
	private double minimumBalance;
	private double transactionAmountLimit;
	private AccountType accountType;

	public int getTransactionsLimit() {
		return transactionsLimit;
	}

	public void setTransactionsLimit(int transactionsLimit) {
		this.transactionsLimit = transactionsLimit;
	}

	public double getMinimumBalance() {
		return minimumBalance;
	}

	public void setMinimumBalance(double minimumBalance) {
		this.minimumBalance = minimumBalance;
	}

	public double getTransactionAmountLimit() {
		return transactionAmountLimit;
	}

	public void setTransactionAmountLimit(double transactionAmountLimit) {
		this.transactionAmountLimit = transactionAmountLimit;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

}
