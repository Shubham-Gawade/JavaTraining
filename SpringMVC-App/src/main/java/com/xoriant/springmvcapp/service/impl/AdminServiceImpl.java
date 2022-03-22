package com.xoriant.springmvcapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xoriant.springmvcapp.dao.AdminDao;
import com.xoriant.springmvcapp.model.Employee;
import com.xoriant.springmvcapp.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	AdminDao dao;

	@Override
	public List<Employee> getAllEmployees() {
		return dao.getAllEmployeesWithRowSet();
	}

	@Override
	public Employee getEmployee(int id) {
		return dao.getEmployee(id);
	}

	@Override
	public boolean addEmployee(Employee employee) {
		return dao.addEmployee(employee);
	}

	@Override
	public boolean updateEmployee(Employee employee, int id) {
		return dao.updateEmployee(employee, id);
	}

	@Override
	public boolean deleteEmployee(int id) {
		return dao.deleteEmployee(id);
	}
}
