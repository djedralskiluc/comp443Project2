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
	
	public Customer getCustomer(String id) {
		return dao.getCustomer(id);
	}
	

	public Customer addCustomer(String firstName, String lastName) {
		
		Customer emp = dao.addCustomer(firstName, lastName);
		
		return emp;
	}

	public void updateCustomer(String id, long salary) {
		dao.updateCustomer(id, salary);
	}

	public void deleteCustomer(String id) {
		dao.deleteCustomer(id);
	}

}

