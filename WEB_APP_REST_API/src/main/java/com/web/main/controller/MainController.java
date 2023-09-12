package com.web.main.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.main.model.Customer;
import com.web.main.model.Product;
import com.web.main.repository.ProductRepository;
import com.web.main.repository.CustomerRepository;


@RestController
public class MainController {

	@Autowired
	private CustomerRepository customerRepo;
	@Autowired
	private ProductRepository productRepo;

	@GetMapping("/")
	public String hello() {
		return "Hello coders...";
	}

	@GetMapping("/customer/all")
	public List<Customer> getCustomer() {
		return customerRepo.findAll();    
	}

	@GetMapping("/customer/{id}")
	public Optional<Customer> getCustomer(@PathVariable("id") int id) {
		return customerRepo.findById(id);
	}

	@GetMapping("/product/all")
	public List<Product> getProduct() {
		return productRepo.findAll();
	}

	@GetMapping("/product/{id}")
	public Optional<Product> getProduct(@PathVariable("id") int id) {
		return productRepo.findById(id);
	}

	@PostMapping("/customer/add")
	public Customer addCustomer(@RequestBody Customer customer) {
		return customerRepo.save(customer);
	}
	
	@PostMapping("/product/add")
	public Product addProduct(@RequestBody Product product) {
		return productRepo.save(product);
	}

	@PostMapping("/customer/update")
	public Customer updateCustomer(@RequestBody Customer customer) {
		return customerRepo.save(customer);
	}

	@GetMapping("/customer/{id}/delete")
	public String deleteCustomer(@PathVariable("id") int id) {
		try {
			customerRepo.deleteById(id);
		} catch (Exception ex) {
			return "Failed";
		}

		return "Successful";
	}

	@PostMapping("/product/update")
	public Product updateCourse(@RequestBody Product product) {
		return productRepo.save(product);
	}

}
