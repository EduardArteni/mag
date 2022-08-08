package com.arteni.mag.Controllers;

import com.arteni.mag.DataBaseConnection;
import com.arteni.mag.Models.User;
import org.springframework.web.bind.annotation.*;

import java.sql.*;


@RestController
public class UserController {

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public User getUser() {
        return new User();
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public User createUser(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password) {
        User createdUser = new User();
        int id = 0;
        try {
            PreparedStatement createUserStatement = DataBaseConnection.connection.prepareStatement("INSERT INTO public.\"user\" (username, password) VALUES (?, ?) RETURNING id;");
            createUserStatement.setString(1, username);
            createUserStatement.setString(2, password);
            ResultSet resultSet = createUserStatement.executeQuery();
            resultSet.next();
            id = resultSet.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        createdUser.username = username;
        createdUser.password = password;
        createdUser.id = id;

        return createdUser;
    }

    /*
    @GetMapping("/user/get")
    public User getUserById(@RequestParam(value = "id") int id) {
        Connection connection = DataBaseConnection.connection;
        String name = "";
        String password = "";
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM public.users where \"id\" = ?;");
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();
            rs.next();
            name = rs.getString(2);
            password = rs.getString(3);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new User(id, name, password);
    }
     */

}
