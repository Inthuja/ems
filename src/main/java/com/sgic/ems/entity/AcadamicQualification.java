package com.sgic.ems.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "accadamic_qualification", schema = "employee")
public class AcadamicQualification implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1729424181786919126L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "type")
	private String type;
	@Column(name = "year_from")
	private String yearFrom;
	@Column(name = "year_to")
	private String yearTo;
	@Column(name = "institute")
	private String institute;
	@Column(name = "grade_obtain")
	private String gradeObtain;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
