package com.backend.ecommerce.service;

import com.backend.ecommerce.entity.Orders;

import java.util.List;

public interface OrdersService {
    Object save(Orders orders);
    Orders addOrders(Orders orders);
    String deleteOrder(long theId);
    Orders findById(long theId);

    List<Orders> findAll();

    Object updateOrder(Long theId, Orders updatedOrder);
}
