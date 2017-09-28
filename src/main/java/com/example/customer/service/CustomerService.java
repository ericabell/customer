package com.example.customer.service;

import com.example.customer.model.Customer;

import java.util.List;

public interface CustomerService {
    public void addCustomer(Customer c);
    public void updateCustomer(int id, Customer c);
    public Customer findCustomerById(int id);
    public List<Customer> getAllCustomers();
    public void deleteCustomer(int id);
    public void deleteAllCustomers();
}
