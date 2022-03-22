package com.xoriant.springcoreapp.di.collection;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBeanDiCollectionMain {

	public static void main(String[] args) {

		ApplicationContext context=new ClassPathXmlApplicationContext("spring_bean_di_collection.xml");

		Account account1=(Account)context.getBean("account1");
		Account account2=(Account)context.getBean("account2");
		
		System.out.println(account1);
		System.out.println(account2);
	}

}
