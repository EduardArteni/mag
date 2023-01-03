package com.arteni.mag.dao;

import com.arteni.mag.Models.Product;
import org.junit.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ProductDAOTest {

    ProductDAO productDAO = new ProductDAO();

    @Test
    public void getProductById() {

        // test find existing product by id
        Product foundProductBySKU = productDAO.getProductById(1);
        assertNotNull(foundProductBySKU);
        assertEquals(1, foundProductBySKU.getId());

        // test find non existing product by non existing id
        assertNull(productDAO.getProductById(-100));
    }

    @Test
    public void getProductBySKU() {

        // test find existing product by SKU
        String productToBeFoundBySKU = "AUTO-JUNIT-TESTS-TV-SAMSUNG-GEN1";
        Product foundProductBySKU = productDAO.getProductBySKU(productToBeFoundBySKU);
        assertNotNull(foundProductBySKU);
        assertEquals(productToBeFoundBySKU, foundProductBySKU.getSKU());

        // test find NON existing product by non existing SKU
        Product nonExistentProductBySKU = productDAO.getProductBySKU("NON-EXISTING-SKU-ZZZ-123");
        assertNull(nonExistentProductBySKU);
    }

    public @Test
    void getProductsByCategory() {

        // test find existing product by Category
        String productToBeFound = "AUTO-JUNIT-TESTS-ELECTRO";
        List<Product> foundProductsByCategory = productDAO.getProductsByCategory(productToBeFound);
        assertEquals(2, foundProductsByCategory.size());
    }
    public @Test
    void getProductsByName() {

        // test find existing product by Category
        String productToBeFound = "AUTO-JUNIT-TESTS-TV";
        List<Product> foundProductsByCategory = productDAO.getProductsByName(productToBeFound);
        assertEquals(2, foundProductsByCategory.size());


        // test find existing product by Category
        String nonExistentProductNames = "NON-EXISTENT-PRODUCTS-NAME";
        assertEquals(0, productDAO.getProductsByName(nonExistentProductNames).size());
    }

}