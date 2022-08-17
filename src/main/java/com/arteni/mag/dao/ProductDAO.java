package com.arteni.mag.dao;

import com.arteni.mag.DataBaseConnection;
import com.arteni.mag.Models.Product;
import com.arteni.mag.Models.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProductDAO {



    public Product getProductById(int id) {
        return new Product();
    }

    public Product getProductBySKU(String SKU) {
        return new Product();
    }

    public ArrayList<Product> getProductsByCategory(String category) {
        return new ArrayList<Product>();
    }

    public ArrayList<Product> getProductsByName(String name) {
        ArrayList<Product> products = new ArrayList();
        try {
            PreparedStatement preparedStatement = DataBaseConnection.connection.prepareStatement("SELECT id, name, description, \"SKU\", category, price, created_at FROM public.product WHERE \"name\"  ILIKE \'%" + name + "%\';");
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
        }

        return products;
    }

}
