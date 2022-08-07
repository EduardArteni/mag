package com.arteni.mag.Controllers;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShoppingCartController {

    /*
    @GetMapping("/shopping_cart/add")
    public ShoppingCartItem addItemToCart(@RequestParam(value = "user_id") int user_id, @RequestParam(value = "item_id") int item_id, @RequestParam(value = "amount") int amount) {
        Connection connection = DataBaseConnection.connection;
        int returnedAmount = 0;
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT amount FROM public.shopping_carts where user_id = ? and item_id = ?;");
            stmt.setInt(1, user_id);
            stmt.setInt(2, item_id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                returnedAmount = rs.getInt(1);
            }
            if(returnedAmount != 0){
                PreparedStatement statement = connection.prepareStatement("UPDATE public.shopping_carts SET amount=? WHERE user_id = ? and item_id = ?;");
                statement.setInt(1, amount + returnedAmount);
                statement.setInt(2, user_id);
                statement.setInt(3, item_id);
                statement.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ShoppingCartItem(user_id,item_id,returnedAmount + amount);
    }
    */

}
