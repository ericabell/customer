package com.example.customer.service;

import com.example.customer.model.Customer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

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

        // add a new customer
        customerService.addCustomer(customer1);

        // let's check to see if we can get that customer back
        List<Customer> customers = new ArrayList<>();
        customers = customerService.getAllCustomers();
        Assert.assertEquals(customers.get(0).getFirstName(), "Eric");
    }

    @Test
    public void testUpdate() {
        // grab the first customer in the table
        List<Customer> customers = new ArrayList<>();
        customers = customerService.getAllCustomers();
        Customer customerToUpdate = customers.get(0);

        // manipulate the first name of the customer
        customerToUpdate.setFirstName("Bob");

        // update the table
        customerService.updateCustomer(customerToUpdate.getId(), customerToUpdate);

        // check to make sure the update occurred
        customers = customerService.getAllCustomers();
        Assert.assertEquals(customers.get(0).getFirstName(), "Bob");
    }
}
