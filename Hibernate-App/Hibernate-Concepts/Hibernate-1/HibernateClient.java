package com.xoriant.hibernateapp.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.xoriant.hibernateapp.model.UserInfo;
import com.xoriant.hibernateapp.util.SessionFactoryUtil;

public class HibernateClient 
{
	public static void main(String[] args) {
		
		UserInfo user1=new UserInfo();
		user1.setUserId(101);
		user1.setUserName("Shubham");
		
		UserInfo user2=new UserInfo();
		user2.setUserId(102);
		user2.setUserName("Sanket");
		
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
		
//		mysql> show tables;
//		+------------------------+
//		| Tables_in_hrmanagement |
//		+------------------------+
//		| userinfo               |
//		+------------------------+
//
//		mysql> select * from userinfo;
//		+--------+----------+
//		| userId | userName |
//		+--------+----------+
//		|    101 | Shubham  |
//		|    102 | Sanket   |
//		+--------+----------+
	}
}
