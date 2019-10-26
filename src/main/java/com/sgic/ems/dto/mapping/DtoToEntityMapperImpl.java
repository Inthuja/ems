package com.sgic.ems.dto.mapping;

import org.springframework.stereotype.Component;

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

@Component
public class DtoToEntityMapperImpl implements DtoToEntityMapper {

	@Override
	public User mapToUser(UserDto dto) {
		User user = new User();
		user.setFullName(dto.getFullName());
		user.setId(dto.getId());
		user.setAddress(dto.getAddress());
		user.setContactNumber(dto.getContactNumber());
		user.setDob(dto.getDob());
		user.setEmail(dto.getEmail());
		user.setGender(dto.getGender());
		user.setNic(dto.getNic());
		user.setJoinDate(dto.getJoinDate());
		user.setMaritalStatus(dto.getMaritalStatus());
		user.setReligion(dto.getReligion());
		return user;
	}

	@Override
	public Login mapToLogin(LoginDto dto) {
		
	Login login = new Login();
		
		login.setId(dto.getId());
		login.setUserName(dto.getUserName());
		login.setPassword(dto.getPassword());
		login.setUser(mapToUser(dto.getUserDto()));
		login.setRole(mapToRole(dto.getRoleDto()));
		return login;
	}

	@Override
	public Role mapToRole(RoleDto dto) {
		
		Role role = new Role();
		
		role.setId(dto.getId());
		role.setRoleName(dto.getRoleName());
		
		
		return role;
	}

	@Override
	public Experience mapToExperiene(ExperienceDto dto) {
		
		Experience experience = new Experience();
		
		experience.setId(dto.getId());
		experience.setDesignation(dto.getDesignation());
		experience.setDuration(dto.getDuration());
		experience.setEndDate(dto.getEndDate());
		experience.setPlace(dto.getPlace());
		experience.setStartDate(dto.getStartDate());
		experience.setUser(mapToUser(dto.getUserDto()));
		
		return experience;
	}

	@Override
	public AcadamicQualification mapToAccadamicQualification(AcadamicQualificationDto dto) {
		
		AcadamicQualification acadamicQualification = new AcadamicQualification();
		
		acadamicQualification.setId(dto.getId());
		acadamicQualification.setType(dto.getType());
		acadamicQualification.setYearFrom(dto.getYearFrom());
		acadamicQualification.setYearTo(dto.getYearTo());
		acadamicQualification.setInstitute(dto.getInstitute());
		acadamicQualification.setGradeObtain(dto.getGradeObtain());
		acadamicQualification.setUser(mapToUser(dto.getUserDto()));
		
		return acadamicQualification;
	}

	@Override
	public ProfessionalQualification mapToProfessionalQualification(ProfessionalQualificationDto dto) {
		
		ProfessionalQualification professionalQualification = new ProfessionalQualification();
		
		professionalQualification.setId(dto.getId());
		professionalQualification.setInstitute(dto.getInstitute());
		professionalQualification.setYearFrom(dto.getYearFrom());
		professionalQualification.setYearTo(dto.getYearTo());
		professionalQualification.setUser(mapToUser(dto.getUserDto()));
		professionalQualification.setType(dto.getType());
		
		return professionalQualification;
		
		
		
	}

}
