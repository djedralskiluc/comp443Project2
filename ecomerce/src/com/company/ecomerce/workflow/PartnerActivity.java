package com.company.ecomerce.workflow;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.company.ecomerce.dal.PartnerDAO;
import com.company.ecomerce.domain.model.Link;
import com.company.ecomerce.partner.*;
import com.company.ecomerce.service.representation.CustomerRepresentation;
import com.company.ecomerce.service.representation.PartnerRepresentation;

public class PartnerActivity {
	private static PartnerManager dao = new PartnerManager();
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
			setLinks(daopRep, id);	
			return daopRep;
		}
		
		public PartnerRepresentation createPartner(String name,  int type) {
			
			//Partner daop = dao.addPartner(firstName, lastName);
			Partner daop = dao.addPartner(name, type);
			
			PartnerRepresentation daopRep = new PartnerRepresentation();
			daopRep.setName(daop.getName());
			daopRep.setPartnerType(daop.getPartnerType());
			setLinks(daopRep,daop.getPartnerId() );	
			return daopRep;
		}
		
		public String deletePartner(int id) {
			
			//dao.deletePartner(id);
			dao.deletePartner(id);
			
			return "OK";
		}
		private void setLinks(PartnerRepresentation partnerRep, int Id) {
			//UriInfo uri= new UriInfo();
			// Set up the activities that can be performed on orders
			Link productLink = new Link("List", 
					"localhost:8080" + "/productservice/product/");
			Link customerListLink = new Link("List", 
					//UriInfo.getPath()
					"localhost:8080"+ "/customerservice/customer/");
			partnerRep.setLinks(productLink,customerListLink);
		}
}
