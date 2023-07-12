package com.cdac.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import com.cdac.entity.Product;

@Component
public interface ProductRepository  extends JpaRepository<Product, Integer>{

	@Query("select p from Product p where p.productId = ?1")
	public List<Product> findAllByProductId(int productId);
//	public List<Product> findBySourceAndDestination(String source, String destination);
}
