package com.company.ecomerce.dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import com.company.ecomerce.customer.Address;
import com.company.ecomerce.customer.Customer;

public class CustomerDAO{

	
	private AddressDAO addressDAO;
		
	public  CustomerDAO() {
		AddressDAO addressDAO = new AddressDAO();
	}
	
	public Customer getCustomer(String id) {
		String lastName = "";
		String firstName="";
		
		Connection connection = DBConnect.getDatabaseConnection();
		
		try {
			Statement selectStatement = connection.createStatement();
			
			String selectQuery = "SELECT * from Customer where CustomerID='" + id +"'";
			ResultSet resultSet = selectStatement.executeQuery(selectQuery);
			resultSet.next();
			
			lastName = resultSet.getString("lastName");
			firstName = resultSet.getString("firstName");

			
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {}
			}
		}
		Customer Customer = new Customer();
		Customer.setFirstName(firstName);
		Customer.setLastName(lastName);
		
		return Customer;
	}
	
	public Set<Customer> getAllCustomers(){
		Connection connection = DBConnect.getDatabaseConnection();
		Set<Customer> Customers = new HashSet<>();
		
		try {
			Statement selectStatement = connection.createStatement();
			
			String selectQuery = "SELECT * from Customer";
			ResultSet resultSet = selectStatement.executeQuery(selectQuery);
			
			while(resultSet.next()) {
				String CustomerID = resultSet.getString("Id");
				Customer emp = getCustomer(CustomerID);
				if(emp != null) {
					Customers.add(emp);
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
		
		return Customers;
		
	}
	
	public Customer addCustomer(String firstName, String lastName,String phoneNumber,Address addr) {
		
		Customer customer = new Customer();
		customer.setAddr(addr);
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setPhoneNumber(phoneNumber);
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement insertStatement = connection.createStatement();
			addressDAO.insertAddress(addr);
			String insertQuery = "INSERT INTO * Customer (firstName,lastName,phone,AddressId)"
					+ "VALUES('"+firstName+"','"+lastName+"','"+phoneNumber+"','"+1+"')";
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
		
		return customer;
	}
	
	public void updateCustomer(int id, String phoneNumber,Address addr) {
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement updateStatement = connection.createStatement();
			
			String updateQuery = "UPDATE Customer SET phone='"+phoneNumber+"' WHERE CustomerId='"+id+"')";
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
	
	public void deleteCustomer(int id) {
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement deleteStatement = connection.createStatement();
			
			String deleteQuery = "DELETE FROM Customer WHERE gid='"+id+"')";
			deleteStatement.executeUpdate(deleteQuery);	
			
			addressDAO.deleteAddress(id);
			
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