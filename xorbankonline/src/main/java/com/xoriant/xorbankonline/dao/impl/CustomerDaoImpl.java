package com.xoriant.xorbankonline.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.xoriant.xorbankonline.dao.CustomerDao;
import com.xoriant.xorbankonline.model.Account;
import com.xoriant.xorbankonline.model.Customer;
import com.xoriant.xorbankonline.model.PersonInfo;
import com.xoriant.xorbankonline.utility.SessionFactoryUtil;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Override
	public Customer getCustomer(long userId) {
		
		Transaction transaction = null;
		Session session = null;
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
		Customer customer=new Customer();
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			
			Query<PersonInfo> query = session.createQuery("from PersonInfo where userid=:userId", PersonInfo.class);
			query.setParameter("userId", userId);
			customer = (Customer) query.uniqueResult();
			
		} catch (Exception e) {
			System.out.println(e);
			transaction.rollback();
		} finally {
			session.close();
		}
		
		return customer;
	}

	@Override
	public Account getAccount(long accountNumber) {
		Transaction transaction = null;
		Session session = null;
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
		Account account=new Account();
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			
			Query<Account> query = session.createQuery("from Account where accountNumber=:accountNumber", Account.class);
			query.setParameter("accountNumber", accountNumber);
			account = (Account) query.uniqueResult();
			
		} catch (Exception e) {
			System.out.println(e);
			transaction.rollback();
		} finally {
			session.close();
		}
		
		return account;
	}
}
