package com.simplilearn.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.simplilearn.project.entities.user;
import com.simplilearn.project.repository.User_repo;

@Controller
public class homecontroller {
	@Autowired
	private User_repo ur;
	@RequestMapping("/")
	public String home()
	{
		return "home";
	}
	@RequestMapping("/signup")
	public String signup(Model model)
	{
		model.addAttribute("user",new user());
		return "signup";
	}
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String register(@ModelAttribute("user") user user)
	{
		user.setRoles("ROLE_USER");
		user result=ur.save(user);
		System.out.println(user);
		return "signup";
	}
}

