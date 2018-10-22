package com.company.ecomerce.order;

public class OrderStatus {
	private String status;
	private String lastUpdate;
	
	public OrderStatus(String stat, String update){
		this.status = stat;
		this.lastUpdate = update;
	}
	public String getOrderStatus() {
		return this.status;
	}
	public String getLastUupdate() {
		return this.lastUpdate;
		
	}
	public void setOrderStatus(String stat) {
		this.status = stat;
	}
	public void setLastUpdate(String update) {
		this.lastUpdate = update;
	}
	
}
