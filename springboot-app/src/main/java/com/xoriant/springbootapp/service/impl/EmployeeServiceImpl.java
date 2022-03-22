package com.xoriant.springbootapp.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xoriant.springbootapp.dao.EmployeeDao;
import com.xoriant.springbootapp.model.Employee;
import com.xoriant.springbootapp.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public List<Employee> getEmployees() {
//		return employees;
		List<Employee> employees=new ArrayList<Employee>();
		employeeDao.findAll().forEach(employees::add);
		return employees;
	}

	@Override
	public Employee getEmployeeById(int id) {
//		return employees.stream().filter(employee->employee.getEmployeeId()==id).findFirst().get();
		return employeeDao.findById(id).get();
	}

	@Override
	public void addEmployee(Employee employee) {
//		employees.add(employee);
		employeeDao.save(employee);
	}

	@Override
	public void updateEmployee(Employee employee, int id) {
//		ListIterator<Employee> iterator=employees.listIterator();
//		while(iterator.hasNext()) {
//			Employee employee2=iterator.next();
//			if(employee2.getEmployeeId()==id) {
//				iterator.set(employee);
//				return;
//			}
//		}
		employeeDao.save(employee);
	}

	@Override
	public void deleteEmployee(int id) {
		//employees.removeIf(employee->employee.getEmployeeId()==id);		
		employeeDao.deleteById(id);
	}

	@Override
	public Employee getEmployeeByName(String name) {
		return employeeDao.findByEmployeeName(name);
	}

}
