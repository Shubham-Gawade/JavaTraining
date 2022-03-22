package com.xoriant.companymanagementapp;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) 
	{
		Department department1=new Department(101,"Developer");
		Department department2=new Department(102,"Tester");
		Department department3=new Department(103,"Sales");
		
		Employee employee1=new Employee();
		employee1.setEmployeeId(11111);
		employee1.setName("Shubham");
		employee1.setAge(21);
		Address address1=new Address(30,"VimanNagar","Pune");
		employee1.setAddress(address1);
		employee1.setBasicSalary(12000.5);
		employee1.setDepartment(department1);
		employee1.setBand(3);
		
		Employee employee2=new Employee();
		employee2.setEmployeeId(11112);
		employee2.setName("Pranav");
		employee2.setAge(21);
		Address address2=new Address(12,"KoregaonPark","Pune");
		employee2.setAddress(address2);
		employee2.setBasicSalary(11000.5);
		employee2.setDepartment(department2);
		employee2.setBand(2);
		
		BranchManager branchManager1=new BranchManager();
		branchManager1.setEmployeeId(11113);
		branchManager1.setName("Sanket");
		branchManager1.setAge(21);
		Address address3=new Address(14,"Hadpsar","Pune");
		branchManager1.setAddress(address3);
		branchManager1.setBasicSalary(15000.5);
		branchManager1.setDepartment(department1);
		branchManager1.setSpecialAllowance(1000.0);
		branchManager1.setBand(6);
		
		BranchManager branchManager2=new BranchManager();
		branchManager2.setEmployeeId(11114);
		branchManager2.setName("Stephen");
		branchManager2.setAge(21);
		Address address4=new Address(10,"Kharadi","Pune");
		branchManager2.setAddress(address4);
		branchManager2.setBasicSalary(14000.5);
		branchManager2.setDepartment(department2);
		branchManager2.setSpecialAllowance(1000.0);
		branchManager2.setBand(8);
		
		SalesPerson salesPerson1=new SalesPerson();
		salesPerson1.setEmployeeId(11115);
		salesPerson1.setName("Saurabh");
		salesPerson1.setAge(21);
		Address address5=new Address(10,"Khadki","Pune");
		salesPerson1.setAddress(address5);
		salesPerson1.setBasicSalary(9000.5);
		salesPerson1.setDepartment(department3);
		salesPerson1.setSalesAchived(20000.0);
		salesPerson1.setTargetAmount(30000.0);
		salesPerson1.setBand(1);
		
		SalesPerson salesPerson2=new SalesPerson();
		salesPerson2.setEmployeeId(11116);
		salesPerson2.setName("Manali");
		salesPerson2.setAge(21);
		Address address6=new Address(45,"Camp","Pune");
		salesPerson2.setAddress(address6);
		salesPerson2.setBasicSalary(9000.5);
		salesPerson2.setDepartment(department3);
		salesPerson2.setSalesAchived(15000.0);
		salesPerson2.setTargetAmount(20000.0);
		salesPerson2.setBand(2);
		
		Address address7=new Address(9,"Baner","Pune");
		Branch branch1=new Branch(branchManager1,address7);
		
		Address address8=new Address(8,"Hinjewadi","Pune");
		Branch branch2=new Branch(branchManager1,address8);
		
		Customer customer1=new Customer();
		customer1.setCustomerId(11117);
		customer1.setName("Vedant");
		customer1.setAge(22);
		Address address9=new Address(23,"Pimpri","Pune");
		customer1.setAddress(address9);
		LocalDate date1=LocalDate.of(2021, 3, 4);
		customer1.setDateOfMemberShip(date1);
		
		RegisteredCustomer customer2=new RegisteredCustomer();
		customer2.setCustomerId(11118);
		customer2.setName("Abhishek");
		customer2.setAge(22);
		Address address10=new Address(21,"Nigdi","Pune");
		customer2.setAddress(address10);
		LocalDate date2=LocalDate.of(2021, 3, 4);
		customer2.setDateOfMemberShip(date2);  
		LocalDate date3=LocalDate.of(2021, 3, 6);
		customer2.setDateOfRegistration(date3);
		customer2.setRegdFees(1200.0);
		customer2.setPrivilegeType(15);
		
		RegisteredCustomer customer3=new RegisteredCustomer();
		customer3.setCustomerId(11119);
		customer3.setName("Aditya");
		customer3.setAge(22);
		Address address11=new Address(2,"Chakan","Pune");
		customer3.setAddress(address11); 
		LocalDate date4=LocalDate.of(2021, 3, 4);
		customer3.setDateOfMemberShip(date4); 
		LocalDate date5=LocalDate.of(2021, 3, 6);
		customer3.setDateOfRegistration(date5);
		customer3.setRegdFees(1500.0);
		customer3.setPrivilegeType(30);
		
		Company company=new Company();
		company.setCompanyName("Xoriant");
		LocalDate date6=LocalDate.of(2020, 1, 7);
		company.setDateOfIncorporation(date6);
		//Branches
		company.setBranch(branch1);
		company.setBranch(branch2);
		//Employees
		company.setEmployee(employee1);
		company.setEmployee(employee2);
		company.setEmployee(branchManager1);
		company.setEmployee(branchManager2);
		company.setEmployee(salesPerson1);
		company.setEmployee(salesPerson2);
		company.setCorporateBranch(branch1);
		company.setRegisterdBranch(branch2);	
		//Customers
		company.setCustomer(customer1);
		company.setCustomer(customer2);
		company.setCustomer(customer3);
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Name of Company: "+company.getCompanyName());
		System.out.println("----------------------------------------------------------------");
		System.out.println("Number of Employees: "+company.numberOfEmployees());
		System.out.println("----------------------------------------------------------------");
		System.out.println("Number of Customers: "+company.numberOfCustomers());
		System.out.println("----------------------------------------------------------------");
		System.out.println("1)Employee");
		System.out.println("2)Customer");
		System.out.println("Enter Your choice for searching: ");
		int choice=scanner.nextInt();
		System.out.println("Enter id to find Customer or Employee : ");
		int id=scanner.nextInt();
		System.out.println("---------------------------- Details --------------------------");
		switch(choice){
			case 1 :
				company.findEmployeeById(id);
				break;
			case 2:
				company.findCustomerById(id);
				break;
			default:
				System.out.println("Wrong Choice!");
				
		}
		System.out.println("----------------------------------------------------------------");
		System.out.println("Total Salary Given to All Employees: "+company.getTotalSalaryOfEmployees());
		System.out.println("----------------------------------------------------------------");
		System.out.println("Total Registration Fee Collected From All RegisteredCustomer: "+company.getTotalRegistrationFee());
		
	}

}
