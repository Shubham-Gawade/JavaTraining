package com.xoriant.xorbankonline.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.xoriant.xorbankonline.enums.Role;
import com.xoriant.xorbankonline.model.Account;
import com.xoriant.xorbankonline.model.Address;
import com.xoriant.xorbankonline.model.Customer;
import com.xoriant.xorbankonline.model.PersonInfo;
import com.xoriant.xorbankonline.model.User;
import com.xoriant.xorbankonline.service.ManagerService;
@Controller
public class ManagerController {
	@Autowired
	public ManagerService managerService;
	
	@RequestMapping(value = "/manager/customers", method = RequestMethod.GET)
	public ModelAndView home(HttpSession session) {
		int id = Integer.parseInt((String) String.valueOf(session.getAttribute("userid")));
		ModelAndView view=new ModelAndView();
		List<PersonInfo> customerList=new ArrayList();
		customerList=managerService.getCustomers(id);
		System.out.println(customerList.size());	

		view.addObject("customers",customerList);
		view.setViewName("accounts");
		return view;
	}
	
	
	@ModelAttribute("addCustomerObj")
	public Customer getCustomerModelAttribute() {
		Customer customer=new Customer();
		User user=new User();
		Address address=new Address();
		customer.setAddress(address);
		customer.setUser(user);
		
		return customer;
	}
	@ModelAttribute("accountObj")
	public Account getAccount() {
		return new Account();
	}
	@RequestMapping(value="/manager/addCustomer",method = RequestMethod.GET)
	public String addCustomer() {
		return "addcustomer";
	}
	@RequestMapping(value="/manager/addCustomer",method = RequestMethod.POST)
	public String addCustomer1(@ModelAttribute("addCustomerObj") Customer c,HttpServletRequest request) {
		//System.out.println(c.toString());
		LocalDate date=LocalDate.parse(request.getParameter("dob"));	
		c.setDateOfBirth(date);
		c.getUser().setRole(Role.CUSTOMER);
	//	System.out.println(c.toString());
		managerService.addCustomer(c);
		return "redirect:customers";
	}
	
	@RequestMapping(value="/manager/addAccount",method = RequestMethod.GET)
	public String addAccount() {
	
		return "addaccount";
	}
	@RequestMapping(value="/manager/addAccount",method = RequestMethod.POST)
	public String addAccount(HttpSession session,@ModelAttribute("accountObj") Account account) {
		int id = Integer.parseInt((String) String.valueOf(session.getAttribute("accountid")));
		System.out.println(id);
		System.out.println(account);
		managerService.addAccount(account,id);
		return "redirect:accounts/"+id;
	}
	
	@RequestMapping(value = "manager/deleteAccount/{accountNumber}",method = RequestMethod.GET)
	public String deleteAccount(@PathVariable("accountNumber") long accountNumber,HttpSession session) {
		System.out.println(accountNumber);
		managerService.deleteAccount(accountNumber);
		int id = Integer.parseInt((String) String.valueOf(session.getAttribute("accountid")));
		System.out.println(id);
		return "redirect:/manager/accounts/"+id;
	}
	@RequestMapping(value = "manager/deleteCustomer/{customerId}",method = RequestMethod.GET)
	public String deleteCustomer(@PathVariable("customerId") int customerId,HttpSession session) {
//		System.out.println(accountNumber);
//		managerService.deleteAccount(accountNumber);
		int id = Integer.parseInt((String) String.valueOf(session.getAttribute("accountid")));
//		System.out.println(id);
		managerService.deleteCustomer(customerId);
		System.out.println(customerId);
		return "redirect:/manager/customers";
	}
}
