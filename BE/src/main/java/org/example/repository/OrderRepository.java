package org.example.repository;

import org.example.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

//@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {
}
