package com.easyportfolio.entities;

import javax.persistence.Embeddable;

@Embeddable
public class Experience {
	private String title,description,startYear, endYear;
	public Experience(String title, String description, String startYear, String endYear) {
		super();
		this.title = title;
		this.description = description;
		this.startYear = startYear;
		this.endYear = endYear;
	}

	public Experience() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
	
	
}

