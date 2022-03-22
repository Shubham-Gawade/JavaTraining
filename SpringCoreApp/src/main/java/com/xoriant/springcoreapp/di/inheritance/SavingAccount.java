package com.xoriant.springcoreapp.di.inheritance;

public class SavingAccount extends Account {

	private String accountType;

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	@Override
	public String toString() {
		return "SavingAccount [accountType=" + accountType + ", accountNumber=" + accountNumber + ", accountName="
				+ accountName + ", balance=" + balance + ", address=" + address + ", nominees=" + nominees + "]";
	}

}
