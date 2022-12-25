package com.arteni.mag.dao;

import com.arteni.mag.Models.Customer;
import com.arteni.mag.Models.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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


    public Customer createCustomer(Customer customer) {

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(
                new PreparedStatementCreator() {
                    public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                        PreparedStatement ps =
                                connection.prepareStatement("insert into customers (first_name, last_name) values(?,?)", new String[]{"id"});
                        ps.setString(1, customer.getFirstName());
                        ps.setString(2, customer.getLastName());
                        return ps;
                    }
                },
                keyHolder);

        customer.setId(keyHolder.getKey().longValue());
        return customer;
    }

    public int updateCustomer(Customer customer) {
        return jdbcTemplate.update(
                "UPDATE customers SET first_name = ?, last_name = ? WHERE id = ?",
                customer.getFirstName(), customer.getLastName(), customer.getId());
    }


}

