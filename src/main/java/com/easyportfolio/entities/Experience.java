package com.easyportfolio.entities;

import javax.persistence.Embeddable;

@Embeddable
public class Experience {
	private String title,description;
	private int year;
	

	public Experience(String title, String description, int year) {
		super();
		this.title = title;
		this.description = description;
		this.year = year;
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
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
}

