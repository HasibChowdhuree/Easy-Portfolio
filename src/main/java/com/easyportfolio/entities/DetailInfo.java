package com.easyportfolio.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class DetailInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int detailId;
	private String fullName, phoneNumber;
	private double cgpa;
	private String summary;
	private String address;
	private String image;
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date birthDay;
	public DetailInfo(String fullName, String phoneNumber, double cgpa, String summary,
			String image,Date birthDay,String address) {
		super();
		this.fullName = fullName;
		this.phoneNumber = phoneNumber;
		this.cgpa = cgpa;
		this.summary = summary;
		this.image = image;
		this.birthDay = birthDay;
		this.address= address;
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
	public String getsummary() {
		return summary;
	}
	public void setsummary(String summary) {
		this.summary = summary;
	}
	public Date getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	


}


