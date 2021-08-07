package com.easyportfolio.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.easyportfolio.entities.Project;

public interface ProjectRepository extends JpaRepository<Project,Integer>{
	@Query("select u from Project u where u.pId = :pId")
	public Project getProfileById(@Param("pId") int pId);
}
