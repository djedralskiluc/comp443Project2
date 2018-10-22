package com.company.ecomerce.dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import com.company.ecomerce.customer.Address;
import com.company.ecomerce.order.Order;
import com.company.ecomerce.order.OrderStatus;
import com.company.ecomerce.product.Product;

public class OrderDAO {

	public OrderDAO() {
		
	}
	
	public Order getOrder(int orderId) {
		
		
		int paymentId;
		int customerId;
		String date;
		int addressId;
		
		OrderStatus orderStatus;
		List<Integer> productIds;
		Connection connection = DBConnect.getDatabaseConnection();
		
		try {
			Statement selectStatement = connection.createStatement();
			
			String selectQuery = "SELECT * from Order where OrderId='" + orderId +"'";
			ResultSet resultSet = selectStatement.executeQuery(selectQuery);
			resultSet.next();
			
			customerId = resultSet.getInt("CustomerId");
			paymentId = resultSet.getInt("PaymentId");
			date = resultSet.getString("Date");
			addressId = resultSet.getInt("AddressId");
			
			selectQuery = "SELECT * from OrderProducts where OrderId='" + orderId +"'";
			ResultSet productResultSet = selectStatement.executeQuery(selectQuery);
			resultSet.next();
			while (productResultSet.next()) {
				  int i = productResultSet.getInt("productId");
				  productIds.add(i);
				}

			
			selectQuery = "SELECT * from OrderStatus where OrderId='" + orderId +"'";
			ResultSet orderResultSet = selectStatement.executeQuery(selectQuery);
			orderResultSet.next();
					
			String status = orderResultSet.getString("Status");
			String lastUpdate = orderResultSet.getString("LastUpdate");
			
			orderStatus = new OrderStatus(status, lastUpdate);
			
			
		
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
		
		Order order = new Order();
		order.setCustomerId(customerId);
		//order.setPaymentId(paymentId);
		order.setDate(date);
		order.setOrderStatus(orderStatus);
		order.setProductIds(productIds);
		
		
		return order;
	}
	
	public Set<Order> getAllOrders(){
		Connection connection = DBConnect.getDatabaseConnection();
		Set<Order> Orders = new HashSet<>();
		
		try {
			Statement selectStatement = connection.createStatement();
			
			String selectQuery = "SELECT * from Order";
			ResultSet resultSet = selectStatement.executeQuery(selectQuery);
			
			while(resultSet.next()) {
				int orderId = resultSet.getInt("OrderId");
				getOrder order = Order.getProduct(orderId);
				if(order != null) {
					Orders.add(order);
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
		
		return Orders;
		
	}
	
	public Order addOrder(int customerId,List<Integer> products , double cost, int partnerId) {
		
		Order order = new Order();
		
		Random randomGenerator = new Random();
	    int orderId = randomGenerator.nextInt(10000);
	    order.setOrderId(orderId);//fix
	    order.setCustomerId(customerId);
	    order.setDate(date);
	    order.setPayment(payment);
	    order.setAddress(address);
		
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement insertStatement = connection.createStatement();
			
			String insertQuery = "INSERT INTO * Order (OrderId,CustomerId,Date,Payment,Address)"
					+ "VALUES('"+orderId+"','"customerId+"','"+date+"','"+payment+"','"+address+"')";
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
		
		return order;
	}
	
	public void updateOrder(int productId, double cost) {
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
	
	public void deleteOrder(int orderId) {
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement deleteStatement = connection.createStatement();
			
			String deleteQuery = "DELETE FROM Order WHERE OrderId='"+orderId+"')";
			deleteStatement.executeUpdate(deleteQuery);	
			ProductReviewDAO productReviewDAO = new ProductReviewDAO();
			productReviewDAO.deleteProductReviews(orderId);
			
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
