package com.example.customer.repository;

import com.example.customer.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final String INSERT_SQL = "INSERT INTO customer (firstName, lastName, phone, email) VALUES (?,?,?,?)";
    @Override
    public void addCustomer(Customer c) {
        jdbcTemplate.update(INSERT_SQL, c.getFirstName(), c.getLastName(), c.getPhone(), c.getEmail());
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
