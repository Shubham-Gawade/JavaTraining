package com.xoriant.xorbankonline.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.xoriant.xorbankonline.config.HibernateConfig;
import com.xoriant.xorbankonline.dao.UserDao;
import com.xoriant.xorbankonline.enums.Role;
import com.xoriant.xorbankonline.enums.TransactionType;
import com.xoriant.xorbankonline.model.Account;
import com.xoriant.xorbankonline.model.BankTransaction;
import com.xoriant.xorbankonline.model.PersonInfo;
import com.xoriant.xorbankonline.model.User;
import com.xoriant.xorbankonline.model.UserDetailsDTO;

@Repository
public class UserDaoImpl implements UserDao {
//	@Autowired
//	private JdbcTemplate jdbcTemplate;

	//private Session session = HibernateConfig.getSessionFactory().openSession();

	@Override
	public User checkUser(String username, String password) {
		Session session=HibernateConfig.getSessionFactory().openSession();
		String queryStr = "from User where userName=:username  and password=:password ";

		Query query = session.createQuery(queryStr);
		query.setParameter("username", username);
		query.setParameter("password", password);

		User user = (User) query.uniqueResult();
		session.close();
		return user;

	}

	@Override
	public UserDetailsDTO getUserDetails(int id) {
		Session session=HibernateConfig.getSessionFactory().openSession();
		String queryString="select new com.xoriant.xorbankonline.model.UserDetailsDTO(u.userId,u.userName,p.personName,p.dateOfBirth,p.gender,p.emailId,p.mobileNo) from User u join PersonInfo p on p.user.userId=u.userId where u.userId=:userId";

		Query query=session.createQuery(queryString);
		query.setParameter("userId", id);
		UserDetailsDTO userDetailsDTO=(UserDetailsDTO)query.uniqueResult();
		System.out.println(userDetailsDTO);
		session.close();
		return userDetailsDTO;
		
	}
	@Override
	public PersonInfo getallDetails(int id) {
		Session session=HibernateConfig.getSessionFactory().openSession();
		String queryString="from PersonInfo where userId=:userId";
		
		Query query=session.createQuery(queryString);
		query.setParameter("userId", id);
		PersonInfo personInfo=(PersonInfo)query.uniqueResult();
		session.close();
		//System.out.println(personInfo);
		return personInfo;
		
	}

	@Override
	public User getUser(int id) {
		Session session=HibernateConfig.getSessionFactory().openSession();
		String queryStr = "from User where userId=:userId";

		Query query = session.createQuery(queryStr);
		query.setParameter("userId", id);
		User user = (User) query.uniqueResult();
		session.close();
		return user;
	}

	@Override
	public void updateDetails(PersonInfo info,int id) {
		// TODO Auto-generated method stub
		Session session=HibernateConfig.getSessionFactory().openSession();
		User user=session.load(User.class, id);
		info.setUser(user);
		Transaction transaction=session.beginTransaction();
		session.update(info);
		session.update(info.getUser());
		transaction.commit();
		session.close();
		//System.out.println(info);
	}

//	public static void main(String[] args) {
//		new UserDaoImpl().updateDetails(new PersonInfo(), 2);
//	}

	@Override
	public String transact(BankTransaction bankTransaction, long senderAccountNumber, long receiverAccountNumber) {
//		bankTransaction.setTransactionAmount(3000.0);
//		bankTransaction.setTransactionType(TransactionType.TRANSFER);
		System.out.println(bankTransaction);
		System.out.println(senderAccountNumber+" "+receiverAccountNumber);
		Session session=HibernateConfig.getSessionFactory().openSession();
		Account senderAccount=session.load(Account.class, senderAccountNumber);
		System.out.println(senderAccount);
		bankTransaction.setAccount(senderAccount);
		if(bankTransaction.getTransactionType().toString()=="DEPOSIT") {
			senderAccount.setBalance(senderAccount.getBalance()+bankTransaction.getTransactionAmount());
		}
		else if(bankTransaction.getTransactionType().toString()=="WITHDRAW") {
			double balance=senderAccount.getBalance();
			if(balance < bankTransaction.getTransactionAmount()) {
				return "balance is less than transaction amount to withdraw";
			}else {
				senderAccount.setBalance(senderAccount.getBalance()-bankTransaction.getTransactionAmount());
			}
		}
		else {
			System.out.println("In else :"+bankTransaction.getAccount().getAccountType());
			Account receiverAccount=session.load(Account.class, receiverAccountNumber);
			System.out.println("RECEIVER ACCOUNT BEFORE TRANSACTION : "+receiverAccount);
			if(receiverAccount.getAccountType()==null) {
				System.out.println("in null case :");
				return "receiver account not found";
			}
			else {
			double balance=senderAccount.getBalance();
			if(balance < bankTransaction.getTransactionAmount()) {
				return "balance is less than transaction amount to transfer";
			}else {
				senderAccount.setBalance(senderAccount.getBalance()-bankTransaction.getTransactionAmount());
				receiverAccount.setBalance(receiverAccount.getBalance()+bankTransaction.getTransactionAmount());
			}
			
			//System.out.println("RECEIVER ACCOUNT : "+receiverAccount);
//			bankTransaction.setTransactionType(TransactionType.WITHDRAW);
//			bankTransaction.setAccount(senderAccount);
//			senderAccount.addBankTransactions(bankTransaction);
//			bankTransaction.setTransactionType(TransactionType.DEPOSIT);
//			bankTransaction.setAccount(receiverAccount);
//			receiverAccount.addBankTransactions(bankTransaction);
			BankTransaction bankTransaction2=new BankTransaction();
			bankTransaction2.setTransactionAmount(bankTransaction.getTransactionAmount());
			bankTransaction2.setTransactionDate(bankTransaction.getTransactionDate());
			bankTransaction2.setTransactionType(bankTransaction.getTransactionType());
			senderAccount.addBankTransactions(bankTransaction);
			receiverAccount.addBankTransactions(bankTransaction2);
			bankTransaction.setAccount(senderAccount);
			bankTransaction2.setAccount(receiverAccount);
			System.out.println("RECEIVER ACCOUNT : "+receiverAccount);
			System.out.println("SENDER ACCOUNT : "+senderAccount);
			Transaction transaction = session.beginTransaction();
			session.update(senderAccount);
			session.update(receiverAccount);
			session.persist(senderAccount);
			session.persist(receiverAccount);
			transaction.commit();
			return "transaction successfull";
			}
		}
		System.out.println("SENDER ACCOUNT : "+senderAccount);
		senderAccount.addBankTransactions(bankTransaction);
		Transaction transaction = session.beginTransaction();
		session.update(senderAccount);
		session.persist(senderAccount);
		transaction.commit();
		return "transaction successfull";
	}
public void transact() {
		
		Session session=HibernateConfig.getSessionFactory().openSession();
		Account account=session.load(Account.class, 1L);
		System.out.println(account);
		session.close();
		
	}
public static void main(String[] args) {
	new UserDaoImpl().transact(new BankTransaction(),2L,3L);
}
}
