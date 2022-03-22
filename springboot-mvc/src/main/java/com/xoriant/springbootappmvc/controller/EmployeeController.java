package com.xoriant.springbootappmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.xoriant.springbootappmvc.model.User;

@Controller
public class EmployeeController {

	@GetMapping("/hello")
	public String hello() {
		return "index";
	}
	
	@PostMapping("/hello")
	public String hello(User user) {
		System.out.println(user);
		return "index";
	}
}
