package com.company.ecomerce.dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import com.company.ecomerce.customer.Address;
import com.company.ecomerce.product.*;

public class ProductDAO {
	
	public ProductDAO () {
	
	}
	
	public Product getProduct(int productId) {
		String name = "";
		String details = "";
		double cost = 0;
		
		Connection connection = DBConnect.getDatabaseConnection();
		
		try {
			Statement selectStatement = connection.createStatement();
			
			String selectQuery = "SELECT * from Product where ProductId='" + productId +"'";
			ResultSet resultSet = selectStatement.executeQuery(selectQuery);
			resultSet.next();
			
			name = resultSet.getString("Name");
			details = resultSet.getString("Details");
			cost = resultSet.getDouble("Cost");
		
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
		
		Product product = new Product();
		product.setProductId(productId);
		product.setName(name);
		product.setDetails(details);
		product.setCost(cost);
		return product;
	}
	
	public Set<Product> getAllProducts(){
		Connection connection = DBConnect.getDatabaseConnection();
		Set<Product> Products = new HashSet<>();
		
		try {
			Statement selectStatement = connection.createStatement();
			
			String selectQuery = "SELECT * from Product";
			ResultSet resultSet = selectStatement.executeQuery(selectQuery);
			
			while(resultSet.next()) {
				int productId = resultSet.getInt("ProductId");
				Product prod = getProduct(productId);
				if(prod != null) {
					Products.add(prod);
				}
			}
			
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {}
			}
		}
		
		return Products;
		
	}
	
	public Product addProduct(String name, String details, double cost, int partnerId) {
		
		Product product = new Product();
		
		Random randomGenerator = new Random();
	    int productId = randomGenerator.nextInt(10000);
	    product.setProductId(productId);
	    product.setName(name);
	    product.setDetails(details);
	    product.setCost(cost);
	    product.setPartnerId(partnerId);
		
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement insertStatement = connection.createStatement();
			
			String insertQuery = "INSERT INTO * Customer (ProductId,Name,Details,Cost,PartnerId)"
					+ "VALUES('"+productId+"','"+name+"','"+details+"','"+cost+"','"+partnerId+"')";
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
		
		return product;
	}
	
	public void updateProduct(int productId, double cost) {
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement updateStatement = connection.createStatement();
			
			String updateQuery = "UPDATE Product SET Cost ='"+cost+"' WHERE ProductId='"+productId+"')";
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
	
	public void deleteProduct(int productId) {
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement deleteStatement = connection.createStatement();
			
			String deleteQuery = "DELETE FROM Product WHERE ProductId='"+productId+"')";
			deleteStatement.executeUpdate(deleteQuery);	
			ProductReviewDAO productReviewDAO = new ProductReviewDAO();
			productReviewDAO.deleteProductReviews(productId);
			
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

