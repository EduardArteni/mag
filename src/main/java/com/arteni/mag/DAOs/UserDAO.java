package com.arteni.mag.DAOs;

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
            foundUser.id = resultSet.getInt(1);
            foundUser.username = resultSet.getString(2);
            foundUser.password = resultSet.getString(3);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return foundUser;
    }

    public User getUserByUsername(String username) {
        User foundUser = new User();
        foundUser.id = 0;
        try {
            PreparedStatement preparedStatement = DataBaseConnection.connection.prepareStatement("SELECT id, username, password FROM public.\"user\" WHERE username = ?;");
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                foundUser.id = resultSet.getInt(1);
                foundUser.username = resultSet.getString(2);
                foundUser.password = resultSet.getString(3);
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
            createdUser.id = resultSet.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        createdUser.username = username;
        createdUser.password = password;
        return createdUser;
    }

    public boolean login(String username, String password) {
        if (getUserByUsername(username).password.equals(password)) {
            return true;
        }
        return false;
    }
}
