package com.arteni.mag.dao;

import com.arteni.mag.Models.Customer;
import com.arteni.mag.Models.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Customer findById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM customers WHERE id = ?", new CustomerMapper(), id);
    }

    public List<Customer> findAll() {
        return jdbcTemplate.query("SELECT * FROM customers", new CustomerMapper());
    }

    public List<Customer> findByLastName(String lastName) {
        return jdbcTemplate.query(
                "SELECT * FROM customers WHERE last_name like ?", new CustomerMapper(), lastName);
    }


    public int createCustomer(Customer customer) {
        return jdbcTemplate.update(
                "insert into customers (first_name, last_name) values(?,?)",
                customer.getFirstName(), customer.getLastName());
    }


}

