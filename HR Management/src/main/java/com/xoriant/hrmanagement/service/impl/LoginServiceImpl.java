package com.xoriant.hrmanagement.service.impl;

import com.xoriant.hrmanagement.dao.LoginDao;
import com.xoriant.hrmanagement.dao.impl.LoginDaoImpl;
import com.xoriant.hrmanagement.service.LoginService;

public class LoginServiceImpl implements LoginService {

	LoginDao dao;
	
	public LoginServiceImpl() {
		dao=new LoginDaoImpl();
	}
	

	@Override
	public boolean loginService(String username, String password) {
		return dao.findEmployee(username,password);
	}

}
