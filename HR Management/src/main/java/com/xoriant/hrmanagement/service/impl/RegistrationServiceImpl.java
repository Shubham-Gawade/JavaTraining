package com.xoriant.hrmanagement.service.impl;

import java.util.List;

import com.xoriant.hrmanagement.dao.RegistrationDao;
import com.xoriant.hrmanagement.dao.impl.RegistrationDaoImpl;
import com.xoriant.hrmanagement.model.Employee;
import com.xoriant.hrmanagement.service.RegistrationService;

public class RegistrationServiceImpl implements RegistrationService {

	RegistrationDao dao;
	
	public RegistrationServiceImpl() {
		dao=new RegistrationDaoImpl();
	}
	
	@Override
	public boolean registerService(Employee employee) {
		return dao.insertEmployee(employee);
	}

	@Override
	public List<Employee> getEmployees() {
		return dao.getEmployeesFromDatabase();
	}

}
