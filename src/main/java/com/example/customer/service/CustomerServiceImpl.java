package com.example.customer.service;

import com.example.customer.model.Customer;
import com.example.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    @Transactional
    public void addCustomer(Customer c) {
        customerRepository.save(c);
    }

    @Override
    @Transactional
    public void updateCustomer(int id, Customer c) {
        customerRepository.save(c);
    }

    @Override
    public Customer findCustomerById(int id) {
        return customerRepository.findOne(id);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteCustomer(int id) {
        customerRepository.delete(id);
    }

    @Override
    @Transactional
    public void deleteAllCustomers() {
        customerRepository.deleteAll();
    }
}
