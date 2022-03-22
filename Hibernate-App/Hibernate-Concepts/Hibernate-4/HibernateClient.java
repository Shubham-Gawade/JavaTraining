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
		address1.setDoorNO(21);
		address1.setStreetName("MG Road");
		address1.setCity("Pune");
		
		Address address2=new Address();
		address2.setDoorNO(21);
		address2.setStreetName("FC Road");
		address2.setCity("Pune");
		
		UserInfo user1=new UserInfo();
		//user1.setUserId(101);
		user1.setUserName("Shubham");
		user1.setAddress(address1);
		
		UserInfo user2=new UserInfo();
		//user2.setUserId(102);
		user2.setUserName("Sanket");
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
		
// Address is merged into userinfo		
		
//		mysql> show tables;
//		+------------------------+
//		| Tables_in_hrmanagement |
//		+------------------------+
//		| userinfo               |
//		+------------------------+
//
//		mysql> select * from userinfo;
//		+--------+------+--------+------------+----------+
//		| userId | city | doorNO | streetName | userName |
//		+--------+------+--------+------------+----------+
//		|      1 | Pune |     21 | MG Road    | Shubham  |
//		|      2 | Pune |     21 | FC Road    | Sanket   |
//		+--------+------+--------+------------+----------+
	}
}
