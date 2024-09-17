package com.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.crm.model.Customer;
import com.crm.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    // Create
    @PostMapping
    public ResponseEntity<Customer> createcustomer(@RequestBody Customer customer) {
        Customer savedCustomer = customerService.createCustomer(customer);
        return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
    }

    // Read (all)
    @GetMapping
    @Cacheable("customers")
    public ResponseEntity<List<Customer>> getAllcustomers() {
        List<Customer> customers = customerService.getAllCustomers();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    // Read (single)
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getcustomerById(@PathVariable Integer id) {
        Customer customer = customerService.getCustomerById(id);
        if (customer != null) {
            return new ResponseEntity<>(customer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<Customer> updatecustomer(@PathVariable Integer id, @RequestBody Customer customer) {
        Customer existingcustomer = customerService.getCustomerById(id);
        if (existingcustomer != null) {
            customer.setId(id);
            Customer updatedcustomer = customerService.createCustomer(customer);
            return new ResponseEntity<>(updatedcustomer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletecustomer(@PathVariable Integer id) {
        Customer existingcustomer = customerService.getCustomerById(id);
        if (existingcustomer != null) {
            customerService.deleteCustomer(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}