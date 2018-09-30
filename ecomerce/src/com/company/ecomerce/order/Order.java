package com.company.ecomerce.order;

import com.company.ecomerce.customer.Customer;

public class Order {
	
	
	private int orderID;
	private Payment payment;
	private OrderDetails orderDetails;
	private OrderStatus orderStatus;
	private Customer customer;
	
	public Order() {
	}
	public Payment getPayment() {
		return this.payment;
	}
	public int getOrderID() {
		return this.orderID;
		
	}
	public OrderDetails getOrderDetails() {
		return this.getOrderDetails();
	}
	public OrderStatus getOrderStatus() {
		return this.orderStatus;
	}
	public Customer getCustomer() {
		return this.customer;
	}
	public void setOrderID(int id) {
		this.orderID = id;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	public void setOrderDetails(OrderDetails orderDetails) {
		this.orderDetails = orderDetails;
	}
	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
