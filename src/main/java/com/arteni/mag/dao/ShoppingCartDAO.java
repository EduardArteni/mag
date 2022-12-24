package com.arteni.mag.dao;

import com.arteni.mag.Models.Product;
import com.arteni.mag.Models.ShoppingCartElement;
import com.arteni.mag.Models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ShoppingCartDAO extends EmagGenericDAO {
    public void addItemToShoppingCart(int user_id, int product_id, int quantity) {

        Connection connection = null;
        User user = (new UserDAO()).getUserByID(user_id);
        Product product = (new ProductDAO()).getProductById(product_id);


        if (user != null && product != null) {
            boolean contains = false;
            int extraQuantity = 0;
            for (ShoppingCartElement currentIteratedElement :
                    getShoppingCart(user_id)) {
                if (currentIteratedElement.product_id == product_id) {
                    contains = true;
                    extraQuantity = currentIteratedElement.quantity;
                    break;
                }
            }
            if (contains) {
                removeItemFromShoppingCart(user_id, product_id);
                addItemToShoppingCart(user_id, product_id, quantity + extraQuantity);
            } else {


                try {
                    connection = getConnection();


                    PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO public.cart_item(user_id, product_id, quantity, total) VALUES (?, ?, ?, ?);");
                    preparedStatement.setInt(1, user_id);
                    preparedStatement.setInt(2, product_id);
                    preparedStatement.setInt(3, quantity);
                    preparedStatement.setDouble(4, (quantity + extraQuantity) * product.price);

                    preparedStatement.executeUpdate();
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
            }
        }
    }

    public ArrayList<ShoppingCartElement> getShoppingCart(int user_id) {

        Connection connection = null;
        ArrayList<ShoppingCartElement> shoppingCartElements = new ArrayList<>();
        User user = (new UserDAO()).getUserByID(user_id);

        if (user != null) {
            try {
                connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, user_id, product_id, quantity, total FROM public.cart_item WHERE \"user_id\" = ?;");
                preparedStatement.setInt(1, user_id);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    ShoppingCartElement shoppingCartElement = new ShoppingCartElement();
                    shoppingCartElement.id = resultSet.getInt(1);
                    shoppingCartElement.user_id = resultSet.getInt(2);
                    shoppingCartElement.product_id = resultSet.getInt(3);
                    shoppingCartElement.quantity = resultSet.getInt(4);
                    shoppingCartElement.total = resultSet.getDouble(5);
                    shoppingCartElements.add(shoppingCartElement);
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
        }
        return shoppingCartElements;
    }

    public void removeItemFromShoppingCart(int user_id, int product_id) {

        Connection connection = null;
        User user = (new UserDAO()).getUserByID(user_id);
        Product product = (new ProductDAO()).getProductById(product_id);

        if (user != null && product != null) {
            try {
                connection = getConnection();


                PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM public.cart_item WHERE \"user_id\" = ? AND \"product_id\" = ?;");
                preparedStatement.setInt(1, user_id);
                preparedStatement.setInt(2, product_id);
                preparedStatement.executeUpdate();
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
        }
    }

    public void clearShoppingCart(int user_id) {
        Connection connection = null;
        User user = (new UserDAO()).getUserByID(user_id);

        if (user != null) {
            try {
                connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM public.cart_item WHERE \"user_id\" = ?;");
                preparedStatement.setInt(1, user_id);
                preparedStatement.executeUpdate();
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
        }
    }


}
