package com.keyin.warehouseinventorysystem;

import com.keyin.warehouseinventorysystem.models.Product;
import com.keyin.warehouseinventorysystem.services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Test
    public void testSortByPrice() {

        List<Product> products = new ArrayList<>();

        products.add(new Product(1L, "Mouse", 25.0, 10));
        products.add(new Product(2L, "Laptop", 1000.0, 5));
        products.add(new Product(3L, "Keyboard", 50.0, 20));

        List<Product> sorted = productService.sortByPrice(products);

        assertEquals("Mouse", sorted.get(0).getName());
        assertEquals("Keyboard", sorted.get(1).getName());
        assertEquals("Laptop", sorted.get(2).getName());
    }

    @Test
    public void testReverseOrder() {
        List<Product> products = new ArrayList<>();

        products.add(new Product(1L, "A", 300, 5));
        products.add(new Product(2L, "B", 200, 5));
        products.add(new Product(3L, "C", 100, 5));

        List<Product> sorted = productService.sortByPrice(products);

        assertEquals(100, sorted.get(0).getPrice());
        assertEquals(200, sorted.get(1).getPrice());
        assertEquals(300, sorted.get(2).getPrice());
    }

    @Test
    public void testDuplicatePrices() {
        List<Product> products = new ArrayList<>();

        products.add(new Product(1L, "A", 50, 5));
        products.add(new Product(2L, "B", 50, 5));
        products.add(new Product(3L, "C", 10, 5));

        List<Product> sorted = productService.sortByPrice(products);

        assertEquals(10, sorted.get(0).getPrice());
        assertEquals(50, sorted.get(1).getPrice());
        assertEquals(50, sorted.get(2).getPrice());
    }

    @Test
    public void testSortEmptyList() {
        List<Product> products = new ArrayList<>();

        List<Product> sorted = productService.sortByPrice(products);

        assertEquals(0, sorted.size());
    }
}
