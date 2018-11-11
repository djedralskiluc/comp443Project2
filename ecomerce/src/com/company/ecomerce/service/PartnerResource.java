package com.company.ecomerce.service;

import java.util.Set;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.company.ecomerce.service.PartnerService;
import com.company.ecomerce.service.representation.PartnerRepresentation;
import com.company.ecomerce.service.representation.PartnerRequest;
import com.company.ecomerce.workflow.PartnerActivity;


	@Path("/partnerservice/")
	public class PartnerResource implements PartnerService {

		@GET
		@Produces({"application/xml" , "application/json"})
		@Path("/partner")
		//@Cacheable(cc="public, maxAge=3600") example for caching
		public Set<PartnerRepresentation> getPartners() {
			System.out.println("GET METHOD Request for all partners .............");
			PartnerActivity empActivity = new PartnerActivity();
			return empActivity.getPartners();	
		}
		
		@GET
		@Produces({"application/xml" , "application/json"})
		@Path("/partner/{partnerId}")
		public PartnerRepresentation getPartner(@PathParam("partnerId") int id) {
			System.out.println("GET METHOD Request from Client with partnerRequest String ............." + id);
			PartnerActivity empActivity = new PartnerActivity();
			return empActivity.getPartner(id);
		}
		
		@POST
		@Produces({"application/xml" , "application/json"})
		@Path("/partner")
		public PartnerRepresentation createPartner(PartnerRequest  partnerRequest) {
			System.out.println("POST METHOD Request from Client with ............." + partnerRequest.getName() + "  " + partnerRequest.getPartnerType());
			PartnerActivity empActivity = new PartnerActivity();
			return empActivity.createPartner(partnerRequest.getName(), partnerRequest.getPartnerType());
		}
		
		@PUT
		@Produces({"application/xml" , "application/json"})
		@Path("/partner")
		public PartnerRepresentation updatePartner(PartnerRequest  partnerRequest) {
			System.out.println("POST METHOD Request from Client with ............." + partnerRequest.getName() + "  " + partnerRequest.getPartnerType());
			PartnerActivity empActivity = new PartnerActivity();
			return empActivity.createPartner(partnerRequest.getName(), partnerRequest.getPartnerType());
		}
		
		@DELETE
		@Produces({"application/xml" , "application/json"})
		@Path("/partner/{partnerId}")
		public Response deletepartner(@PathParam("partnerId") int id) {
			System.out.println("Delete METHOD Request from Client with partnerRequest String ............." + id);
			PartnerActivity prdActivity = new PartnerActivity();
			String res = prdActivity.deletePartner(id);
			if (res.equals("OK")) {
				return Response.status(Status.OK).build();
			}
			return null;
		}	

		
}
