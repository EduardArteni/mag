package com.arteni.mag.dao;

import com.arteni.mag.Models.Product;
import org.junit.jupiter.api.Test;

import java.util.List;

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
        String productToBeFoundBySKU = "AUTO-JUNIT-TESTS-TV-SAMSUNG-GEN1";
        Product foundProductBySKU = productDAO.getProductBySKU(productToBeFoundBySKU);
        assertNotNull(foundProductBySKU);
        assertEquals(productToBeFoundBySKU, foundProductBySKU.getSKU());

        // test find NON existing product by non existing SKU
        Product nonExistentProductBySKU = productDAO.getProductBySKU("NON-EXISTING-SKU-ZZZ-123");
        assertNull(nonExistentProductBySKU);
    }

    @Test
    void getProductsByCategory() {

        // test find existing product by Category
        String productToBeFound = "AUTO-JUNIT-TESTS-ELECTRO";
        List<Product> foundProductsByCategory = productDAO.getProductsByCategory(productToBeFound);
        assertEquals(2, foundProductsByCategory.size());
    }

}