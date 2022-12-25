package com.arteni.mag.Models;

import java.sql.Timestamp;
import java.util.Date;

public class Order {
    private int id;
    private int user_id;

    private Status status = Status.CREATED;
    private double total;
    private Date createdAt;

    public Order(int id, int user_id, double total) {
        this.id = id;
        this.user_id = user_id;
        this.total = total;
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


    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
