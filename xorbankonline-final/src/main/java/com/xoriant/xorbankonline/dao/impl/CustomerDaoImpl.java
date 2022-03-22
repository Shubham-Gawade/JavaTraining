package com.xoriant.xorbankonline.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.xoriant.xorbankonline.config.HibernateConfig;
import com.xoriant.xorbankonline.dao.CustomerDao;
import com.xoriant.xorbankonline.model.Account;
import com.xoriant.xorbankonline.model.BankTransaction;
import com.xoriant.xorbankonline.model.Customer;

@Repository
public class CustomerDaoImpl extends BaseDao implements CustomerDao{
	
	private Session session = HibernateConfig.getSessionFactory().openSession();


	@Override
	public List<Account> getAccountDetails(int id) {
		Session session=HibernateConfig.getSessionFactory().openSession();
		String queryStr="from Account where customerId=(select personId from PersonInfo where userId=:userId)";
		Query query=session.createQuery(queryStr);
		query.setParameter("userId", id);
		List<Account> list=query.list();
		for(Account account:list) {
			System.out.println(account.getAccountNumber());
		}
		session.close();
		return list;
	}


	@Override
	public List<BankTransaction> getTransaction(int accountNumber) {
		Session session=HibernateConfig.getSessionFactory().openSession();
		String queryStr="from BankTransaction where accountNumber=:accountNumber";
		Query query=session.createQuery(queryStr);
		query.setParameter("accountNumber", accountNumber);
		List<BankTransaction> list=query.list();
		for(BankTransaction bankTransaction:list) {
			System.out.println(bankTransaction.getTransactionAmount()+" "+bankTransaction.getAccount().getAccountNumber());
		}
		session.close();
		return list;
	}



	@Override
	public List<BankTransaction> getTransactions() {
		Session session=HibernateConfig.getSessionFactory().openSession();
		String queryStr="from BankTransaction";
		Query query=session.createQuery(queryStr);
		List<BankTransaction> list=query.list();
		for(BankTransaction bankTransaction:list) {
			System.out.println(bankTransaction.getTransactionAmount()+" "+bankTransaction.getAccount().getAccountNumber());
		}
		session.close();
		return list;
	}


	@Override
	public List<BankTransaction> getMinistatement(int an) {
		// TODO Auto-generated method stub
		long accountNumber=(long)an;
		Session session=HibernateConfig.getSessionFactory().openSession();
		String queryString="from BankTransaction where accountNumber=:accountNumber order by transactionDate DESC";
		Query query=session.createQuery(queryString);
		query.setFirstResult(0);
		query.setMaxResults(5);
		query.setParameter("accountNumber", accountNumber);
		List<BankTransaction> transactions=query.list();
		for(BankTransaction bankTransaction:transactions) {
			System.out.println(bankTransaction.getTransactionAmount()+" "+bankTransaction.getAccount().getAccountNumber());
		}
		session.close();
		return transactions;
	}
	
	public static void main(String[] args) {
		new CustomerDaoImpl().getMinistatement(1);
	}
}
