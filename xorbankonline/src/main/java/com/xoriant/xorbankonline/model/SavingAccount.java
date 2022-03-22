package com.xoriant.xorbankonline.model;

import javax.persistence.Entity;

import com.xoriant.xorbankonline.enums.AccountType;

@Entity
public class SavingAccount extends Account {
	private double interestRate;
	private double minimumBalance;
	private int transactionsLimit;
	private double transactionAmountLimit;
	private AccountType accountType;

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public double getMinimumBalance() {
		return minimumBalance;
	}

	public void setMinimumBalance(double minimumBalance) {
		this.minimumBalance = minimumBalance;
	}

	public int getTransactionsLimit() {
		return transactionsLimit;
	}

	public void setTransactionsLimit(int transactionsLimit) {
		this.transactionsLimit = transactionsLimit;
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
