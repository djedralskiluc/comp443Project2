package com.company.ecomerce.order;

import java.util.List;
import java.util.Set;

import com.company.ecomerce.dal.OrderDAO;
import com.company.ecomerce.dal.ProductDAO;
import com.company.ecomerce.product.Product;


public class OrderManager {
private static OrderDAO dao = new OrderDAO();
private static ProductDAO pdao = new ProductDAO();

	public Set<Order> getAllOrders(){
		return dao.getAllOrders();
	}
	
	public Order getOrder(int id) {
		Order a = dao.getOrder(id);
		for(Integer product:a.getProductIds()) {
			
		}
		return a;
	}
	

	public Order addOrder(int customerId,List<Integer> products , double cost, int partnerId) {
//		for(int p : products){
//			
//		}
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
