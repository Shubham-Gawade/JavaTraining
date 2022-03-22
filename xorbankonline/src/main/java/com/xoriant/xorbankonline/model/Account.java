package com.xoriant.xorbankonline.model;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.xoriant.xorbankonline.enums.AccountType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Account {
	
	@Id
	@TableGenerator(name = "Account_Gen", table = "Account_ID_GEN", pkColumnName = "GEN_NAME", valueColumnName = "GEN_VAL", pkColumnValue = "Account_Gen", initialValue = 10000, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "Account_Gen")
	protected long accountNumber;
	@Enumerated(EnumType.STRING)
	protected AccountType accountType;
	protected double balance;
	
	//@ManyToOne(cascade = CascadeType.PERSIST)
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "branchId")
	protected Branch branch;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "account",fetch = FetchType.EAGER)
	protected List<Transactions> transactions=new ArrayList<Transactions>();
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name ="customerId")
	private Customer customer;
	
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
	
	public void addTransaction(Transactions transaction) {
		this.transactions.add(transaction);
	}

	public List<Transactions> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transactions> transactions) {
		this.transactions = transactions;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", accountType=" + accountType + ", balance=" + balance
				+ ", branch=" + branch + ", transactions=" + transactions + ", customer=" + customer + "]";
	}
	
	
}
