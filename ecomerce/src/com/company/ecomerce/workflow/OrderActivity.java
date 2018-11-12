package com.company.ecomerce.workflow;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.company.ecomerce.dal.OrderDAO;
import com.company.ecomerce.order.*;
import com.company.ecomerce.service.representation.OrderRepresentation;

public class OrderActivity {
	//private static OrderDAO dao = new OrderDAO();
	//private static ProductDAO pdao = new ProductDAO();
		private static OrderManager dao = new OrderManager();
		
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
	          orderRepresentation.setProducts(daop.getProducts());	         
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
						
			return daopRep;
		}
		
		public String deleteOrder(int id) {
			
			//dao.deleteOrder(id);
			dao.deleteOrder(id);
			
			return "OK";
		}
}
