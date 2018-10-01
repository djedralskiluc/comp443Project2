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
	
	public Product getProduct(int productID) {
		String name = "";
		String details = "";
		double cost = 0;
		
		Connection connection = DBConnect.getDatabaseConnection();
		
		try {
			Statement selectStatement = connection.createStatement();
			
			String selectQuery = "SELECT * from Product where ProductID='" + productID +"'";
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
		product.setProductID(productID);
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
				int productID = resultSet.getInt("ProductID");
				Product prod = getProduct(productID);
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
	
	public Product addProduct(String name, String details, double cost, int partnerID) {
		
		Product product = new Product();
		
		Random randomGenerator = new Random();
	    int productID = randomGenerator.nextInt(10000);
	    product.setProductID(productID);
	    product.setName(name);
	    product.setDetails(details);
	    product.setCost(cost);
	    product.setPartnerID(partnerID);
		
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement insertStatement = connection.createStatement();
			
			String insertQuery = "INSERT INTO * Customer (ProductID,Name,Details,Cost,PartnerID)"
					+ "VALUES('"+productID+"','"+name+"','"+details+"','"+cost+"','"+partnerID+"')";
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
	
	public void updateProduct(int productID, double cost) {
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement updateStatement = connection.createStatement();
			
			String updateQuery = "UPDATE Product SET Cost ='"+cost+"' WHERE ProductId='"+productID+"')";
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
	
	public void deleteProduct(int productID) {
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement deleteStatement = connection.createStatement();
			
			String deleteQuery = "DELETE FROM ProductID WHERE ProductID='"+productID+"')";
			deleteStatement.executeUpdate(deleteQuery);	
			
			productReviewDAO.deleteReviews(productID);
			
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

