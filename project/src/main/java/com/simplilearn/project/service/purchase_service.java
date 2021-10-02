package com.simplilearn.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.project.entities.Purchase;
import com.simplilearn.project.repository.purchase_repo;

@Service
public class purchase_service {
	@Autowired
	private purchase_repo pur;
	public List<Purchase> display()
	{
		return pur.findAll();
	}

}
