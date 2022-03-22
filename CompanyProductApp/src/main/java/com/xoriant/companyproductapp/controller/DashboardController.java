package com.xoriant.companyproductapp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xoriant.companyproductapp.model.Company;
import com.xoriant.companyproductapp.service.CompanyService;
import com.xoriant.companyproductapp.service.impl.CompanyServiceImpl;
/**
 * Servlet implementation class Dashboard
 */
//@WebServlet("/dashboard")
public class DashboardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	private CompanyService service;
    public DashboardController() {
        super();
        service=new CompanyServiceImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Company> companies=service.getCompanies();
		for (Company company : companies) {
			System.out.println(company.getCompanyName());
		}
		HttpSession session=request.getSession(false);
		session.setAttribute("companies", companies);
		response.sendRedirect("dashboard.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
