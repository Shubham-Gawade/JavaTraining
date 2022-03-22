package com.xoriant.xorbankonline.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@PrimaryKeyJoinColumn(name = "customerId")
public class Customer extends PersonInfo {
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customer",fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	private List<Account> accounts=new ArrayList<Account>();

	public void addAccount(Account account) {
		this.accounts.add(account);
	}
	
	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
}
