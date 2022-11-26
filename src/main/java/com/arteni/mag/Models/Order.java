package com.arteni.mag.Models;

import java.sql.Timestamp;

public class Order {
    public int id;
    public int user_id;

    public Status status;
    public double total;
    public Timestamp created_at;

    public Order(int id, int user_id, double total, Timestamp created_at) {
        this.id = id;
        this.user_id = user_id;
        this.total = total;
        this.created_at = created_at;
        this.status = Status.CREATED;
    }
}
