package com.sgic.ems.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.ems.entity.User;
import com.sgic.ems.repository.UserRepository;
import com.sgic.ems.service.UserService;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	
	
	@Override
	public boolean addUser(User user) {
		userRepository.save(user);
		return true;
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	@Override
	public boolean editUser(User user, Integer id) {
		boolean success = false;
		if (userRepository.getOne(id) != null) {
			user.setId(id);
			userRepository.save(user);
			success = true;
			return success;
		}
		return success;
	}

	@Override
	public boolean deleteUser(Integer id) {
		User user = userRepository.getOne(id);
		if (user.getId() == (id)) {
			userRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public User getById(Integer id) {
		return userRepository.getOne(id);
	}

}
