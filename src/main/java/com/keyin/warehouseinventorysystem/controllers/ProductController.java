package com.keyin.warehouseinventorysystem.controllers;

import com.keyin.warehouseinventorysystem.models.Product;
import com.keyin.warehouseinventorysystem.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // ✅ Get all products
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // ✅ Create product
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    // ✅ Sorting endpoint
    @GetMapping("/sorted")
    public List<Product> getSortedProducts(@RequestParam String by) {

        List<Product> products = productService.getAllProducts();

        if (by.equalsIgnoreCase("price")) {
            return productService.sortByPrice(products);
        } else if (by.equalsIgnoreCase("stock")) {
            return productService.sortByStock(products);
        } else {
            throw new RuntimeException("Invalid sort type. Use 'price' or 'stock'");
        }
    }
}