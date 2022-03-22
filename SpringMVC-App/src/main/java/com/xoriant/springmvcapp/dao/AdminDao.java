package com.xoriant.springmvcapp.dao;

import java.util.List;

import com.xoriant.springmvcapp.model.Employee;

public interface AdminDao {

	List<Employee> getAllEmployeesResultSetExtractor();

	List<Employee> getAllEmployeesWithRowSet();

	Employee getEmployee(int id);

	boolean addEmployee(Employee employee);

	boolean updateEmployee(Employee employee, int id);

	boolean deleteEmployee(int id);


}
