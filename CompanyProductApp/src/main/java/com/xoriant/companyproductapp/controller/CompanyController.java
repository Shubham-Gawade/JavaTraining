package com.xoriant.companyproductapp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.xoriant.companyproductapp.model.Company;
import com.xoriant.companyproductapp.service.CompanyService;
import com.xoriant.companyproductapp.service.impl.CompanyServiceImpl;

//@WebServlet("company")
public class CompanyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    CompanyService companyService;
    public CompanyController() {
        super();
        companyService=new CompanyServiceImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int companyId=Integer.parseInt(request.getParameter("companyId"));
		String companyName=request.getParameter("companyName");
	
		Company company=new Company(companyId,companyName);
		if(companyService.addCompany(company)) {
			response.sendRedirect("dashboard.jsp");
		}
	}

}
