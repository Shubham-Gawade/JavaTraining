package com.xoriant.springcoreapp.di.annotation;

import java.sql.Connection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
public class Account {
	
	private int accountNumber;
	private String accountName;
	private double balance;
	@Autowired
	private Address address;
	@Autowired(required = false)
	private Connection connection;
	
	@Autowired
	private MessageSource messageSource;
	
	
	
	
	public MessageSource getMessageSource() {
		return messageSource;
	}
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	public Account(int accountNumber, String accountName, double balance, Address address, Connection connection) {
		super();
		this.accountNumber = accountNumber;
		this.accountName = accountName;
		this.balance = balance;
		this.address = address;
		this.connection = connection;
	}
	public Account(Address address, Connection connection) {
		super();
		this.address = address;
		this.connection = connection;
	}
	public Connection getConnection() {
		return connection;
	}
	public void setConnection(Connection connection) {
		System.out.println("Connection setter method called");
		this.connection = connection;
	}
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
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		System.out.println("Address Setter method called");
		this.address = address;
	}
	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", accountName=" + accountName + ", balance=" + balance
				+ ", address=" + address + "]";
	}
	
	public void displayMessage() {
		
		System.out.println(messageSource.getMessage("mysql.driver", null, "default message", null));
	}

}