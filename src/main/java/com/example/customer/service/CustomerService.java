package com.example.customer.service;

import com.example.customer.model.Customer;

import java.util.List;

public interface CustomerService {
    public void addCustomer(Customer c);
    public void updateCustomer(Long id, Customer c);
    public Customer findCustomerById(Long id);
    public List<Customer> getAllCustomers();
    public void deleteCustomer(Long id);
}
