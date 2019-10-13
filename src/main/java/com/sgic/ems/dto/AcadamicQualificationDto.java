package com.sgic.ems.dto;

public class AcadamicQualificationDto {

	private Integer id;
	
	private String type;
	
	private String yearFrom;
	
	private String yearTo;
	
	private String institute;
	
	private String gradeObtain;

	
	private UserDto userDto;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
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


	public String getInstitute() {
		return institute;
	}


	public void setInstitute(String institute) {
		this.institute = institute;
	}


	public String getGradeObtain() {
		return gradeObtain;
	}


	public void setGradeObtain(String gradeObtain) {
		this.gradeObtain = gradeObtain;
	}


	public UserDto getUserDto() {
		return userDto;
	}


	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
	}


	
	
	
}
