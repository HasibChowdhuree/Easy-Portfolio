package com.easyportfolio.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.easyportfolio.entities.Achievement;

public interface AchievementRepository extends JpaRepository<Achievement,Integer> {
	@Query("select u from Achievement u where u.aId = :aId")
	public Achievement getAchievementById(@Param("aId") int aId);
}
