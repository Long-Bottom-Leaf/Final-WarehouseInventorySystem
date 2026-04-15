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

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @GetMapping("/sorted")
    public List<Product> getSortedProducts(@RequestParam String by) {

        List<Product> products = productService.getAllProducts();

        if (by == null) {
            throw new RuntimeException("Sort parameter 'by' is required");

        } else if (by.equalsIgnoreCase("price")) {
            return productService.sortByPrice(products);

        } else if (by.equalsIgnoreCase("stock")) {
            return productService.sortByStock(products);

        } else {
            throw new RuntimeException("Invalid sort type. Use 'price' or 'stock'");
        }
    }
}