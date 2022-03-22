package com.xoriant.companyproductapp.service.impl;

import java.util.List;

import com.xoriant.companyproductapp.dao.CompanyDao;
import com.xoriant.companyproductapp.dao.impl.ComapnyDaoImpl;
import com.xoriant.companyproductapp.model.Company;
import com.xoriant.companyproductapp.service.CompanyService;

public class CompanyServiceImpl implements CompanyService{

	CompanyDao dao;
	public CompanyServiceImpl() {
		dao=new ComapnyDaoImpl();
	}
	
	@Override
	public boolean addCompany(Company company) {
		return dao.insertCompany(company);
	}

	@Override
	public List<Company> getCompanies() {
		return dao.getAllCompanies();
	}

}
