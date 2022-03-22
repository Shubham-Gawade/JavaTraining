package com.xoriant.xorbankonline.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.xoriant.xorbankonline.enums.AccountType;
import com.xoriant.xorbankonline.enums.Gender;
import com.xoriant.xorbankonline.model.Account;
import com.xoriant.xorbankonline.model.Address;
import com.xoriant.xorbankonline.model.Branch;
import com.xoriant.xorbankonline.model.CurrentAccount;
import com.xoriant.xorbankonline.model.Customer;
import com.xoriant.xorbankonline.model.Manager;
import com.xoriant.xorbankonline.model.SavingAccount;
import com.xoriant.xorbankonline.model.Transactions;
import com.xoriant.xorbankonline.model.User;
import com.xoriant.xorbankonline.service.ManagerService;

@Controller
@SessionAttributes({ "customerId", "accountNumber" })
public class ManagerController {

	@Autowired
	private ManagerService managerService;

	@RequestMapping(value = "/addCustomer", method = RequestMethod.GET)
	public String addCustomerView() {
		return "addcustomer";
	}

	@RequestMapping(value = "/showCustomer/addAccount/{customerId}", method = RequestMethod.GET)
	public String addAccountView(@PathVariable long customerId, Model model) {
		model.addAttribute("customerId", customerId);
		return "addaccount";
	}

	@RequestMapping(value = "/showCustomer/showAccount/makeTransaction/{accountNumber}", method = RequestMethod.GET)
	public String addTransactionView(@PathVariable long accountNumber, Model model) {
		model.addAttribute("accountNumber", accountNumber);
		return "maketransaction";
	}

	// Add Customer
	@RequestMapping(value = "/addcustomer", method = RequestMethod.POST)
	public String addCustomer(@ModelAttribute("customerObj") Customer customer, HttpServletRequest request) {
		LocalDate date = LocalDate.parse(request.getParameter("dob"));
		customer.setDateOfBirth(date);
		boolean isAdded = managerService.addCustomer(customer);
		return "redirect:/managerhome";
	}

	@ModelAttribute("customerObj")
	public Customer getCustomer() {
		Customer customer = new Customer();
		User user = new User();
		Address address = new Address();
		customer.setAddress(address);
		customer.setUser(user);
		return customer;
	}

	// Add Account
	@RequestMapping(value = "/showCustomer/addAccount/addaccount", method = RequestMethod.POST)
	public String addAccount(HttpServletRequest request, @SessionAttribute("userId") int managerId,
			@SessionAttribute("customerId") long customerId, @ModelAttribute("accountObj") Account account) {

		String accountType = request.getParameter("accountType");
		System.out.println("Acctype" + accountType);
		int transactionsLimit = Integer.parseInt(request.getParameter("transactionsLimit"));
		double minimumBalance = Double.parseDouble(request.getParameter("transactionsLimit"));
		double transactionAmountLimit = Double.parseDouble(request.getParameter("transactionsLimit"));
		double interestRate = Double.parseDouble(request.getParameter("interestRate"));

		Branch branch = managerService.getBranch(managerId);
		Customer customer = managerService.getCustomer(customerId);
		if (account.getAccountType().equals("CURRENT")) {
			CurrentAccount currentAccount = new CurrentAccount();
			currentAccount.setAccountType(account.getAccountType());
			currentAccount.setBalance(account.getBalance());
			currentAccount.setMinimumBalance(minimumBalance);
			currentAccount.setTransactionsLimit(transactionsLimit);
			currentAccount.setTransactionAmountLimit(transactionAmountLimit);
			currentAccount.setBranch(branch);
			currentAccount.setCustomer(customer);
			boolean isAdded = managerService.addAccount(currentAccount);
			return "redirect:/managerhome";
		} else {
			SavingAccount savingAccount = new SavingAccount();
			savingAccount.setAccountType(account.getAccountType());
			savingAccount.setBalance(account.getBalance());
			savingAccount.setMinimumBalance(minimumBalance);
			savingAccount.setTransactionsLimit(transactionsLimit);
			savingAccount.setAccountType(AccountType.valueOf(accountType));
			savingAccount.setTransactionAmountLimit(transactionAmountLimit);
			savingAccount.setInterestRate(interestRate);
			savingAccount.setBranch(branch);
			savingAccount.setCustomer(customer);
			boolean isAdded = managerService.addAccount(savingAccount);
			return "redirect:/managerhome";
		}
	}

	@ModelAttribute("accountObj")
	public Account getAccount() {
		Account account = new Account();
		return account;
	}

	@RequestMapping(value = "/managerhome", method = RequestMethod.GET)
	public ModelAndView getCustomerDetails(Model model, @SessionAttribute("userId") long managerId) {
		List<Customer> customers = managerService.getAllCustomerDetails();
		Manager manager = managerService.getManagerDetails(managerId);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("managerhome");
		modelAndView.addObject("customers", customers);
		modelAndView.addObject("manager", manager);
		return modelAndView;
	}

	@RequestMapping(value = "/showCustomer/{customerId}", method = RequestMethod.GET)
	public ModelAndView showAccountView(@PathVariable long customerId, Model model) {
		ModelAndView modelAndView = new ModelAndView();
		Customer customer = managerService.getCustomer(customerId);
		modelAndView.setViewName("showcustomer");
		modelAndView.addObject("customer", customer);
		return modelAndView;
	}

	// Display Account
	@RequestMapping(value = "/showCustomer/showAccount/{accountNumber}", method = RequestMethod.GET)
	public ModelAndView getAccountDetails(@PathVariable("accountNumber") long accountNumber, Model model,
			HttpServletRequest request) {
		Account account = managerService.getAccountDetails(accountNumber);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("showaccount");
		HttpSession session = request.getSession(false);
		session.setAttribute("accountType", account.getAccountType().toString());
		modelAndView.addObject("account", account);
		return modelAndView;
	}

	// Delete Account
	@RequestMapping(value = "/showCustomer/deleteAccount/{accountNumber}", method = RequestMethod.GET)
	public String deleteAccount(@PathVariable("accountNumber") long accountNumber) {
		boolean isDeleted = managerService.deleteAccount(accountNumber);
		return "redirect:/managerhome";
	}

	// Delete Customer
	@RequestMapping(value = "/deleteCustomer/{customerId}", method = RequestMethod.GET)
	public String deleteCustomer(@PathVariable("customerId") long customerId) {
		boolean isDeleted = managerService.deleteCustomer(customerId);
		return "redirect:/managerhome";
	}

	@RequestMapping(value = "/showCustomer/showAccount/MakeTransaction/maketransaction", method = RequestMethod.POST)
	public String makeTransaction(@SessionAttribute("accountNumber") long accountNumber,
			@ModelAttribute("transactionObj") Transactions transaction) {
		Account account = managerService.getAccount(accountNumber);
		transaction.setAccount(account);
		LocalDateTime date = LocalDateTime.now();
		transaction.setTransactionDate(date);
		System.out.println(transaction);
		boolean isDeleted = managerService.makeTransaction(transaction);
		return "redirect:/managerhome";
	}

	@ModelAttribute("transactionObj")
	public Transactions getTransaction() {
		Transactions transaction = new Transactions();
		return transaction;
	}

}
