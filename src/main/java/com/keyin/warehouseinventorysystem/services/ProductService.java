package com.keyin.warehouseinventorysystem.services;

import com.keyin.warehouseinventorysystem.models.Product;
import com.keyin.warehouseinventorysystem.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> sortByPrice(List<Product> products) {
        for (int i = 1; i < products.size(); i++) {
            Product current = products.get(i);
            int size = i -1;

            while (size >= 0 && products.get(size).getPrice() > current.getPrice()) {
                products.set(size + 1, products.get(size));
                size--;
            }

            products.set(size + 1, current);
        }

        return products;
    }

    public List<Product> sortByStock(List<Product> products) {
        for (int i = 1; i < products.size(); i++) {
            Product current = products.get(i);
            int size = i -1;

            while (size >= 0 && products.get(size).getStock() > current.getStock()) {
                products.set(size + 1, products.get(size));
                size--;
            }

            products.set(size +1, current);
        }

        return products;
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }
}
