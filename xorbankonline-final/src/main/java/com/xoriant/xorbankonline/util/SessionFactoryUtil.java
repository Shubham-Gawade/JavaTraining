package com.xoriant.xorbankonline.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryUtil {
	static SessionFactory sessionFactory=null;
	public static SessionFactory getSessionFactory() {
		if(null==sessionFactory) {
			sessionFactory=new Configuration().configure().buildSessionFactory();
		}
		return sessionFactory;

	}

}
