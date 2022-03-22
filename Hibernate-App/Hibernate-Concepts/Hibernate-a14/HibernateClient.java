package com.xoriant.hibernateapp.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.xoriant.hibernateapp.model.UserInfo;
import com.xoriant.hibernateapp.util.SessionFactoryUtil;

public class HibernateClient 
{
	public static void main(String[] args) {
		
		//Object State During Creation
		
		UserInfo user1=new UserInfo(); //Transient Object
		user1.setUserId(106);
		user1.setUserName("Saurabh");
		
		UserInfo user=null;
		Transaction transaction=null;
		Session session=null;
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
				
		try {
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			session.save(user1); //Session Object
			
			//Hibernate will update the change
			//user1.setUserName("Sanket");
			
			//Hibernate will not update the change
			//user1.setUserName("Vedant");
			
			transaction.commit();
			//user=session.get(UserInfo.class, 103);
			//System.out.println("Before the session is closed :"+user);
		}catch(Exception e) {
			System.out.println(e);
			transaction.rollback();
		}finally {
			session.close();
		}	
		
		user1.setUserName("Shreyas");
		//System.out.println("After the session is closed :"+user);
		
		//Transient -> New Object
		//Session -> session.save(Object) -> Any update is made on the object
		//			after this will automatically reflects to the tables.
		//          But with intelligence (Only if there are real changes to
		//          Value of Object)
		//Detached -> session.close()
	}
}
