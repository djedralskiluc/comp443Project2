package com.company.ecomerce.order;
import java.util.List;

import com.company.ecomerce.customer.Address;
import com.company.ecomerce.product.*;;

public class OrderDetails {
	
	private List<Product> products;
	private String date;
	private Address address;
		
	public OrderDetails(List<Product> products, String date) {
		this.products = products;
		this.date = date;
	}
	public String getDate() {
		return this.date;
	}
	public List<Product> getProducts(){
		return this.products;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
}
