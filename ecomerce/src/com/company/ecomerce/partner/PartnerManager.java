package com.company.ecomerce.partner;

import java.util.List;
import java.util.Set;

import com.company.ecomerce.customer.Address;


import com.company.ecomerce.dal.PartnerDAO;
import com.company.ecomerce.product.Product;

public class PartnerManager {
private static PartnerDAO dao = new PartnerDAO();
	
	public Set<Partner> getAllPartners(){
		return dao.getAllPartners();
	}
	
	public Partner getPartner(int id) {
		return dao.getPartner(id);
	}
	

	public Partner addPartner(String name, int partnerType) {

		Partner emp = dao.addPartner(name, partnerType);
		
		return emp;
	}

	public void updatePartner(int id, int partnerType) {
		dao.updatePartner(id, partnerType);
	}

	public void deletePartner(int id) {
		dao.deletePartner(id);
	}
	public List<Product> getPartnerProduct(int id){
		return null;
	}

}
