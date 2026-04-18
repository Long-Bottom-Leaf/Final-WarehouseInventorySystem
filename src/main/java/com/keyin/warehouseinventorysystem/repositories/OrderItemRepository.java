package com.keyin.warehouseinventorysystem.repositories;

import com.keyin.warehouseinventorysystem.models.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
