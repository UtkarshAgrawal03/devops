package com.simplilearn.project.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Purchase {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int purchaseid;
	@ManyToOne
	private product product;
	@ManyToOne
	private user user;
	
	

	public Purchase(int purchaseid, com.simplilearn.project.entities.product product,
			com.simplilearn.project.entities.user user) {
		super();
		this.purchaseid = purchaseid;
		this.product = product;
		this.user = user;
	}
	public Purchase() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getPurchaseid() {
		return purchaseid;
	}
	public void setPurchaseid(int purchaseid) {
		this.purchaseid = purchaseid;
	}
	public product getProduct() {
		return product;
	}
	public void setProduct(product product) {
		this.product = product;
	}
	public user getUser() {
		return user;
	}
	public void setUser(user user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Purchase [purchaseid=" + purchaseid + ", product=" + product.getId() + ", user=" + user.getUsername() + "]";
	}
	
	
	

}
