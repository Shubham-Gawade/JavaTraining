package com.xoriant.xorbankonline.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.xoriant.xorbankonline.enums.Gender;
@Entity
@Table(name="manager")
public class Manager extends PersonInfo {
	@Override
	public String toString() {
		return "Manager [branch=" + branch + ", customers=" + customers + ", personId=" + personId + ", personName="
				+ personName + ", gender=" + gender + ", dateOfBirth=" + dateOfBirth + ", emailId=" + emailId
				+ ", mobileNo=" + mobileNo + ", address=" + address + ", user=" + user + "]";
	}
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "branchId")
	private Branch branch;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "manager")
	private List<Customer> customers=new ArrayList<Customer>();

	public Manager() {
		
	}

	public Branch getBranch() {
		return branch;
	}
	public void setBranch(Branch branch) {
		this.branch = branch;
	}
	public List<Customer> getCustomers() {
		return customers;
	}
	public void addCustomer(Customer customer) {
		this.customers.add(customer);
	}
}
