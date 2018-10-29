package com.company.ecomerce.service.representation;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.company.ecomerce.partner.*;
import com.company.ecomerce.product.Product;

@XmlRootElement(name = "Partner")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class PartnerRepresentation {
	private int partnerId;
	private List<Product> products;
	private String name;
	private int partnerType;
	public PartnerRepresentation() {}
	public int getPartnerId() {
		return partnerId;
	}
	public void setPartnerId(int partnerId) {
		this.partnerId = partnerId;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPartnerType() {
		return partnerType;
	}
	public void setPartnerType(int partnerType) {
		this.partnerType = partnerType;
	}
	
	
}
