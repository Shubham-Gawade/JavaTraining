package com.xoriant.companymanagementapp;

public class SalesPerson extends Employee{
	
	private double salesAchived;
	private double targetAmount;
	
	public SalesPerson() {
	}
	
	public SalesPerson(double salesAchived, double targetAmount) {
		super();
		this.salesAchived = salesAchived;
		this.targetAmount = targetAmount;
	}
	public double getSalesAchived() {
		return salesAchived;
	}
	public void setSalesAchived(double salesAchived) {
		this.salesAchived = salesAchived;
	}
	public double getTargetAmount() {
		return targetAmount;
	}
	public void setTargetAmount(double targetAmount) {
		this.targetAmount = targetAmount;
	}
	
	

}
