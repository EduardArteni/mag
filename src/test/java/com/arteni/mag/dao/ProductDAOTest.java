package com.arteni.mag.dao;

import com.arteni.mag.Models.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductDAOTest {

    ProductDAO productDAO = new ProductDAO();

    @Test
    void getProductBySKU() {

        String productToBeFound = "TVSMSNG-GEN1";
        Product foundProductBySKU = productDAO.getProductBySKU(productToBeFound);
        assertEquals(productToBeFound, foundProductBySKU.getSKU());
    }
}