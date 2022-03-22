package com.xoriant.xorbankonline.main;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.TemporalType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.xoriant.xorbankonline.enums.AccountType;
import com.xoriant.xorbankonline.enums.Gender;
import com.xoriant.xorbankonline.enums.Role;
import com.xoriant.xorbankonline.enums.TransactionType;
import com.xoriant.xorbankonline.model.Address;
import com.xoriant.xorbankonline.model.BankTransaction;
import com.xoriant.xorbankonline.model.Branch;
import com.xoriant.xorbankonline.model.CurrentAccount;
import com.xoriant.xorbankonline.model.Customer;
import com.xoriant.xorbankonline.model.Manager;
import com.xoriant.xorbankonline.model.SavingAccount;
import com.xoriant.xorbankonline.model.User;
import com.xoriant.xorbankonline.util.SessionFactoryUtil;

public class HibernateClient {

	public static void main(String[] args) {
		//-----------branch Creation-----------------
		Address branchAddress=new Address();
		branchAddress.setDoorNo(21);
		branchAddress.setArea("deccan");
		branchAddress.setCity("Pune");
		branchAddress.setState("Maharashtra");
		branchAddress.setPin(411004);
		
		Branch branch=new Branch();
		branch.setBranchId(101);
		branch.setBranchName("Deccan-Branch");
		branch.setIfscCode("XB000123");
		branch.setMicrCode("XB-123456");
		branch.setAddress(branchAddress);

		//--Manager Creation=-------------------
		User user1=new User();
		user1.setUserName("manager");
		user1.setPassword("manager123");
		user1.setSecurityQuestion("pet name?");
		user1.setSecurityAnswer("meet");
		user1.setRole(Role.MANAGER);

		Address managerAddress=new Address();
		managerAddress.setDoorNo(45);
		managerAddress.setArea("camp");
		managerAddress.setCity("Pune");
		managerAddress.setState("Maharashtra");
		managerAddress.setPin(411006);
		
		Manager manager=new Manager();
		//manager.setPersonId(11);
		manager.setPersonName("meet");
		manager.setGender(Gender.MALE);
		manager.setDateOfBirth(LocalDate.of(2000,1,23));
		manager.setEmailId("jainmeet053@gmail.com");
		manager.setMobileNo(9403608772L);
		manager.setAddress(managerAddress);
		manager.setUser(user1);
		manager.setBranch(branch);
	
		//Customers Creation---------------------------
		User user2=new User();
		user2.setUserName("customer1");
		user2.setPassword("customer123");
		user2.setSecurityQuestion("pet name?");
		user2.setSecurityAnswer("meet");
		user2.setRole(Role.CUSTOMER);

		Address customer1Address=new Address();
		customer1Address.setDoorNo(41);
		customer1Address.setArea("swargate");
		customer1Address.setCity("Pune");
		customer1Address.setState("Maharashtra");
		customer1Address.setPin(411001);

		Customer customer1=new Customer();
		//customer1.setPersonId(1000);
		customer1.setPersonName("saheer");
		customer1.setGender(Gender.MALE);
		customer1.setDateOfBirth(LocalDate.of(1975, 3, 31));
		customer1.setEmailId("saheer@gmail.com");
		customer1.setMobileNo(9191919191L);
		customer1.setAddress(customer1Address);
		customer1.setUser(user2);
		
		manager.addCustomer(customer1);
		customer1.setManager(manager);
		
		User user3=new User();
		user3.setUserName("customer2");
		user3.setPassword("customer123");
		user3.setSecurityQuestion("pet name?");
		user3.setSecurityAnswer("heema");
		user3.setRole(Role.CUSTOMER);

		Address customer2Address=new Address();
		customer2Address.setDoorNo(91);
		customer2Address.setArea("padmavati");
		customer2Address.setCity("Pune");
		customer2Address.setState("Maharashtra");
		customer2Address.setPin(411005);
		
		Customer customer2=new Customer();
		//customer2.setPersonId(1001);
		customer2.setPersonName("shruti");
		customer2.setGender(Gender.FEMALE);
		customer2.setDateOfBirth(LocalDate.of(1999, 3, 31));
		customer2.setEmailId("heema@gmail.com");
		customer2.setMobileNo(9292929292L);
		customer2.setAddress(customer2Address);
		customer2.setUser(user3);
		

		manager.addCustomer(customer2);
		customer2.setManager(manager);

//		public CurrentAccount(long accountNumber, AccountType accountType, double balance, Branch branch) {
		CurrentAccount currentAccount=new CurrentAccount();
		//currentAccount.setAccountNumber(1111);
		currentAccount.setAccountType(AccountType.CURRENT);
		currentAccount.setBalance(10000);
		currentAccount.setBranch(branch);
		SavingAccount savingAccount=new SavingAccount();
		//savingAccount.setAccountNumber(1112);
		savingAccount.setAccountType(AccountType.SAVING);
		savingAccount.setBalance(5000);
		savingAccount.setBranch(branch);
		
		customer1.addAccount(currentAccount);
		customer1.addAccount(savingAccount);
		savingAccount.setCustomer(customer1);
		currentAccount.setCustomer(customer1);
		
		SavingAccount savingAccount1=new SavingAccount();
		//savingAccount1.setAccountNumber(1122);
		savingAccount1.setAccountType(AccountType.SAVING);
		savingAccount1.setBalance(5000);
		savingAccount1.setBranch(branch);
		
		customer2.addAccount(savingAccount1);
		savingAccount1.setCustomer(customer2);

		BankTransaction bankTransaction=new BankTransaction();
		bankTransaction.setTransactionAmount(3000);
		bankTransaction.setTransactionDate(LocalDateTime.now());
		bankTransaction.setTransactionType(TransactionType.DEPOSIT);
		currentAccount.addBankTransactions(bankTransaction);
		bankTransaction.setAccount(currentAccount);
		
		BankTransaction bankTransaction1=new BankTransaction();
		bankTransaction1.setTransactionAmount(5000);
		bankTransaction1.setTransactionDate(LocalDateTime.now());
		bankTransaction1.setTransactionType(TransactionType.WITHDRAW);
		currentAccount.addBankTransactions(bankTransaction1);
		bankTransaction1.setAccount(currentAccount);
		
		BankTransaction bankTransaction2=new BankTransaction();
		bankTransaction2.setTransactionAmount(2000);
		bankTransaction2.setTransactionDate(LocalDateTime.now());
		bankTransaction2.setTransactionType(TransactionType.DEPOSIT);
		savingAccount1.addBankTransactions(bankTransaction2);
		bankTransaction2.setAccount(savingAccount1);
		
		BankTransaction bankTransaction3=new BankTransaction();
		bankTransaction3.setTransactionAmount(2000);
		bankTransaction3.setTransactionDate(LocalDateTime.now());
		bankTransaction3.setTransactionType(TransactionType.DEPOSIT);
		savingAccount.addBankTransactions(bankTransaction3);
		bankTransaction3.setAccount(savingAccount);
		
		Session session=null;
		Transaction transaction=null;
		SessionFactory sessionFactory=SessionFactoryUtil.getSessionFactory();
		try {
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			session.persist(manager);
			transaction.commit();
			
		} catch (Exception e) {
			transaction.rollback();
		
		}finally {
			session.close();
		}
	}
}
