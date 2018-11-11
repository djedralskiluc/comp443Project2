package com.company.ecomerce.service;

import java.util.Set;

import javax.jws.WebService;

import com.company.ecomerce.service.representation.PartnerRepresentation;
import com.company.ecomerce.service.representation.PartnerRequest;

@WebService
public interface PartnerService {
	public Set<PartnerRepresentation> getPartners();
	public PartnerRepresentation getPartner(int partnerId);
	public PartnerRepresentation createPartner(PartnerRequest partnerRequest);
	public PartnerRepresentation updatePartner(PartnerRequest partnerRequest);

}
