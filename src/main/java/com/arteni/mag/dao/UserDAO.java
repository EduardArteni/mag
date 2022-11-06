package com.arteni.mag.dao;

import com.arteni.mag.DataBaseConnection;
import com.arteni.mag.Models.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
    public User getUserByID(int id) {
        User foundUser = new User();
        try {
            PreparedStatement preparedStatement = DataBaseConnection.connection.prepareStatement("SELECT id, username, password FROM public.\"user\" WHERE id = ?;");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            foundUser.setId(resultSet.getInt(1));
            foundUser.setUsername(resultSet.getString(2));
            foundUser.setPassword(resultSet.getString(3));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return foundUser;
    }

    public User getUserByUsername(String username) {
        User foundUser = new User();
        foundUser.setId(0);
        try {
            PreparedStatement preparedStatement = DataBaseConnection.connection.prepareStatement("SELECT id, username, password FROM public.\"user\" WHERE username = ?;");
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                foundUser.setId(resultSet.getInt(1));
                foundUser.setUsername(resultSet.getString(2));
                foundUser.setPassword(resultSet.getString(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return foundUser;
    }

    public User createUser(String username, String password) {
        User createdUser = new User();
        try {
            PreparedStatement preparedStatement = DataBaseConnection.connection.prepareStatement("INSERT INTO public.\"user\"(username, password) VALUES (?, ?) RETURNING id;");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            createdUser.setId(resultSet.getInt(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
        createdUser.setUsername(username);
        createdUser.setPassword(password);
        return createdUser;
    }

    public User login(String username, String password) {
        User foundUser = new User();
        try {
            PreparedStatement preparedStatement = DataBaseConnection.connection.prepareStatement("SELECT id, username, password FROM public.\"user\" WHERE username = ? AND password = ?;");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                foundUser.setId(resultSet.getInt(1));
                foundUser.setUsername(resultSet.getString(2));
                foundUser.setPassword(resultSet.getString(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        foundUser.setUsername(username);
        foundUser.setPassword(password);
        return foundUser;
    }
}
