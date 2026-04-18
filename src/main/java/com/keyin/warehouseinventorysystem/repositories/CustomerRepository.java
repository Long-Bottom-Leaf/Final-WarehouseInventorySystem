package com.keyin.warehouseinventorysystem.repositories;

import com.keyin.warehouseinventorysystem.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}