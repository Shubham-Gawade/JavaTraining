package com.xoriant.hibernateapp.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.xoriant.hibernateapp.model.UserInfo;
import com.xoriant.hibernateapp.util.SessionFactoryUtil;

public class HibernateClient 
{
	public static void main(String[] args) {
		
		//How to update an Object
		
		//Method 1 -> Get the object to the session state the update and commit
		//Method 2 -> Use Update

		/*
		UserInfo user=null;
		Transaction transaction=null;
		Session session=null;
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
				

		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
		user=session.get(UserInfo.class, 103);			
		user.setUserName("Shubham Gawade");
		transaction.commit();
		session.close();
		*/
	
		
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
		Session session=sessionFactory.openSession();	
		Transaction transaction=session.beginTransaction();
		UserInfo user=session.get(UserInfo.class, 103);			
		transaction.commit();
		session.close();
		
		//Need to update the fetched object after closing of the session
	
		//Use -> @SelectBeforeUpdate(value = true) in UserInfo
		
		Session session1=sessionFactory.openSession();	
		Transaction transaction1=session1.beginTransaction();
		user.setUserName("Pranav N. Goel");
		session1.update(user);
		transaction1.commit();
		session1.close();
	}
}
