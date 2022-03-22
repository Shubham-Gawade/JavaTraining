package com.xoriant.springmvcapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.xoriant.springmvcapp.model.User;

@Controller
public class EmployeeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "index";
		
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginConventional(HttpServletRequest request) {
		// Retrieve the posted form data
		String userName = request.getParameter("username");
		String password = request.getParameter("password");

		System.out.println(userName + "   " + password);

		if (userName.equals("Shubham") && password.equals("12345")) {
			return "home";
		}

		else {
			return "index";
		}
	}

	//----------------------------------------------------------------------------------
	
	@RequestMapping(value = "/login1", method = RequestMethod.POST)
	public String loginRequestParam(@RequestParam("username") String userName,
			@RequestParam("password") String password) {
		// Retrieve the posted form data
		System.out.println(userName + "   " + password);

		if (userName.equals("Shubham") && password.equals("12345")) {
			return "home";
		}

		else {
			return "index";
		}
	}
	
	//----------------------------------------------------------------------------------

	//We have to use jstl form library
	@RequestMapping(value = "/login2", method = RequestMethod.POST)
	public String loginModelAttribute(@ModelAttribute("userObj") User user) {
		// Retrieve the posted form data
		System.out.println(user.getUserName() + "   " + user.getPassword());

		if (user.getUserName().equals("Shubham") && user.getPassword().equals("12345")) {
			return "home";
		}

		else {
			return "index";
		}
	}

	@ModelAttribute("userObj")
	public User getUser() {
		return new User();
	}

}
