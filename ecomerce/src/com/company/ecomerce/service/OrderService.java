package com.company.ecomerce.service;

import java.util.Set;

import javax.jws.WebService;

import com.company.ecomerce.service.representation.OrderRepresentation;
import com.company.ecomerce.service.representation.OrderRequest;

@WebService
public interface OrderService {
	public Set<OrderRepresentation> getOrders();
	public OrderRepresentation getOrder(int orderId);
	public OrderRepresentation createOrder(OrderRequest orderRequest);
   

}
