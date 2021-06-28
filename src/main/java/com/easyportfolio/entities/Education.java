package com.easyportfolio.entities;

import javax.persistence.Embeddable;

@Embeddable
public class Education {
	private String institute, nameOfDegree, startingYear, endingYear, gradeType, additionalInfo;
	private double grade;
	public Education() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Education(String institute, String nameOfDegree, String startingYear, String endingYear, String gradeType,
			String additionalInfo, double grade) {
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
	public double getGrade() {
		return grade;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}
	
}