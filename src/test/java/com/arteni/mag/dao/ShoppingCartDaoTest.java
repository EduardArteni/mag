package com.arteni.mag.dao;

import com.arteni.mag.Models.User;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShoppingCartDaoTest {
    ShoppingCartDAO shoppingCartDAO = new ShoppingCartDAO();
    UserDAO userDAO = new UserDAO();

    @Test
    public void addItemToShoppingCart() {
        User createdUser = userDAO.createUser("created-user-username", "created-user-password");
        shoppingCartDAO.addItemToShoppingCart(createdUser.getId(), 1, 1);
        assertEquals(1, shoppingCartDAO.getShoppingCart(createdUser.getId()).size());
        shoppingCartDAO.clearShoppingCart(createdUser.getId());
        assertEquals(0, shoppingCartDAO.getShoppingCart(createdUser.getId()).size());
        userDAO.deleteUserByID(createdUser.getId());
    }

    @Test
    public void getShoppingCart() {
        User createdUser = userDAO.createUser("created-user-username", "created-user-password");
        assertEquals(0, shoppingCartDAO.getShoppingCart(createdUser.getId()).size());
        shoppingCartDAO.addItemToShoppingCart(createdUser.getId(), 1, 1);
        assertEquals(1, shoppingCartDAO.getShoppingCart(createdUser.getId()).size());
        shoppingCartDAO.clearShoppingCart(createdUser.getId());
        assertEquals(0, shoppingCartDAO.getShoppingCart(createdUser.getId()).size());
        userDAO.deleteUserByID(createdUser.getId());
    }

    @Test
    public void clearShoppingCart() {
        User createdUser = userDAO.createUser("created-user-username", "created-user-password");
        shoppingCartDAO.clearShoppingCart(createdUser.getId());
        assertEquals(0, shoppingCartDAO.getShoppingCart(createdUser.getId()).size());
        shoppingCartDAO.addItemToShoppingCart(createdUser.getId(), 1, 1);
        assertEquals(1, shoppingCartDAO.getShoppingCart(createdUser.getId()).size());
        shoppingCartDAO.clearShoppingCart(createdUser.getId());
        assertEquals(0, shoppingCartDAO.getShoppingCart(createdUser.getId()).size());
        userDAO.deleteUserByID(createdUser.getId());
    }

    @Test
    public void removeItemFromShoppingCart() {
        User createdUser = userDAO.createUser("created-user-username", "created-user-password");
        shoppingCartDAO.clearShoppingCart(createdUser.getId());
        assertEquals(0, shoppingCartDAO.getShoppingCart(createdUser.getId()).size());
        shoppingCartDAO.addItemToShoppingCart(createdUser.getId(), 1, 1);
        shoppingCartDAO.addItemToShoppingCart(createdUser.getId(), 2, 1);
        assertEquals(2, shoppingCartDAO.getShoppingCart(createdUser.getId()).size());
        shoppingCartDAO.removeItemFromShoppingCart(createdUser.getId(), 1);
        assertEquals(1, shoppingCartDAO.getShoppingCart(createdUser.getId()).size());
        shoppingCartDAO.removeItemFromShoppingCart(createdUser.getId(), 2);
        assertEquals(0, shoppingCartDAO.getShoppingCart(createdUser.getId()).size());
        userDAO.deleteUserByID(createdUser.getId());
    }
}
