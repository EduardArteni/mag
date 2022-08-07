package com.arteni.mag.Models;

import java.sql.Timestamp;

public class Shopping_Cart {
    public int id;
    public int user_id;
    public double total;
    public Timestamp created_at;

    public Shopping_Cart(int id, int user_id, double total, Timestamp created_at) {
        this.id = id;
        this.user_id = user_id;
        this.total = total;
        this.created_at = created_at;
    }
}
