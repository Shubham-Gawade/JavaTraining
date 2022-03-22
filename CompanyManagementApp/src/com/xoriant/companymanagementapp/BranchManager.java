package com.xoriant.companymanagementapp;

public class BranchManager extends Employee{
	private double specialAllowance;

	public BranchManager() {
	}

	public BranchManager(double specialAllowance) {
		super();
		this.specialAllowance = specialAllowance;
	}

	public double getSpecialAllowance() {
		return specialAllowance;
	}

	public void setSpecialAllowance(double specialAllowance) {
		this.specialAllowance = specialAllowance;
	}
	
}
