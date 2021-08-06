package com.easyportfolio.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.easyportfolio.entities.ProfileLinks;

public interface ProfileLinkRepository extends JpaRepository<ProfileLinks,Integer>{
	@Query("select u from ProfileLinks u where u.pId = :pId")
	public ProfileLinks getProfileById(@Param("pId") int pId);
}
