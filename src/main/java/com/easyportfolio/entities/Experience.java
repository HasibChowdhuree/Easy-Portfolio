package com.easyportfolio.entities;

import javax.persistence.Embeddable;

@Embeddable
public class Experience {
	private String companyName, position,startYear, endYear,description;

	public Experience(String companyName, String position, String startYear, String endYear, String description) {
		super();
		this.companyName = companyName;
		this.position = position;
		this.startYear = startYear;
		this.endYear = endYear;
		this.description = description;
	}

	public Experience() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getStartYear() {
		return startYear;
	}

	public void setStartYear(String startYear) {
		this.startYear = startYear;
	}

	public String getEndYear() {
		return endYear;
	}

	public void setEndYear(String endYear) {
		this.endYear = endYear;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}

