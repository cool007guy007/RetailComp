/**
 * 
 */
package com.web;

import java.util.List;

public interface ProductRepository {
	
	List<Product> getAllProducts();
	
	Product getProduct(String number);
}
