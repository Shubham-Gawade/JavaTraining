package com.xoriant.hrmanagement.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.xoriant.hrmanagement.dao.RegistrationDao;
import com.xoriant.hrmanagement.model.Employee;
import com.xoriant.hrmanagement.util.DBUtil;

public class RegistrationDaoImpl implements RegistrationDao {

	@Override
	public boolean insertEmployee(Employee employe) {
		boolean success=false;
		String query="insert into employees values(?,?,?,?,?,?)";
		
		Connection connection=DBUtil.getConnection();
		try {
			PreparedStatement statement=connection.prepareStatement(query);
			statement.setInt(1, employe.getEmployeeId());
			statement.setString(2, employe.getEmployeeName());
			statement.setString(3, employe.getGender());
			statement.setString(4, employe.getCity());
			statement.setString(5, employe.getUsername());
			statement.setString(6, employe.getPassword());
			int row=statement.executeUpdate();
			if(row != 0) {
				success=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return success;
	}

	@Override
	public List<Employee> getEmployeesFromDatabase() {
		List<Employee> employees = new ArrayList<Employee>();
		String query="select * from employees";
		
		Connection connection=DBUtil.getConnection();
		try {
			PreparedStatement statement=connection.prepareStatement(query);
			ResultSet rs=statement.executeQuery();
			while(rs.next()) {
				Employee employee=new Employee();
				employee.setEmployeeId(rs.getInt(1));
				employee.setEmployeeName(rs.getString(2));
				employee.setGender(rs.getString(3));
				employee.setCity(rs.getString(4));
				employee.setUsername(rs.getString(5));
				//employee.setPassword(rs.getString(6));
				
				employees.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return employees;
	}

}
