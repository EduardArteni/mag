package com.arteni.mag.dao;

import com.arteni.mag.Models.Product;
import org.junit.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class ShoppingCartDaoTest {
    ShoppingCartDAO shoppingCartDAO = new ShoppingCartDAO();

    @Test
    public void addItemToShoppingCart(){
        assertEquals(0,shoppingCartDAO.getShoppingCart(1).size());
        shoppingCartDAO.addItemToShoppingCart(1,1,1);
        assertEquals(1,shoppingCartDAO.getShoppingCart(1).size());
        System.out.println(shoppingCartDAO.getShoppingCart(1));
        shoppingCartDAO.removeItemFromShoppingCart(1,2);
        assertEquals(1,shoppingCartDAO.getShoppingCart(1).size());
        System.out.println(shoppingCartDAO.getShoppingCart(1));
        shoppingCartDAO.removeItemFromShoppingCart(1,1);
        assertEquals(0,shoppingCartDAO.getShoppingCart(1).size());
        System.out.println(shoppingCartDAO.getShoppingCart(1));
    }

    @Test
    public void getShoppingCart(){
        //Test case, user with no items in shopping cart, checking if the size is 0
        assertEquals(0,shoppingCartDAO.getShoppingCart(1).size());
        //Test case, user doesn't exist should have 0 items in shopping cart
        assertEquals(0,shoppingCartDAO.getShoppingCart(1).size());
    }
}
