package com.xoriant.hibernateapp.dao;

import java.util.Collection;

import javax.persistence.ElementCollection;
import javax.persistence.FetchType;

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
		address1.setDoorNO(21);
		address1.setStreetName("MG Road");
		address1.setCity("Pune");
		
		Address address2=new Address();
		address2.setDoorNO(25);
		address2.setStreetName("FC Road");
		address2.setCity("Mumbai");
		
		UserInfo user1=new UserInfo();
		user1.setUserId(101);
		user1.setUserName("Shubham");
		user1.setAddress(address1);
		
		UserInfo user2=new UserInfo();
		user2.setUserId(102);
		user2.setUserName("Pranav");
		user2.setAddress(address2);
		
		
		Transaction transaction=null;
		Session session=null;
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
				
		try {
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			session.save(user1);
			session.save(user2);
			transaction.commit();
		}catch(Exception e) {
			System.out.println(e);
			transaction.rollback();
		}finally {
			session.close();
		}
		
		
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
		
		UserInfo userResult=session.get(UserInfo.class, 101);
		
		//If session is closed before then after that also we able to fetch data
		//Change in UserInfo - @ElementCollection(fetch = FetchType.EAGER)
		
		session.close();
		
		Collection<Address> users=userResult.getAddress();
		for (Address address : users) {
			System.out.println(address);
		}
		
		//Hibernate never returns the actual entity object it returns the proxy object of the entity 
		
//		mysql> show tables;
//		+------------------------+
//		| Tables_in_hrmanagement |
//		+------------------------+
//		| user_address           |
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
//		mysql> select * from user_address;
//		+--------+--------+--------+------------+-----------+
//		| userId | city   | doorNO | streetName | addressId |
//		+--------+--------+--------+------------+-----------+
//		|    101 | Pune   |     21 | MG Road    |         1 |
//		|    102 | Mumbai |     25 | FC Road    |         2 |
//		+--------+--------+--------+------------+-----------+
	}
}
