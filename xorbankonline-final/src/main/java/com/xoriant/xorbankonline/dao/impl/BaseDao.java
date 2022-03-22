package com.xoriant.xorbankonline.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;

public class BaseDao {
	
	
	protected void releaseResource(Session session) {
		
		try {
			session.close();
		}catch (HibernateException e) {
		}
		
	}

}
