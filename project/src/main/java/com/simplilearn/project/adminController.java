package com.simplilearn.project;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.simplilearn.project.entities.Purchase;
import com.simplilearn.project.entities.product;
import com.simplilearn.project.entities.user;
import com.simplilearn.project.repository.User_repo;
import com.simplilearn.project.repository.product_repo;
import com.simplilearn.project.repository.purchase_repo;



@Controller
@RequestMapping("/admin")
public class adminController {
	@Autowired
	private product_repo pr;
	@Autowired
	private User_repo ur;
	@Autowired
	private purchase_repo pur;
	@RequestMapping("")
	public String adminpage()
	{
		
		return "admin/admin_dashboard";
		
	}
	@RequestMapping("/users")
	@ResponseBody
	public String usersAll()
	{
		String result="";
		List<user> user=ur.findAll();
		for(user ur:user)
		{
		result=result+" <b>UserID</b> "+ur.getUid()+" <b>User Name</b> "+ur.getUsername()+" <b> UserRole </b> "+ur.getRoles()+" <b>Product Category</b> "+ur.getPurchase()+"<br>";
		}
		return result;
		
	}
	@RequestMapping("/user")	
	public String user()
	{
		
		return "admin/findUser";
		
	}
	@RequestMapping(value="/finduser",method=RequestMethod.POST)	
	@ResponseBody
	public String findOneuser(@Param("id") int id)
	{
		String result="";
		List<user> user=ur.findAll();
		for(user ur:user)
		{
			if(ur.getUid()==id)
		result=" <b>UserID</b> "+ur.getUid()+" <b>User Name</b> "+ur.getUsername()+" <b> UserRole </b> "+ur.getRoles()+" <b>Product Category</b> "+ur.getPurchase()+"<br>";
		}
		return result;
		
	}
	@RequestMapping("/products")
	@ResponseBody
	public String productsAll()
	{
		String result="";
		List<product> prod=pr.findAll();
		for(product pr:prod)
		{
		result=result+" <b>ProductID</b> "+pr.getId()+" <b>Product Name</b> "+pr.getName()+" <b> Product size </b> "+pr.getSize()+" <b>Product Category</b> "+pr.getCategory()+" <b> Product Quantity </b> "+pr.getQuantity()+"<br>";
		}
		return result;
		
	}
	@RequestMapping("/product")	
	public String product()
	{
		
		return "admin/findProduct";
		
	}
	@RequestMapping(value="/findproduct",method=RequestMethod.POST)	
	@ResponseBody
	public String findOneproduct(@Param("id") int id)
	{
		String result="";
		List<product> prod=pr.findAll();
		for(product pr:prod)
		{
			if(pr.getId()==id)
		result=" <b>ProductID</b> "+pr.getId()+" <b>Product Name</b> "+pr.getName()+" <b> Product size </b> "+pr.getSize()+" <b>Product Category</b> "+pr.getCategory()+" <b> Product Quantity </b> "+pr.getQuantity()+"<br>";
		}
		return result;
		
		
	}
	@RequestMapping("/purchases")
	@ResponseBody
	public String purchasesAll()
	{
		String result="";
		List<Purchase> purchase=pur.findAll();
		for(Purchase p:purchase) {
			result+=" purchaseId "+p.getPurchaseid()+" product "+p.getProduct()+" user "+p.getUser()+"<br>";
		}
		return result;
		
	}
	@RequestMapping("/purchase")	
	public String purchase()
	{
		
		return "admin/findPurchase";
		
	}
	@RequestMapping(value="/findPurchase",method=RequestMethod.POST)	
	@ResponseBody
	public String findOnepurchase(@RequestParam("id") int id)
	{
		String result="";
		List<Purchase> purchase=pur.findAll();
		for(Purchase p:purchase) {
			if(p.getPurchaseid()==id) {
			result=" purchaseId "+p.getPurchaseid()+" product "+p.getProduct()+" user "+p.getUser()+"<br>";}
		}
		return result;
		
	}
	@RequestMapping("/RegisterUser")
	public String signup(Model model)
	{
		model.addAttribute("user",new user());
		return "admin/signup";
	}
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String register(@ModelAttribute("user") user user)
	{
		user.setRoles("ROLE_ADMIN");
		user result=ur.save(user);
		System.out.println(result);
		return "admin/admin_dashboard";
	}
	@RequestMapping("/AddProduct")
	public String adproduct(Model model)
	{
		model.addAttribute("product",new product());
		return "admin/addProduct";
	}
	@RequestMapping(value="/addProduct",method=RequestMethod.POST)
	public String addproduct(@ModelAttribute("product") product product)
	{
		
		product result=pr.save(product);
		System.out.println(result);
		return "admin/admin_dashboard";
	}
	@RequestMapping("/passChange")
	public String passchange()
	{
		
		return "admin/passchange";
	}
	@RequestMapping(value="/Pass",method=RequestMethod.POST)
	public String pass(@RequestParam("pass") String pass,Principal principal)
	{
		String username=principal.getName();
		user user=ur.findbyusername(username);
		user.setPassword(pass);
		ur.save(user);
		return "admin/admin_dashboard";
	}
	
	
	
	
}
