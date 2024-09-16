package controller;

import com.crm.controller.CustomerController;
import com.crm.model.Customer;
import com.crm.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CustomerControllerTest {

    @Mock
    private CustomerService customerService;

    @InjectMocks
    private CustomerController customerController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createCustomer() {
        Customer customer = new Customer();
        customer.setId(1);
        when(customerService.createCustomer(any(Customer.class))).thenReturn(customer);

        ResponseEntity<Customer> response = customerController.createcustomer(new Customer());

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(customer, response.getBody());
    }

    @Test
    void getAllCustomers() {
        List<Customer> customers = Arrays.asList(new Customer(), new Customer());
        when(customerService.getAllCustomers()).thenReturn(customers);

        ResponseEntity<List<Customer>> response = customerController.getAllcustomers();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(customers, response.getBody());
    }

    @Test
    void getCustomerById_Found() {
        Customer customer = new Customer();
        customer.setId(1);
        when(customerService.getCustomerById(1)).thenReturn(customer);

        ResponseEntity<Customer> response = customerController.getcustomerById(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(customer, response.getBody());
    }

    @Test
    void getCustomerById_NotFound() {
        when(customerService.getCustomerById(1)).thenReturn(null);

        ResponseEntity<Customer> response = customerController.getcustomerById(1);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
    }

    @Test
    void updateCustomer_Found() {
        Customer customer = new Customer();
        customer.setId(1);
        when(customerService.getCustomerById(1)).thenReturn(customer);
        when(customerService.createCustomer(any(Customer.class))).thenReturn(customer);

        ResponseEntity<Customer> response = customerController.updatecustomer(1, new Customer());

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(customer, response.getBody());
    }

    @Test
    void updateCustomer_NotFound() {
        when(customerService.getCustomerById(1)).thenReturn(null);

        ResponseEntity<Customer> response = customerController.updatecustomer(1, new Customer());

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
    }

    @Test
    void deleteCustomer_Found() {
        Customer customer = new Customer();
        customer.setId(1);
        when(customerService.getCustomerById(1)).thenReturn(customer);

        ResponseEntity<Void> response = customerController.deletecustomer(1);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(customerService, times(1)).deleteCustomer(1);
    }

    @Test
    void deleteCustomer_NotFound() {
        when(customerService.getCustomerById(1)).thenReturn(null);

        ResponseEntity<Void> response = customerController.deletecustomer(1);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(customerService, never()).deleteCustomer(anyInt());
    }
}