package com.arteni.mag.Controllers;

import com.arteni.mag.dao.UserDAO;
import com.arteni.mag.Models.User;
import com.arteni.mag.Models.request.UserManagementResponse;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {

    @CrossOrigin(origins = "http://127.0.0.1:5500/")
    @RequestMapping(value = "/login")
    public UserManagementResponse loginUser(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password) {
        UserManagementResponse userManagementResponse = new UserManagementResponse();
        UserDAO userDAO = new UserDAO();

        /*
        if (userDAO.getUserByUsername(username).id == 0) {
            userManagementResponse.user = new User(0, username, password);
            userManagementResponse.responseCode = "400";
            userManagementResponse.message = "username doesnt exist";
            return userManagementResponse;
        }
         */

        if (userDAO.login(username, password)) {
            userManagementResponse.user = userDAO.getUserByUsername(username);
            userManagementResponse.responseCode = "0";
            userManagementResponse.message = "logged in successfully";
            return userManagementResponse;
        }


        userManagementResponse.user = new User(0, username, password);
        userManagementResponse.responseCode = "401";
        userManagementResponse.message = "wrong username or password";
        return userManagementResponse;
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500/")
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public UserManagementResponse createUser(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password) {
        UserManagementResponse userManagementResponse = new UserManagementResponse();
        UserDAO userDAO = new UserDAO();

        if (userDAO.getUserByUsername(username).id != 0) {
            userManagementResponse.user = new User(0, username, password);
            userManagementResponse.responseCode = "501";
            userManagementResponse.message = "username taken";
            return userManagementResponse;
        }

        userManagementResponse.user = userDAO.createUser(username, password);

        if (userManagementResponse.user.id == 0) {
            userManagementResponse.responseCode = "500";
            userManagementResponse.message = "unknown error";
            return userManagementResponse;
        }

        userManagementResponse.responseCode = "0";
        userManagementResponse.message = "user created successfully";
        return userManagementResponse;
    }


}
