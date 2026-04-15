package com.keyin.warehouseinventorysystem.datastructures;

import com.keyin.warehouseinventorysystem.models.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderBST {

    private OrderNode root;

    public void insert(Order order) {
        root = insertRecursive(root, order);
    }

    public OrderNode insertRecursive(OrderNode current, Order order) {
        if (current == null) {
            return new OrderNode(order);
        }

        if (order.getPriorityLevel() < current.data.getPriorityLevel()) {
            current.left = insertRecursive(current.left, order);

        } else {
            current.right = insertRecursive(current.right, order);
        }

        return current;
    }

    public List<Order> inOrder() {
        List<Order> result = new ArrayList<>();
        inorderRecursive(root, result);

        return result;
    }

    private void inorderRecursive(OrderNode node, List<Order> result) {
        if (node != null) {
            inorderRecursive(node.left, result);
            result.add(node.data);
            inorderRecursive(node.right, result);
        }
    }

    // Find highest and lowest
    public Order findHighest() {
        if (root == null) return null;

        OrderNode current = root;

        while (current.right != null) {
            current = current.right;
        }

        return current.data;
    }

    public Order findLowest() {
        if (root == null) return null;

        OrderNode current = root;
        while (current.left != null) {
            current = current.left;
        }

        return current.data;
    }
}
