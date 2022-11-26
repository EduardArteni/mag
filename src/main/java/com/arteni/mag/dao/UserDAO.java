package com.arteni.mag.dao;

import com.arteni.mag.Models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO extends EmagGenericDAO {
    public User getUserByID(int id) {

        Connection connection = null;
        User foundUser = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, username, password FROM public.\"user\" WHERE id = ?;");
            //System.out.println(preparedStatement);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                foundUser = new User();
                foundUser.setId(resultSet.getInt(1));
                foundUser.setUsername(resultSet.getString(2));
                foundUser.setPassword(resultSet.getString(3));
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
        return foundUser;
    }

    public void deleteUserByID(int id) {

        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM public.\"user\" WHERE \"id\" = ?;");
            System.out.println(preparedStatement);
            preparedStatement.setInt(1, id);
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

    public User getUserByUsername(String username) {

        Connection connection = null;
        User foundUser = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, username, password FROM public.\"user\" WHERE username = ?;");
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                foundUser = new User();
                foundUser.setId(resultSet.getInt(1));
                foundUser.setUsername(resultSet.getString(2));
                foundUser.setPassword(resultSet.getString(3));
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
        return foundUser;
    }

    public User createUser(String username, String password) {

        Connection connection = null;
        User createdUser = new User();

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO public.\"user\"(username, password) VALUES (?, ?) RETURNING id;");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            createdUser.setId(resultSet.getInt(1));
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
        createdUser.setUsername(username);
        createdUser.setPassword(password);
        return createdUser;

    }

    public User login(String username, String password) {

        Connection connection = null;
        User foundUser = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, username, password FROM public.\"user\" WHERE username = ? AND password = ?;");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                foundUser = new User();
                foundUser.setId(resultSet.getInt(1));
                foundUser.setUsername(resultSet.getString(2));
                foundUser.setPassword(resultSet.getString(3));
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

        return foundUser;
    }
}
