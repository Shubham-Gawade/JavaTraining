package com.xoriant.companymanagementapp;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.List;

public class Company {
	private List<Employee> employees=new ArrayList<>();
	private List<Branch> branches=new ArrayList<>();
	private List<Customer> customers=new ArrayList<>();
	private Branch corporateBranch;
	private Branch registerdBranch;
	private String companyName;
	private LocalDate dateOfIncorporation;
	
	
	public Company(List<Employee> employees, List<Branch> branches, Branch corporateBranch, Branch registerdBranch,
			String companyName, LocalDate dateOfIncorporation) {
		super();
		this.employees = employees;
		this.branches = branches;
		this.corporateBranch = corporateBranch;
		this.registerdBranch = registerdBranch;
		this.companyName = companyName;
		this.dateOfIncorporation = dateOfIncorporation;
	}


	public Company() {
		
	}


	public List<Employee> getEmployees() {
		return employees;
	}


	public void setEmployee(Employee employee) {
		this.employees.add(employee);
	}


	public List<Branch> getBranches() {
		return branches;
	}


	public void setCustomer(Customer customer) {
		this.customers.add(customer);
	}
	
	public List<Customer> getCustomers() {
		return customers;
	}


	public void setBranch(Branch branch) {
		this.branches.add(branch);
	}


	public Branch getCorporateBranch() {
		return corporateBranch;
	}


	public void setCorporateBranch(Branch corporateBranch) {
		this.corporateBranch = corporateBranch;
	}


	public Branch getRegisterdBranch() {
		return registerdBranch;
	}


	public void setRegisterdBranch(Branch registerdBranch) {
		this.registerdBranch = registerdBranch;
	}


	public String getCompanyName() {
		return companyName;
	}


	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}


	public LocalDate getDateOfIncorporation() {
		return dateOfIncorporation;
	}


	public void setDateOfIncorporation(LocalDate dateOfIncorporation) {
		this.dateOfIncorporation = dateOfIncorporation;
	}
	
	public int numberOfEmployees() {
		return employees.size();
	}
	
	public int numberOfCustomers() {
		return customers.size();
	}
	
	public void findEmployeeById(int id) {
		int flag=0;
		for(Employee employee: employees) {
			if(employee.getEmployeeId()==id) {
				System.out.println("Employee Name: "+employee.getName());
				System.out.println("Employee Age: "+employee.getAge());
				System.out.println("Employee Basic Salary "+employee.getBasicSalary());
				System.out.println("Employee Door No: "+employee.getAddress().getDoorNo());
				System.out.println("Employee Street Name: "+employee.getAddress().getStreetName());
				System.out.println("Employee City: "+employee.getAddress().getCity());
				System.out.println("Employee Department: "+employee.getDepartment().getDepartmentName());

				if(employee instanceof BranchManager) {
					BranchManager branchManager=(BranchManager)employee;
					System.out.println("Employee Special Allowance: "+branchManager.getSpecialAllowance());
				}else if(employee instanceof SalesPerson) {
					SalesPerson salesPerson=(SalesPerson)employee;
					System.out.println("Employee Sales Achived: "+salesPerson.getSalesAchived());
					System.out.println("Employee Target Amount: "+salesPerson.getTargetAmount());
				}
				flag = 1;
				break;
			}else {
				flag = 0;
			}
		}
		if(flag==0)
			System.out.println("Employee Not Found!!");
	}
	
	public void findCustomerById(int id) {
		int flag=0;
		for(Customer customer: customers) {
			if(customer.getCustomerId()==id) {
				System.out.println("Customer Name: "+customer.getName());
				System.out.println("Customer Age: "+customer.getAge());
				System.out.println("Customer Door No: "+customer.getAddress().getDoorNo());
				System.out.println("Customer Street Name: "+customer.getAddress().getStreetName());
				System.out.println("Customer City: "+customer.getAddress().getCity());
				System.out.println("Customer Date Of Membership: "+customer.getDateOfMemberShip());
				
				if(customer instanceof RegisteredCustomer) {
					RegisteredCustomer registeredCustomer=(RegisteredCustomer)customer;
					System.out.println("Customer Registration Fees: "+registeredCustomer.getRegdFees());
					System.out.println("Customer Date Of Registration: "+registeredCustomer.getDateOfRegistration());
					System.out.println("Customer PrivilegeType: "+PrivilegeType.getPrivilegeTypeName(registeredCustomer.getPrivilegeType()));
				}
				flag = 1;
				break;
			}else {
				flag = 0;
			}
		}
		if(flag==0)
			System.out.println("Employee Not Found!!");
	}
	
	public double getTotalSalaryOfEmployees() {
		double totalSalary=0;
		for(Employee employee: employees) {
			totalSalary+=employee.calculateSalary(employee);
		}
		return totalSalary;
	}
	
	public double getTotalRegistrationFee() {
		double totalRegistrationFee=0;
		for(Customer customer: customers) {
			if(customer instanceof RegisteredCustomer) {
				RegisteredCustomer registeredCustomer=(RegisteredCustomer)customer;
				totalRegistrationFee+=registeredCustomer.getRegdFees();
			}
		}
		return totalRegistrationFee;
	}
}
