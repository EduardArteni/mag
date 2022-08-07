package com.arteni.mag.Models;

import java.sql.Timestamp;


public class Product {
    public int id;
    public String name;
    public String description;
    public String SKU;
    public String category;
    public double price;
    public Timestamp created_at;

    public Product(int id, String name, String description, String SKU, String category, double price, Timestamp created_at) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.SKU = SKU;
        this.category = category;
        this.price = price;
        this.created_at = created_at;
    }
}
