package com.sgic.ems.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.ems.entity.Experience;
import com.sgic.ems.entity.User;
import com.sgic.ems.repository.ExperienceRepository;
import com.sgic.ems.service.ExperienceService;
@Service
public class ExperienceServiceImpl implements ExperienceService {

	@Autowired
	private ExperienceRepository experienceRepository;
	
	@Override
	public boolean addExperience(Experience experience) {
		experienceRepository.save(experience);
		return true;
	}

	@Override
	public List<Experience> getAllExperience() {
		return experienceRepository.findAll();
	}

	@Override
	public boolean editExperience(Experience experience, Integer id) {
		boolean success = false;
		if (experienceRepository.getOne(id) != null) {
			experience.setId(id);
			experienceRepository.save(experience);
			success = true;
			return success;
		}
		return success;
	}

	@Override
	public boolean deleteExperience(Integer id) {
		Experience experience = experienceRepository.getOne(id);
		if (experience.getId() == (id)) {
			experienceRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public Experience getById(Integer id) {
		return experienceRepository.getOne(id);
	}

	@Override
	public List<Experience> getAllExperienceByUser(Integer id) {
		User user = new User();
		user.setId(id);
		return experienceRepository.getByUser(user);
	}

}
