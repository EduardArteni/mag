package com.arteni.mag.Controllers;

import com.arteni.mag.Models.Product;
import com.arteni.mag.dao.ProductDAO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ProductController {


    @CrossOrigin(origins = "http://127.0.0.1:5500/")
    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public ArrayList<Product> getProductsByName(@RequestParam(value = "name") String name) {
        ProductDAO productDAO = new ProductDAO();
        return productDAO.getProductsByName(name);
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500/")
    @RequestMapping(value = "/productBySKU", method = RequestMethod.GET)
    public Product getProductsBySKU(@RequestParam(value = "SKU") String SKU) {
        ProductDAO productDAO = new ProductDAO();
        return productDAO.getProductBySKU(SKU);
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500/")
    @RequestMapping(value = "/productDetails", method = RequestMethod.GET)
    public Product getProductById(@RequestParam(value = "id") int id) {
        ProductDAO productDAO = new ProductDAO();
        return productDAO.getProductById(id);
    }

}
