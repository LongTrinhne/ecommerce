package com.backend.ecommerce.service;

import com.backend.ecommerce.entity.OrderDetails;
import com.backend.ecommerce.entity.Product;

public class OrderDetailsServiceImpl implements OrderDetailsService{
    @Override
    public OrderDetails createNewOrderDetails(OrderDetails orderDetails) {
        OrderDetails tmp = new OrderDetails();
        tmp.setProducts(orderDetails.getProducts());
        tmp.setQuantity(orderDetails.getQuantity());
        tmp.setPrice(orderDetails.getPrice());
        tmp.setTotalMoney(orderDetails.getPrice() * orderDetails.getQuantity());
        tmp.setProducts(orderDetails.getProducts());
        return null;
    }
}
