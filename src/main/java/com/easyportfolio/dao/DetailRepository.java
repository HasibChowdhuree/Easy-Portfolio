package com.easyportfolio.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.easyportfolio.entities.DetailInfo;

public interface DetailRepository extends JpaRepository<DetailInfo,Integer>{
	public interface UserRepository {
		@Query("select u from DetailInfo u where u.id = :id")
		public DetailRepository getUserByUserName(@Param("id") int id);
	}
}
