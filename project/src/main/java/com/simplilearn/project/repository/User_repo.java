package com.simplilearn.project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.simplilearn.project.entities.user;

public interface User_repo extends JpaRepository<user, Integer> {

	@Query("select u from user u where u.username=:username")
	public user findbyusername(@Param("username") String username);
}
