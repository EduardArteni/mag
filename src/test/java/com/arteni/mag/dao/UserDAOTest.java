package com.arteni.mag.dao;

import com.arteni.mag.Models.User;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserDAOTest {

    UserDAO userDAO = new UserDAO();

    @Test
    public void getUserByID() {

        // test find existing user by id
        User foundUserByID = userDAO.getUserByID(1);
        assertNotNull(foundUserByID);

        // test find non existing user by non existing id
        assertNull(userDAO.getUserByID(-100));
    }

    @Test
    public void getUserByUsername() {

        // test case #1 - success
        // test find existing user by id
        User foundUserByID = userDAO.getUserByID(1);
        // test find existing user by username
        String username = foundUserByID.getUsername();
        User foundUserByUserName = userDAO.getUserByUsername(username);
        assertNotNull(foundUserByUserName);
        assertEquals(username, foundUserByUserName.getUsername());

        // test case #2 - can not find non existent user
        // test find non existing user by non existing username
        assertNull(userDAO.getUserByUsername("nuexistaacestusername"));
    }

    @Test
    public void createUser() {

        // Complex test: 1) test create user, find and delete
        User createdUser = userDAO.createUser("created-user-username", "created-user-password");
        assertNotEquals(0, createdUser.getId());

        assertNotNull(userDAO.getUserByUsername("created-user-username"));

        userDAO.deleteUserByID(createdUser.getId());

        assertNull(userDAO.getUserByUsername("created-user-username"));
    }

    @Test
    public void login() {

        // test case #1 sucesiful scenario
        // complex test: 1) create user, find, log in with the new created user, delete.
        User createdUser = userDAO.createUser("created-user-username-login", "created-user-password-login");
        assertNotEquals(0, createdUser.getId());

        assertNotNull(userDAO.getUserByUsername("created-user-username-login"));

        User loggedInUser = userDAO.login("created-user-username-login", "created-user-password-login");

        assertEquals(createdUser.getId(), loggedInUser.getId());

        userDAO.deleteUserByID(createdUser.getId());

        assertNull(userDAO.getUserByUsername("created-user-username-login"));

        // test case #2 un sucesiful scenario
        // can not find any valid user with a wrong username and password

        assertNull(userDAO.getUserByUsername("junit-non-existent-username-login"));
    }

}