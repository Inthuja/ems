package com.sgic.ems.dto;

public class ProfessionalQualificationDto {

	private Integer id;
	
	private String institute;
	
	private String yearFrom;
	
	private String yearTo;
	
	
	private UserDto userDto;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getInstitute() {
		return institute;
	}


	public void setInstitute(String institute) {
		this.institute = institute;
	}


	public String getYearFrom() {
		return yearFrom;
	}


	public void setYearFrom(String yearFrom) {
		this.yearFrom = yearFrom;
	}


	public String getYearTo() {
		return yearTo;
	}


	public void setYearTo(String yearTo) {
		this.yearTo = yearTo;
	}


	public UserDto getUserDto() {
		return userDto;
	}


	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
	}


	
	
	
}
