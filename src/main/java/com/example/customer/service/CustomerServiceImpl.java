package com.example.customer.service;

import com.example.customer.model.Customer;
import com.example.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    @Transactional
    public void addCustomer(Customer c) {
        customerRepository.addCustomer(c);
    }

    @Override
    @Transactional
    public void updateCustomer(Long id, Customer c) {
        customerRepository.updateCustomer(id, c);
    }

    @Override
    public Customer findCustomerById(Long id) {
        return customerRepository.findCustomerById(id);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.getAllCustomers();
    }

    @Override
    @Transactional
    public void deleteCustomer(Long id) {
        customerRepository.deleteCustomer(id);
    }
}
