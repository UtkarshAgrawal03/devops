package com.simplilearn.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.project.entities.user;
import com.simplilearn.project.service.user_service;

@RestController
public class user_controoler {
	@Autowired
	private user_service pr;
	@GetMapping("/users")
	@ResponseBody()
	public List<user> findusers()
	{
		
		return pr.displayuser() ;
		
	}

}
