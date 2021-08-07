package com.easyportfolio.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.easyportfolio.entities.Reference;

public interface ReferenceRepository extends JpaRepository<Reference,Integer>{
	@Query("select u from Reference u where u.rId = :rId")
	public Reference getProfileById(@Param("rId") int rId);
}
