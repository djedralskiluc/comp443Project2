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

import com.company.ecomerce.service.ProductService;
import com.company.ecomerce.service.representation.ProductRepresentation;
import com.company.ecomerce.service.representation.ProductRequest;
import com.company.ecomerce.workflow.ProductActivity;


	@Path("/productservice/")
	public class ProductResource implements ProductService {

		@GET
		@Produces({"application/xml" , "application/json"})
		@Path("/product")
		//@Cacheable(cc="public, maxAge=3600") example for caching
		public Set<ProductRepresentation> getProducts() {
			System.out.println("GET METHOD Request for all products .............");
			ProductActivity empActivity = new ProductActivity();
			return empActivity.getProducts();	
		}
		
		@GET
		@Produces({"application/xml" , "application/json"})
		@Path("/product/{productId}")
		public ProductRepresentation getProduct(@PathParam("productId") int id) {
			System.out.println("GET METHOD Request from Client with productRequest String ............." + id);
			ProductActivity empActivity = new ProductActivity();
			return empActivity.getProduct(id);
		}
		
		@POST
		@Produces({"application/xml" , "application/json"})
		@Path("/product")
		public ProductRepresentation createProduct(ProductRequest  productRequest) {
			System.out.println("POST METHOD Request from Client with ............." + productRequest.getName() + "  " + productRequest.getDetails()+ "  " + productRequest.getCost()+ "  " + productRequest.getPartner());
			ProductActivity empActivity = new ProductActivity();
			return empActivity.createProduct(productRequest.getName(), productRequest.getDetails(),productRequest.getCost(),productRequest.getPartner());
		}
		
		@PUT
		@Produces({"application/xml" , "application/json"})
		@Path("/product")
		public ProductRepresentation updateProduct(ProductRequest  productRequest) {
			System.out.println("POST METHOD Request from Client with ............." + productRequest.getName() + "  " + productRequest.getDetails()+ "  " + productRequest.getCost()+ "  " + productRequest.getPartner());
			ProductActivity empActivity = new ProductActivity();
			return empActivity.createProduct(productRequest.getName(), productRequest.getDetails(),productRequest.getCost(),productRequest.getPartner());
		}
		
		@DELETE
		@Produces({"application/xml" , "application/json"})
		@Path("/product/{productId}")
		public Response deleteproduct(@PathParam("productId") int id) {
			System.out.println("Delete METHOD Request from Client with productRequest String ............." + id);
			ProductActivity prdActivity = new ProductActivity();
			String res = prdActivity.deleteProduct(id);
			if (res.equals("OK")) {
				return Response.status(Status.OK).build();
			}
			return null;
		}	

		
}
