package com.keyin.warehouseinventorysystem.datastructures;

import org.w3c.dom.Node;
import com.keyin.warehouseinventorysystem.models.Order;

public class OrderNode {

    public Order data;
    public OrderNode left, right;

    public OrderNode(Order data) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
