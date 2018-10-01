package com.company.ecomerce.product;

import java.util.List;

public class Product {
	private int productId;
	private int partnerId;
	private String name;
	private String details;
	private double cost;
	private List<ProductReview> Reviews; 
	public Product(){
	
	}
	public void setProductId(int id) {
		this.productId = id;
	}
	public int getProductId() {
		return this.productId;
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
	public int getPartnerId() {
		return partnerId;
	}
	public void setPartnerId(int partnerId) {
		this.partnerId = partnerId;
	}
	
}
