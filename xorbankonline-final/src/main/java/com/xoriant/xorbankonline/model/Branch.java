package com.xoriant.xorbankonline.model;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Branch {
	@Override
	public String toString() {
		return "Branch [branchId=" + branchId + ", branchName=" + branchName + ", ifscCode=" + ifscCode + ", micrCode="
				+ micrCode + ", address=" + address + "]";
	}
	@Id
	private long branchId;
	private String branchName;
	private String ifscCode;
	private String micrCode;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "addressId")
	public Address address;
	

	public Branch() {
		
	}

//	public void addManager(Manager manager) {
//	this.manager=manager;
//	}
	public long getBranchId() {
		return branchId;
	}
	public void setBranchId(long branchId) {
		this.branchId = branchId;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getIfscCode() {
		return ifscCode;
	}
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
	public String getMicrCode() {
		return micrCode;
	}
	public void setMicrCode(String micrCode) {
		this.micrCode = micrCode;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
}
