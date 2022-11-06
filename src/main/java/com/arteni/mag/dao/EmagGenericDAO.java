package com.arteni.mag.dao;

import com.arteni.mag.DataBaseConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class EmagGenericDAO {

    protected Connection getConnection() throws SQLException {
        return DataBaseConnectionFactory.getInstance().getConnection();
    }
}
