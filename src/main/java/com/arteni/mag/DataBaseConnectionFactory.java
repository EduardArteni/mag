package com.arteni.mag;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnectionFactory {

    private static final String url = "jdbc:postgresql://localhost/postgres";
    private static final String driverClassName = "org.postgresql.Driver";
    private static final String user = "postgres";
    private static final String password = "123";
    private static DataBaseConnectionFactory connectionFactory = null;

    public Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, password);
        return conn;
    }

    public static DataBaseConnectionFactory getInstance() {
        if (connectionFactory == null) {
            connectionFactory = new DataBaseConnectionFactory();
        }
        return connectionFactory;
    }
}
