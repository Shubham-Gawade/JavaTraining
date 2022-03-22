package com.xoriant.hrmanagement.dao.impl;

import java.sql.*;

import com.xoriant.hrmanagement.dao.LoginDao;
import com.xoriant.hrmanagement.util.DBUtil;

public class LoginDaoImpl implements LoginDao {

	@Override
	public boolean findEmployee(String username, String password) {
		boolean success=false;
		String query="select * from employees where username=? and password=?";
		
		Connection connection=DBUtil.getConnection();
		try {
			PreparedStatement statement=connection.prepareStatement(query);
			statement.setString(1, username);
			statement.setString(2, password);
			ResultSet rs=statement.executeQuery();
			if(rs.next()) {
				success=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return success;
	}

}
