package com.xoriant.xorbankonline.dao;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.xoriant.xorbankonline.enums.AccountType;
import com.xoriant.xorbankonline.enums.Gender;
import com.xoriant.xorbankonline.enums.Role;
import com.xoriant.xorbankonline.enums.TransactionType;
import com.xoriant.xorbankonline.model.Account;
import com.xoriant.xorbankonline.model.Address;
import com.xoriant.xorbankonline.model.Branch;
import com.xoriant.xorbankonline.model.CurrentAccount;
import com.xoriant.xorbankonline.model.Customer;
import com.xoriant.xorbankonline.model.Manager;
import com.xoriant.xorbankonline.model.SavingAccount;
import com.xoriant.xorbankonline.model.User;
import com.xoriant.xorbankonline.utility.SessionFactoryUtil;
import com.xoriant.xorbankonline.model.Transactions;

public class HibernateClient {
	public static void main(String[] args) {

		// Branch Address
		Address address1 = new Address();
		address1.setArea("Baner");
		address1.setCity("Pune");
		address1.setDoorNo(22);
		address1.setState("Maharashtra");
		address1.setPincode(784824);

		// Branch details
		Branch branch1 = new Branch();
		branch1.setBranchId(1);
		branch1.setBranchName("XoriantBaner");
		branch1.setIfscCode("XORB00234");
		branch1.setMicrCode("98765432");
		branch1.setAddress(address1);

		// Manager user
		User user = new User();
		user.setUserName("manager");
		user.setPassword("98765");
		user.setSecurityQuestion("Favoirate sport?");
		user.setSecurityAnswer("basketball");
		user.setRole(Role.MANAGER);

		// Manager details
		Manager manager = new Manager();
		manager.setPersonName("Manager");
		LocalDate date = LocalDate.of(1999, 9, 4);
		manager.setDateOfBirth(date);
		manager.setGender(Gender.MALE);
		manager.setEmailId("manager@gmail.com");
		manager.setMobileNo(985342736);

		// Manager user set to Manager
		manager.setUser(user);
				
		// Manager Address
		Address address = new Address();
		address.setArea("Kalyani nagar");
		address.setCity("Pune");
		address.setDoorNo(19);
		address.setState("Maharashtra");
		address.setPincode(684824);
		
		// Address set to Customer
		manager.setAddress(address);

		// Branch set to manager
		manager.setBranch(branch1);

		// Customer user
		User user1 = new User();
		user1.setUserName("shubhamg");
		user1.setPassword("12345");
		user1.setSecurityQuestion("Favoirate sport?");
		user1.setSecurityAnswer("cricket");
		user1.setRole(Role.CUSTOMER);
		
		// Manager set to Customer user
		user1.setManager(manager);
		
		//Customer user added to Manager
		manager.addUser(user1);

		// Customer details
		Customer customer1 = new Customer();
		customer1.setPersonName("Shubham");
		LocalDate date1 = LocalDate.of(2000, 3, 4);
		customer1.setDateOfBirth(date1);
		customer1.setGender(Gender.MALE);
		customer1.setEmailId("shubham@gmail.com");
		customer1.setMobileNo(985342736);

		// Customer Address
		Address address2 = new Address();
		address2.setArea("Viman nagar");
		address2.setCity("Pune");
		address2.setDoorNo(12);
		address2.setState("Maharashtra");
		address2.setPincode(784824);

		// Address set to Customer
		customer1.setAddress(address2);

		// User set to Customer
		customer1.setUser(user1);

		// Account 1
		SavingAccount account1 = new SavingAccount();
		account1.setAccountType(AccountType.SAVINGS);
		account1.setBalance(5000);
		account1.setInterestRate(10);
		account1.setMinimumBalance(100);
		account1.setTransactionAmountLimit(10000);
		account1.setTransactionsLimit(100);
		account1.setBranch(branch1);
		account1.setCustomer(customer1);

		// Account 2
		CurrentAccount account2 = new CurrentAccount();
		account2.setAccountType(AccountType.CURRENT);
		account2.setBalance(6000);
		account2.setMinimumBalance(500);
		account2.setTransactionAmountLimit(20000);
		account2.setTransactionsLimit(150);
		account2.setBranch(branch1);
		account2.setCustomer(customer1);

		// Transaction 1 of Account 1
		Transactions transaction1 = new Transactions();
		transaction1.setTransactionAmount(500);
		transaction1.setReceiverAccountNumber(account2.getAccountNumber());
		LocalDateTime now = LocalDateTime.now();
		transaction1.setTransactionDate(now);
		transaction1.setTransactionType(TransactionType.DEPOSIT);

		// Account 1 set to Transaction 1
		transaction1.setAccount(account1);

		// Transaction 2 of Account 1
		Transactions transaction2 = new Transactions();
		transaction2.setTransactionAmount(1000);
		transaction2.setReceiverAccountNumber(account2.getAccountNumber());
		transaction2.setTransactionDate(now);
		transaction2.setTransactionType(TransactionType.WITHDRAWL);

		// Account 1 set to Transaction 2
		transaction2.setAccount(account1);

		// Transaction 1 and 2 added to Account 1
		account1.addTransaction(transaction1);
		account1.addTransaction(transaction2);

		// Account 1 and 2 added 2 to Customer 1
		customer1.addAccount(account1);
		customer1.addAccount(account2);
		

		Transaction transaction = null;
		Session session = null;
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();

		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.persist(customer1);
			session.persist(manager);
//			long accno=10002;
//			CurrentAccount account=session.get(CurrentAccount.class, accno);			
//			session.delete(account);
			transaction.commit();
		} catch (Exception e) {
			System.out.println(e);
			transaction.rollback();
		} finally {
			session.close();
		}
	}
}
