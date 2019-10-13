package com.sgic.ems.service;

import java.util.List;

import com.sgic.ems.entity.Role;

public interface RoleService {
	
	
		boolean addRole(Role role);
		  
		   List<Role> getAllRole();
		   
		   boolean editRole(Role role, Integer id);
		   
		   boolean deleteRole(Integer id);
		   
		   Role getById(Integer id);

	}


