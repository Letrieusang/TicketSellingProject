package org.example.service.impl;

import org.example.entity.OrderEntity;
import org.example.repository.OrderRepository;
import org.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Override
    public List<OrderEntity> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<OrderEntity> getOrderById(Integer orderId) {
        return orderRepository.findById(orderId);
    }

    @Override
    public OrderEntity createOrder(OrderEntity order) {
        return orderRepository.save(order);
    }

//    @Override
//    public OrderEntity updateOrder(OrderEntity orderDetails) {
//        OrderEntity order = orderRepository.findById(orderDetails.getOrderId())
//                .orElseThrow(() -> new RuntimeException("Order not found"));
//        order.setUserId(orderDetails.getUserId());
//        order.setOrderDate(orderDetails.getOrderDate());
//        order.setStatus(orderDetails.getStatus());
//        order.setTotalPrice(orderDetails.getTotalPrice());
//        order.setDeliveryFee(orderDetails.getDeliveryFee());
//        order.setTotalAmount(orderDetails.getTotalAmount());
//        return orderRepository.save(order);
//    }

    @Override
    public void deleteOrder(Integer orderId) {
        OrderEntity order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        orderRepository.delete(order);
    }
}