package com.sgic.ems.service;

import java.util.List;

import com.sgic.ems.dto.UserNameDto;
import com.sgic.ems.entity.User;

public interface UserService {

	
			User addUser(User user);
		  
		   List<User> getAllUser();
		   
		   boolean editUser(User user, Integer id);
		   
		   boolean deleteUser(Integer id);
		   
		   User getById(Integer id);
		   
		   List<UserNameDto> getAllUserNames();

	}

