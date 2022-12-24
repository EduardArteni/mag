package com.arteni.mag.Controllers;

import com.arteni.mag.Models.ShoppingCartElement;
import com.arteni.mag.dao.ShoppingCartDAO;
import com.arteni.mag.dao.UserDAO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ShoppingCartController {

//    @CrossOrigin(origins = "http://127.0.0.1:5500/")
//    @RequestMapping(value = "/cart", method = RequestMethod.POST)
//    public void addProductToShoppingCart(@RequestParam(value = "user_id") int user_id, @RequestParam(value = "product_id") int product_id, @RequestParam(value = "quantity") int quantity) {
//        ShoppingCartDAO shoppingCartDAO = new ShoppingCartDAO();
//        shoppingCartDAO.addItemToShoppingCart(user_id, product_id, quantity);
//    }

    @CrossOrigin(origins = "http://127.0.0.1:5500/")
    @RequestMapping(value = "/cart", method = RequestMethod.POST)
    public void addProductToShoppingCartByUsername(@RequestParam(value = "username") String username, @RequestParam(value = "product_id") int product_id, @RequestParam(value = "quantity") int quantity) {
        ShoppingCartDAO shoppingCartDAO = new ShoppingCartDAO();
        UserDAO userDAO = new UserDAO();
        shoppingCartDAO.addItemToShoppingCart(userDAO.getUserByUsername(username).getId(), product_id, quantity);
    }

//    @CrossOrigin(origins = "http://127.0.0.1:5500/")
//    @RequestMapping(value = "/cart", method = RequestMethod.GET)
//    public ArrayList<ShoppingCartElement> getShoppingCart(@RequestParam(value = "user_id") int user_id) {
//        ShoppingCartDAO shoppingCartDAO = new ShoppingCartDAO();
//        return shoppingCartDAO.getShoppingCart(user_id);
//    }

    @CrossOrigin(origins = "http://127.0.0.1:5500/")
    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public ArrayList<ShoppingCartElement> getShoppingCartByUsername(@RequestParam(value = "username") String username) {
        ShoppingCartDAO shoppingCartDAO = new ShoppingCartDAO();
        UserDAO userDAO = new UserDAO();
        return shoppingCartDAO.getShoppingCart(userDAO.getUserByUsername(username).getId());
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500/")
    @RequestMapping(value = "/cart", method = RequestMethod.DELETE)
    public void removeProductFromCart(@RequestParam(value = "user_id") int user_id, @RequestParam(value = "product_id") int product_id) {
        ShoppingCartDAO shoppingCartDAO = new ShoppingCartDAO();
        shoppingCartDAO.removeItemFromShoppingCart(user_id, product_id);
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500/")
    @RequestMapping(value = "/cart/clear", method = RequestMethod.DELETE)
    public void clearCart(@RequestParam(value = "user_id") int user_id) {
        ShoppingCartDAO shoppingCartDAO = new ShoppingCartDAO();
        shoppingCartDAO.clearShoppingCart(user_id);
    }

}
