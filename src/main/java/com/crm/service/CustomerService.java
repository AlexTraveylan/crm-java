package com.crm.service;

import com.crm.model.Customer;
import com.crm.repository.CustomerRepository;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class CustomerService {
    private CustomerRepository repository = new CustomerRepository();

    public void addCustomer(Customer customer) {
        repository.addCustomer(customer);
    }

    public List<Customer> getAllCustomers() {
        return repository.getAllCustomers();
    }

    public Customer getCustomerById(int id) {
        return repository.getCustomerById(id);
    }

    public Customer updateCustomer(Customer customer) {
        return repository.updateCustomer(customer);
    }

    public void deleteCustomer(int id) {
        repository.deleteCustomer(id);
    }
}