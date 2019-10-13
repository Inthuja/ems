package com.sgic.ems.entity.mapping;

import java.util.List;

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

public interface EntityToDtoMapper {

	UserDto mapToUserDto(User user);
	
	List<UserDto> mapToUserDtoList(List<User> userList);

	LoginDto mapToLoginDto(Login login);
	
	List<LoginDto> mapToLoginDtoList(List<Login> loginList);

	RoleDto mapToRoleDto(Role role);

	List<RoleDto> mapToRoleDtoList(List<Role> roleList);

	ExperienceDto mapToExperieneDto(Experience experience);

	List<ExperienceDto> mapToExperieneDtoList(List<Experience> experienceList);

	AcadamicQualificationDto mapToAccadamicQualificationDto(AcadamicQualification acadamicQualification);
	
	List<AcadamicQualificationDto> mapToAcadamicQualificationDtoList(List<AcadamicQualification> acadamicQualificationList);
	
	ProfessionalQualificationDto mapToProfessionalQualificationDto(ProfessionalQualification ProfessionalQualification);
	
	List<ProfessionalQualificationDto> mapToProfessionalQualificationDtoList(List<ProfessionalQualification> professionalQualificationList);

}
