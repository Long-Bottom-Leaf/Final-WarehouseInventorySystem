package com.keyin.warehouseinventorysystem.services;

import com.keyin.warehouseinventorysystem.datastructures.OrderBST;
import com.keyin.warehouseinventorysystem.models.Order;
import com.keyin.warehouseinventorysystem.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    private OrderBST orderBST = new OrderBST();

    public Order createOrder(Order order) {
        if (order.getOrderDate() == null) {
            order.setOrderDate(LocalDate.now());
        }

        if (order.getCustomer() == null) {
            throw new RuntimeException("Order must have a customer");
        }

        if (order.getPriorityLevel() < 1 || order.getPriorityLevel() > 10) {
            throw new RuntimeException("Priority must be between 1 and 10");
        }

        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public void addToPriorityTree(Order order) {
        orderBST.insert(order);
    }

    public List<Order> getOrdersInPriorityOrder() {
        return orderBST.inOrder();
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    public Order getHighestPriorityOrder() {
        if (orderBST.findHighest() == null) {
            throw new RuntimeException("No orders in priority tree");
        }

        return orderBST.findHighest();
    }

    public Order getLowestPriorityOrder() {
        if (orderBST.findLowest() == null) {
            throw new RuntimeException("No orders in priority tree");
        }

        return orderBST.findLowest();
    }
}
