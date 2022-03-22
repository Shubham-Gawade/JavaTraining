package com.xoriant.springbootappclientapp.model;

public class Employee {

	private int employeeId;
	private String employeeName;
	private double salary;
	//private Department dept;

	public Employee() {

	}

	public Employee(int employeeId, String employeeName, double salary) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.salary = salary;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "{\"employeeId\":\"" + employeeId + "\", \"employeeName\":\"" + employeeName + "\", \"salary\":\""
				+ salary + "\"}";
	}

}
