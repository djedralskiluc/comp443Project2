package com.company.ecomerce.customer;

public class Customer {
	
	private int customerID;
	private String lastName;
	private String firstName;
	private String phoneNumber;
	private Address addr;
	public Customer() {}
	public void setCustomerID(int id) {
		this.customerID = id;
	}
	public int getCustomerID() {
		return this.customerID;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setPhoneNumber(String number) {
		this.phoneNumber = number;
	}
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	public Address getAddr() {
		return addr;
	}
	public void setAddr(Address addr) {
		this.addr = addr;
	}
	
}
