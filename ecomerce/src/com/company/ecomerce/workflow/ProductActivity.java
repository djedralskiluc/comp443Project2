package com.company.ecomerce.workflow;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.ws.rs.core.UriInfo;

import com.company.ecomerce.dal.ProductDAO;
import com.company.ecomerce.product.*;
import com.company.ecomerce.domain.model.Link;
import com.company.ecomerce.service.representation.ProductRepresentation;

public class ProductActivity {
	private static ProductManager dao = new ProductManager();
	private static String url = "http://localhost:8081";
		
		public Set<ProductRepresentation> getProducts() {
			
			Set<Product> products = new HashSet<Product>();
			Set<ProductRepresentation> productRepresentations = new HashSet<ProductRepresentation>();
			//products = dao.getAllProducts();
			products = dao.getAllProducts();
			
			Iterator<Product> it = products.iterator();
			while(it.hasNext()) {
	          Product daop = (Product)it.next();
	          ProductRepresentation productRepresentation = new ProductRepresentation();
	          productRepresentation.setCost(daop.getCost());
	          productRepresentation.setName(daop.getName());
	          productRepresentation.setDetails(daop.getDetails());
	          productRepresentation.setPartnerId(daop.getPartnerId());
	          setIDLinks(productRepresentation,daop.getProductId());
	          //now add this representation in the list
	          productRepresentations.add(productRepresentation);
	        }
			
			return productRepresentations;
		}
		
		public ProductRepresentation getProduct(int id) {
			
			//Product daop = dao.getProduct(id);
			Product daop = dao.getProduct(id);
			
			ProductRepresentation daopRep = new ProductRepresentation();
			daopRep.setName(daop.getName());
			daopRep.setDetails(daop.getDetails());
			daopRep.setCost(daop.getCost());
			setIDLinks(daopRep,daop.getProductId());
			return daopRep;
		}
		
		public ProductRepresentation createProduct(String name, String details,double cost, int partnerId) {
			
			//Product daop = dao.addProduct(firstName, lastName);
			Product daop = dao.addProduct(name, details, cost, partnerId);
			
			ProductRepresentation daopRep = new ProductRepresentation();
			daopRep.setName(daop.getName());
			daopRep.setDetails(daop.getDetails());
			daopRep.setCost(daop.getCost());
			setIDLinks(daopRep,daop.getProductId());
			return daopRep;
		}

		public String deleteProduct(int id) {
			
			//dao.deleteProduct(id);
			dao.deleteProduct(id);
			
			return "OK";
		}
		
		private void setIDLinks(ProductRepresentation productRep, int orderId) {
			// Set up the activities that can be performed on orders
			Link productIdLink = new Link("PUT", 
					url + "/productservice/product/" + productRep.getProductId(),"application/json");
			Link productDeleteLink = new Link("DELETE", 
					url + "/productservice/product/"+ productRep.getProductId(),"application/json");
			Link orderListLink = new Link("POST", 
					url + "/orderservice/order/","application/json");
			Link partnerListLink = new Link("GET", 
					url + "/partnerservice/partner/","application/json");
			productRep.setLinks(productIdLink,productDeleteLink,orderListLink,partnerListLink);
		}
}
