package com.xoriant.xorbankonline.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.xoriant.xorbankonline.enums.Role;
import com.xoriant.xorbankonline.model.Address;
import com.xoriant.xorbankonline.model.BankTransaction;
import com.xoriant.xorbankonline.model.PersonInfo;
import com.xoriant.xorbankonline.model.User;
import com.xoriant.xorbankonline.model.UserDetailsDTO;
import com.xoriant.xorbankonline.service.UserService;

@Controller
//@SessionAttributes({"userid","userrole"})
public class UserController {
	@Autowired
	public UserService userService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "index";
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String home() {
		return "index";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(WebRequest request, SessionStatus sessionStatus, HttpSession session) {
	
		session.invalidate();
		return "redirect:/index";
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView loginGet(HttpSession session) {
		// System.out.println(id);

		if(session.getAttribute("transactionmsg")!=null)
			session.removeAttribute("transactionmsg");
		ModelAndView view = new ModelAndView();
		if (null != session.getAttribute("userid")) {
			int id = Integer.parseInt((String) String.valueOf(session.getAttribute("userid")));
			User user = userService.getUser(id);

			view.addObject("user", user);
			String role = (String) session.getAttribute("userrole");
			if (role.equals("CUSTOMER"))
				view.setViewName("customer");
			else {
				view.setViewName("manager");
			}

		} else {
			view.setViewName("index");
		}
		return view;
	}

	@RequestMapping(value = "/home", method = RequestMethod.POST)
	public ModelAndView home(@RequestParam("username") String username, @RequestParam("password") String password,
			HttpSession session) {
		ModelAndView view = new ModelAndView();

		if(session.getAttribute("transactionmsg")!=null)
			session.removeAttribute("transactionmsg");
		System.out.println("Modelandview : " + username + " " + password + " ");
		User user = userService.checkUser(username, password);
		if (user != null) {
			view.addObject("user", user);
			view.addObject("userid", user.getUserId());
			session.setAttribute("userid", user.getUserId());
			if (user.getRole().equals(Role.CUSTOMER)) {
				System.out.println("customer found");
				view.addObject("userrole", "CUSTOMER");
				session.setAttribute("userrole", "CUSTOMER");
				view.setViewName("customer");
			} else {
				System.out.println("manager found");
				view.addObject("userrole", "MANAGER");
				session.setAttribute("userrole", "MANAGER");
				view.setViewName("manager");
			}
		} else {
			System.out.println("user not found");
			view.addObject("msg", "Invalid credentials");
			view.setViewName("index");
		}
		return view;

	}

	@RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
	public ModelAndView details(@PathVariable int id) {
		ModelAndView view = new ModelAndView();
		//UserDetailsDTO userDetails = userService.getUserDetails(id);
		PersonInfo userDetails=userService.getallDetails(id);
		view.addObject("details", userDetails);
		view.setViewName("details");
		return view;
	}

	@ModelAttribute("personinfoObj")
	public PersonInfo gePersonInfo() {
		Address address = new Address();
		PersonInfo personInfo = new PersonInfo();
		personInfo.setAddress(address);
		return personInfo;
	}
	
	@ModelAttribute("bankTransactionObj")
	public BankTransaction getBankTransactionObj() {
		return new BankTransaction();
	}

	@RequestMapping(value = "/updateDetails/{id}", method = RequestMethod.GET)
	public ModelAndView updatedetailsGet(@PathVariable int id) {
		ModelAndView view = new ModelAndView();
		// UserDetailsDTO userDetails=userService.getUserDetails(id);
		PersonInfo allInfo = userService.getallDetails(id);
		view.addObject("details", allInfo);
		view.setViewName("updatedetails");
		return view;
	}

	@RequestMapping(value = "/updateDetails", method = RequestMethod.POST)
	public String updatedetailsPost(@ModelAttribute("personinfoObj") PersonInfo info, HttpSession session) {
		int id = Integer.parseInt((String) String.valueOf(session.getAttribute("userid")));
		PersonInfo allInfo = userService.getallDetails(id);
		info.setPersonId(allInfo.getPersonId());
		info.setDateOfBirth(allInfo.getDateOfBirth());
		info.getAddress().setAddressId(allInfo.getAddress().getAddressId());
		userService.updateDetails(info, id);
		System.out.println(info);
		return "redirect:details/"+id;
	}
	@RequestMapping(value = "/transact/{accountNumber}", method = RequestMethod.GET)
	public ModelAndView updatedetailsGet(@PathVariable("accountNumber") long accountNumber,HttpSession session,Model model) {
		ModelAndView view = new ModelAndView();
		
		session.setAttribute("accountNumber", accountNumber);
	//	view.addObject("accountNumber",accountNumber);
		view.setViewName("transact");
		return view;
	}
	
	@RequestMapping(value = "/transact", method = RequestMethod.POST)
	public String transact(HttpSession session,@ModelAttribute("bankTransactionObj") BankTransaction bankTransaction,HttpServletRequest request) {
		long senderAccountNumber = Integer.parseInt((String) String.valueOf(session.getAttribute("accountNumber")));
		long id = Integer.parseInt((String) String.valueOf(session.getAttribute("userid")));
		long receiverAccountNumber;
		if(session.getAttribute("transactionmsg")!=null)
			session.removeAttribute("transactionmsg");
		System.out.println(senderAccountNumber);
		if(bankTransaction.getTransactionType().toString() == "TRANSFER" ) {
			System.out.println("in transfer if");
			receiverAccountNumber=Integer.parseInt(request.getParameter("receiverAccountnumber"));
		}
		else {
			System.out.println("in transfer else");
			receiverAccountNumber=senderAccountNumber;
		}
		System.out.println("senderAccountNumber : "+senderAccountNumber+" receiverAccountNumber : "+receiverAccountNumber);
		bankTransaction.setTransactionDate(LocalDateTime.now());
		System.out.println(bankTransaction);

	String transactionMsg=userService.transact(bankTransaction,senderAccountNumber,receiverAccountNumber);
	ModelAndView view = new ModelAndView();
	//view.addObject("transactionmsg",transactionMsg);
	
	
	if(transactionMsg.equals("transaction successfull"))
		return "redirect:/customer/accounts/"+id;
	else {
		session.setAttribute("transactionmsg", transactionMsg);
	return "redirect:transact/"+senderAccountNumber;
	}
//		view.addObject("transactionmsg",transactionMsg);
//		//return "transact";
//		return view;
	}
}
