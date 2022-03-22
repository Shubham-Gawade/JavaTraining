package com.xoriant.springcoreapp.di.scope;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBeanDiScopeMain {

	public static void main(String[] args) {
		
		ApplicationContext context=new ClassPathXmlApplicationContext("spring_bean_di_scope.xml");

		Account account3=AccountFactory.getAccountSingleton();
		Account account33=AccountFactory.getAccountSingleton();
		account33.setAccountName("Osama");
		System.out.println("Account3 : "+account3);
		System.out.println("account33 : "+account33);
		
		System.out.println("----------------------------------------------------------------");
		
		Account account4=AccountFactory.getAccountPrototype();
		Account account44=AccountFactory.getAccountPrototype();
		account44.setAccountName("Osama");
		System.out.println("Account4 : "+account4);
		System.out.println("account44 : "+account44);
		
		System.out.println("----------------------------------------------------------------");
		System.out.println("----------------------------------------------------------------");
		
		//Singleton scope - will change for first object if we change second object
		Account account1=(Account)context.getBean("account1");
		System.out.println("Account1 : "+account1);
		Account account11=(Account)context.getBean("account1");
		System.out.println("Account1-1 : "+account11);
		account11.setAccountName("Osama");
		System.out.println("Account1 : "+account1);
		System.out.println("Account1-1 : "+account1);
		
		System.out.println("----------------------------------------------------------------");
		
		//Prototype scope - will not change for first object if we change second object
		Account account2=(Account)context.getBean("account2");
		System.out.println("Account2 : "+account2);
		Account account22=(Account)context.getBean("account2");
		System.out.println("Account2-2 : "+account22);
		account22.setAccountName("Saheer");
		System.out.println("Account2 : "+account2);
		System.out.println("Account2-2 : "+account22);
		
	}

}
