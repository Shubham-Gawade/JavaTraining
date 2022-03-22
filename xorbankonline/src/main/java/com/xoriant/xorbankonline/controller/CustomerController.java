package com.xoriant.xorbankonline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.xoriant.xorbankonline.model.Account;
import com.xoriant.xorbankonline.model.Customer;
import com.xoriant.xorbankonline.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value = "/customerhome", method = RequestMethod.GET)
	public String getCustomerDetails() {
		return "customerhome";
	}
	
	@RequestMapping(value = "/customerDetails", method = RequestMethod.GET)
	public ModelAndView getCustomerDetails(@SessionAttribute("userId") long userId,Model model) {
		Customer customer=customerService.getCustomerDetails(userId);
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("customerdetails");
		modelAndView.addObject("customer",customer);
	
		return modelAndView;
	}
	
	@RequestMapping(value = "/accountDetails/{accountNumber}", method = RequestMethod.GET)
	public ModelAndView getAccountDetails(@PathVariable("accountNumber") long accountNumber,Model model) {
		Account account=customerService.getAccountDetails(accountNumber);
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("accountdetails");
		modelAndView.addObject("account",account);
		
		return modelAndView;
	}
}
