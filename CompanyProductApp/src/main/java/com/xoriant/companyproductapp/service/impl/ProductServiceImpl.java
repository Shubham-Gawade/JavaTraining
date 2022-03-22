package com.xoriant.companyproductapp.service.impl;

import com.xoriant.companyproductapp.dao.ProductDao;
import com.xoriant.companyproductapp.dao.impl.ProductDaoImpl;
import com.xoriant.companyproductapp.model.Product;
import com.xoriant.companyproductapp.service.ProductService;

public class ProductServiceImpl implements ProductService{

	ProductDao dao;
	public ProductServiceImpl() {
		dao=new ProductDaoImpl();
	}
	
	@Override
	public boolean addProduct(Product product,String companyName) {
		return dao.insertProduct(product,companyName);
	}

}
