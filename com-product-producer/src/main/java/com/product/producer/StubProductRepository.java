package com.product.producer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;


@Repository
public class StubProductRepository implements ProductRepository {
	
	private Map<String, Product> productsByNumber = new HashMap<String, Product>();
	
	public StubProductRepository() {
		Product product = new Product(1000l, "Mobile" , "0001");
		productsByNumber.put("0001", product);
		product = new Product(2000l, "Watch" , "0002");
		productsByNumber.put("0002", product);
		product = new Product(3000l, "Jeans" , "0003");
		productsByNumber.put("0003", product);
		Logger.getLogger(StubProductRepository.class).info("Created StubProductRepository");
	}
	
	@Override
	public List<Product> getAllProducts() {
		return new ArrayList<Product>(productsByNumber.values());
	}

	@Override
	public Product getProduct(String number) {
		return productsByNumber.get(number);
	}

}
