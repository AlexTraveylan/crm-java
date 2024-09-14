package model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.crm.model.Customer;

public class CustomerTest {

    @Test
    public void testGettersAndSetters() {
        Customer customer = new Customer();
        customer.setId(1);
        assertEquals(1, customer.getId());

        customer.setName("John Doe");
        assertEquals("John Doe", customer.getName());

        customer.setEmail("john.doe@example.com");
        assertEquals("john.doe@example.com", customer.getEmail());

        customer.setPhone("1234567890");
        assertEquals("1234567890", customer.getPhone());
    }

    @Test
    public void testToString() {
        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("John Doe");
        customer.setEmail("john.doe@example.com");
        customer.setPhone("1234567890");

        String expected = "Customer{id=1, name='John Doe', email='john.doe@example.com', phone='1234567890'}";
        assertEquals(expected, customer.toString());
    }

}
