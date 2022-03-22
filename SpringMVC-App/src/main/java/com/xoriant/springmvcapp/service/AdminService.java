package com.xoriant.springmvcapp.service;

import java.util.List;

import com.xoriant.springmvcapp.model.Employee;

public interface AdminService {

	List<Employee> getAllEmployees();

	Employee getEmployee(int id);

	boolean addEmployee(Employee employee);

	boolean updateEmployee(Employee employee, int id);

	boolean deleteEmployee(int id);

}
