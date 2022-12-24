package com.arteni.mag.dao;

import com.arteni.mag.Models.Order;

import java.sql.*;

public class OrderDAO extends EmagGenericDAO {

    public Order createOrder(int user_id, double total) {

        Connection connection = null;
        Order createdOrder = new Order();
        createdOrder.setUser_id(user_id);
        createdOrder.setTotal(total);
        //createdOrder.setCreated_at(Timestamp.);

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO public.order_details(user_id, total, created_at)VALUES (?, ?, NOW());");
            preparedStatement.setInt(1, user_id);
            preparedStatement.setDouble(2, total);
            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                createdOrder.setId(generatedKeys.getInt(1));
                createdOrder.setCreated_at(generatedKeys.getTimestamp(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
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
