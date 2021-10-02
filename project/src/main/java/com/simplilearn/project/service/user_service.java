package com.simplilearn.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.project.entities.user;
import com.simplilearn.project.repository.User_repo;

@Service
public class user_service {

	@Autowired
	private User_repo ur;
	
	public List<user> displayuser(){
		return this.ur.findAll();
	}

}
