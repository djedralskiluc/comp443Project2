package com.company.ecomerce.service.representation;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.company.ecomerce.partner.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class PartnerRequest {
	

	private String name;
	private int partnerType;
	
	public PartnerRequest() {}

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
