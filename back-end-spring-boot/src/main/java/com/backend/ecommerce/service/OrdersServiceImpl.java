package com.backend.ecommerce.service;

import com.backend.ecommerce.entity.Orders;
import com.backend.ecommerce.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdersServiceImpl implements OrdersService {
    private OrdersRepository ordersRepository;
    private OrderDetailsService orderDetailsService;
    @Autowired
    public OrdersServiceImpl(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }
    @Override
    public Object save(Orders orders) {
        return ordersRepository.save(orders);
    }
    @Override
    public Orders findById(long theId) {
        return ordersRepository.findById(theId).orElseThrow(
                ()->new RuntimeException("Can not find the order with id: " + theId));
    }
    @Override
    public List<Orders> findAll() {
        return ordersRepository.findAll();
    }

    @Override
    public Object updateOrder(Long theId, Orders updatedOrder) {
        Optional<Orders> existingOrder = ordersRepository.findById(theId);
        if (existingOrder.isPresent()) {
            Orders tmp = existingOrder.get();
            tmp.setFullname(updatedOrder.getFullname());
            tmp.setEmail(updatedOrder.getEmail());
            tmp.setPhoneNumber(updatedOrder.getPhoneNumber());
            tmp.setAddress(updatedOrder.getAddress());
            tmp.setNote(updatedOrder.getNote());
            tmp.setOrderDate(updatedOrder.getOrderDate());
            tmp.setStatus(updatedOrder.getStatus());
            tmp.setTotalMoney(updatedOrder.getTotalMoney());
            return ordersRepository.save(tmp);
        }
        else throw new RuntimeException("Order not Exist");
    }

    @Override
    public Orders addOrders(Orders orders) {
        Orders tmp = new Orders();
        tmp.setId(0L);
        tmp.setFullname(orders.getFullname());
        tmp.setEmail(orders.getEmail());
        tmp.setPhoneNumber(orders.getPhoneNumber());
        tmp.setAddress(orders.getAddress());
        tmp.setNote(orders.getNote());
        tmp.setOrderDate(orders.getOrderDate());
        tmp.setStatus(orders.getStatus());
        tmp.setTotalMoney(orders.getTotalMoney());
        return ordersRepository.save(tmp);
    }

    @Override
    public String deleteOrder(long theId) {
        ordersRepository.deleteById(theId);
        return "Category with Id: " + theId + " has been deleted.";
    }
}
