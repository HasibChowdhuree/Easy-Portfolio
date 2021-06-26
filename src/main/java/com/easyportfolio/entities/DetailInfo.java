package com.easyportfolio.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DetailInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int detailId;
	private String firstName,lastName, phoneNumber;
	private double cgpa;
	private String tagline;
	private String image;
	private String schoolName, collegeName, universityName;
	private double sscGrade, hscGrade;
	private String graduationYear;
	public DetailInfo(String firstName, String lastName, String phoneNumber, double cgpa, String tagline,
			String image,String schoolName, String collegeName, String universityName, double sscGrade, double hscGrade,
			String graduationYear) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.cgpa = cgpa;
		this.tagline = tagline;
		this.image = image;
		this.schoolName = schoolName;
		this.collegeName = collegeName;
		this.universityName = universityName;
		this.sscGrade = sscGrade;
		this.hscGrade = hscGrade;
		this.graduationYear = graduationYear;
	}
	public DetailInfo() {
		super();
	}
	public int getDetailId() {
		return detailId;
	}
	public void setDetailId(int detailId) {
		this.detailId = detailId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public double getCgpa() {
		return cgpa;
	}
	public void setCgpa(double cgpa) {
		this.cgpa = cgpa;
	}
	public String getTagline() {
		return tagline;
	}
	public void setTagline(String tagline) {
		this.tagline = tagline;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	public String getUniversityName() {
		return universityName;
	}
	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}
	public double getSscGrade() {
		return sscGrade;
	}
	public void setSscGrade(double sscGrade) {
		this.sscGrade = sscGrade;
	}
	public double getHscGrade() {
		return hscGrade;
	}
	public void setHscGrade(double hscGrade) {
		this.hscGrade = hscGrade;
	}
	public String getGraduationYear() {
		return graduationYear;
	}
	public void setGraduationYear(String graduationYear) {
		this.graduationYear = graduationYear;
	}

}


