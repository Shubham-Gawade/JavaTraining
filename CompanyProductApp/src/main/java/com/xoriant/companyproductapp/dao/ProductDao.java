package com.xoriant.companyproductapp.dao;

import com.xoriant.companyproductapp.model.Product;

public interface ProductDao {
	
	boolean insertProduct(Product product,String companyName);
}
