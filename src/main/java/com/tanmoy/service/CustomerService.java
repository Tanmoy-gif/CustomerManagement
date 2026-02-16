package com.tanmoy.service;

import java.util.Optional;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tanmoy.constant.Constant;
import com.tanmoy.entity.Customer;
import com.tanmoy.repo.CustomerRepo;

import jakarta.transaction.Transactional;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepo repo;
	
	
	public Customer getCustomer(Integer id) {
		Optional<Customer> cust=repo.findById(id);
		if(!cust.isEmpty())
			return cust.get();
		else
			return null;
	}
	@Transactional
	public String saveCustomer(Customer cust) {
		try {
			repo.save(cust);
			return Constant.SUCCESS;
		}
		catch (Exception e) {
			return Constant.FAIL;
		}
	}
	
	public String saveManyCustomer(List<Customer> cust) {
		try {
			repo.saveAll(cust);  
			return Constant.SUCCESS;
		}
		catch (Exception e) {
			return Constant.FAIL;
		}
	}
	public List<Customer> getCustByName(String name) {
		List<Customer> cus=repo.findByName(name);
		
		return cus;
	}

}
