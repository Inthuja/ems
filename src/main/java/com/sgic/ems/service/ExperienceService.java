package com.sgic.ems.service;

import java.util.List;

import com.sgic.ems.entity.Experience;

public interface ExperienceService {

	boolean addExperience(Experience experience);
	  
	   List<Experience> getAllExperience();
	   
	   boolean editExperience(Experience experience, Integer id);
	   
	   boolean deleteExperience(Integer id);
	   
	   Experience getById(Integer id);
	   
	   List<Experience> getAllExperienceByUser(Integer id);
	
}
