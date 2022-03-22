package com.xoriant.springcoreapp.di.inheritance;

import java.util.List;
import java.util.Set;

public class Account {

	protected int accountNumber;
	protected String accountName;
	protected double balance;
	protected List<Address> address;
	protected Set<String> nominees;

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

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", accountName=" + accountName + ", balance=" + balance
				+ ", address=" + address + ", nominees=" + nominees + "]";
	}

}
