package com.company.ecomerce.order;

import java.util.List;

import com.company.ecomerce.customer.Address;
import com.company.ecomerce.customer.Customer;
import com.company.ecomerce.product.Product;

public class Order {
	
	
	private int orderID;
	private Payment payment;
	private OrderStatus orderStatus;
	private int customerId;
	private List<Integer> productIds;
	private String date;
	private Address addressId;
	
	public Order() {
	}
	public Payment getPayment() {
		return this.payment;
	}
	public int getOrderID() {
		return this.orderID;
	}
	public OrderStatus getOrderStatus() {
		return this.orderStatus;
	}
	public int getCustomerId() {
		return this.customerId;
	}
	public void setCustomerId(int customerId){
		this.customerId = customerId;
	}
	public void setOrderID(int id) {
		this.orderID = id;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}
	public List<Integer> getProductIds() {
		return productIds;
	}
	public void setProductIds(List<Integer> productIds) {
		this.productIds = productIds;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Address getAddressId() {
		return addressId;
	}
	public void setAddressId(Address addressId) {
		this.addressId = addressId;
	}

}
