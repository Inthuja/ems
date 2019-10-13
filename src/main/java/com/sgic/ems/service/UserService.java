package com.sgic.ems.service;

import java.util.List;

import com.sgic.ems.entity.User;

public interface UserService {

	
		boolean addUser(User user);
		  
		   List<User> getAllUser();
		   
		   boolean editUser(User user, Integer id);
		   
		   boolean deleteUser(Integer id);
		   
		   User getById(Integer id);

	}

