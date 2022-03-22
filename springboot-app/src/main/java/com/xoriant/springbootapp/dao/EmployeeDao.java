package com.xoriant.springbootapp.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.xoriant.springbootapp.model.Employee;

@Repository
public interface EmployeeDao extends CrudRepository<Employee, Integer>{

	Employee findByEmployeeName(String name);
}
