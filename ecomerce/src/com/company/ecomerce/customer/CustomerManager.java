package com.company.ecomerce.customer;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import com.company.ecomerce.dal.CustomerDAO;

public class CustomerManager {
	
	private static CustomerDAO dao = new CustomerDAO();
	
	public Set<Customer> getAllCustomers(){
		return dao.getAllCustomers();
	}
	
	public Customer getCustomer(int id) {
		return dao.getCustomer(id);
	}
	

	public Customer addCustomer(String firstName, String lastName,String phoneNumber, Address addr) {

		Customer emp = dao.addCustomer(firstName, lastName,phoneNumber,addr);
		
		return emp;
	}

	public void updateCustomer(int id, String phoneNumber, Address addr) {
		dao.updateCustomer(id, phoneNumber,addr);
	}

	public void deleteCustomer(int id) {
		dao.deleteCustomer(id);
	}

}

