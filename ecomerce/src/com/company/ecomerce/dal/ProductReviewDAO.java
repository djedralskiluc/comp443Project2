package com.company.ecomerce.dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

import com.company.ecomerce.product.*;


public class ProductReviewDAO {
	
	public ProductReviewDAO () {
	
	}
	
	public List<ProductReview> getProductReviews(int productId) {
		List<ProductReview> productReviews = new ArrayList<ProductReview>();
		
		Connection connection = DBConnect.getDatabaseConnection();
		
		try {
			Statement selectStatement = connection.createStatement();
			
			String selectQuery = "SELECT * from ProductReviews where ProductId='" + productId +"'";
			ResultSet resultSet = selectStatement.executeQuery(selectQuery);
			
			while(resultSet.next()) {
				int productReviewId = resultSet.getInt("ProductReviewId");
				String review = resultSet.getString("Review");
				int rating = resultSet.getInt("Rating");
				int productId1 = resultSet.getInt("ProductId");
				int customerId = resultSet.getInt("CustomerId");
				
				ProductReview productReview = new ProductReview();
				productReview.setProductReviewId(productReviewId);
				productReview.setReview(review);
				productReview.setProductId(productId1);
				productReview.setCustomerId(customerId);
				productReview.setRating(rating);
				if(productReview != null) {
					productReviews.add(productReview);
				}
			}
			
		
		}catch(SQLException se) {
		se.printStackTrace();
		}finally {
		if(connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				
			}
		}
		}
		return productReviews;

	}
	
	public ProductReview addProductReview(String review, int rating, int productId, int customerId) {
		
		ProductReview productReview = new ProductReview();
		
		Random randomGenerator = new Random();
	    int productReviewId = randomGenerator.nextInt(10000);
	    productReview.setProductId(productReviewId);
	    productReview.setRating(rating);
	    productReview.setReview(review);
	    productReview.setCustomerId(customerId);

		
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement insertStatement = connection.createStatement();
			
			String insertQuery = "INSERT INTO * Customer (ProductReviewId,Rating,Review,CustomerId)"
					+ "VALUES('"+productReviewId+"','"+rating+"','"+review+"','"+customerId+"')";
			insertStatement.executeUpdate(insertQuery);
			
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {}
			}
		}
		
		return productReview;
	}
	
	public void updateProductReview(int productReviewId, int rating) {
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement updateStatement = connection.createStatement();
			
			String updateQuery = "UPDATE Product SET Rating ='"+rating+"' WHERE ProductId='"+productReviewId+"')";
			updateStatement.executeUpdate(updateQuery);		
			
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {}
			}
		}
	}
	
	public void deleteProductReviews(int productId) {
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement deleteStatement = connection.createStatement();
			
			String deleteQuery = "DELETE FROM ProductReview WHERE ProductId='"+productId+"')";
			deleteStatement.executeUpdate(deleteQuery);	
			
			
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {}
			}
		}
		
	}

}
