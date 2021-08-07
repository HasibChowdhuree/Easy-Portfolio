package com.easyportfolio.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(unique=true)
	private String email;
	@Column(unique=true)
	private String username;
	private String password;
	private String role;
	//user properties 
	@OneToOne(cascade = CascadeType.ALL, fetch =FetchType.LAZY)
	private DetailInfo details;
	@OneToMany(cascade = CascadeType.ALL,fetch =FetchType.LAZY)
	private List<Education> educations;
	@OneToMany(cascade = CascadeType.ALL,fetch =FetchType.LAZY)
	private List<Achievement> achievements;
	@OneToMany(cascade = CascadeType.ALL,fetch =FetchType.LAZY)
	private List<ProfileLinks> profile_links;
	@OneToMany(cascade = CascadeType.ALL,fetch =FetchType.LAZY)
	private List<Skill> skills;
	@OneToMany(cascade = CascadeType.ALL,fetch =FetchType.LAZY)
	private List<Project> projects;
	@OneToMany(cascade = CascadeType.ALL,fetch =FetchType.LAZY)
	private List<Reference> reference;
	@OneToMany(cascade = CascadeType.ALL,fetch =FetchType.LAZY)
	private List<Experience> experience;
	// all getter and setter methods for each entity
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public List<Experience> getExperience() {
		return experience;
	}
	public void setExperience(List<Experience> experience) {
		this.experience = experience;
	}
	public DetailInfo getDetails() {
		return details;
	}
	public void setDetails(DetailInfo details) {
		this.details = details;
	}
	public List<Project> getProjects() {
		return projects;
	}
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	public List<Skill> getSkills() {
		return skills;
	}
	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String toString() {
		return email;
	}
	public int getDetailId() {
		return details.getDetailId();
	}
	public List<Education> getEducations() {
		return educations;
	}
	public void setEducations(List<Education> educations) {
		this.educations = educations;
	}
	public List<Achievement> getAchievements() {
		return achievements;
	}
	public void setAchievements(List<Achievement> achievements) {
		this.achievements = achievements;
	}
	public List<Reference> getReference() {
		return reference;
	}
	public void setReference(List<Reference> reference) {
		this.reference = reference;
	}
	public List<ProfileLinks> getProfile_links() {
		return profile_links;
	}
	public void setProfile_links(List<ProfileLinks> profile_links) {
		this.profile_links = profile_links;
	}
	
}


