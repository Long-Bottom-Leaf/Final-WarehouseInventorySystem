package com.keyin.warehouseinventorysystem.repositories;

import com.keyin.warehouseinventorysystem.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
