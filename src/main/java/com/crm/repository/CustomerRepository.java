package com.crm.repository;

import com.crm.model.Customer;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {
    private List<Customer> customers = new ArrayList<>();

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public List<Customer> getAllCustomers() {
        return customers;
    }

    public Customer getCustomerById(int id) {
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        return null;
    }

    public Customer updateCustomer(Customer customer) {
        for (Customer c : customers) {
            if (c.getId() == customer.getId()) {
                c.setName(customer.getName());
                c.setEmail(customer.getEmail());
                c.setPhone(customer.getPhone());
                return c;
            }
        }
        return null;
    }

    public void deleteCustomer(int id) {
        for (Customer c : customers) {
            if (c.getId() == id) {
                customers.remove(c);
                return;
            }
        }
    }
}