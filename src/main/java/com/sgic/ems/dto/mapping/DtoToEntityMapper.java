package com.sgic.ems.dto.mapping;

import com.sgic.ems.dto.AcadamicQualificationDto;
import com.sgic.ems.dto.ExperienceDto;
import com.sgic.ems.dto.LoginDto;
import com.sgic.ems.dto.ProfessionalQualificationDto;
import com.sgic.ems.dto.RoleDto;
import com.sgic.ems.dto.UserDto;
import com.sgic.ems.entity.AcadamicQualification;
import com.sgic.ems.entity.Experience;
import com.sgic.ems.entity.Login;
import com.sgic.ems.entity.ProfessionalQualification;
import com.sgic.ems.entity.Role;
import com.sgic.ems.entity.User;

public interface DtoToEntityMapper {

	User mapToUser(UserDto dto);
	
	Login mapToLogin(LoginDto dto);
	
	Role mapToRole(RoleDto dto);
	
	Experience mapToExperiene(ExperienceDto dto);
	
	AcadamicQualification mapToAccadamicQualification(AcadamicQualificationDto dto);
	
	ProfessionalQualification mapToProfessionalQualification(ProfessionalQualificationDto dto);
}
