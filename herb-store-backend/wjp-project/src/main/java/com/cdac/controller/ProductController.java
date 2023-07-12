package com.cdac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.entity.Product;
import com.cdac.service.ProductService;

@RestController
@CrossOrigin
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping("/add-product")
	public void add(@RequestBody Product product) {
		
		productService.addProduct(product);
	}
	
	@GetMapping("/product-list")
	public List<Product> fetch(){
		return productService.fetchProducts();
	}
	
	@GetMapping("/find-product")
	public List<Product> findProduct(@RequestParam int productId){
		return productService.getProduct(productId);
		
	}
	
	@DeleteMapping("/delete")
	public List<Product> removeProduct(@RequestParam int productId) {
		
		return productService.removeProduct(productId);
	}
}
