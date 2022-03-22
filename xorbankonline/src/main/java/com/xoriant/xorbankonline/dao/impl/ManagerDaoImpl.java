package com.xoriant.xorbankonline.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.xoriant.xorbankonline.dao.ManagerDao;
import com.xoriant.xorbankonline.enums.AccountType;
import com.xoriant.xorbankonline.model.Account;
import com.xoriant.xorbankonline.model.Branch;
import com.xoriant.xorbankonline.model.CurrentAccount;
import com.xoriant.xorbankonline.model.Customer;
import com.xoriant.xorbankonline.model.Manager;
import com.xoriant.xorbankonline.model.PersonInfo;
import com.xoriant.xorbankonline.model.SavingAccount;
import com.xoriant.xorbankonline.model.Transactions;
import com.xoriant.xorbankonline.utility.SessionFactoryUtil;

@Repository
public class ManagerDaoImpl implements ManagerDao {

	@Override
	public boolean addCustomer(Customer customer) {
		Transaction transaction = null;
		Session session = null;
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.persist(customer);
			transaction.commit();
		} catch (Exception e) {
			System.out.println(e);
			transaction.rollback();
		} finally {
			session.close();
		}
		return true;
	}

	@Override
	public boolean addAccount(Account account) {
		Transaction transaction = null;
		Session session = null;
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Customer customer=account.getCustomer();
			if(account.getAccountType().equals("CURRENT")) {
				CurrentAccount currentAccount=(CurrentAccount) account;
				customer.addAccount(currentAccount);
			}else {
				SavingAccount savingAccount=(SavingAccount) account;
				customer.addAccount(savingAccount);
			}
			session.update(customer);
			transaction.commit();
		} catch (Exception e) {
			System.out.println(e);
			transaction.rollback();
		} finally {
			session.close();
		}
		return true;
	}

	@Override
	public List<Customer> getAllCustomerDetails() {
		Transaction transaction = null;
		Session session = null;
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
		List<Customer> customers = new ArrayList<>();
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			Query<Customer> query = session.createQuery("from Customer", Customer.class);
			customers = (List<Customer>) query.getResultList();
		} catch (Exception e) {
			System.out.println(e);
			transaction.rollback();
		} finally {
			session.close();
		}
		return customers;
	}

	@Override
	public Account getAccountDetails(long accountNumber) {
		Transaction transaction = null;
		Session session = null;
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
		Account account = new Account();
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			Query<Account> query = session.createQuery("from Account where accountNumber=:accountNumber",
					Account.class);
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

	@Override
	public Customer getCustomer(long customerId) {
		Transaction transaction = null;
		Session session = null;
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
		Customer customer = new Customer();
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			Query<PersonInfo> query = session.createQuery("from PersonInfo where personid=:personId", PersonInfo.class);
			query.setParameter("personId", customerId);
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
	public Manager getManagerDetails(long managerId) {
		Transaction transaction = null;
		Session session = null;
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
		Manager manager = new Manager();
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			Query<PersonInfo> query = session.createQuery("from PersonInfo where personid=:personId", PersonInfo.class);
			query.setParameter("personId", managerId);
			manager = (Manager) query.uniqueResult();

		} catch (Exception e) {
			System.out.println(e);
			transaction.rollback();
		} finally {
			session.close();
		}

		return manager;
	}

	@Override
	public Branch getBranch(long managerId) {
		Transaction transaction = null;
		Session session = null;
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
		Branch branch = new Branch();
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Manager manager=session.load(Manager.class,managerId);
			Query query = session.createQuery("from Branch where branchId=:branchId");

			query.setParameter("branchId", manager.getBranch().getBranchId());
			branch = (Branch) query.uniqueResult();
		} catch (Exception e) {
			System.out.println(e);
			transaction.rollback();
		} finally {
			session.close();
		}
		return branch;
	}

	@Override
	public boolean deleteAccount(long accountNumber) {
		Transaction transaction = null;
		Session session = null;
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Account account=getAccount(accountNumber);
			
			session.delete(account);
			transaction.commit();
		} catch (Exception e) {
			System.out.println(e);
			transaction.rollback();
		} finally {
			session.close();
		}
		return true;
	}

	@Override
	public boolean deleteCustomer(long customerId) {
		Transaction transaction = null;
		Session session = null;
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			Customer customer=session.get(Customer.class, customerId);			
			session.delete(customer);
			transaction.commit();
		} catch (Exception e) {
			System.out.println(e);
			transaction.rollback();
		} finally {
			session.close();
		}
		return true;
	}

	@Override
	public Account getAccount(long accountNumber) {
		Transaction transaction = null;
		Session session = null;
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
		Account account = new Account();
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

	@Override
	public boolean makeTransaction(Transactions transaction1) {
		Transaction transaction = null;
		Session session = null;
		System.out.println("Transaction:"+transaction1);
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Account account=transaction1.getAccount();
			double balance=account.getBalance();
			if(transaction1.getTransactionType().equals("DEPOSIT")) {
				account.setBalance(balance+transaction1.getTransactionAmount());
			}
			else if(transaction1.getTransactionType().equals("WITHDRAWL")) {
				account.setBalance(balance-transaction1.getTransactionAmount());
			}else {
				account.setBalance(balance-transaction1.getTransactionAmount());
				Account receiverAccount=getAccount(transaction1.getReceiverAccountNumber());
				receiverAccount.setBalance(balance+transaction1.getTransactionAmount());
				session.update(receiverAccount);
			}
			
			session.update(account);
			session.update(transaction1);
			transaction.commit();
		} catch (Exception e) {
			System.out.println(e);
			transaction.rollback();
		} finally {
			session.close();
		}
		return true;
	}
}
