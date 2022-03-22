package com.xoriant.springcoreapp.di.lifecycle;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBeanDiLifecycleMain {

	public static void main(String[] args) {
	
		AbstractApplicationContext context=new ClassPathXmlApplicationContext("spring_bean_di_autowire_xml.xml");

		Account account1=(Account)context.getBean("account1");
		//Account account2=(Account)context.getBean("account2");
		
		account1.manupulate();
		System.out.println(account1);
		context.registerShutdownHook();
	}

}
