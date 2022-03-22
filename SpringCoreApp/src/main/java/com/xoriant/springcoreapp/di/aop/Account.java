package com.xoriant.springcoreapp.di.aop;


public class Account {
	
	private Integer accountNumber;
	private String accountName;
	private Double balance;
	private Address address;
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Account(int accountNumber, String accountName, double balance) {
		super();
		this.accountNumber = accountNumber;
		this.accountName = accountName;
		this.balance = balance;
	}
	
	public Account(int accountNumber, String accountName, double balance, Address address) {
		super();
		this.accountNumber = accountNumber;
		this.accountName = accountName;
		this.balance = balance;
		this.address = address;
	}
	public Integer getAccountNumber() {
		System.out.println("Get Account Number Inside");
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountName() {
		System.out.println("Get Account Name Inside");
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	@MyAnnotation
	public Double getBalance() {
		System.out.println("Get Balance Inside");
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public Integer getSomeMehtod() {
		System.out.println("Some method internal");
		int i=10,j=0;
		int k=i/j;
		return 10;
	}
	
	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", accountName=" + accountName + ", balance=" + balance
				+ ", address=" + address + "]";
	}
	

}
