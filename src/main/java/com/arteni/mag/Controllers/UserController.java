package com.arteni.mag.Controllers;

import com.arteni.mag.DataBaseConnection;
import com.arteni.mag.Models.User;
import com.arteni.mag.Models.request.UserManagementResponse;
import org.postgresql.util.PSQLException;
import org.springframework.web.bind.annotation.*;

import java.sql.*;


@RestController
public class UserController {

    //TODO move to DAO
    public static String ERROR_MESSAGE_UNIQUE_USER = "user_username_key";

    @CrossOrigin(origins = "http://127.0.0.1:5500/")
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public User getUser() {
        return new User(122, "Radu Rus", "Bulevardul Capitan numaistiucum");
    }

    /*
    @CrossOrigin(origins = "http://localhost:5500")
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public User getUserById(@RequestParam(value = "id") int id) {
        try {
            PreparedStatement createUserStatement = DataBaseConnection.connection.prepareStatement("");
            createUserStatement.setString(1, username);
            createUserStatement.setString(2, password);
            ResultSet resultSet = createUserStatement.executeQuery();
            resultSet.next();
            id = resultSet.getInt(1);
            userManagementResponse.responseCode = "0";
            userManagementResponse.message = "user created successfully";
        } catch (PSQLException e) {

        } catch (Exception e) {
        }
        return new User(1,"test","test");
    }
     */
    @CrossOrigin(origins = "http://127.0.0.1:5500/")
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public UserManagementResponse createUser(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password) {
        User createdUser = new User();
        UserManagementResponse userManagementResponse = new UserManagementResponse();
        userManagementResponse.user = createdUser;

        //TODO move to DAO

        int id = 0;
        try {
            PreparedStatement createUserStatement = DataBaseConnection.connection.prepareStatement("INSERT INTO public.\"user\" (username, password) VALUES (?, ?) RETURNING id;");
            createUserStatement.setString(1, username);
            createUserStatement.setString(2, password);
            ResultSet resultSet = createUserStatement.executeQuery();
            resultSet.next();
            id = resultSet.getInt(1);
            userManagementResponse.responseCode = "0";
            userManagementResponse.message = "user created successfully";
        } catch (PSQLException e) {

            if (e.getMessage().contains(ERROR_MESSAGE_UNIQUE_USER)) {
                userManagementResponse.responseCode = "501";
                userManagementResponse.message = "username already exists";

                System.out.println("USERNAME ALREADY EXISTS");
            } else {
                e.printStackTrace();
                userManagementResponse.responseCode = "500";
                userManagementResponse.message = "UNKNOWN ERROR";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        createdUser.username = username;
        createdUser.password = password;
        createdUser.id = id;

        return userManagementResponse;
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
