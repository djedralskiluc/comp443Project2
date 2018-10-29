package com.company.ecomerce.workflow;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.company.ecomerce.dal.PartnerDAO;
import com.company.ecomerce.partner.*;
import com.company.ecomerce.service.representation.PartnerRepresentation;

public class PartnerActivity {
	private static PartnerDAO dao = new PartnerDAO();
		//private static PartnerManager dao = new PartnerManager();
		
		public Set<PartnerRepresentation> getPartners() {
			
			Set<Partner> partners = new HashSet<Partner>();
			Set<PartnerRepresentation> partnerRepresentations = new HashSet<PartnerRepresentation>();
			//partners = dao.getAllPartners();
			partners = dao.getAllPartners();
			
			Iterator<Partner> it = partners.iterator();
			while(it.hasNext()) {
	          Partner daop = (Partner)it.next();
	          PartnerRepresentation partnerRepresentation = new PartnerRepresentation();
	          partnerRepresentation.setName(daop.getName());
	          partnerRepresentation.setPartnerType(daop.getPartnerType());
	          	          
	          //now add this representation in the list
	          partnerRepresentations.add(partnerRepresentation);
	        }
			return partnerRepresentations;
		}
		
		public PartnerRepresentation getPartner(int id) {
			
			//Partner daop = dao.getPartner(id);
			Partner daop = dao.getPartner(id);
			
			PartnerRepresentation daopRep = new PartnerRepresentation();
			daopRep.setName(daop.getName());
			daopRep.setPartnerType(daop.getPartnerType());
			
			return daopRep;
		}
		
		public PartnerRepresentation createPartner(String name,  int type) {
			
			//Partner daop = dao.addPartner(firstName, lastName);
			Partner daop = dao.addPartner(name, type);
			
			PartnerRepresentation daopRep = new PartnerRepresentation();
			daopRep.setName(daop.getName());
			daopRep.setPartnerType(daop.getPartnerType());
			
			return daopRep;
		}
		
		public String deletePartner(int id) {
			
			//dao.deletePartner(id);
			dao.deletePartner(id);
			
			return "OK";
		}
}