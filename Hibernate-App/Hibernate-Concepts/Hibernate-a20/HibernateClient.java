package com.xoriant.hibernateapp.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.xoriant.hibernateapp.model.UserInfo;
import com.xoriant.hibernateapp.util.SessionFactoryUtil;

public class HibernateClient 
{
	public static void main(String[] args) {
		
		//Second Level Cache(We have to configure)
		
		//First Level Cache(session provides)
		
		//By default Second Level Cache disabled 
		
		//Modification in hibernate.cfg.xml
		//Enable Second Level Cache
		//Declare the factory class for the cache provider
		//Enable the cache for entity
		//Enable the cache for queries
		
		//Modification in pom.xml
		//hibernate dependency to get the cache provider
		//cache provider dependency is to be added
		
		//class
		//Catchable
		//Catching(strategy)
		
		//Execution Enable the catching
		
		
		//Class level
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
		Session session=sessionFactory.openSession();	
		Transaction transaction=session.beginTransaction();
		UserInfo info=session.get(UserInfo.class, 104);
		System.out.println(info);
		transaction.commit();
		session.close();
		
		//2nd time same execution it will take from cache
		Session session1=sessionFactory.openSession();	
		Transaction transaction1=session1.beginTransaction();
		Query query1=session1.createQuery("from UserInfo");
		UserInfo info1=session1.get(UserInfo.class, 104);
		System.out.println(info1);
		info1.setUserName("Sanket Mahajan");
		transaction1.commit();
		session1.close();
	}
}
