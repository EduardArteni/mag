package com.arteni.mag.dao;

import com.arteni.mag.Models.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductDAOTest {

    ProductDAO productDAO = new ProductDAO();

    @Test
    void getProductById() {

        // test find existing product by id
        Product foundProductBySKU = productDAO.getProductById(1);
        assertNotNull(foundProductBySKU);

        // test find non existing product by non existing id
        assertNull(productDAO.getProductById(-100));
    }

    @Test
    void getProductBySKU() {

        // test find existing product by SKU
        String productToBeFound = "TVSMSNG-GEN1";
        Product foundProductBySKU = productDAO.getProductBySKU(productToBeFound);
        assertNotNull(foundProductBySKU);
        assertEquals(productToBeFound, foundProductBySKU.getSKU());

        // test find NON existing product by non existing SKU
        Product nonExistentProductBySKU = productDAO.getProductBySKU("NON-EXISTING-SKU-ZZZ-123");
        assertNull(nonExistentProductBySKU);
    }

}