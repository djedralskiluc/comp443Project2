package com.company.ecomerce.service;

import java.util.Set;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.company.ecomerce.service.OrderService;
import com.company.ecomerce.service.representation.OrderRepresentation;
import com.company.ecomerce.service.representation.OrderRequest;
import com.company.ecomerce.workflow.OrderActivity;


	@Path("/orderservice/")
	public class OrderResource implements OrderService {

		@GET
		@Produces({"application/xml" , "application/json"})
		@Path("/order")
		//@Cacheable(cc="public, maxAge=3600") example for caching
		public Set<OrderRepresentation> getOrders() {
			System.out.println("GET METHOD Request for all orders .............");
			OrderActivity empActivity = new OrderActivity();
			return empActivity.getOrders();	
		}
		
		@GET
		@Produces({"application/xml" , "application/json"})
		@Path("/order/{orderId}")
		public OrderRepresentation getOrder(@PathParam("orderId") int id) {
			System.out.println("GET METHOD Request from Client with orderRequest String ............." + id);
			OrderActivity empActivity = new OrderActivity();
			return empActivity.getOrder(id);
		}
		
		@POST
		@Produces({"application/xml" , "application/json"})
		@Path("/order")
		public OrderRepresentation createOrder(OrderRequest  orderRequest) {
			System.out.println("POST METHOD Request from Client with ............." + orderRequest.getCustomerId() + "  " + orderRequest.getProducts() + "  " + orderRequest.getCost()+ "  " + orderRequest.getPartnerId());
			OrderActivity empActivity = new OrderActivity();
			return empActivity.createOrder(orderRequest.getCustomerId(), orderRequest.getProducts(), orderRequest.getCost(), orderRequest.getPartnerId());
		}
		
		@DELETE
		@Produces({"application/xml" , "application/json"})
		@Path("/order/{orderId}")
		public Response deleteorder(@PathParam("orderId") int id) {
			System.out.println("Delete METHOD Request from Client with orderRequest String ............." + id);
			OrderActivity prdActivity = new OrderActivity();
			String res = prdActivity.deleteOrder(id);
			if (res.equals("OK")) {
				return Response.status(Status.OK).build();
			}
			return null;
		}	

		
}
