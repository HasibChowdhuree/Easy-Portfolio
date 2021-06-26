package com.easyportfolio.entities;

import javax.persistence.Embeddable;

@Embeddable
public class Project {
	private String name, description, link;
	public Project() {
		super();
	}
	public Project(String name, String description, String link) {
		super();
		this.name = name;
		this.description = description;
		this.link = link;
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

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
}

