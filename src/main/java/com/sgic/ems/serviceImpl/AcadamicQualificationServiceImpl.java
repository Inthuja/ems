package com.sgic.ems.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.ems.entity.AcadamicQualification;
import com.sgic.ems.entity.User;
import com.sgic.ems.repository.AcadamicQualificationRepository;
import com.sgic.ems.service.AcadamicQualificationService;
@Service
public class AcadamicQualificationServiceImpl implements AcadamicQualificationService {

	@Autowired
	private AcadamicQualificationRepository acedemicQualificationRepository;
	
	
	@Override
	public boolean addAcedemicQualification(AcadamicQualification acedemicQualification) {
		acedemicQualificationRepository.save(acedemicQualification);
		return true;
		
	}

	@Override
	public List<AcadamicQualification> getAllAcedemicQualification() {
		return acedemicQualificationRepository.findAll();
	}

	@Override
	public boolean editAcedemicQualification(AcadamicQualification acedemicQualification, Integer id) {
		boolean success = false;
		if (acedemicQualificationRepository.getOne(id) != null) {
			acedemicQualification.setId(id);
			acedemicQualificationRepository.save(acedemicQualification);
			success = true;
			return success;
		}
		return success;
	}

	@Override
	public boolean deleteAcedemicQualification(Integer id) {
		AcadamicQualification acedemicQualification = acedemicQualificationRepository.getOne(id);
		if (acedemicQualification.getId() == (id)) {
			acedemicQualificationRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public AcadamicQualification getById(Integer id) {
		return acedemicQualificationRepository.getOne(id);
	}

	@Override
	public List<AcadamicQualification> getAllAcedemicQualificationByUser(Integer id) {
		User user = new User();
		user.setId(id);
		return acedemicQualificationRepository.getByUser(user);
	}

}
