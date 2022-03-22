package com.xoriant.springbootapp.service;

import java.util.List;

import com.xoriant.springbootapp.model.Employee;

public interface EmployeeService {

	Employee getEmployeeById(int id);
	
	Employee getEmployeeByName(String name);

	List<Employee> getEmployees();

	void addEmployee(Employee employee);

	void updateEmployee(Employee employee,int id);

	void deleteEmployee(int id);

}
