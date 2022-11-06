package com.arteni.mag.dao;

import com.arteni.mag.Models.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserDAOTest {

    UserDAO userDAO = new UserDAO();

    @Test
    void getUserByID() {

        // test find existing user by id
        User foundUserByID = userDAO.getUserByID(1);
        assertNotNull(foundUserByID);

        // test find non existing user by non existing id
        assertNull(userDAO.getUserByID(-100));
    }

    @Test
    void getUserByUsername() {

        // test find existing user by id
        User foundUserByID = userDAO.getUserByUsername("test");
        assertNotNull(foundUserByID);

        // test find non existing user by non existing id
        assertNull(userDAO.getUserByUsername("nuexistaacestusername"));
    }

    @Test
    void createUser() {

        // test find existing user by id
        User createdUser = userDAO.createUser("created-user-username","created-user-password");
        assertNotEquals(0 , createdUser.getId());

        assertNotNull(userDAO.getUserByUsername("created-user-username"));

        userDAO.deleteUserByID(createdUser.getId());

        assertNull(userDAO.getUserByUsername("created-user-username"));

        // test find non existing user by non existing id
        //assertNull(userDAO.getUserByUsername("nuexistaacestusername"));
    }

    @Test
    void login() {

        User createdUser = userDAO.createUser("created-user-username-login","created-user-password-login");
        assertNotEquals(0 , createdUser.getId());

        assertNotNull(userDAO.getUserByUsername("created-user-username-login"));

        User loggedInUser = userDAO.login("created-user-username-login","created-user-password-login");

        assertEquals(createdUser.getId(),loggedInUser.getId());

        userDAO.deleteUserByID(createdUser.getId());

        assertNull(userDAO.getUserByUsername("created-user-username-login"));

    }

}