package com.company.ecomerce.order;
import com.company.ecomerce.customer.Address;
public class Payment {
	private Address address;
	private double amount;
	Payment(){
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}

}
