package org.example.repository;

import org.example.entity.CartItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//@Repository
public interface CartItemRepository extends JpaRepository<CartItemEntity, Integer> {
    List<CartItemEntity> findByCart_CartId(Integer cartId);
}
