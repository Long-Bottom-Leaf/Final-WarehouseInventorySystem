package com.keyin.warehouseinventorysystem;


import com.keyin.warehouseinventorysystem.models.Customer;
import com.keyin.warehouseinventorysystem.models.Order;
import com.keyin.warehouseinventorysystem.services.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class OrderServiceTest {

    @Autowired
    private OrderService orderService;

    @Test
    public void testPriorityValidationThrowsException() {

        Order order = new Order();
        order.setPriorityLevel(999); // invalid

        Customer customer = new Customer();
        customer.setId(1L);

        order.setCustomer(customer);

        assertThrows(RuntimeException.class, () -> {
            orderService.createOrder(order);
        });
    }

    @Test
    public void testMissingCustomerThrowsException() {

        Order order = new Order();
        order.setPriorityLevel(5);

        assertThrows(RuntimeException.class, () -> {
            orderService.createOrder(order);
        });
    }
}
