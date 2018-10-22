package com.company.ecomerce.order;

import java.util.List;
import java.util.Set;

import com.company.ecomerce.dal.OrderDAO;
import com.company.ecomerce.product.Product;


public class OrderManager {
private static OrderDAO dao = new OrderDAO();
	
	public Set<Order> getAllPartners(){
		return dao.getAllOrders();
	}
	
	public Order getOrder(int id) {
		return dao.getOrder(id);
	}
	

	public Order addPartner(int customerId,List<Product> products , double cost, int partnerId) {

		Order emp = dao.addOrder(customerId, products ,  cost,  partnerId);
		
		return emp;
	}

	public void updateOrder(int id, int paymentType) {
		dao.updateOrder(id, paymentType);
	}

	public void deleteOrder(int id) {
		dao.deleteOrder(id);
	}
	public List<Product> getOrderProduct(int id){
		return null;
	}
}
