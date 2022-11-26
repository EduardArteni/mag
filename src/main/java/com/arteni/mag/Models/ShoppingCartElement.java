package com.arteni.mag.Models;

public class ShoppingCartElement {
    public int id;
    public int user_id;
    public int product_id;
    public int quantity;
    public double total;

    @Override
    public String toString() {
        return "ShoppingCartElement{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", product_id=" + product_id +
                ", quantity=" + quantity +
                ", total=" + total +
                '}';
    }
}
