package com.xoriant.hibernateapp.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.xoriant.hibernateapp.util.SessionFactoryUtil;

public class HibernateClient 
{
	public static void main(String[] args) {
		
		//HQL -> Hibernate Query Language
		//Hibernate core - 5.5.7
		
		
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
		Session session=sessionFactory.openSession();	
		Transaction transaction=session.beginTransaction();
		
		Query query=session.createQuery("from UserInfo");
		
		System.out.println(query.list());
		
		transaction.commit();
		session.close();
	}
}
