package com.easyportfolio.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Education {
	private String institute, nameOfDegree, startingYear, endingYear, gradeType, additionalInfo;
	private String grade;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int eId;
	public int geteId() {
		return eId;
	}
	public void seteId(int eId) {
		this.eId = eId;
	}
	public Education() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Education(String institute, String nameOfDegree, String startingYear, String endingYear, String gradeType,
			String additionalInfo, String grade) {
		super();
		this.institute = institute;
		this.nameOfDegree = nameOfDegree;
		this.startingYear = startingYear;
		this.endingYear = endingYear;
		this.gradeType = gradeType;
		this.additionalInfo = additionalInfo;
		this.grade = grade;

	}
	public String getInstitute() {
		return institute;
	}
	public void setInstitute(String institute) {
		this.institute = institute;
	}
	public String getNameOfDegree() {
		return nameOfDegree;
	}
	public void setNameOfDegree(String nameOfDegree) {
		this.nameOfDegree = nameOfDegree;
	}
	public String getStartingYear() {
		return startingYear;
	}
	public void setStartingYear(String startingYear) {
		this.startingYear = startingYear;
	}
	public String getEndingYear() {
		return endingYear;
	}
	public void setEndingYear(String endingYear) {
		this.endingYear = endingYear;
	}
	public String getGradeType() {
		return gradeType;
	}
	public void setGradeType(String gradeType) {
		this.gradeType = gradeType;
	}
	public String getAdditionalInfo() {
		return additionalInfo;
	}
	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}

}
