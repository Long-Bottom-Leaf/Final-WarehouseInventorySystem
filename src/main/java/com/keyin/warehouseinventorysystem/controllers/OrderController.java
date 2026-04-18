package com.keyin.warehouseinventorysystem.controllers;

import com.keyin.warehouseinventorysystem.models.Order;
import com.keyin.warehouseinventorysystem.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @PostMapping("/add-to-priority-tree/{id}")
    public String addToPriorityTree(@PathVariable Long id) {

        Order order = orderService.getOrderById(id);
        orderService.addToPriorityTree(order);

        return "Order with ID " + id + " added to priority tree";
    }

    @GetMapping("/priority/inorder")
    public List<Order> getOrdersInPriorityOrder() {
        return orderService.getOrdersInPriorityOrder();
    }

    @GetMapping("/priority/highest")
    public Order getHighestPriorityOrder() {
        return orderService.getHighestPriorityOrder();
    }

    @GetMapping("/priority/lowest")
    public Order getLowestPriorityOrder() {
        return orderService.getLowestPriorityOrder();
    }
}