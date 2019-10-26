package com.sgic.ems.service;

import java.util.List;

import com.sgic.ems.entity.AcadamicQualification;

public interface AcadamicQualificationService {

	boolean addAcedemicQualification(AcadamicQualification acedemicQualification);

	List<AcadamicQualification> getAllAcedemicQualification();

	boolean editAcedemicQualification(AcadamicQualification acedemicQualification, Integer id);

	boolean deleteAcedemicQualification(Integer id);

	AcadamicQualification getById(Integer id);
	
	List<AcadamicQualification> getAllAcedemicQualificationByUser(Integer id);

}
