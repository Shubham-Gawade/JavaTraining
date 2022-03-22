package com.xoriant.companyproductapp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
	public static Connection getConnection() {
		Connection connection=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/companyproducts","root","root");
			System.out.println("Connection Done");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}    

		return connection;
	}
//	public static void main(String[] args) {
//		getConnection();
//	}
}

//CREATE TABLE Company
//( companyId INT,
//  companyName VARCHAR(25) NOT NULL,
//  CONSTRAINT contacts_pk PRIMARY KEY (companyId)
//);

//CREATE TABLE Product
//(   productId INT,
//	  companyId INT, 
//    productName varchar(50) NOT NULL,  
//    productPrice varchar(50) NOT NULL,  
//    CONSTRAINT fk_company FOREIGN KEY (companyId)  
//	  REFERENCES Company(companyId)  
//	  ON DELETE CASCADE   
//);  