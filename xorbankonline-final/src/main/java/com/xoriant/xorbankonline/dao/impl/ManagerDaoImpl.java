package com.xoriant.xorbankonline.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
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
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.xoriant.xorbankonline.config.HibernateConfig;
import com.xoriant.xorbankonline.controller.CustomerController;
import com.xoriant.xorbankonline.dao.ManagerDao;
import com.xoriant.xorbankonline.enums.Gender;
import com.xoriant.xorbankonline.enums.Role;
import com.xoriant.xorbankonline.model.Account;
import com.xoriant.xorbankonline.model.Address;
import com.xoriant.xorbankonline.model.Branch;
import com.xoriant.xorbankonline.model.Customer;
import com.xoriant.xorbankonline.model.Manager;
import com.xoriant.xorbankonline.model.PersonInfo;
import com.xoriant.xorbankonline.model.User;

@Repository
public class ManagerDaoImpl implements ManagerDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private Session session = HibernateConfig.getSessionFactory().openSession();

	@Override
	public List<PersonInfo> getCustomers(int id) {
		Session session = HibernateConfig.getSessionFactory().openSession();
		// TODO Auto-generated method stub
		// String query="select c.personId as
		// customerId,c.managerId,p.emailId,p.gender,p.mobileNo,p.userId from customer
		// as c inner join manager as m on m.personId=c.managerId inner join personinfo
		// as p on c.personId=p.personId";

		String queryStr = "from PersonInfo where personId in (select personId from Customer where managerId=(select personId from PersonInfo where userId=:userId))";
		Query query = session.createQuery(queryStr);
		query.setParameter("userId", id);
		List<PersonInfo> list = query.list();
		for (PersonInfo personInfo : list) {
			System.out.println(personInfo.getEmailId());
		}
		session.close();
		return list;
	}

	@Override
	public void addCustomer(Customer customer) {
		Session session = HibernateConfig.getSessionFactory().openSession();
		// TODO Auto-generated method stub
		// String query="select c.personId as
		// customerId,c.managerId,p.emailId,p.gender,p.mobileNo,p.userId from customer
		// as c inner join manager as m on m.personId=c.managerId inner join personinfo
		// as p on c.personId=p.personId";

		String queryStr = "from Manager";
		Query query = session.createQuery(queryStr);
		Manager manager = (Manager) query.uniqueResult();

		List<Customer> customers = new ArrayList<Customer>();
		System.out.println(manager.getEmailId());
		customers = manager.getCustomers();
		for (Customer c : customers) {
			System.out.println(c.getPersonName());
		}

		manager.addCustomer(customer);
		customer.setManager(manager);
		Transaction transaction = session.beginTransaction();
		session.persist(manager);
		transaction.commit();
		customers = manager.getCustomers();
		for (Customer c : customers) {
			System.out.println(c.getPersonName());
		}
		session.close();

	}



	@Override
	public void addAccount(Account account, int id) {
		Session session = HibernateConfig.getSessionFactory().openSession();
		Customer customer = session.get(Customer.class, id);
		Query query = session.createQuery("from Branch");
		Branch branch = (Branch) query.uniqueResult();
		account.setBranch(branch);
		account.setCustomer(customer);
		customer.addAccount(account);
		Transaction transaction = session.beginTransaction();
		session.persist(customer);
		transaction.commit();
//		System.out.println(account.getCustomer()+" "+account.getBranch());
//		System.out.println(branch.getBranchId()+" "+branch.getBranchName());
		session.close();
	}

	public void deleteAccount(long accountNumber) {
		Session session = HibernateConfig.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Account account = session.get(Account.class, accountNumber);
		session.delete(account);
		transaction.commit();
		session.close();
	}

//	public static void main(String[] args) {
//		new ManagerDaoImpl().deleteCustomer();
//	}

	@Override
	public void deleteCustomer(int customerId) {
		// TODO Auto-generated method stub
		Session session = HibernateConfig.getSessionFactory().openSession();

		Transaction transaction = session.beginTransaction();
		Customer customer2 = session.get(Customer.class, customerId);
		session.delete(customer2);
		transaction.commit();
		session.close();
	}
}
