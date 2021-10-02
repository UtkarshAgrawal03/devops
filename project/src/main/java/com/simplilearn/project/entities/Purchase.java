package com.simplilearn.project.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class Purchase {
	@Id
	private int purchaseid;
	
	private int productId;
	
	private int userId;
	
	public Purchase(int purchaseid, int productId, int userId) {
		super();
		this.purchaseid = purchaseid;
		this.productId = productId;
		this.userId = userId;
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
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
	

}
