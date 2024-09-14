package repository;

import com.crm.repository.CustomerRepository;
import com.crm.model.Customer;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CustomerRepositoryTest {

    public void testAddCustomer() {
        CustomerRepository repository = new CustomerRepository();
        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("John Doe");
        customer.setEmail("john.doe@example.com");
        customer.setPhone("1234567890");

        repository.addCustomer(customer);

        assertEquals(1, repository.getAllCustomers().size());
    }

    @Test
    public void testGetAllCustomers() {
        CustomerRepository repository = new CustomerRepository();
        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("John Doe");
        customer.setEmail("john.doe@example.com");
        customer.setPhone("1234567890");

        repository.addCustomer(customer);

        assertEquals(1, repository.getAllCustomers().size());
    }

    @Test
    public void testGetCustomerById() {
        CustomerRepository repository = new CustomerRepository();
        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("John Doe");
        customer.setEmail("john.doe@example.com");
        customer.setPhone("1234567890");

        repository.addCustomer(customer);

        Customer result = repository.getCustomerById(1);
        assertEquals(customer, result);
    }

    @Test
    public void testUpdateCustomer() {
        CustomerRepository repository = new CustomerRepository();
        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("John Doe");
        customer.setEmail("john.doe@example.com");
        customer.setPhone("1234567890");

        repository.addCustomer(customer);

        Customer updatedCustomer = new Customer();
        updatedCustomer.setId(1);
        updatedCustomer.setName("Jane Doe");
        updatedCustomer.setEmail("jane.doe@example.com");
        updatedCustomer.setPhone("9876543210");

        Customer result = repository.updateCustomer(updatedCustomer);
        assertEquals(updatedCustomer.getId(), result.getId());
        assertEquals(updatedCustomer.getName(), result.getName());
        assertEquals(updatedCustomer.getEmail(), result.getEmail());
        assertEquals(updatedCustomer.getPhone(), result.getPhone());
    }

    @Test
    public void testDeleteCustomer() {
        CustomerRepository repository = new CustomerRepository();
        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("John Doe");
        customer.setEmail("john.doe@example.com");
        customer.setPhone("1234567890");

        repository.addCustomer(customer);

        repository.deleteCustomer(1);
        assertEquals(0, repository.getAllCustomers().size());
    }
}
