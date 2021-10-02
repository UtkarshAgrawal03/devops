package com.simplilearn.project.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class product {
@Id
private int id;
private String name;
private String category;
private int size;
private int quantity;

public product(int id, String name, String category, int size, int quantity) {
	super();
	this.id = id;
	this.name = name;
	this.category = category;
	this.size = size;
	this.quantity = quantity;
}

public product() {
	super();
	// TODO Auto-generated constructor stub
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
public int getSize() {
	return size;
}
public void setSize(int size) {
	this.size = size;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
@Override
public String toString() {
	return "product [id=" + id + ", name=" + name + ", category=" + category + ", size=" + size + ", quantity="
			+ quantity + "]";
}
}
