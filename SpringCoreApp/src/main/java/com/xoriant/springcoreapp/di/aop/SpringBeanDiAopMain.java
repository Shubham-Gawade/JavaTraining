package com.xoriant.springcoreapp.di.aop;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class SpringBeanDiAopMain {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("spring_bean_di_aop.xml");

		Account account1 = (Account) context.getBean("account1");
		//System.out.println(account1);
		account1.getAccountNumber();
		//account1.getSomeMehtod();
		account1.getAccountName();
		account1.getBalance();
		
		account1.getAddress().getStreetName();
		

	}

}
