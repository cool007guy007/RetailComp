package com.web;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;


public class RemoteProductRepository implements ProductRepository {
	
	@Autowired
	protected RestTemplate restTemplate;
	
	protected String serviceUrl;
	
	public RemoteProductRepository(String serviceUrl) {
		this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl
				: "http://" + serviceUrl;
	}
	
	@Override
	public List<Product> getAllProducts() {
		Product[] products = restTemplate.getForObject(serviceUrl+"/products", Product[].class);
		return Arrays.asList(products);
	}

	@Override
	public Product getProduct(String number) {
		return restTemplate.getForObject(serviceUrl + "/products/{id}",
				Product.class, number);
	}

}
