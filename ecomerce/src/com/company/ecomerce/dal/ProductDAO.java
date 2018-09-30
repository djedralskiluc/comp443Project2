package com.company.ecomerce.dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import com.company.ecomerce.product.*;

public class ProductDAO {
	
	public ProductDAO () {
	
	}
	
	public Product getProduct(String ProductID) {
		String name = "";
		String details = "";
		double cost = 0;
		
		Connection connection = DBConnect.getDatabaseConnection();
		
		try {
			Statement selectStatement = connection.createStatement();
			
			String selectQuery = "SELECT * from Product where ProductID='" + ProductID +"'";
			ResultSet resultSet = selectStatement.executeQuery(selectQuery);
			resultSet.next();
			
			name = resultSet.getString("Name");
			details = resultSet.getString("Details");
			cost = resultSet.getDouble("salary");
		
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
		product.set
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
				String ProductID = resultSet.getString("ProductID");
				Product prod = getProduct(ProductID);
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

}

