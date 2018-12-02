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
	
	public Customer getCustomer(int id) {
		String lastName = "";
		String firstName="";
		
		Connection connection = DBConnect.getDatabaseConnection();
		
		try {
			Statement selectStatement = connection.createStatement();
			
			String selectQuery = "SELECT * from Customer where CustomerId='" + id +"'";
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
				int CustomerId = resultSet.getInt("Id");
				Customer emp = getCustomer(CustomerId);
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
			if(addr == null)
			{
				addr = new Address();
			}
			
			addressDAO.insertAddress(addr);
			String insertQuery = "INSERT INTO * Customer (firstName,lastName,phone,AddressId)"
					+ "VALUES('"+firstName+"','"+lastName+"','"+phoneNumber+"','1')";
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

	public void addorUpdateCustomerPayment(int customerId, String cardType, String cCnumber, String exp, String pin,
			String nameOnCard) {
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement insertStatement = connection.createStatement();
			
			String insertQuery = "INSERT INTO * PaymentType (customerId,cardType,cCnumber,exp,pin)"
					+ "VALUES('"+customerId+"','"+cardType+"','"+cCnumber+"','"+exp+"','"+pin+"')";
			insertStatement.executeUpdate(insertQuery);
			
			Statement updateStatement = connection.createStatement();
			int paymentType = (int) (Math.random()*100);
			String updateQuery = "UPDATE Customer SET PaymentType='"+paymentType+"' WHERE CustomerId='"+customerId+"')";
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
		
}