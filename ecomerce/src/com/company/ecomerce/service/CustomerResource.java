package com.company.ecomerce.service;

import java.util.Set;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.company.ecomerce.service.CustomerService;
import com.company.ecomerce.service.representation.CustomerRepresentation;
import com.company.ecomerce.service.representation.CustomerRequest;
import com.company.ecomerce.workflow.CustomerActivity;


	@Path("/customerservice/")
	public class CustomerResource implements CustomerService {

		@GET
		@Produces({"application/xml" , "application/json"})
		@Path("/customer")
		//@Cacheable(cc="public, maxAge=3600") example for caching
		public Set<CustomerRepresentation> getCustomers() {
			System.out.println("GET METHOD Request for all customers .............");
			CustomerActivity empActivity = new CustomerActivity();
			return empActivity.getCustomers();	
		}
		
		@GET
		@Produces({"application/xml" , "application/json"})
		@Path("/customer/{customerId}")
		public CustomerRepresentation getCustomer(@PathParam("customerId") int id) {
			System.out.println("GET METHOD Request from Client with customerRequest String ............." + id);
			CustomerActivity empActivity = new CustomerActivity();
			return empActivity.getCustomer(id);
		}
		
		@POST
		@Produces({"application/xml" , "application/json"})
		@Path("/customer")
		public CustomerRepresentation createCustomer(CustomerRequest  customerRequest) {
			System.out.println("POST METHOD Request from Client with ............." + customerRequest.getFirstName() + "  " + customerRequest.getLastName() + "  " + customerRequest.getPhoneNumber()+ "  " + customerRequest.getAddress());
			CustomerActivity empActivity = new CustomerActivity();
			return empActivity.createCustomer(customerRequest.getFirstName(), customerRequest.getLastName(),customerRequest.getPhoneNumber(),customerRequest.getAddress());
		}
		
		@PUT
		@Produces({"application/xml" , "application/json"})
		@Path("/customer")
		public CustomerRepresentation updateCustomer(CustomerRequest  customerRequest) {
			System.out.println("POST METHOD Request from Client with ............." + customerRequest.getFirstName() + "  " + customerRequest.getLastName() + "  " + customerRequest.getPhoneNumber()+ "  " + customerRequest.getAddress());
			CustomerActivity empActivity = new CustomerActivity();
			return empActivity.createCustomer(customerRequest.getFirstName(), customerRequest.getLastName(),customerRequest.getPhoneNumber(),customerRequest.getAddress());
		}
		
		@DELETE
		@Produces({"application/xml" , "application/json"})
		@Path("/customer/{customerId}")
		public Response deletecustomer(@PathParam("customerId") int id) {
			System.out.println("Delete METHOD Request from Client with customerRequest String ............." + id);
			CustomerActivity prdActivity = new CustomerActivity();
			String res = prdActivity.deleteCustomer(id);
			if (res.equals("OK")) {
				return Response.status(Status.OK).build();
			}
			return null;
		}	

		
}
