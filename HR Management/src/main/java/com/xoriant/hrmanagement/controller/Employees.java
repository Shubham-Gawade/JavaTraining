package com.xoriant.hrmanagement.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xoriant.hrmanagement.model.Employee;
import com.xoriant.hrmanagement.service.RegistrationService;
import com.xoriant.hrmanagement.service.impl.RegistrationServiceImpl;

//@WebServlet("/employees")
public class Employees extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private RegistrationService service;
    public Employees() {
        super();
        service=new RegistrationServiceImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Employee> employees=service.getEmployees();
		HttpSession session=request.getSession(false);
		session.setAttribute("employees", employees);
		response.sendRedirect("employees2.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
