package com.insynergy.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.insynergy.dao.LoginDAO;

@Service
public class LoginServiceImpl implements LoginService {
	
	private LoginDAO loginDAO;

	public void setLoginDAO(LoginDAO loginDAO) {
		this.loginDAO = loginDAO;
	}

	
      @Override
      @Transactional
       public boolean login(String userName, String userPassword){
              System.out.println("In Service class...Check Login   " + loginDAO);
              return loginDAO.login(userName, userPassword);
       }

	
}