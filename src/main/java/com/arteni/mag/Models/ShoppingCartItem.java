package com.arteni.mag.Models;

public class ShoppingCartItem {
    public int user_id;
    public int item_id;
    public int amount;

    public ShoppingCartItem(int user_id, int item_id, int amount) {
        this.user_id = user_id;
        this.item_id = item_id;
        this.amount = amount;
    }
}
