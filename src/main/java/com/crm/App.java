package com.crm;

import com.crm.model.Customer;
import com.crm.service.CustomerService;

public class App {
    public static void main(String[] args) {
        CustomerService customerService = new CustomerService();

        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("John Doe");
        customer.setEmail("john.doe@example.com");
        customer.setPhone("123-456-7890");

        customerService.addCustomer(customer);
        System.out.println("Clients : " + customerService.getAllCustomers());
    }
}