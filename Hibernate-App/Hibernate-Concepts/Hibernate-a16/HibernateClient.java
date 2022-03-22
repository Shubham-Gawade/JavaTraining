package com.xoriant.hibernateapp.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.xoriant.hibernateapp.model.UserInfo;
import com.xoriant.hibernateapp.util.SessionFactoryUtil;

public class HibernateClient 
{
	public static void main(String[] args) {
		
		//How to delete an Object
		
		/*
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
		Session session=sessionFactory.openSession();	
		Transaction transaction=session.beginTransaction();
		UserInfo user=session.get(UserInfo.class, 106);			
		session.delete(user); //Object Moved to detached state 
		transaction.commit();
		session.close();
		*/
		
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
		Session session=sessionFactory.openSession();	
		Transaction transaction=session.beginTransaction();
		UserInfo user=session.get(UserInfo.class, 106);			
		session.delete(user); //Object Moved to detached state
		user.setUserName("Abc"); //Cannot update after delete
		transaction.commit();
		session.close();
	}
}
