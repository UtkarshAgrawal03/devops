package com.simplilearn.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplilearn.project.entities.user;

public interface User_repo extends JpaRepository<user, Integer> {

}
