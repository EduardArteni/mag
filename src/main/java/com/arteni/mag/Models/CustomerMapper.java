package com.arteni.mag.Models;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;


public class CustomerMapper implements RowMapper<Customer> {

    public Customer mapRow(ResultSet resultSet, int i) throws SQLException {

        Customer Customer = new Customer();
        Customer.setId(resultSet.getLong("id"));
        Customer.setFirstName(resultSet.getString("first_name"));
        Customer.setLastName(resultSet.getString("last_name"));
        return Customer;
    }
}