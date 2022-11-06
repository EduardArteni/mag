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

    public Product() {
    }

    public Product(int id, String name, String description, String SKU, String category, double price, Timestamp created_at) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.SKU = SKU;
        this.category = category;
        this.price = price;
        this.created_at = created_at;
    }

    public Product(String name, String description, String SKU, String category, double price, Timestamp created_at) {
        this.name = name;
        this.description = description;
        this.SKU = SKU;
        this.category = category;
        this.price = price;
        this.created_at = created_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSKU() {
        return SKU;
    }

    public void setSKU(String SKU) {
        this.SKU = SKU;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }
}
