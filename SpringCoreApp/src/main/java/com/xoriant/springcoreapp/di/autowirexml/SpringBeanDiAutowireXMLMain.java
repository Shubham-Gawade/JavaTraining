package com.xoriant.springcoreapp.di.autowirexml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBeanDiAutowireXMLMain {

	public static void main(String[] args) {
		
		ApplicationContext context=new ClassPathXmlApplicationContext("spring_bean_di_autowire_xml.xml");

		Account account1=(Account)context.getBean("account1");
		
		System.out.println(account1);
	}

}
