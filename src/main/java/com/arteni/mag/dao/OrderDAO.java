package com.arteni.mag.dao;

import com.arteni.mag.Models.Order;
import com.arteni.mag.Models.OrderItem;

import java.sql.*;
import java.util.Date;

public class OrderDAO extends EmagGenericDAO {

    public Order createOrder(Order order) throws Exception {

        Connection connection = null;
        order.setCreatedAt(new Date(System.currentTimeMillis()));

        //System.out.println(order);

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO public.order_details(user_id, total, created_at)VALUES (?, ?, ?);", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, order.getUser_id());
            preparedStatement.setDouble(2, order.getTotal());
            preparedStatement.setTimestamp(3, new java.sql.Timestamp(order.getCreatedAt().getTime()));

            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            generatedKeys.next();
            order.setId(generatedKeys.getInt(1));

            for (OrderItem orderItem : order.getItems()) {
                orderItem.setOrderId(order.getId());
                preparedStatement = connection.prepareStatement("INSERT INTO public.order_items(order_id, product_id, quantity, total) VALUES (?, ?, ?, ?);", Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setInt(1, orderItem.getOrderId());
                preparedStatement.setInt(2, orderItem.getProductId());
                preparedStatement.setInt(3, orderItem.getQuantity());
                preparedStatement.setDouble(4, orderItem.getTotal());
                preparedStatement.executeUpdate();
                generatedKeys = preparedStatement.getGeneratedKeys();
                generatedKeys.next();
                orderItem.setId(generatedKeys.getInt(1));
                System.out.println(orderItem);
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
        return order;

    }

    public Order getOrderById(int id) {
        Order order = null;
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT user_id, total, created_at FROM public.order_details WHERE \"id\"=?;");
            //System.out.println(preparedStatement);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                order = new Order();
                order.setId(id);
                order.setUser_id(resultSet.getInt("user_id"));
                order.setTotal(resultSet.getDouble("total"));
                order.setCreatedAt(resultSet.getTimestamp("created_at"));
            }

            preparedStatement = connection.prepareStatement("SELECT id, order_id, product_id, quantity, total FROM public.order_items WHERE \"order_id\"=?;");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                OrderItem orderItem = new OrderItem();
                orderItem.setId(resultSet.getInt("id"));
                orderItem.setOrderId(id);
                orderItem.setProductId(resultSet.getInt("product_id"));
                orderItem.setQuantity(resultSet.getInt("quantity"));
                orderItem.setTotal(resultSet.getDouble("total"));
                order.getItems().add(orderItem);
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

        return order;
    }

}
