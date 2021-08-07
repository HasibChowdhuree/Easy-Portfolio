package com.easyportfolio.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.easyportfolio.entities.Skill;

public interface SkillRepository extends JpaRepository<Skill,Integer>{
	@Query("select u from Skill u where u.sId = :sId")
	public Skill getProfileById(@Param("sId") int sId);
}
