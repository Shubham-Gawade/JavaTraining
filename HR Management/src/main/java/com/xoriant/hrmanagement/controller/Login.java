package com.xoriant.hrmanagement.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xoriant.hrmanagement.service.LoginService;
import com.xoriant.hrmanagement.service.impl.LoginServiceImpl;

//@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private LoginService service;
    public Login() {
        super();
        service=new LoginServiceImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(service.loginService(username,password)) {
			HttpSession session = request.getSession(true);
			session.setAttribute("user", username);
			//session.setMaxInactiveInterval(60);
			response.sendRedirect("index.jsp");
		} else {
			response.sendRedirect("login.jsp?msg=Username or Password is Invalid");
		}
	}

}
