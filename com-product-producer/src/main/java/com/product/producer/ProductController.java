/**
 * 
 */
package com.product.producer;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProductController {

	protected Logger logger = Logger
			.getLogger(ProductController.class.getName());
	
	@Autowired
	ProductRepository productRepository;
	
	@RequestMapping("/products")
	public Product[] all() {
		logger.info("products-microservice all() invoked");
		List<Product> products = productRepository.getAllProducts();
		logger.info("products-microservice all() found: " + products.size());
		return products.toArray(new Product[products.size()]);
	}
	
	@RequestMapping("/products/{id}")
	public Product byId(@PathVariable("id") String id) {
		logger.info("products-microservice byId() invoked: " + id);
		Product product = productRepository.getProduct(id);
		logger.info("products-microservice byId() found: " + product);
		return product;
	}
}
