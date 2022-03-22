package com.xoriant.companyproductapp.service;

import java.util.List;

import com.xoriant.companyproductapp.model.Company;

public interface CompanyService {
	boolean addCompany(Company company);
	
	List<Company> getCompanies();
}
