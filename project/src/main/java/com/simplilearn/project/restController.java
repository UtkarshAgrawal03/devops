package com.simplilearn.project;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.project.entities.Purchase;
import com.simplilearn.project.entities.product;
import com.simplilearn.project.entities.user;
import com.simplilearn.project.service.Product_service;

@RestController
public class restController {
	@Autowired
	private Product_service pr;
	
	@GetMapping("/boots")
	@ResponseBody()
	public Iterable<product> findAll()
	{
		
		return pr.getProducts() ;
		
	}
	
	
	@RequestMapping("/hello")
	public String home(Model model) {
		model.addAttribute("message", "helloWorld");
		return "thpage";
	}
	@GetMapping("/boots/{pid}")
	@ResponseBody()
	public Optional<product> findone(@PathVariable int pid )
	{
		return pr.getProducts(pid);
	}
	@PostMapping("/boots")
	@ResponseBody()
	public product Addproduct(@RequestBody product p)
	{ 
		
		return this.pr.addProduct(p);
	}
}
