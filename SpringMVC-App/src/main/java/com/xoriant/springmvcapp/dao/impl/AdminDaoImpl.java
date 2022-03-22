package com.xoriant.springmvcapp.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import com.xoriant.springmvcapp.dao.AdminDao;
import com.xoriant.springmvcapp.model.Employee;

@Repository
public class AdminDaoImpl implements AdminDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Employee> getAllEmployeesResultSetExtractor() {
		String query = "select * from employee";

		return jdbcTemplate.query(query, new ResultSetExtractor<List<Employee>>() {
			@Override
			public List<Employee> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Employee> list = new ArrayList<Employee>();

				while (rs.next()) {
					Employee e = new Employee();
					e.setEmployeeId(rs.getInt(1));
					e.setEmployeeName(rs.getString(2));
					e.setGender(rs.getString(3));
					e.setCity(rs.getString(4));
					list.add(e);
				}
				return list;
			}
		});
	}
	
	@Override
	public List<Employee> getAllEmployeesWithRowSet() {
		String query = "select * from employee";
		return jdbcTemplate.query(query, new RowMapper<Employee>() {

			@Override
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				return new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
			}
			
		});
	}

	
	public Employee getEmployee(int id) {
		String query = "select * from employee where employeeId="+id;

		return jdbcTemplate.query(query, new ResultSetExtractor<Employee>() {
			@Override
			public Employee extractData(ResultSet rs) throws SQLException, DataAccessException {
				Employee e = new Employee();
				while (rs.next()) {
					e.setEmployeeId(rs.getInt(1));
					e.setEmployeeName(rs.getString(2));
					e.setGender(rs.getString(3));
					e.setCity(rs.getString(4));
				}
				return e;
			}
		});
	}

	@Override
	public boolean addEmployee(final Employee employee) {
		String query = "insert into employee values(?,?,?,?)";
		return jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {

			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setInt(1, employee.getEmployeeId());
				ps.setString(2, employee.getEmployeeName());
				ps.setString(3, employee.getGender());
				ps.setString(4, employee.getCity());
				
				if(ps.executeUpdate()>0)
					return true;
				else
					return false;
			}
		});
	}

	@Override
	public boolean updateEmployee(final Employee employee, int id) {
		String query = "update employee set employeeName=?, gender=?, city=? where employeeId="+id;
		return jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {

			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setString(1, employee.getEmployeeName());
				ps.setString(2, employee.getGender());
				ps.setString(3, employee.getCity());
				
				if(ps.executeUpdate()>0)
					return true;
				else
					return false;
			}
		});
	}

	@Override
	public boolean deleteEmployee(int id) {
		String query = "delete from employee where employeeId="+id;
		if(jdbcTemplate.update(query)>0) {
			return true;
		}
		else {
			return false;
		}
	}

}
