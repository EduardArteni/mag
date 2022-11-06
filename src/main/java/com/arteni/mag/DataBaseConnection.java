package com.arteni.mag;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnection {

    private static final String url = "jdbc:postgresql://localhost/postgres";
    private static final String user = "postgres";
    private static final String password = "123";
    public static Connection connection = null;

    public DataBaseConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(url, user, password);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void connect() {
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
