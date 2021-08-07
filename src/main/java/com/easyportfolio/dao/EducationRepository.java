package com.easyportfolio.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.easyportfolio.entities.Education;
import com.easyportfolio.entities.ProfileLinks;


public interface EducationRepository extends JpaRepository<Education,Integer> {
	@Query("select u from Education u where u.eId = :eId")
	public ProfileLinks getEducationById(@Param("eId") int eId);
}
