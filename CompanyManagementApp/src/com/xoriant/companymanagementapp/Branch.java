package com.xoriant.companymanagementapp;

public class Branch {
	private BranchManager manager;
	private Address address;
	
	public Branch() {
	}
	
	public Branch(BranchManager manager, Address address) {
		super();
		this.manager = manager;
		this.address = address;
	}
	public BranchManager getManager() {
		return manager;
	}
	public void setManager(BranchManager manager) {
		this.manager = manager;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
}
