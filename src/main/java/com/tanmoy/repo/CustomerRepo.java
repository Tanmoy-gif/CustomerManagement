package com.tanmoy.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tanmoy.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer>{
	public List<Customer> findByName(String name);
	@Query(value = "DELETE FROM customer WHERE name = ?" ,nativeQuery = true)
	public void deleteByName(String name);
	

}
