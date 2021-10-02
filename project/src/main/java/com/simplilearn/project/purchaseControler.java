package com.simplilearn.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.project.entities.Purchase;
import com.simplilearn.project.service.purchase_service;

@RestController
public class purchaseControler {
	@Autowired
	private purchase_service pr;
	@GetMapping("/purchases")
	@ResponseBody()
	public List<Purchase> purdisplay()
	{
		
		return pr.display() ;
		
	}

}
