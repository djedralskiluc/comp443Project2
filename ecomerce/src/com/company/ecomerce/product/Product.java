package com.company.ecomerce.product;

import java.util.List;

public class Product {
	private int ProductID;
	private String name;
	private String details;
	private List<ProductReview> Reviews; 
	Product(){
	
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
	
}
