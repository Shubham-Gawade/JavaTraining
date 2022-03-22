package com.xoriant.springcoreapp.di.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Account implements ApplicationContextAware, BeanNameAware, InitializingBean, DisposableBean {

	private int accountNumber;
	private String accountName;
	private double balance;
	private Address address;
	private ApplicationContext context;
	private String beanName;

	public Account() {

	}

	public Account(int accountNumber, String accountName, double balance) {
		super();
		this.accountNumber = accountNumber;
		this.accountName = accountName;
		this.balance = balance;
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
		System.out.println("Account Number setter called");
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
		this.address = address;
	}

	public void manupulate() {
		Account account = (Account) context.getBean(beanName);
		System.out.println(account);
	}

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", accountName=" + accountName + ", balance=" + balance
				+ ", address=" + address + "]";
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("Application Context Called");
		context = applicationContext;
		System.out.println(context);
	}

	@Override
	public void setBeanName(String name) {
		this.beanName = name;
		System.out.println("Bean name aware called " + name);
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Destroy method called");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("After Property set method called");
	}

	public void myCustomInit() throws Exception {
		System.out.println("MyCustomInit method called");
		accountNumber=1002220;
	}

	public void myCustomDestroy() throws Exception {
		System.out.println("MyCustomDestroy method called");
	}
}
