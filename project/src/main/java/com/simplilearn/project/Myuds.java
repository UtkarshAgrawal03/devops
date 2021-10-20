package com.simplilearn.project;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.simplilearn.project.entities.user;
import com.simplilearn.project.repository.User_repo;

@Service
public class Myuds implements UserDetailsService {

	@Autowired
	User_repo ur;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		user user=ur.findbyusername(username);
		return  new MyuserDetails(user);
		 	}

}
