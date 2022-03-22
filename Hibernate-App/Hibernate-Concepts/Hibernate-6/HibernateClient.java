package com.xoriant.hibernateapp.dao;

import javax.persistence.GeneratedValue;

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
		address2.setCity("Pune");
		
		UserInfo user1=new UserInfo();
		//user1.setUserId(101);
		user1.setUserName("Shubham");
		user1.setAddress(address1);
		user1.setAddress(address2);
		
		
		Transaction transaction=null;
		Session session=null;
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
				
		try {
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			session.save(user1);
			transaction.commit();
		}catch(Exception e) {
			System.out.println(e);
			transaction.rollback();
		}finally {
			session.close();
		}

//Same Column created in both tables
//One user has many address and user_address has auto incremented column with name addressId		
// with auto @GeneratedValue userId		
		
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
//		|      1 | Shubham  |
//		+--------+----------+
//
//		mysql> select * from user_address;
//		+--------+------+--------+------------+-----------+
//		| userId | city | doorNO | streetName | addressId |
//		+--------+------+--------+------------+-----------+
//		|      1 | Pune |     21 | MG Road    |         1 |
//		|      1 | Pune |     25 | FC Road    |         2 |
		+--------+------+--------+------------+-----------+
	}
}
