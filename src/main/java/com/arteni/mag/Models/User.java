package com.arteni.mag.Models;

public class User {
    public int id;
    public String name;
    public String password;
    public Integer[] shopping_cart;

    public User(int id, String name, String password, Integer[] shopping_cart) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.shopping_cart = shopping_cart;
    }
}
