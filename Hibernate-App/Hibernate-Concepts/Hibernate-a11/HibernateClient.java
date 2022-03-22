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
		
		UserInfo user2=new UserInfo();
		user2.setUserId(102);
		user2.setUserName("Pranav");
		user2.addAddress(address1);
		user2.addAddress(address2);
		
		UserInfo user1=new UserInfo();
		user1.setUserId(101);
		user1.setUserName("Shubham");
		//One user has many address
		user1.addAddress(address1);
		user1.addAddress(address2);
		//One address has many user
		address1.addUserInfo(user1);
		address1.addUserInfo(user2);
		address2.addUserInfo(user1);
		address2.addUserInfo(user2);
		
		Transaction transaction=null;
		Session session=null;
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
				
		try {
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			session.persist(user1);
			session.persist(user2);
			transaction.commit();
		}catch(Exception e) {
			System.out.println(e);
			transaction.rollback();
		}finally {
			session.close();
		}
		
//		1)If mappedby is done with userinfo then extra table is not created
		
//		mysql> show tables;
//		+------------------------+
//		| Tables_in_hrmanagement |
//		+------------------------+
//		| address                |
//		| address_userinfo       |
//		| userinfo               |
//		+------------------------+
//
//		mysql> select * from userinfo;
//		+--------+----------+
//		| userId | userName |
//		+--------+----------+
//		|    101 | Shubham  |
//		|    102 | Pranav   |
//		+--------+----------+
//
//		mysql> select * from address;
//		+-----------+--------+--------+------------+
//		| addressId | city   | doorNO | streetName |
//		+-----------+--------+--------+------------+
//		|       123 | Pune   |     21 | MG Road    |
//		|       456 | Mumbai |     25 | FC Road    |
//		+-----------+--------+--------+------------+/
//
//		mysql> select * from address_userinfo;
//		+-----------+--------+
//		| addressId | userId |
//		+-----------+--------+
//		|       123 |    101 |
//		|       123 |    102 |
//		|       456 |    101 |
//		|       456 |    102 |
//		+-----------+--------+
		
//---------------------------------------------------------------------------------------------
		
//		2)If mappedby is not done the extra table is created we don't want this
		
//		mysql> select * from userinfo_address;
//		+-----------------+-------------------+
//		| UserInfo_userId | address_addressId |
//		+-----------------+-------------------+
//		|             101 |               123 |
//		|             101 |               456 |
//		|             102 |               123 |
//		|             102 |               456 |
//		+-----------------+-------------------+
		
//---------------------------------------------------------------------------------------------
		
//		3)Cascade is must be written in Userinfo bcoz of address is child of Userinfo
//			then mappedby cannot not be done there		 
	}
}
