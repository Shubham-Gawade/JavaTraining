package com.xoriant.springcoreapp.di.scope;

public class AccountFactory {

	private static Account account;
	
	public static Account getAccountSingleton() {
		if(account==null) {
			account= new Account();
			account.setAccountName("Shubham");
		}	
		return account;
	}
	
	public static Account getAccountPrototype() {
		return new Account(1234,"Shubham",200);
	}
}
