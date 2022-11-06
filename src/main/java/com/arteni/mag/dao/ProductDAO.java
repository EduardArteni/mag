package com.arteni.mag.dao;

import com.arteni.mag.Models.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO extends EmagGenericDAO {
    public Product getProductBySKU(String SKU) {

        Connection connection = null;
        Product product = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, name, description, \"SKU\", category, price, created_at FROM public.product WHERE \"SKU\"  = ?;");
            System.out.println(preparedStatement);
            preparedStatement.setString(1,SKU);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                product = new Product();
                product.id = resultSet.getInt(1);
                product.name = resultSet.getString(2);
                product.description = resultSet.getString(3);
                product.SKU = resultSet.getString(4);
                product.category = resultSet.getString(5);
                product.price = resultSet.getDouble(6);
                product.created_at = resultSet.getTimestamp(7);
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

        return product;
    }

    public List<Product> getProductsByCategory(String category) {

        List<Product> foundProducts = new ArrayList();
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, name, description, \"SKU\", category, price, created_at FROM public.product WHERE \"category\"  ILIKE \'%" + category + "%\';");
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Product product = new Product();
                product.id = resultSet.getInt(1);
                product.name = resultSet.getString(2);
                product.description = resultSet.getString(3);
                product.SKU = resultSet.getString(4);
                product.category = resultSet.getString(5);
                product.price = resultSet.getDouble(6);
                product.created_at = resultSet.getTimestamp(7);
                foundProducts.add(product);
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

        return foundProducts;
    }

    public ArrayList<Product> getProductsByName(String name) {
        ArrayList<Product> products = new ArrayList();
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, name, description, \"SKU\", category, price, created_at FROM public.product WHERE \"name\"  ILIKE \'%" + name + "%\';");
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Product product = new Product();
                product.id = resultSet.getInt(1);
                product.name = resultSet.getString(2);
                product.description = resultSet.getString(3);
                product.SKU = resultSet.getString(4);
                product.category = resultSet.getString(5);
                product.price = resultSet.getDouble(6);
                product.created_at = resultSet.getTimestamp(7);
                products.add(product);
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

        return products;
    }


    public Product getProductById(int id) {
        Product product = null;
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, name, description, \"SKU\", category, price, created_at FROM public.product WHERE \"id\"  = ?;");
            System.out.println(preparedStatement);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                product = new Product();
                product.id = resultSet.getInt(1);
                product.name = resultSet.getString(2);
                product.description = resultSet.getString(3);
                product.SKU = resultSet.getString(4);
                product.category = resultSet.getString(5);
                product.price = resultSet.getDouble(6);
                product.created_at = resultSet.getTimestamp(7);
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

        return product;
    }

}
