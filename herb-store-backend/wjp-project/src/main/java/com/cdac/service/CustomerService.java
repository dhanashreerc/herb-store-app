package com.cdac.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.dao.CustomerRepository;
import com.cdac.dto.CustomerRegisterRequestDTO;
import com.cdac.entity.Customer;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	public void addCustomer(CustomerRegisterRequestDTO customerRequestDTO) {
		Customer customer = mapper.map(customerRequestDTO, Customer.class); 
		customerRepo.save(customer);
	}
	
	public List<Customer> fetchAll(){
		return customerRepo.findAll();
	}
	
	public void deleteCustomer(int customerId) {
		customerRepo.deleteById(customerId);
	}
	
	public Optional<Customer> findByCustomer(int customerId) {
		return customerRepo.findById(customerId);
	}
	
	public List<Customer> findByCustomerRole(Customer customer) {
		return customerRepo.findByRole(customer);
	}
	
public Customer findByEmailandPassword(String email, String password) {
	return customerRepo.findByUsernameandPassword(email, password);
		
	}
}
