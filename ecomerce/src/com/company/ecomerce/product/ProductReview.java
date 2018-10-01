package com.company.ecomerce.product;

public class ProductReview {
	private int productReviewId;
	private String review;
	private int rating;
	private int productId;
	private int customerId;
	
	public ProductReview(){}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getProductReviewId() {
		return productReviewId;
	}
	public void setProductReviewId(int productReviewId) {
		this.productReviewId = productReviewId;
	}
}
