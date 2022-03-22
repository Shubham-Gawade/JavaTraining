package com.xoriant.companymanagementapp;

public class Employee extends Person implements SalaryCalculator{
	protected double basicSalary;
	protected int employeeId;
	protected Department department;
	protected int band;
	
	public Employee() {
	}
	
	public Employee(int employeeId, double basicSalary, Department department, int band) {
		super();
		this.basicSalary = basicSalary;
		this.employeeId = employeeId;
		this.department = department;
		this.band = band;
	}
	
	public double getBasicSalary() {
		return basicSalary;
	}
	public void setBasicSalary(double basicSalary) {
		this.basicSalary = basicSalary;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public int getBand() {
		return band;
	}
	public void setBand(int band) {
		this.band = band;
	}

	public double calculateSalary(Employee employee) {
		double salary=0;
		if(employee instanceof BranchManager) {
			BranchManager branchManager=(BranchManager)employee;
			double rateOfAllowance=employee.getBasicSalary()*Band.getPercentage(getBand())/100;
			salary=employee.getBasicSalary()+branchManager.getSpecialAllowance()+rateOfAllowance;
		}else if(employee instanceof SalesPerson) {
			SalesPerson salesPerson=(SalesPerson)employee;
			double rateOfAllowance=employee.getBasicSalary()*Band.getPercentage(getBand())/100;
			double incentives=(salesPerson.getTargetAmount()-salesPerson.getSalesAchived())*30/100;
			salary=employee.getBasicSalary()+rateOfAllowance+incentives;
		}else {
			double rateOfAllowance=employee.getBasicSalary()*Band.getPercentage(getBand())/100;
			salary=employee.getBasicSalary()+rateOfAllowance;
		}
		return salary;
	}

}
