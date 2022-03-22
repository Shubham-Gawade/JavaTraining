package com.xoriant.xorbankonline.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;

import com.xoriant.xorbankonline.enums.Role;
import com.xoriant.xorbankonline.model.User;
import com.xoriant.xorbankonline.service.UserService;

@Controller
//@SessionAttributes({"userId","userName","userRole"})
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "index";
		
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam("userName") String userName,
			@RequestParam("password") String password,HttpSession session, Model model) {

		User user=userService.getUser(userName,password);
	
		if(user != null) {
			
			session.setAttribute("userId",user.getUserId());
			session.setAttribute("userName",user.getUserName());
			session.setAttribute("userRole",user.getRole());
			
			if(user.getRole().equals(Role.MANAGER)) {
				return "redirect:/managerhome";
			}
			else {
				return "redirect:/customerhome";
			}
		}
		else {
			model.addAttribute("message","Username or Password is Invalid");
			return "index";
		}
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/index";
	}
}
