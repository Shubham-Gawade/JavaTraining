package com.xoriant.hrmanagement.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xoriant.hrmanagement.model.Employee;
import com.xoriant.hrmanagement.service.RegistrationService;
import com.xoriant.hrmanagement.service.impl.*;


//@WebServlet("/register")
public class Registration extends HttpServlet {
       
	private RegistrationService service;
    public Registration() {
        super();
        service=new RegistrationServiceImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processService(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processService(request,response);
	}

	private void processService(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println("Hello Server");
		int eid=Integer.parseInt(request.getParameter("eid"));
		String empname=request.getParameter("ename");
		String gender=request.getParameter("gender");
		String city=request.getParameter("city");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		Employee employee=new Employee(eid, empname, gender, city,username,password);
		
		if(service.registerService(employee)) {
			//response.sendRedirect("success.jsp");
			//response.sendRedirect("index.jsp?msg=Successfully Registered");
			
			RequestDispatcher dispatcher=request.getRequestDispatcher("index.jsp");
			request.setAttribute("msg", "Successfully Registered");
		    dispatcher.forward(request, response);
		}
	}

}
