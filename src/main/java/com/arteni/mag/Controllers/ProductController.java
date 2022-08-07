package com.arteni.mag.Controllers;

import com.arteni.mag.Models.Product;
import org.springframework.web.bind.annotation.RestController;
import com.arteni.mag.DataBaseConnection;
import com.arteni.mag.Models.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {


    @GetMapping("/product/get")
    public Product getProductById(@RequestParam(value = "id") int id) {

        return new Product();
    }

}
