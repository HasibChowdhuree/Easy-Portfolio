package com.easyportfolio.entities;

import javax.persistence.Embeddable;

@Embeddable
public class Reference {
	private String name, description;

	public Reference() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reference(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
