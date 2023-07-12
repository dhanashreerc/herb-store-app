package com.cdac.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.dto.CustomerRegisterRequestDTO;
import com.cdac.entity.Customer;
import com.cdac.service.CustomerService;

@RestController
@CrossOrigin
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/add-customer")
	public String add(@RequestBody CustomerRegisterRequestDTO customerRequestDTO) {
		customerService.addCustomer(customerRequestDTO);
		return "Customer details added successfully!";
	}
	
	@GetMapping("/all-customer")
	public List<Customer> fetch() {
		return customerService.fetchAll();
	}
	
	@GetMapping("/find-by-custId")
	public Optional<Customer> findCustomer(@RequestParam int customerId) {
		return customerService.findByCustomer(customerId);
	}
	
	@DeleteMapping("/remove-customer")
	public void removeCustomer(int customerId) {
		customerService.deleteCustomer(customerId);
	}
	
	@GetMapping("/role")
	public List<Customer> findByRole(Customer customer){
		return customerService.findByCustomerRole(customer);
	}
	
	@PostMapping("/app-login")
	public Optional<Customer> findByUsernameandPassword(@RequestParam String email,@RequestParam String password) {
		return Optional.ofNullable(customerService.findByEmailandPassword(email, password));
		
	}
}
