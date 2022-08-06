package com.arteni.mag.Controllers;

import com.arteni.mag.DataBaseConnection;
import com.arteni.mag.Models.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import java.util.Arrays;

@RestController
public class UserController {

        @GetMapping("/user/get")
        public User getUserById(@RequestParam(value = "id") int id) {
            Connection connection = DataBaseConnection.connection;
            String name = "";
            String password = "";
            Integer[] shopping_cart = {};
            try {
                PreparedStatement stmt = connection.prepareStatement("SELECT * FROM public.users where \"id\" = ?;");
                stmt.setInt(1, id);

                ResultSet rs = stmt.executeQuery();
                rs.next();
                name = rs.getString(2);
                password = rs.getString(3);
                Array shopping_cart_array = rs.getArray(4);

                //String[] zips = (String[])z.getArray();

                shopping_cart = (Integer[])shopping_cart_array.getArray();
                System.out.println(shopping_cart[1]);
            }catch (Exception e){
                e.printStackTrace();
            }
            return new User(id,name,password,shopping_cart);
        }

    @GetMapping("/user/add/too/cart")
    public Integer[] addItemToCart(@RequestParam(value = "user_id") int user_id, @RequestParam(value = "item_id") int item_id) {
        Connection connection = DataBaseConnection.connection;

        Integer[] shopping_cart = {};
        int shopping_cart_size = 0;
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT shopping_cart FROM public.users where \"id\" = ?;");
            stmt.setInt(1, user_id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            Array shopping_cart_array = rs.getArray(1);
            shopping_cart = (Integer[])shopping_cart_array.getArray();
            shopping_cart_size = shopping_cart.length;

            PreparedStatement stmt2 = connection.prepareStatement("UPDATE public.users set \"shopping_cart\" [?] = ? WHERE id = ? returning shopping_cart;");
            stmt2.setInt(1,shopping_cart_size+1);
            stmt2.setInt(2,item_id);
            stmt2.setInt(3,user_id);
            rs = stmt2.executeQuery();
            rs.next();
            shopping_cart_array = rs.getArray(1);
            shopping_cart = (Integer[])shopping_cart_array.getArray();

        }catch (Exception e){
            e.printStackTrace();
        }
        return shopping_cart;
    }

}
