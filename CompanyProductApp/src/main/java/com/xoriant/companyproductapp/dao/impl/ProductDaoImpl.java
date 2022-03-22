package com.xoriant.companyproductapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.xoriant.companyproductapp.dao.ProductDao;
import com.xoriant.companyproductapp.model.Product;
import com.xoriant.companyproductapp.util.DBUtil;

public class ProductDaoImpl implements ProductDao{

	@Override
	public boolean insertProduct(Product product,String companyName) {
		boolean success=false;
		String query1="select * from company where companyName=?";
		String query2="insert into product values(?,?,?,?)";
		Connection connection=DBUtil.getConnection();
		int companyId=0;
		try {
			PreparedStatement statement1=connection.prepareStatement(query1);
			statement1.setString(1, companyName);
			ResultSet rs=statement1.executeQuery();
			while(rs.next()) {
				companyId=rs.getInt("companyId");
			}
			
			PreparedStatement statement2=connection.prepareStatement(query2);
			statement2.setInt(1, product.getProductId());
			statement2.setInt(2, companyId);
			statement2.setString(3, product.getProductName());
			statement2.setDouble(4, product.getProductPrice());
			int row=statement2.executeUpdate();
			if(row != 0) {
				success=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return success;
	}
//	public static void main(String[] args) {
//		ProductDaoImpl daoImpl=new ProductDaoImpl();
//		Product product=new Product(113,"Laptop1",50000.0);
//		daoImpl.insertProduct(product, "Amazon");
//		
//		//select * from Address,Employee where Employee.EmpId=Address.EmpId and EmpName="A";
//	}
}
