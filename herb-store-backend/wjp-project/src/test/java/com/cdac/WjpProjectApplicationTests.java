package com.cdac;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cdac.dao.CustomerRepository;
import com.cdac.dao.ProductRepository;
import com.cdac.entity.Customer;
import com.cdac.entity.Product;

@SpringBootTest
class WjpProjectApplicationTests {

	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private CustomerRepository customerRepo;
	@Test
	void contextLoads() {
	
//		Customer customer = new Customer();
//		customer.setName("Name");
//		customer.setEmail("temp@gmail.com");
//		customer.setContact("1234567854");;
//		customer.setAddress("Mumbai");
//		Product product = new Product();
//		product.setName("Basil");
//		product.setPrice(500);
//		product.setQuantity(2);
//		productRepo.save(product);
		
		Customer customer = customerRepo.findByUsernameandPassword("abcd@gmail.com", "abcd");
		System.out.println(customer.getName());
	}

}
