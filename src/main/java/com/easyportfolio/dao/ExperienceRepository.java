package com.easyportfolio.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.easyportfolio.entities.Experience;


public interface ExperienceRepository extends JpaRepository<Experience,Integer> {
	@Query("select u from Experience u where u.eId = :eId")
	public Experience getEducationById(@Param("eId") int eId);
}

