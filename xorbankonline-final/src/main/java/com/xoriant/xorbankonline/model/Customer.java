package com.xoriant.xorbankonline.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Customer extends PersonInfo {
	
//	@Override
//	public String toString() {
//		return "Customer [accounts=" + accounts + ", manager=" + manager + ", personId=" + personId + ", personName="
//				+ personName + ", gender=" + gender + ", dateOfBirth=" + dateOfBirth + ", emailId=" + emailId
//				+ ", mobileNo=" + mobileNo + ", address=" + address + ", user=" + user + "]";
//	}

	@OneToMany(cascade = CascadeType.ALL,mappedBy = "customer")
	private List<Account> accounts=new ArrayList<Account>();
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="managerId")
	private Manager manager;
	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void addAccount(Account account) {
		this.accounts.add(account);
	}


	
}
