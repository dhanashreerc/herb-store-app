package com.cdac.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import com.cdac.entity.Customer;
import com.cdac.entity.Product;

@Component
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	@Query("select p from Customer p where p.customerId = ?1")
	public List<Customer> findAllByProductId(int customerId);
	
	@Query("select c from Customer c where c.role=?1")
	public List<Customer> findByRole(Customer customer);
	
	@Query("select c from Customer c where c.email=?1 and c.password=?2")
	public Customer findByUsernameandPassword(String email, String password);
	
	//@Query("select t from Train t where t.source = ?1  and t.destination = ?2")
//		public List<Train> findBySourceAndDestination(String source, String destination);
}
