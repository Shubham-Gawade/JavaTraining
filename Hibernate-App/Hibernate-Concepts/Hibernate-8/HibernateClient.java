package com.xoriant.hibernateapp.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.xoriant.hibernateapp.model.Address;
import com.xoriant.hibernateapp.model.UserInfo;
import com.xoriant.hibernateapp.util.SessionFactoryUtil;

public class HibernateClient 
{
	public static void main(String[] args) {

		//One to One Mapping strategy with save()
		
		Address address1=new Address();
		address1.setAddressId(123);
		address1.setDoorNO(21);
		address1.setStreetName("MG Road");
		address1.setCity("Pune");
		
		Address address2=new Address();
		address2.setDoorNO(25);
		address2.setStreetName("FC Road");
		address2.setCity("Mumbai");
		
		UserInfo user1=new UserInfo();
		user1.setUserId(101);
		user1.setUserName("Shubham");
		user1.setAddress(address1);
		
		Transaction transaction=null;
		Session session=null;
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
				
		try {
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			session.save(user1);
			session.save(address1);
			transaction.commit();
		}catch(Exception e) {
			System.out.println(e);
			transaction.rollback();
		}finally {
			session.close();
		}

//Two tables are created with common column		
//OneToOne Mapping Joined a addressId column in userinfo table		
		
//		mysql> show tables;
//		+------------------------+
//		| Tables_in_hrmanagement |
//		+------------------------+
//		| address                |
//		| userinfo               |
//		+------------------------+
//		2 rows in set (0.01 sec)
//
//		mysql> select * from userinfo;
//		+--------+----------+-----------+
//		| userId | userName | addressId |
//		+--------+----------+-----------+
//		|    101 | Shubham  |       123 |
//		+--------+----------+-----------+
//		1 row in set (0.00 sec)
//
//		mysql> select * from address;
//		+-----------+------+--------+------------+
//		| addressId | city | doorNO | streetName |
//		+-----------+------+--------+------------+
//		|       123 | Pune |     21 | MG Road    |
//		+-----------+------+--------+------------+
	}
}
