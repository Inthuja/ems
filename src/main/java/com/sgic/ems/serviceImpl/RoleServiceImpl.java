package com.sgic.ems.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.ems.entity.Role;
import com.sgic.ems.repository.RoleRepository;
import com.sgic.ems.service.RoleService;
@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;
	
	
	@Override
	public boolean addRole(Role role) {
		roleRepository.save(role);
		return true;
	}

	@Override
	public List<Role> getAllRole() {
		return roleRepository.findAll();
	}

	@Override
	public boolean editRole(Role role, Integer id) {
		boolean success = false;
		if (roleRepository.getOne(id) != null) {
			role.setId(id);
			roleRepository.save(role);
			success = true;
			return success;
		}
		return success;
	}

	@Override
	public boolean deleteRole(Integer id) {
		Role role = roleRepository.getOne(id);
		if (role.getId() == (id)) {
			roleRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public Role getById(Integer id) {
		return roleRepository.getOne(id);
	}

}
