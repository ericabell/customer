package com.example.customer.repository;

import com.example.customer.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
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

    private final String SELECT_BY_ID_SQL = "SELECT * FROM customer WHERE id = ?";
    @Override
    public Customer findCustomerById(Long id) {
        return jdbcTemplate.queryForObject(SELECT_BY_ID_SQL, new CustomerMapper(), id);
    }

    private final String SELECT_SQL = "SELECT * FROM customer";
    @Override
    public List<Customer> getAllCustomers() {
        return jdbcTemplate.query(SELECT_SQL, new CustomerMapper());
    }

    private final String DELETE_SQL = "DELETE FROM customer WHERE id=?";
    @Override
    public void deleteCustomer(Long id) {
        jdbcTemplate.update(DELETE_SQL, id);
    }

    private static class CustomerMapper implements RowMapper<Customer> {
        @Override
        public Customer mapRow(ResultSet resultSet, int i) throws SQLException {
            Customer customer = new Customer();
            customer.setId(resultSet.getLong("id"));
            customer.setFirstName(resultSet.getString("firstName"));
            customer.setLastName(resultSet.getString("lastName"));
            customer.setPhone(resultSet.getString("phone"));
            customer.setEmail(resultSet.getString("email"));
            return customer;
        }
    }
}
