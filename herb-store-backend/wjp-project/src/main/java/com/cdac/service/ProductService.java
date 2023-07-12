package com.cdac.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.dao.ProductRepository;
import com.cdac.entity.Product;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepo;
	
	public void addProduct(Product product) {
		productRepo.save(product);
	}
	
	public List<Product> fetchProducts(){
		return productRepo.findAll();
	}

	public List<Product> getProduct(int productId) {
		return productRepo.findAllByProductId(productId);
	}
	
	public List<Product> removeProduct(int productId) {
		productRepo.deleteById(productId);
		return productRepo.findAll();
	}
	
}
