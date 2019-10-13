package com.sgic.ems.service;

import java.util.List;

import com.sgic.ems.entity.Login;

public interface LoginService {

	boolean addLogin(Login login);
	  
	   List<Login> getAllLogin();
	   
	   boolean editLogin(Login login, Integer id);
	   
	   boolean deleteLogin(Integer id);
	   
	   Login getById(Integer id);

}
