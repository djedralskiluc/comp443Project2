package com.company.ecomerce.product;


import java.util.List;

import java.util.Set;


import com.company.ecomerce.dal.ProductDAO;
import com.company.ecomerce.dal.ProductReviewDAO;

public class ProductManager {
	private static ProductDAO dao = new ProductDAO();
	private static ProductReviewDAO rdao = new ProductReviewDAO();
	public Product getProduct(int productId) {
		return dao.getProduct(productId);
	}
	
	public Set<Product> getAllProducts(){
				
		return dao.getAllProducts();
		
	}
	
	public Product addProduct(String name, String details, double cost, int partnerId) {
				
		return dao.addProduct(name, details, cost, partnerId);
	}
	
	public void updateProduct(int productId, double cost) {
		dao.updateProduct(productId, cost);
	}
	
	public void deleteProduct(int productId) {
		dao.deleteProduct(productId);		
	}
	public List<ProductReview> getProductReviews(int productId) {		
		return rdao.getProductReviews(productId);

	}
	
	public ProductReview addProductReview(String review, int rating, int productId, int customerId) {
				
		return rdao.addProductReview(review, rating, productId, customerId);
	}
	
	public void updateProductReview(int productReviewId, int rating) {
		rdao.updateProductReview(productReviewId, rating);
	}
	
	public void deleteProductReviews(int productId) {
		rdao.deleteProductReviews(productId);		
	}
}
