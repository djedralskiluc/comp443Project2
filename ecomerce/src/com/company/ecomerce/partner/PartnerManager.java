package com.company.ecomerce.partner;

import java.util.Set;

import com.company.ecomerce.customer.Address;


import com.company.ecomerce.dal.PartnerDAO;

public class PartnerManager {
private static PartnerDAO dao = new PartnerDAO();
	
	public Set<Partner> getAllPartner(){
		return dao.getAllPartners();
	}
	
	public Partner getPartner(String id) {
		return dao.getPartner(id);
	}
	

	public Partner addPartner(String firstName, String lastName,String phoneNumber, Address addr) {

		Partner emp = dao.addPartner(firstName, lastName,phoneNumber,addr);
		
		return emp;
	}

	public void updatePartner(int id, String phoneNumber, Address addr) {
		dao.updatePartner(id, phoneNumber,addr);
	}

	public void deletePartner(int id) {
		dao.deletePartner(id);
	}

}
