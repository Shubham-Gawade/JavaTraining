package com.xoriant.springmvcapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.xoriant.springmvcapp.model.Employee;
import com.xoriant.springmvcapp.service.AdminService;

@Controller
public class AdminController {

	@Autowired
	private AdminService service;

	// getAllEmployee
	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public ModelAndView getAllEmployee() {
		List<Employee> employees = service.getAllEmployees();

		ModelAndView view = new ModelAndView();
		view.addObject("employees", employees);
		view.setViewName("employeedetails");
		return view;
	}

	@RequestMapping(value = "/employees1", method = RequestMethod.GET)
	public String getAllEmployee1(Model model) {
		List<Employee> employees = service.getAllEmployees();

		model.addAttribute("employees", employees);

		return "employeedetails";
	}

	// =============================================================================

	// getEmployee(int id)
	@RequestMapping(value = "/employees/{id}", method = RequestMethod.GET)
	public ModelAndView getEmployee(@PathVariable int id) {
		Employee employee = service.getEmployee(id);
		System.out.println(employee.getEmployeeName());
		System.out.println(employee.getGender());
		System.out.println(employee.getCity());
		return null;
	}

	// =============================================================================

	// addEmployeeView
	@RequestMapping(value = "/addEmployee", method = RequestMethod.GET)
	public String addEmployeeView() {
		return "addemployee";

	}

	// addEmployee
	@RequestMapping(value = "/addemployee", method = RequestMethod.POST)
	public String addEmployee(@ModelAttribute("employeeObj") Employee employee) {
		boolean isAdded = service.addEmployee(employee);
		return "redirect:/employees";
	}

	@ModelAttribute("employeeObj")
	public Employee getEmployee() {
		return new Employee();
	}

	// =============================================================================

	// First Setting data in text fields to Update
	@RequestMapping(value = "/updateEmployee/{id}", method = RequestMethod.GET)
	public String getEmploeeToUpdate(@PathVariable int id, Model model) {
		Employee employee = service.getEmployee(id);
		model.addAttribute("employee", employee);
		return "updateemployee";
	}

	// updateEmployee
	@RequestMapping(value = "/updateEmployee", method = RequestMethod.POST)
	public String updateEmployee(@RequestParam("employeeId") int employeeId,
			@RequestParam("employeeName") String employeeName, @RequestParam("gender") String gender,
			@RequestParam("city") String city) {
		Employee employee = new Employee(employeeId, employeeName, gender, city);
		service.updateEmployee(employee, employee.getEmployeeId());
		return "redirect:/employees";
	}

	// =============================================================================

	// deleteEmployee
	@RequestMapping(value = "/deleteEmployee/{id}", method = RequestMethod.GET)
	public String deleteEmployee(@PathVariable int id) {
		boolean isDeleted = service.deleteEmployee(id);
		return "redirect:/employees";
	}

}
