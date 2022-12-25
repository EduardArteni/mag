package com.arteni.mag.dao;

import com.arteni.mag.Models.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class OrderDAO extends EmagGenericDAO {

    public Order createOrder(int user_id, double total) throws Exception {

        Connection connection = null;
        Order createdOrder = new Order();
        createdOrder.setUser_id(user_id);
        createdOrder.setTotal(total);
        createdOrder.setCreatedAt(new Date(System.currentTimeMillis()));

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO public.order_details(user_id, total, created_at)VALUES (?, ?, ?);");
            preparedStatement.setInt(1, user_id);
            preparedStatement.setDouble(2, total);
            preparedStatement.setTimestamp(3, new java.sql.Timestamp(createdOrder.getCreatedAt().getTime()));

            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                createdOrder.setId(generatedKeys.getInt(1));
            }
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return createdOrder;

    }

}
