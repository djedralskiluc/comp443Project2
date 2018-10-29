package com.company.ecomerce.workflow;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.company.ecomerce.dal.CustomerDAO;
import com.company.ecomerce.customer.*;
import com.company.ecomerce.service.representation.CustomerRepresentation;

public class CustomerActivity {
	private static CustomerDAO dao = new CustomerDAO();
		//private static CustomerManager dao = new CustomerManager();
		
		public Set<CustomerRepresentation> getCustomers() {
			
			Set<Customer> customers = new HashSet<Customer>();
			Set<CustomerRepresentation> customerRepresentations = new HashSet<CustomerRepresentation>();
			//customers = dao.getAllCustomers();
			customers = dao.getAllCustomers();
			
			Iterator<Customer> it = customers.iterator();
			while(it.hasNext()) {
	          Customer daop = (Customer)it.next();
	          CustomerRepresentation customerRepresentation = new CustomerRepresentation();

	          customerRepresentation.setCustomerID(daop.getCustomerID());
	          customerRepresentation.setAddr(daop.getAddr());
	          customerRepresentation.setFirstName(daop.getFirstName());
	          customerRepresentation.setLastName(daop.getLastName());
	          customerRepresentation.setPaymentType(daop.getPaymentType());
	          customerRepresentation.setPhoneNumber(daop.getPhoneNumber());
							
	          	          
	          //now add this representation in the list
	          customerRepresentations.add(customerRepresentation);
	        }
			return customerRepresentations;
		}
		
		public CustomerRepresentation getCustomer(int id) {
			
			//Customer daop = dao.getCustomer(id);
			Customer daop = dao.getCustomer(id);
			
			CustomerRepresentation daopRep = new CustomerRepresentation();
			daopRep.setCustomerID(daop.getCustomerID());
			daopRep.setAddr(daop.getAddr());
			daopRep.setFirstName(daop.getFirstName());
			daopRep.setLastName(daop.getLastName());
			daopRep.setPaymentType(daop.getPaymentType());
			daopRep.setPhoneNumber(daop.getPhoneNumber());
						
			return daopRep;
		}
		
		public CustomerRepresentation createCustomer(String firstName, String lastName, String phoneNumber, Address addr) {
			
			//Customer daop = dao.addCustomer(firstName, lastName);
			Customer daop = dao.addCustomer(firstName, lastName, phoneNumber, addr);
			
			CustomerRepresentation daopRep = new CustomerRepresentation();
			daopRep.setCustomerID(daop.getCustomerID());
			daopRep.setAddr(daop.getAddr());
			daopRep.setFirstName(daop.getFirstName());
			daopRep.setLastName(daop.getLastName());
			daopRep.setPaymentType(daop.getPaymentType());
			daopRep.setPhoneNumber(daop.getPhoneNumber());
						
			return daopRep;
		}
		
		public String deleteCustomer(int id) {
			
			//dao.deleteCustomer(id);
			dao.deleteCustomer(id);
			
			return "OK";
		}
}
