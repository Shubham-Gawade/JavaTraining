package com.xoriant.springcoreapp.di.annotation;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBeanDiAnnotationMain {

	public static void main(String[] args) {
		
		ApplicationContext context=new ClassPathXmlApplicationContext("spring_bean_di_annotation.xml");

		MessageSource message = (MessageSource) context.getBean("messageSource");
		System.out.println(message.getMessage("mysql.driver",null,"Default Message", null));

	}

}
