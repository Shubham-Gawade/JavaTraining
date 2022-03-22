package com.xoriant.springcoreapp.di.annotation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
@ComponentScan(basePackages = "com.xoriant")
@PropertySource("classpath:data.properties")
public class AppConfig {

//	@Bean
//	public Address getAddress() {
//		return new Address(20,"Nigdi","Banglore");
//	}
//	
//	@Bean
//	public Account getAccount() {
//		return new Account(12345, "Shubham", 40000 ,getAddress());
//	}
	
	@Value("${mysql.url}")
	private String URL;
	@Value("${mysql.username}")
	private String username;
	@Value("${mysql.password}")
	private String password;
	@Value("${mysql.driver}")
	private String driver;
	
	@Bean
	public Connection getConnection() throws SQLException, ClassNotFoundException {
		System.out.println("Driver : "+driver);
		System.out.println("URL : "+URL);
		System.out.println("Username : "+password);
		System.out.println("Password : "+password);
		
		Class.forName(driver);
		System.out.println("Driver Loaded");
		Connection connection=DriverManager.getConnection(URL,username,password);
		System.out.println("Connection is established");
		return connection;
	}
	
	@Bean
	public MessageSource getMessageSource() {
		ResourceBundleMessageSource messageBundleResrc=new ResourceBundleMessageSource();
        messageBundleResrc.setBasename("data");
        return messageBundleResrc;
	}
}
