package com.xoriant.xorbankonline.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.text.View;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.xoriant.xorbankonline.model.Account;
import com.xoriant.xorbankonline.model.BankTransaction;
import com.xoriant.xorbankonline.service.CustomerService;

@Controller
//@SessionAttributes("accountid")
public class CustomerController {
	@Autowired
	public CustomerService customerService;

	@RequestMapping(value = "manager/accounts/{id}", method = RequestMethod.GET)
	public ModelAndView accounts(@PathVariable int id, HttpSession session) {
		ModelAndView view = new ModelAndView();
		List<Account> accounts = customerService.getAccountDetails(id);
		System.out.println("accounts/id" + id);
		view.addObject("accountid", id);
		session.setAttribute("accountid", id);
		List<BankTransaction> transactions = customerService.getTransactions();
		view.addObject("accounts", accounts);
		for (Account account : accounts) {
			System.out.println(account.getAccountType());
		}
		view.addObject("page", "manager");
		view.addObject("transactiontype", "all");
		view.addObject("transactions", transactions);
		view.setViewName("accounts");
		return view;
	}

	@RequestMapping(value = "customer/accounts/{id}", method = RequestMethod.GET)
	public ModelAndView accounts1(@PathVariable int id, HttpSession session) {
		ModelAndView view = new ModelAndView();
		List<Account> accounts = customerService.getAccountDetails(id);
		System.out.println("accounts/id" + id);
		view.addObject("accountid", id);
		session.setAttribute("accountid", id);
		List<BankTransaction> transactions = customerService.getTransactions();
		view.addObject("accounts", accounts);
		for (Account account : accounts) {
			System.out.println(account.getAccountType());
		}
		view.addObject("page", "customer");
		view.addObject("transactiontype", "all");
		view.addObject("transactions", transactions);
		view.setViewName("accounts");
		return view;
	}

	@RequestMapping(value = "customer/transactions/{accountNumber}", method = RequestMethod.GET)
	public ModelAndView transactions(@PathVariable int accountNumber, HttpSession session) {
		ModelAndView view = new ModelAndView();
		int id = Integer.parseInt((String) String.valueOf(session.getAttribute("accountid")));
		System.out.println("transactions/id" + id);
		List<BankTransaction> transactions = customerService.getTransaction(accountNumber);
		List<Account> accounts = customerService.getAccountDetails(id);
		for (Account account : accounts) {
			System.out.println(account.getAccountType());
		}
		view.addObject("accounts", accounts);
		view.addObject("page", "customer");
		view.addObject("transactiontype", "specific");
		view.addObject("transactions", transactions);
		view.setViewName("accounts");

		return view;
	}

	@RequestMapping(value = "manager/transactions/{accountNumber}", method = RequestMethod.GET)
	public ModelAndView transactions1(@PathVariable int accountNumber, HttpSession session) {
		ModelAndView view = new ModelAndView();
		int id = Integer.parseInt((String) String.valueOf(session.getAttribute("accountid")));
		System.out.println("transactions/id" + id);
		List<BankTransaction> transactions = customerService.getTransaction(accountNumber);
		List<Account> accounts = customerService.getAccountDetails(id);
		for (Account account : accounts) {
			System.out.println(account.getAccountType());
		}
		view.addObject("accounts", accounts);
		view.addObject("page", "manager");
		view.addObject("transactiontype", "specific");
		view.addObject("transactions", transactions);
		view.setViewName("accounts");

		return view;
	}

	@RequestMapping(value = "customer/ministatement", method = RequestMethod.GET)
	public ModelAndView ministatement(HttpSession session, HttpServletRequest request) {
		int id = Integer.parseInt((String) String.valueOf(session.getAttribute("userid")));

		ModelAndView view = new ModelAndView();
		List<Account> accounts = customerService.getAccountDetails(id);
		for (Account account : accounts) {
			System.out.println(account.getAccountNumber());
		}
		if (request.getParameter("accountNumber") != null) {
			int accountNumber = Integer.parseInt(request.getParameter("accountNumber"));
			System.out.println(accountNumber);
			List<BankTransaction> transactions=customerService.getMinistatement(accountNumber);
			view.addObject("transactions",transactions);
		}
		System.out.println("hello");

		view.addObject("accounts", accounts);
		view.setViewName("ministatement");
		return view;
	}
}
