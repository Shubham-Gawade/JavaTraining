package com.xoriant.companyproductapp.dao;

import java.util.List;

import com.xoriant.companyproductapp.model.Company;

public interface CompanyDao {
	
	boolean insertCompany(Company company);
	
	List<Company> getAllCompanies();
}
