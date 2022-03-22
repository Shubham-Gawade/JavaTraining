package com.xoriant.hibernatetutorials;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {

	public static void main(String[] args) {
		
		SName name1=new SName();
		name1.setFname("Shubham");
		name1.setLname("Gawade");
		
		SName name2=new SName();
		name2.setFname("Pranav");
		name2.setLname("Goel");
		
		Laptop laptop1=new Laptop();
		laptop1.setLid(1);
		laptop1.setName("Dell");
		laptop1.setPrice(30000.0);
		
		Laptop laptop2=new Laptop();
		laptop2.setLid(2);
		laptop2.setName("HP");
		laptop2.setPrice(40000.0);
		
		Student s1=new Student();
		s1.setSid(103);
		s1.setSname(name1);
		s1.setSmarks(120.0);
		s1.getLaptops().add(laptop1);
		
		laptop1.getStudents().add(s1);
		
		Student s2=new Student();
		s2.setSid(102);
		s2.setSname(name2);
		s2.setSmarks(130.0);
		s2.getLaptops().add(laptop2);
		
		laptop2.getStudents().add(s2);
		
		Transaction transaction=null;
		Session session=null;
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
				
		try {
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			
			//Save into DB
//			session.save(laptop1);
//			session.save(s1);
//			session.save(laptop2);
//			session.save(s2);
			
			//Fetch from DB
			Student s3 = session.get(Student.class, 103);
			
			System.out.println(s3.getSname());
			
			System.out.println(s3.getLaptops().get(0));
			
			transaction.commit();
		}catch(Exception e) {
			System.out.println(e);
			transaction.rollback();
		}finally {
			session.close();
		}	
	}

}
