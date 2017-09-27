package com.example.customer.service;

import com.example.customer.model.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTest {

    @Autowired
    CustomerService customerService;

    @Test
    public void testAddGet() {
        Customer customer1 = new Customer();
        customer1.setFirstName("Eric");
        customer1.setLastName("Abell");
        customer1.setPhone("555-5555");
        customer1.setEmail("eric@eric.com");

        customerService.addCustomer(customer1);
    }
}
