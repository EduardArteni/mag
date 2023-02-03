package com.arteni.mag.dao;

import com.arteni.mag.Models.Order;
import com.arteni.mag.Models.OrderItem;
import com.arteni.mag.Models.OrderStatus;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

@Repository
public class OrderDAO extends EmagGenericDAO {

    public Order createOrder(Order order) throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet generatedKeys = null;

        order.setCreatedAt(new Date(System.currentTimeMillis()));

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO public.order_details(user_id, total, created_at, status)VALUES (?, ?, ?, 'CREATED');", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, order.getUser_id());
            preparedStatement.setDouble(2, order.getTotal());
            preparedStatement.setTimestamp(3, new java.sql.Timestamp(order.getCreatedAt().getTime()));

            preparedStatement.executeUpdate();

            generatedKeys = preparedStatement.getGeneratedKeys();
            generatedKeys.next();
            order.setId(generatedKeys.getInt(1));

            for (OrderItem orderItem : order.getItems()) {
                orderItem.setOrderId(order.getId());
                preparedStatement = connection.prepareStatement("INSERT INTO public.order_items(order_id, product_id, quantity, total) VALUES (?, ?, ?, ?);", Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setInt(1, orderItem.getOrderId());
                preparedStatement.setInt(2, orderItem.getProduct_id());
                preparedStatement.setInt(3, orderItem.getQuantity());
                preparedStatement.setDouble(4, orderItem.getTotal());
                preparedStatement.executeUpdate();
                generatedKeys = preparedStatement.getGeneratedKeys();
                generatedKeys.next();
                orderItem.setId(generatedKeys.getInt(1));
                System.out.println(orderItem);
            }

        } finally {
            if (generatedKeys != null) {
                generatedKeys.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return order;
    }

    public Order getOrderById(int id) throws SQLException {
        Order order = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("SELECT user_id, total, created_at, status FROM public.order_details WHERE \"id\"=?;");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                order = new Order();
                order.setId(id);
                order.setUser_id(resultSet.getInt("user_id"));
                order.setTotal(resultSet.getDouble("total"));
                order.setCreatedAt(resultSet.getTimestamp("created_at"));
                order.setStatus(OrderStatus.getCodeFromString(resultSet.getString("status")));
            } else {
                return null;
            }

            preparedStatement = connection.prepareStatement("SELECT oi.id, order_id, product_id, p.\"name\" as prod_name, quantity, total FROM public.order_items oi INNER JOIN product p ON oi.product_id = p.id WHERE \"order_id\"=?;");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                OrderItem orderItem = new OrderItem();
                orderItem.setId(resultSet.getInt("id"));
                orderItem.setOrderId(id);
                orderItem.setProduct_id(resultSet.getInt("product_id"));
                orderItem.setProductName(resultSet.getString("prod_name"));
                orderItem.setQuantity(resultSet.getInt("quantity"));
                orderItem.setTotal(resultSet.getDouble("total"));
                order.getItems().add(orderItem);
            }

        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

        return order;
    }

    public ArrayList<Order> getOrdersByUserId(int id) throws SQLException {
        ArrayList<Order> orders = new ArrayList<>();
        Order order = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("SELECT id, status, user_id, total, created_at FROM public.order_details WHERE \"user_id\" = ?;");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                order = new Order();
                order.setId(resultSet.getInt("id"));
                order.setUser_id(resultSet.getInt("user_id"));
                order.setTotal(resultSet.getDouble("total"));
                order.setCreatedAt(resultSet.getTimestamp("created_at"));
                order.setStatus(OrderStatus.getCodeFromString(resultSet.getString("status")));
                orders.add(order);
            }
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

        return orders;
    }

    public boolean payOrder(int id) throws SQLException {
        Order order = getOrderById(id);
        Connection connection;
        if (order != null) {
            if (order.getStatus().code.equals("CREATED")) {
                //UPDATE public.order_details SET status='PAYED' WHERE "id" = ?;
                connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("UPDATE public.order_details SET status='PAYED' WHERE \"id\" = ?;");
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
                return true;
            } else {
                System.out.println("ALREADY PAYED");
                //CANT PAY AN ALREADY PAYED ORDER
                return false;
            }
        }
        //CANT PAY A NON-EXISTENT ORDER
        System.out.println("NO EXIST :(");
        return false;
    }

    public boolean cancelOrder(int id) throws SQLException {
        Order order = getOrderById(id);
        Connection connection;
        if (order != null) {
            if (!order.getStatus().code.equals("CANCELLED")) {
                //UPDATE public.order_details SET status='PAYED' WHERE "id" = ?;
                connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("UPDATE public.order_details SET status='CANCELLED' WHERE \"id\" = ?;");
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
                System.out.println("canceled order with id " + id);
                return true;
            } else {
                System.out.println("ALREADY CANCELLED");
                //CANT PAY AN ALREADY PAYED ORDER
                return false;
            }
        }
        //CANT PAY A NON-EXISTENT ORDER
        System.out.println("NO EXIST :(");
        return false;
    }
}
