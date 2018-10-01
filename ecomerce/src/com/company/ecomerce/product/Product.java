package com.company.ecomerce.product;

import java.util.List;

public class Product {
	private int productID;
	private String name;
	private String details;
	private double cost;
	private List<ProductReview> Reviews; 
	public Product(){
	
	}
	public void setProductID(int id) {
		this.productID = id;
	}
	public int getProductID() {
		return this.productID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public List<ProductReview> getReviews() {
		return Reviews;
	}
	public void setReviews(List<ProductReview> reviews) {
		Reviews = reviews;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	
}
