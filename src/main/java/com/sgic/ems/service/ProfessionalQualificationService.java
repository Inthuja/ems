package com.sgic.ems.service;

import java.util.List;

import com.sgic.ems.entity.ProfessionalQualification;

public interface ProfessionalQualificationService {

	boolean addProfessionalQualification(ProfessionalQualification professionalQualification);
	  
	   List<ProfessionalQualification> getAllProfessionalQualification();
	   
	   boolean editProfessionalQualification(ProfessionalQualification professionalQualification, Integer id);
	   
	   boolean deleteProfessionalQualification(Integer id);
	   
	   ProfessionalQualification getById(Integer id);
	   
	   List<ProfessionalQualification> getAllProfessionalQualificationByUser(Integer id);
	
}
