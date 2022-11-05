package com.arteni.mag.Models;

import java.util.ArrayList;
import java.util.List;

public class Shopping_Cart {
    public int id;
    public int user_id;
    public double total;
    public List<Product> shopping_cart_items = new ArrayList();


    public Shopping_Cart(int id, int user_id, double total) {
        this.id = id;
        this.user_id = user_id;
        this.total = total;
    }
}
