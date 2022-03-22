package com.xoriant.hrmanagement.dao;

import java.util.List;

import com.xoriant.hrmanagement.model.Employee;

public interface RegistrationDao {
	
	boolean insertEmployee(Employee employe);
	
	List<Employee> getEmployeesFromDatabase();
}
