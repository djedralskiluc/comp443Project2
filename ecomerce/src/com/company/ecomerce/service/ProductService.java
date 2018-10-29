package com.company.ecomerce.service;

import java.util.Set;

import javax.jws.WebService;

import com.company.ecomerce.service.representation.ProductRepresentation;
import com.company.ecomerce.service.representation.ProductRequest;

@WebService
public interface ProductService {
	public Set<ProductRepresentation> getProducts();
	public ProductRepresentation getProduct(int productId);
	public ProductRepresentation createProduct(ProductRequest productRequest);
   

}
