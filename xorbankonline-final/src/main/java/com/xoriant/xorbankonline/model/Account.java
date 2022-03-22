package com.xoriant.xorbankonline.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.xoriant.xorbankonline.enums.AccountType;
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Account {
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="customerId")
	protected Customer customer;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected long accountNumber;
	@Override
	public String toString() {
		return "Account [customer=" + customer + ", accountNumber=" + accountNumber + ", accountType=" + accountType
				+ ", balance=" + balance  + "]";
	}
	@Enumerated(EnumType.STRING)
	protected AccountType accountType;
	protected double balance;
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "branchId")
	protected Branch branch;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "account")
	protected List<BankTransaction> bankTransactions=new ArrayList<BankTransaction>();
	
	public List<BankTransaction> getBankTransactions() {
		return bankTransactions;
	}
	public void addBankTransactions(BankTransaction bankTransactions) {
		this.bankTransactions.add(bankTransactions);
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

//	public Account(long accountNumber, AccountType accountType, double balance, Branch branch) {
//		super();
//		this.accountNumber = accountNumber;
//		this.accountType = accountType;
//		this.balance = balance;
//		this.branch = branch;
//	}

	public Account() {
		// TODO Auto-generated constructor stub
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public AccountType getAccountType() {
		return accountType;
	}
	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Branch getBranch() {
		return branch;
	}
	public void setBranch(Branch branch) {
		this.branch = branch;
	}
//	public List<Transaction> getTransactions() {
//		return transactions;
//	}
//	public void addTransactions(Transaction transaction) {
//		this.transactions.add(transaction);
//	} 
}
