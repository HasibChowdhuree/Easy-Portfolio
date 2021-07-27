package com.easyportfolio.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProfileLinks {
	private String website, link;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int pId;
	public ProfileLinks(String website, String link) {
		super();
		this.website = website;
		this.link = link;
	}

	public ProfileLinks() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
	
}
