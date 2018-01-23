/**
 * 
 */
package com.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ProductController {
	
	@Autowired
	ProductRepository productRepository;
	
	@RequestMapping("/")
	public String home(){
		return "index";
	}
	@RequestMapping("/productList")
	public String productList(Model model) {
		model.addAttribute("products", productRepository.getAllProducts());
		return "productList";
	}
	
	@RequestMapping("/productDetails")
	public String productDetails(@RequestParam("number") String id, Model model) {
		model.addAttribute("product", productRepository.getProduct(id));
		return "productDetails";
	}
}
