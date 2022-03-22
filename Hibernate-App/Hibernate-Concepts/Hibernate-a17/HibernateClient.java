package com.xoriant.hibernateapp.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.xoriant.hibernateapp.model.UserInfo;
import com.xoriant.hibernateapp.util.SessionFactoryUtil;

public class HibernateClient 
{
	public static void main(String[] args) {
		
		//HQL -> Hibernate Query Language
		//Hibernate core - 4.3.11(Which supports Query)
		
		// write the query to the Object name and attribute name
		// They are case sensitive with regards to Object name and attribute name
		// Case sensitive 
		
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
		Session session=sessionFactory.openSession();	
		Transaction transaction=session.beginTransaction();
		
		/*
		Query query = session.createQuery("from UserInfo");
		List<UserInfo> list=(List<UserInfo>)query.list();
		for (UserInfo userInfo : list) {
			System.out.println(userInfo.getUserId()+"  "+userInfo.getUserName());
		}
		*/
		
//		102  Shubham Gawade
//		103  Pranav N. Goel
//		104  Sanket
//		105  Vedant

//-----------------------------------------------------------------------------------------------------
		
		/*
		Query query = session.createQuery("from UserInfo where userId=?");
		query.setInteger(0, 104);
		UserInfo userInfo=(UserInfo)query.uniqueResult();
		System.out.println(userInfo.getUserId()+"  "+userInfo.getUserName());
		*/
		
//		104  Sanket
		
//-----------------------------------------------------------------------------------------------------
		//Pagination
		
		/*
		Query query = session.createQuery("from UserInfo");
		query.setFirstResult(2); //Row statrting from 0
		query.setMaxResults(3);  //Number of records to fetch from the first result which is set
		List<UserInfo> list=(List<UserInfo>)query.list();
		for (UserInfo userInfo : list) {
			System.out.println(userInfo.getUserId()+"  "+userInfo.getUserName());
		}
		*/
		
//		104  Sanket
//		105  Vedant
//		106  Stephen	

//-----------------------------------------------------------------------------------------------------
		
		/*
		Query query = session.createQuery("select userName from UserInfo");
		List<String> names=(List<String>)query.list();
		for (String name : names) {
			System.out.println(name);
		}
		*/
		
//		Shubham Gawade
//		Pranav N. Goel
//		Sanket
//		Vedant
//		Stephen
//		Saurabh
		
//-----------------------------------------------------------------------------------------------------
		
		/*
		String userId="104";
		Query query = session.createQuery("select userName from UserInfo where userId="+userId);
		List<String> names=(List<String>)query.list();
		for (String name : names) {
			System.out.println(name);
		}
		*/
		
//		Sanket
		
//-----------------------------------------------------------------------------------------------------
		
		//If we do SQL injection then this will fail
		
		/*
		String userId="104 or 1=1";
		Query query = session.createQuery("select userName from UserInfo where userId="+userId);
		List<String> names=(List<String>)query.list();
		for (String name : names) {
			System.out.println(name);
		}
		*/
		
//		Shubham Gawade
//		Pranav N. Goel
//		Sanket
//		Vedant
//		Stephen
//		Saurabh

//-----------------------------------------------------------------------------------------------------
		
		/*
		String userId="104";
		Query query = session.createQuery("select userId, userName from UserInfo where userId=:userId");
		query.setInteger("userId", Integer.parseInt(userId));
		List<Object[]> list=(List<Object[]>)query.list();
		for (Object[] userInfo : list) {
			System.out.println(userInfo[0]+"  "+userInfo[1]);
		}
		*/
		
//		104  Sanket
		
//-----------------------------------------------------------------------------------------------------
		
		//Named Query
		
		/*
		Query query = session.getNamedQuery("findUserInfoById");
		query.setInteger("userId", 104);
		System.out.println(query.uniqueResult());
		*/
		
//		UserInfo [userId=104, userName=Sanket]
		
//-----------------------------------------------------------------------------------------------------
		
		//Named Native Query
		
		/*
		Query query = session.getNamedQuery("findUserInfoByName");
		query.setString("userName", "Sanket");
		System.out.println(query.uniqueResult());
		*/
		
//		[userId=104, userName=Sanket]
		
//-----------------------------------------------------------------------------------------------------		
		
		//Aggregate Function MIN(),MAX(),AVG(),SUM(),COUNT()
		
		Query query = session.createQuery("select MIN(userId) from UserInfo");
		Object minUserId=query.uniqueResult();
		System.out.println((Integer)minUserId);
	
		
//-----------------------------------------------------------------------------------------------------			
		
		transaction.commit();
		session.close();
	}
}
