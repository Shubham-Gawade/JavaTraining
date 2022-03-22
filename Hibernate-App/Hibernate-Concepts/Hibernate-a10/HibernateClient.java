package com.xoriant.hibernateapp.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.xoriant.hibernateapp.model.Address;
import com.xoriant.hibernateapp.model.UserInfo;
import com.xoriant.hibernateapp.util.SessionFactoryUtil;

public class HibernateClient 
{
	public static void main(String[] args) {
		
		//One to Many Mapping strategy
		
		Address address1=new Address();
		address1.setAddressId(123);
		address1.setDoorNO(21);
		address1.setStreetName("MG Road");
		address1.setCity("Pune");
		
		Address address2=new Address();
		address2.setAddressId(456);
		address2.setDoorNO(25);
		address2.setStreetName("FC Road");
		address2.setCity("Mumbai");
		
		UserInfo user1=new UserInfo();
		user1.setUserId(101);
		user1.setUserName("Shubham");
		
		//Birectional mapping
		
		//One user has many address
		user1.addAddress(address1);
		user1.addAddress(address2);
		
		//One address associated with One user
		address1.setUserInfo(user1);
		
		address2.setUserInfo(user1);
		
		
		Transaction transaction=null;
		Session session=null;
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
				
		try {
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			session.persist(user1);
			transaction.commit();
		}catch(Exception e) {
			System.out.println(e);
			transaction.rollback();
		}finally {
			session.close();
		}
		
		//In case of OneToMany unidirection hibernate results in additional table
		//created which is not required. Hence need to do bidirection mapping 
	
		//Who is mapping in that class you can change column name
		
//		mysql> show tables;
//		+------------------------+
//		| Tables_in_hrmanagement |
//		+------------------------+
//		| address                |
//		| userinfo               |
//
//		mysql> select * from userinfo;
//		+--------+----------+
//		| userId | userName |
//		+--------+----------+
//		|    101 | Shubham  |
//		+--------+----------+
//
//		mysql> select * from address;
//		+-----------+--------+--------+------------+--------+
//		| addressId | city   | doorNO | streetName | userId |
//		+-----------+--------+--------+------------+--------+
//		|       123 | Pune   |     21 | MG Road    |    101 |
//		|       456 | Mumbai |     25 | FC Road    |    101 |
//		+-----------+--------+--------+------------+--------+
	}
}
