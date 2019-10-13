package com.sgic.ems.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.ems.entity.Login;
import com.sgic.ems.repository.LoginRepository;
import com.sgic.ems.service.LoginService;
@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginRepository loginRepository;
	
	@Override
	public boolean addLogin(Login login) {
		loginRepository.save(login);
		return true;
	}

	@Override
	public List<Login> getAllLogin() {
		return loginRepository.findAll();
	}

	@Override
	public boolean editLogin(Login login, Integer id) {
		boolean success = false;
		if (loginRepository.getOne(id) != null) {
			login.setId(id);
			loginRepository.save(login);
			success = true;
			return success;
		}
		return success;
	}

	@Override
	public boolean deleteLogin(Integer id) {
		Login login = loginRepository.getOne(id);
		if (login.getId() == (id)) {
			loginRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public Login getById(Integer id) {
		return loginRepository.getOne(id);
	}

}
