package com.xoriant.springcoreapp.di.collection;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Account {

	private int accountNumber;
	private String accountName;
	private double balance;
	private List<Address> address;
	private Set<String> nominees;
	private Map<Integer,Double> transactionMap;

	public Account() {

	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public Set<String> getNominees() {
		return nominees;
	}

	public void setNominees(Set<String> nominees) {
		this.nominees = nominees;
	}
	
	

	public Map<Integer, Double> getTransactionMap() {
		return transactionMap;
	}

	public void setTransactionMap(Map<Integer, Double> transactionMap) {
		this.transactionMap = transactionMap;
	}

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", accountName=" + accountName + ", balance=" + balance
				+ ", address=" + address + ", nominees=" + nominees + ", transactionMap=" + transactionMap + "]";
	}
}
