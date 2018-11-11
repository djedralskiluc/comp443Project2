package com.company.ecomerce.service;

import java.util.Set;

import javax.jws.WebService;

import com.company.ecomerce.service.representation.CustomerRepresentation;
import com.company.ecomerce.service.representation.CustomerRequest;

@WebService
public interface CustomerService {
	public Set<CustomerRepresentation> getCustomers();
	public CustomerRepresentation getCustomer(int customerId);
	public CustomerRepresentation createCustomer(CustomerRequest customerRequest);
	public CustomerRepresentation updateCustomer(CustomerRequest customerRequest);
   

}
