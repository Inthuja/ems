package com.sgic.ems.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.ems.entity.ProfessionalQualification;
import com.sgic.ems.repository.ProfessionalQualificationRepository;
import com.sgic.ems.service.ProfessionalQualificationService;
@Service
public class ProfessionalQualificationServiceImpl implements ProfessionalQualificationService {

	@Autowired
	private ProfessionalQualificationRepository professionalQualificationRepository;
	
	
	@Override
	public boolean addProfessionalQualification(ProfessionalQualification professionalQualification) {
		professionalQualificationRepository.save(professionalQualification);
		return true;
	}

	@Override
	public List<ProfessionalQualification> getAllProfessionalQualification() {
		return professionalQualificationRepository.findAll();
	}

	@Override
	public boolean editProfessionalQualification(ProfessionalQualification professionalQualification, Integer id) {
		boolean success = false;
		if (professionalQualificationRepository.getOne(id) != null) {
			professionalQualification.setId(id);
			professionalQualificationRepository.save(professionalQualification);
			success = true;
			return success;
		}
		return success;
	}

	@Override
	public boolean deleteProfessionalQualification(Integer id) {
		ProfessionalQualification professionalQualification = professionalQualificationRepository.getOne(id);
		if (professionalQualification.getId() == (id)) {
			professionalQualificationRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public ProfessionalQualification getById(Integer id) {
		return professionalQualificationRepository.getOne(id);
	}

}
