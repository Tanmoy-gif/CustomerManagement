package com.tanmoy.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.tanmoy.entity.Customer;
import com.tanmoy.service.CustomerService;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class CustomerEndPoint {
	@Autowired
	private CustomerService service;
	
	@PostMapping(value="/saveCustomer")
	public ResponseEntity<String> saveCustomer(@RequestBody Customer customer){
		System.out.println(customer);
		String saveCustomer = service.saveCustomer(customer);
		return new ResponseEntity<>(saveCustomer,HttpStatus.OK);
		
	}
	
	@PostMapping(value="/saveAll")
	public ResponseEntity<String> saveManyCustomer(@RequestBody List<Customer> customers){
		String res=service.saveManyCustomer(customers);
		return new ResponseEntity<String>(res,HttpStatus.OK);
		
	}
	
	@GetMapping(value = "/get/{name}")
	public ResponseEntity<List<Customer>> getCustomerByName(@PathVariable String name){
		List<Customer> customer=service.getCustByName(name);
		return new ResponseEntity<List<Customer>>(customer,HttpStatus.OK);
	}
	@GetMapping(value = "/getAll")
	public ResponseEntity<List<Customer>> getAllCustomers(){
		List<Customer> customer=service.getAllCustomers();
		return new ResponseEntity<List<Customer>>(customer,HttpStatus.OK);
	}
	
	
	@DeleteMapping(value = "deleteByName/{name}")
	public ResponseEntity<String> deleteByName(@PathVariable String name){
		String res=service.deletByName(name);
		return new ResponseEntity<String>(res,HttpStatus.OK);
	}
	
	@GetMapping(value = "/customer")
	public ResponseEntity<Customer> getByNameAndEmail(@RequestParam String name,
														@RequestParam String email){
		List<Customer> cust=service.getByNameAndEmail(name, email);
		
		return new ResponseEntity<Customer>(cust.get(0),HttpStatus.OK);
	}
	

}
