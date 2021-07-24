package com.easyportfolio.entities;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Award {
	private String title, description, year, link;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int aId;
	public Award() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Award(String title, String description, String year, String link) {
		super();
		this.title = title;
		this.description = description;
		this.year = year;
		this.link = link;
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

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
}
