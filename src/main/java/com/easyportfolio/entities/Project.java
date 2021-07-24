package com.easyportfolio.entities;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Project {
	private String name, description,toolUsed, link;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int pId;
	public Project() {
		super();
	}
	public Project(String name, String description,String toolUsed, String link) {
		super();
		this.name = name;
		this.description = description;
		this.link = link;
		this.toolUsed = toolUsed;
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
	
	public String getToolUsed() {
		return toolUsed;
	}
	public void setToolUsed(String toolUsed) {
		this.toolUsed = toolUsed;
	}
	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
}

