package com.xoriant.companyproductapp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xoriant.companyproductapp.model.Product;
import com.xoriant.companyproductapp.service.ProductService;
import com.xoriant.companyproductapp.service.impl.ProductServiceImpl;

/**
 * Servlet implementation class Product
 */
//@WebServlet("/product")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ProductService productService;
    public ProductController() {
        super();
        productService=new ProductServiceImpl();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int productId=Integer.parseInt(request.getParameter("productId"));
		String productName=request.getParameter("productName");
		double productPrice=Double.parseDouble(request.getParameter("productPrice"));
		String companyName=request.getParameter("companyName");
		
		Product product=new Product(productId,productName,productPrice);
		if(productService.addProduct(product,companyName)) {
			response.sendRedirect("dashboard.jsp");
		}
	}

}
