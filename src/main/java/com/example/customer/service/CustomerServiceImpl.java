package com.example.customer.service;

import com.example.customer.model.Customer;
import com.example.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    
    @Override
    public void addCustomer(Customer c) {

    }

    @Override
    public void updateCustomer(Long id, Customer c) {

    }

    @Override
    public Customer findCustomerById(Long id) {
        return null;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return null;
    }

    @Override
    public void deleteCustomer(Long id) {

    }
}
