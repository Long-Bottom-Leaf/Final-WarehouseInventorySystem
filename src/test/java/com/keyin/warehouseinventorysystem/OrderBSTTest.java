package com.keyin.warehouseinventorysystem;

import com.keyin.warehouseinventorysystem.datastructures.OrderBST;
import com.keyin.warehouseinventorysystem.models.Order;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class OrderBSTTest {

    @Test
    public void testBSTInOrderTraversal() {

        OrderBST bst = new OrderBST();

        Order o1 = new Order();
        o1.setPriorityLevel(5);

        Order o2 = new Order();
        o2.setPriorityLevel(2);

        Order o3 = new Order();
        o3.setPriorityLevel(8);

        bst.insert(o1);
        bst.insert(o2);
        bst.insert(o3);

        List<Order> result = bst.inOrder();

        assertEquals(2, result.get(0).getPriorityLevel());
        assertEquals(5, result.get(1).getPriorityLevel());
        assertEquals(8, result.get(2).getPriorityLevel());
    }

    @Test
    public void testBSTHighestAndLowest() {

        OrderBST bst = new OrderBST();

        Order o1 = new Order(); o1.setPriorityLevel(5);
        Order o2 = new Order(); o2.setPriorityLevel(1);
        Order o3 = new Order(); o3.setPriorityLevel(10);

        bst.insert(o1);
        bst.insert(o2);
        bst.insert(o3);

        assertEquals(10, bst.findHighest().getPriorityLevel());
        assertEquals(1, bst.findLowest().getPriorityLevel());
    }

    @Test
    public void testBSTSingleNode() {

        OrderBST bst = new OrderBST();

        Order o1 = new Order();
        o1.setPriorityLevel(5);

        bst.insert(o1);

        assertEquals(5, bst.findHighest().getPriorityLevel());
        assertEquals(5, bst.findLowest().getPriorityLevel());
    }
}
