package com.easyportfolio.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Skill {
	private String category,skillName;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int sId;
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

