package com.xoriant.hibernateapp.dao;

import javax.persistence.InheritanceType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.xoriant.hibernateapp.model.CurrentAccount;
import com.xoriant.hibernateapp.model.SavingAccount;
import com.xoriant.hibernateapp.util.SessionFactoryUtil;

public class HibernateClient 
{
	public static void main(String[] args) {
		
		//Inheritance with InheritanceType.JOINED
		
		SavingAccount savingAccount=new SavingAccount();
		savingAccount.setAccountNumber(111);
		savingAccount.setAccountName("Shubham");
		savingAccount.setMinBalance(500);
		
		CurrentAccount currentAccount=new CurrentAccount();
		currentAccount.setAccountNumber(112);
		currentAccount.setAccountName("Pranav");
		currentAccount.setDailyLimit(10);
		
		Transaction transaction=null;
		Session session=null;
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
				
		try {
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			session.save(savingAccount);
			session.save(currentAccount);
			transaction.commit();
		}catch(Exception e) {
			System.out.println(e);
			transaction.rollback();
		}finally {
			session.close();
		}	

//		mysql> select * from account;
//		+---------+---------------+-------------+------------+------------+
//		| AccType | accountNumber | accountName | minBalance | dailyLimit |
//		+---------+---------------+-------------+------------+------------+
//		| saving  |           111 | Shubham     |        500 |       NULL |
//		| current |           112 | Pranav      |       NULL |         10 |
//		+---------+---------------+-------------+------------+------------+
	}
}
