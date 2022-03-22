package com.xoriant.companyproductapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xoriant.companyproductapp.dao.CompanyDao;
import com.xoriant.companyproductapp.model.Company;
import com.xoriant.companyproductapp.util.DBUtil;

public class ComapnyDaoImpl implements CompanyDao{

	@Override
	public boolean insertCompany(Company company) {
		boolean success=false;
		String query="insert into company values(?,?)";
		
		Connection connection=DBUtil.getConnection();
		System.out.println("Connection :"+connection);
		try {
			PreparedStatement statement=connection.prepareStatement(query);
			statement.setInt(1, company.getCompanyId());
			statement.setString(2, company.getCompanyName());
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
	public List<Company> getAllCompanies() {
		List<Company> companies=new ArrayList<>();
		String query="select * from company";
		
		Connection connection=DBUtil.getConnection();
		System.out.println("Connection :"+connection);
		try {
			PreparedStatement statement=connection.prepareStatement(query);
			ResultSet rs=statement.executeQuery();
			while(rs.next()) {
				Company company=new Company();
				company.setCompanyId(rs.getInt(1));
				company.setCompanyName(rs.getString(2));
				companies.add(company);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return companies;
	}

}
