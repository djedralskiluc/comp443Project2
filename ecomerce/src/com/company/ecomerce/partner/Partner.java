package com.company.ecomerce.partner;
import com.company.ecomerce.product.*;
import java.util.List;

public class Partner {
	
	private int partnerId;
	private List<Product> products;
	private String name;
	private int partnerType;
	
	public Partner() {}
	
	public int getPartnerId() {
		return this.partnerId;
	}
	public void setPartnerId(int partnerId) {
		this.partnerId = partnerId;
	}
	public List<Product> getProducts(){
		return this.products;
	}
	public String getName() {
		return this.name;
	}
	public int getPartnerType() {
		return this.partnerType;
	}
	public void setParterId(int id) {
		this.partnerId = id;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPartnerType(int type) {
		this.partnerType = type;
	}
}
