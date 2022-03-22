package com.xoriant.xorbankonline.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.xoriant.xorbankonline.config.HibernateConfig;
import com.xoriant.xorbankonline.dao.TestDao;
import com.xoriant.xorbankonline.model.PersonInfo;
import com.xoriant.xorbankonline.model.User;
import com.xoriant.xorbankonline.model.UserDetailsDTO;

@Repository
public class TestDaoImpl implements TestDao{
//	@Autowired
//	private HibernateTemplate hibernateTemplate;
	private Session session=HibernateConfig.getSessionFactory().openSession();
	public List<User> getUsers(){
		String query="from User";
		
		//List<User> users=(List<User>) this.hibernateTemplate.find(query);
		List<User> users=session.createQuery(query).list();
		return users;
	}
	public User getUser(String username,String password){
		String queryStr="from User where userName=:username and password=:password";
		//Query query=hibernateTemplate.getSessionFactory().openSession().createQuery(queryStr);
		Query query=session.createQuery(queryStr);
		query.setParameter("username", username);
		query.setParameter("password", password);
		List<User> userList=query.list();
		for(User user:userList) {
			System.out.println(user.getUserName()+" "+user.getRole());
		}
		return userList.get(0);
	}
	public List<PersonInfo> getPersonInfo(){
		String query="from PersonInfo";
		//List<PersonInfo> personInfos=(List<PersonInfo>) this.hibernateTemplate.find(query);
		List<PersonInfo> personInfos=session.createQuery(query).list();
		return personInfos;
	}
	
	
	public void callJoin() {
		
		String queryString="select new com.xoriant.xorbankonline.model.UserDetailsDTO(u.userId,u.userName,p.personName,p.dateOfBirth,p.gender,p.emailId,p.mobileNo) from User u join PersonInfo p on p.user.userId=u.userId where u.userId=2";
		
		Query query=session.createQuery(queryString);
		
		UserDetailsDTO userDetailsDTO=(UserDetailsDTO)query.uniqueResult();
		System.out.println(userDetailsDTO);
		
		//Object[] joinResult=(Object[])query.uniqueResult();
		
	/*	for(Object o: joinResult) {
			System.out.println(o);
		}*/
	}
	
	public static void main(String[] args) {
		
		new TestDaoImpl().callJoin();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
