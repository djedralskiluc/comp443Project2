package com.company.ecomerce.dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

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
	
	public Product addProduct(String firstName, String lastName) {
		
		Customer Customer = new Customer();
		
		Random randomGenerator = new Random();
	    int randomInt = randomGenerator.nextInt(10000);
	    String randomLong = Long.toString(randomGenerator.nextLong());
	    String id = "XY" + randomInt;
	    
		Customer.setGid(id);
		Customer.setFirstName(firstName);
		Customer.setLastName(lastName);
		Customer.setSalary(Long.parseLong(randomLong));
		Set<String> privileges = new HashSet<String>();
		privileges.add("Free Lunch");
		Customer.setPrivileges(privileges);		
		
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement insertStatement = connection.createStatement();
			
			String insertQuery = "INSERT INTO * Customer (gid,firstName,lastName,salary)"
					+ "VALUES('"+id+"','"+firstName+"','"+lastName+"','"+randomLong+"')";
			insertStatement.executeUpdate(insertQuery);
			
			CustomerPrivilegeDAO.insertPrivileges(id,privileges);
		
			
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {}
			}
		}
		
		return Customer;
	}

}

