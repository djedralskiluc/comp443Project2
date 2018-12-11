package com.company.ecomerce.workflow;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.company.ecomerce.dal.OrderDAO;
import com.company.ecomerce.order.*;
import com.company.ecomerce.product.Product;
import com.company.ecomerce.product.ProductManager;
import com.company.ecomerce.domain.model.Link;
import com.company.ecomerce.service.representation.CustomerRepresentation;
import com.company.ecomerce.service.representation.OrderRepresentation;

public class OrderActivity {
	//private static OrderDAO dao = new OrderDAO();
	//private static ProductDAO pdao = new ProductDAO();
		private static OrderManager dao = new OrderManager();
		private static ProductManager pdao = new ProductManager();
		private static String url = "http://localhost:8081";
		
		public Set<OrderRepresentation> getOrders() {
			
			Set<Order> orders = new HashSet<Order>();
			Set<OrderRepresentation> orderRepresentations = new HashSet<OrderRepresentation>();
			//orders = dao.getAllOrders();
			orders = dao.getAllOrders();
			
			Iterator<Order> it = orders.iterator();
			while(it.hasNext()) {
	          Order daop = (Order)it.next();
	          OrderRepresentation orderRepresentation = new OrderRepresentation();


	          orderRepresentation.setOrderID(daop.getOrderID());
	          orderRepresentation.setAddressId(daop.getAddressId());
	          orderRepresentation.setCustomerId(daop.getCustomerId());
	          orderRepresentation.setDate(daop.getDate());
	          orderRepresentation.setOrderStatus(daop.getOrderStatus());
	          orderRepresentation.setPayment(daop.getPayment());
	          orderRepresentation.setProductIds(daop.getProductIds());	
	          List<Integer> productIds = daop.getProductIds();
				List<Product> products = daop.getProducts();
//				for(Integer prodId :productIds)
//				{
//					products.add(pdao.getProduct(prodId));
//				}			
				orderRepresentation.setProducts(products);         
	          //now add this representation in the list
	          orderRepresentations.add(orderRepresentation);
	        }
			return orderRepresentations;
		}
		
		public OrderRepresentation getOrder(int id) {
			
			//Order daop = dao.getOrder(id);
			Order daop = dao.getOrder(id);
			
			OrderRepresentation daopRep = new OrderRepresentation();
			daopRep.setOrderID(daop.getOrderID());
			daopRep.setAddressId(daopRep.getAddressId());
			daopRep.setCustomerId(daopRep.getCustomerId());
			daopRep.setDate(daopRep.getDate());
			daopRep.setOrderStatus(daopRep.getOrderStatus());
			daopRep.setPayment(daopRep.getPayment());
			daopRep.setProductIds(daopRep.getProductIds());	
					
			
			List<Integer> productIds = daopRep.getProductIds();
			List<Product> products = daopRep.getProducts();
//			for(Integer prodId :productIds)
//			{
//				products.add(pdao.getProduct(prodId));
//			}			
			daopRep.setProducts(products);
			setLinks(daopRep,id);
			return daopRep;
		}
		
		public OrderRepresentation createOrder(int customerId, List<Integer> products, double cost, int partnerId) {
			
			//Order daop = dao.addOrder(firstName, lastName);
			Order daop = dao.addOrder(customerId, products, cost, partnerId);
			
			OrderRepresentation daopRep = new OrderRepresentation();
			daopRep.setOrderID(daop.getOrderID());
			daopRep.setAddressId(daopRep.getAddressId());
			daopRep.setCustomerId(daopRep.getCustomerId());
			daopRep.setDate(daopRep.getDate());
			daopRep.setOrderStatus(daopRep.getOrderStatus());
			daopRep.setPayment(daopRep.getPayment());
			daopRep.setProductIds(daopRep.getProductIds());	
			 List<Integer> productIds = daopRep.getProductIds();
				List<Product> products1 = daopRep.getProducts();
				for(Integer prodId :productIds)
				{
					products1.add(pdao.getProduct(prodId));
				}			
				daopRep.setProducts(products1);   
				setLinks(daopRep,daop.getOrderID());
			return daopRep;
		}
		
		public String deleteOrder(int id) {
			
			//dao.deleteOrder(id);
			dao.deleteOrder(id);
			
			return "OK";
		}
		private void setLinks(OrderRepresentation orderRep, int orderId) {
			//UriInfo uri= new UriInfo();
			// Set up the activities that can be performed on orders
			Link customerIdLink = new Link("PUT", 
					url + "/customerservice/customer/" + orderRep.getCustomerId(),"application/json");
			Link customerListLink = new Link("GET", 
					//UriInfo.getPath()
					url+ "/customerservice/customer/","application/json");
			Link orderListLink = new Link("GET", 
					//UriInfo.getPath()
					url+ "/orderservice/order/","application/json");
			
			Link productListLink = new Link("GET", 
					url + "/productservice/product/","application/json");

			orderRep.setLinks(customerIdLink,customerListLink,orderListLink,productListLink);

		}
}
