package com.company.ecomerce.product;

import java.util.List;

public class Product {
	private String name;
	private String details;
	private double cost;
	private List<ProductReview> reviews;
	
	
	public Product() {}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getDetails() {
		return this.details;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public double getCost() {
		return this.cost;
	}
	public void setProductReviews(List<ProductReview> reviews) {
		this.reviews = reviews;
	}
	public List<ProductReview> getProductReviews(){
		return this.reviews;
	}
}
