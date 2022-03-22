package com.xoriant.xorbankonline.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xoriant.xorbankonline.model.PersonInfo;
import com.xoriant.xorbankonline.model.User;
import com.xoriant.xorbankonline.service.TestService;

@Controller
public class TestController {

	@Autowired
	TestService testService;
	
	@RequestMapping(value = "/try")
	public String users() {
		System.out.println("in test controller/try");
		List<User> users=testService.getUsers();
		for(User user: users) {
			System.out.println(user.getUserName());
		}
		
		return "index";
	}
	@RequestMapping(value = "/try1")
	public String personinfos() {
		System.out.println("in test controller/try");
		List<PersonInfo> personInfos=testService.getPersonInfo();
		for(PersonInfo personInfo:personInfos) {
			System.out.println(personInfo.getEmailId() +" "+personInfo.getMobileNo()+" "+personInfo.getPersonName());
		}
		
		return "index";
	}
	
	@RequestMapping(value = "/try2")
	public String User() {
		System.out.println("in test controller/try2");
		User user=testService.getUser("customer1","customer123");
		System.out.println(user.getPassword()+" "+user.getUserName()+" "+user.getRole()+" "+user.getSecurityQuestion());
		
		return "index";
	}
}
