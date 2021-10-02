package com.simplilearn.project.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.project.entities.product;
import com.simplilearn.project.repository.product_repo;
@Service 
public class Product_service {
	@Autowired
	private product_repo pr;
	
	

	public Iterable<product> getProducts()
	{
		return pr.findAll();
	}
	public Optional<product> getProducts(int id)
	{
		return pr.findById(id);
	}
	public product addProduct(product p)
	{
		return pr.save(p);
	}
}
