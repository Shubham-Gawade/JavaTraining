package com.xoriant.hrmanagement.service;

import java.util.List;

import com.xoriant.hrmanagement.model.Employee;

public interface RegistrationService {
	
	boolean registerService(Employee employee);
	
	List<Employee> getEmployees();
}
