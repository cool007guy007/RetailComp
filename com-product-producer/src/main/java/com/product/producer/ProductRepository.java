/**
 * 
 */
package com.product.producer;

import java.util.List;


public interface ProductRepository {
	
	List<Product> getAllProducts();
	
	Product getProduct(String number);
}
