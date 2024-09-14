package service;

import com.crm.service.CustomerService;
import com.crm.model.Customer;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CustomerServiceTest {

    @Test
    public void testAddCustomer() {
        CustomerService service = new CustomerService();
        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("John Doe");
        customer.setEmail("john.doe@example.com");
        customer.setPhone("1234567890");

        service.addCustomer(customer);

        assertEquals(1, service.getAllCustomers().size());
    }

    @Test
    public void testGetAllCustomers() {
        CustomerService service = new CustomerService();
        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("John Doe");
        customer.setEmail("john.doe@example.com");
        customer.setPhone("1234567890");

        service.addCustomer(customer);

        assertEquals(1, service.getAllCustomers().size());
    }

    @Test
    public void testGetCustomerById() {
        CustomerService service = new CustomerService();
        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("John Doe");
        customer.setEmail("john.doe@example.com");
        customer.setPhone("1234567890");

        service.addCustomer(customer);

        Customer result = service.getCustomerById(1);
        assertEquals(customer, result);
    }

    @Test
    public void testUpdateCustomer() {
        CustomerService service = new CustomerService();
        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("John Doe");
        customer.setEmail("john.doe@example.com");
        customer.setPhone("1234567890");

        service.addCustomer(customer);

        Customer updatedCustomer = new Customer();
        updatedCustomer.setId(1);
        updatedCustomer.setName("Jane Doe");
        updatedCustomer.setEmail("jane.doe@example.com");
        updatedCustomer.setPhone("9876543210");

        Customer result = service.updateCustomer(updatedCustomer);
        assertEquals(updatedCustomer.getId(), result.getId());
        assertEquals(updatedCustomer.getName(), result.getName());
        assertEquals(updatedCustomer.getEmail(), result.getEmail());
        assertEquals(updatedCustomer.getPhone(), result.getPhone());
    }

    @Test
    public void testDeleteCustomer() {
        CustomerService service = new CustomerService();
        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("John Doe");
        customer.setEmail("john.doe@example.com");
        customer.setPhone("1234567890");

        service.addCustomer(customer);

        service.deleteCustomer(1);
        assertEquals(0, service.getAllCustomers().size());
    }
}
