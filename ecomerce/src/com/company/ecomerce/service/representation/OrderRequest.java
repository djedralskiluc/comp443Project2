package com.company.ecomerce.service.representation;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.company.ecomerce.customer.Address;
import com.company.ecomerce.order.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class OrderRequest {
	


	private int customerId;
	private List<Integer> products;
	private double cost;
	private int partnerId;

	
	public OrderRequest() {}


	public int getCustomerId() {
		return customerId;
	}


	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}


	public List<Integer> getProducts() {
		return products;
	}


	public void setProducts(List<Integer> products) {
		this.products = products;
	}


	public double getCost() {
		return cost;
	}


	public void setCost(double cost) {
		this.cost = cost;
	}


	public int getPartnerId() {
		return partnerId;
	}


	public void setPartnerId(int partnerId) {
		this.partnerId = partnerId;
	}

	


	


	

}
