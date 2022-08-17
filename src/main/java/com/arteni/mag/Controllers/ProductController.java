package com.arteni.mag.Controllers;

import com.arteni.mag.Models.Product;
import com.arteni.mag.dao.ProductDAO;
import org.springframework.web.bind.annotation.*;
import com.arteni.mag.DataBaseConnection;
import com.arteni.mag.Models.User;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class ProductController {


    @CrossOrigin(origins = "http://127.0.0.1:5500/")
    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public ArrayList<Product> getProductsByName(@RequestParam(value = "name") String name) {
        ProductDAO productDAO = new ProductDAO();
        return productDAO.getProductsByName(name);
    }

}
