package com.easyportfolio.entities;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class DetailInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int detailId;
	private String full_name;
	private String phone_number;
	private double cgpa;
	private String summary;
	private String address;
	private byte[] image;
	private String email;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date birth_day;
//	public DetailInfo(String fullName, String phoneNumber, double cgpa, String summary,
//			String image,Date birthDay,String address) {
//		super();
//		this.fullName = fullName;
//		this.phoneNumber = phoneNumber;
//		this.cgpa = cgpa;
//		this.summary = summary;
//		this.image = image;
//		this.birthDay = birthDay;
//		this.address= address;
//	}
	public DetailInfo() {
		super();
	}
	
	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public int getDetailId() {
		return detailId;
	}
	public void setDetailId(int detailId) {
		this.detailId = detailId;
	}
	
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
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
	
	public Date getBirth_day() {
		return birth_day;
	}

	public void setBirth_day(Date birth_day) {
		this.birth_day = birth_day;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}


