package com.easyportfolio.entities;

import javax.persistence.Embeddable;

@Embeddable
public class Skill {
	private String category,skillName;
	public Skill() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Skill(String category, String skillName) {
		super();
		this.category = category;
		this.skillName = skillName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSkillName() {
		return skillName;
	}
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
	
}

