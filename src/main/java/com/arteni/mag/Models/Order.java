package com.arteni.mag.Models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private int id;
    private int user_id;

    private OrderStatus status = OrderStatus.CREATED;
    private double total;
    private Date createdAt;

    private List<OrderItem> items = new ArrayList<>();

    public Order(int id, int user_id, double total) {
        this.id = id;
        this.user_id = user_id;
        this.total = total;
        this.status = OrderStatus.CREATED;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", status=" + status +
                ", total=" + total +
                ", createdAt=" + createdAt +
                ", items=" + items +
                '}';
    }

    public Order() {
        this.status = OrderStatus.CREATED;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
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


    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
