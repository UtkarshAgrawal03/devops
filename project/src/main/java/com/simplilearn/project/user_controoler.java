package com.simplilearn.project;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simplilearn.project.entities.Purchase;
import com.simplilearn.project.entities.product;
import com.simplilearn.project.repository.User_repo;
import com.simplilearn.project.repository.product_repo;
import com.simplilearn.project.repository.purchase_repo;

@Controller
@RequestMapping("/user")
public class user_controoler {
	@Autowired
	private product_repo pr;
	@Autowired
	private User_repo ur;
	@Autowired
	private purchase_repo pur;
	
	@RequestMapping("")
	public String home(Model model,Principal prin)
	{
		model.addAttribute("username", prin.getName());
		
		return "user/user_dashboard";
	}
	@RequestMapping("/products")
	@ResponseBody
	public String products()
	{
		String result="";
		List<product> product=pr.findAll();
		for(product pr:product)
		{
		result=result+" <b>ProductID</b> "+pr.getId()+" <b>Product Name</b> "+pr.getName()+" <b> Product size </b> "+pr.getSize()+" <b>Product Category</b> "+pr.getCategory()+"<br>";
		}
		return result;
	}
	@RequestMapping("/purchase")
	public String purchase(Model model,Principal prin)
	{
		model.addAttribute("username", prin.getName());
		
		return "user/purchase";
	}
	@RequestMapping("/purchased")
	@ResponseBody
	public String purchase(@Param("pid") int pid,Principal prin)
	{
		Purchase purchase=new Purchase();
		purchase.setProduct(pr.getById(pid));
		purchase.setUser(ur.getById(ur.findbyusername(prin.getName()).getUid()));
		pur.save(purchase);
		return "<h1>Purchased Successfuly</h1>";
	}

}

