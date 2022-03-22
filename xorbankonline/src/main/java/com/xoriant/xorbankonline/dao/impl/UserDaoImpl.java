package com.xoriant.xorbankonline.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.xoriant.xorbankonline.dao.UserDao;
import com.xoriant.xorbankonline.model.User;
import com.xoriant.xorbankonline.utility.SessionFactoryUtil;

@Repository
public class UserDaoImpl implements UserDao {

	@Override
	public User getUser(String userName, String password) {
		
		Transaction transaction = null;
		Session session = null;
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
		User user=new User();
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			
			Query<User> query = session.createQuery(
			  "from User where userName=:userName and password=:password" , User.class);
			query.setParameter("userName", userName);
			query.setParameter("password", password);
			user = (User)query.uniqueResult();
		} catch (Exception e) {
			System.out.println(e);
			transaction.rollback();
		} finally {
			session.close();
		}
		
		return user;
	}
}
