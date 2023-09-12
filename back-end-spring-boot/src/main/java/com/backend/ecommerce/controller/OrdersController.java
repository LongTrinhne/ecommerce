package com.backend.ecommerce.controller;

import com.backend.ecommerce.entity.Orders;
import com.backend.ecommerce.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;
    @GetMapping("/get")
    public ResponseEntity<List> getAllOrders() {
        return ResponseEntity.ok(ordersService.findAll());
    }
    @GetMapping("/get/{theId}")
    public ResponseEntity<Orders> getOrderById(@PathVariable Long theId) {
        return ResponseEntity.ok(ordersService.findById(theId));
    }
    @PostMapping("/create")
    public ResponseEntity<Orders> createNewOrder(@RequestBody Orders orders) {
        return ResponseEntity.ok(ordersService.addOrders(orders));
    }
    @PutMapping("/update/{theId}")
    public ResponseEntity<Object> updateOrdersById(@PathVariable Long theId, @RequestBody Orders updatedOrder) {
        return ResponseEntity.ok(ordersService.updateOrder(theId ,updatedOrder));
    }
    @DeleteMapping("/delete/{theId}")
    public ResponseEntity<String> deleteOrder(@PathVariable Long theId) {
        return ResponseEntity.ok(ordersService.deleteOrder(theId));
    }
}
