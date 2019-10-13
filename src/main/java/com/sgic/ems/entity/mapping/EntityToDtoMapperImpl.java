package com.sgic.ems.entity.mapping;

import java.util.ArrayList;
import java.util.List;

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
public class EntityToDtoMapperImpl implements EntityToDtoMapper {

	@Override
	public UserDto mapToUserDto(User user) {
		
		UserDto dto = new UserDto();
		dto.setFullName(user.getFullName());
		dto.setId(user.getId());
		dto.setAddress(user.getAddress());
		dto.setContactNumber(user.getAddress());
		dto.setDob(user.getDob());
		dto.setEmail(user.getEmail());
		dto.setGender(user.getGender());
		dto.setNic(user.getNic());
		dto.setJoinDate(user.getJoinDate());
		dto.setMaritalStatus(user.getMaritalStatus());
		dto.setReligion(user.getReligion());
		
		return dto;
	}

	@Override
	public LoginDto mapToLoginDto(Login login) {
		LoginDto dto = new LoginDto();
		
		dto.setId(login.getId());
		dto.setUserName(login.getUserName());
		dto.setPassword(login.getPassword());
		dto.setUserDto(mapToUserDto(login.getUser()));
		dto.setRoleDto(mapToRoleDto(login.getRole()));
		return dto;
	}

	@Override
	public RoleDto mapToRoleDto(Role role) {
		RoleDto dto = new RoleDto();
		
		dto.setId(role.getId());
		dto.setRoleName(role.getRoleName());
		
		return dto;
	}

	@Override
	public ExperienceDto mapToExperieneDto(Experience experience) {
		
		ExperienceDto dto = new ExperienceDto();
		
		dto.setId(experience.getId());
		dto.setDesignation(experience.getDesignation());
		
		return dto;
	}

	@Override
	public AcadamicQualificationDto mapToAccadamicQualificationDto(AcadamicQualification acadamicQualification) {
		
		AcadamicQualificationDto dto = new AcadamicQualificationDto();
		
		dto.setId(acadamicQualification.getId());
		dto.setType(acadamicQualification.getType());
		dto.setYearFrom(acadamicQualification.getYearFrom());
		dto.setYearTo(acadamicQualification.getYearTo());
		dto.setInstitute(acadamicQualification.getInstitute());
		dto.setGradeObtain(acadamicQualification.getGradeObtain());
		dto.setUserDto(mapToUserDto(acadamicQualification.getUser()));
		
		return dto;
	}

	@Override
	public ProfessionalQualificationDto mapToProfessionalQualificationDto(
			ProfessionalQualification professionalQualification) {
		
		ProfessionalQualificationDto dto = new ProfessionalQualificationDto();
		
		dto.setId(professionalQualification.getId());
		dto.setInstitute(professionalQualification.getInstitute());
		dto.setYearFrom(professionalQualification.getYearFrom());
		dto.setYearTo(professionalQualification.getYearTo());
		dto.setUserDto(mapToUserDto(professionalQualification.getUser()));
		
		return dto;
	}

	@Override
	public List<ExperienceDto> mapToExperieneDtoList(List<Experience> experienceList) {
		
		List<ExperienceDto> dtoList = new ArrayList<>();
		
		for (Experience experience : experienceList) {
			dtoList.add(mapToExperieneDto(experience));
		}
		
		return dtoList;
	}

	@Override
	public List<UserDto> mapToUserDtoList(List<User> userList) {
		List<UserDto> dtoList = new ArrayList<>();
		
		for (User user : userList) {
			dtoList.add(mapToUserDto(user));
		}
		
		return dtoList;
	}

	@Override
	public List<LoginDto> mapToLoginDtoList(List<Login> loginList) {
		List<LoginDto> dtoList = new ArrayList<>();
		
		for (Login login : loginList) {
			dtoList.add(mapToLoginDto(login));
		}
		
		return dtoList;
	}

	@Override
	public List<RoleDto> mapToRoleDtoList(List<Role> roleList) {
		List<RoleDto> dtoList = new ArrayList<>();
		
		for (Role role : roleList) {
			dtoList.add(mapToRoleDto(role));
		}
		
		return dtoList;
	}

	@Override
	public List<AcadamicQualificationDto> mapToAcadamicQualificationDtoList(
			List<AcadamicQualification> acadamicQualificationList) {
		List<AcadamicQualificationDto> dtoList = new ArrayList<>();
		
		for (AcadamicQualification acadamicQualification : acadamicQualificationList) {
			dtoList.add(mapToAccadamicQualificationDto(acadamicQualification));
		}
		
		return dtoList;
	}

	@Override
	public List<ProfessionalQualificationDto> mapToProfessionalQualificationDtoList(
			List<ProfessionalQualification> professionalQualificationList) {
		List<ProfessionalQualificationDto> dtoList = new ArrayList<>();
		
		for (ProfessionalQualification professionalQualification : professionalQualificationList) {
			dtoList.add(mapToProfessionalQualificationDto(professionalQualification));
		}
		
		return dtoList;
	}

}
