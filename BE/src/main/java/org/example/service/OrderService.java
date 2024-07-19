package org.example.service;

import org.example.entity.OrderEntity;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    List<OrderEntity> getAllOrders();

    Optional<OrderEntity> getOrderById(Integer orderId);

    OrderEntity createOrder(OrderEntity order);

//    OrderEntity updateOrder(OrderEntity orderDetails);

    void deleteOrder(Integer orderId);
}