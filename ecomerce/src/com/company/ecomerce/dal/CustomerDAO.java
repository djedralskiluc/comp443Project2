package com.company.ecomerce.dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import com.company.ecomerce.Customer;

public class CustomerDAO{

	
	private CustomerPrivilegeDAO CustomerPrivilegeDAO;
		
	public  CustomerDAO() {
		CustomerPrivilegeDAO = new CustomerPrivilegeDAO();
	}
	
	public Customer getCustomer(String id) {
		String lastName = "";
		String firstName="";
		String salary = "";
		Set<String> privileges = new HashSet<>();
		Connection connection = DBConnect.getDatabaseConnection();
		
		try {
			Statement selectStatement = connection.createStatement();
			
			String selectQuery = "SELECT * from Customer where gid='" + id +"'";
			ResultSet resultSet = selectStatement.executeQuery(selectQuery);
			resultSet.next();
			
			lastName = resultSet.getString("lastName");
			firstName = resultSet.getString("firstName");
			salary = resultSet.getString("salary");
			
			privileges = CustomerPrivilegeDAO.getPrivileges(id);
			
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
		Customer.setPrivileges(privileges);
		Customer.setSalary(Long.parseLong(salary));
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
				String CustomerID = resultSet.getString("gid");
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
	
	public Customer addCustomer(String firstName, String lastName) {
		
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
	
	public void updateCustomer(String id, long salary) {
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement updateStatement = connection.createStatement();
			
			String updateQuery = "UPDATE Customer SET salary='"+Long.toString(salary)+"' WHERE gid='"+id+"')";
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
	
	public void deleteCustomer(String id) {
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement deleteStatement = connection.createStatement();
			
			String deleteQuery = "DELETE FROM Customer WHERE gid='"+id+"')";
			deleteStatement.executeUpdate(deleteQuery);	
			
			CustomerPrivilegeDAO.deletePrivileges(id);
			
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