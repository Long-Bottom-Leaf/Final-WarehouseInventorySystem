package com.keyin.warehouseinventorysystem.repositories;

import com.keyin.warehouseinventorysystem.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}