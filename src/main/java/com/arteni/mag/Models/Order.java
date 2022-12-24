package com.arteni.mag.Models;

import java.sql.Timestamp;

public class Order {
    private int id;
    private int user_id;

    public Status status = Status.CREATED;
    private double total;
    private Timestamp created_at;

    public Order(int id, int user_id, double total, Timestamp created_at) {
        this.id = id;
        this.user_id = user_id;
        this.total = total;
        this.created_at = created_at;
        this.status = Status.CREATED;
    }

    public Order() {
        this.status = Status.CREATED;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }
}
