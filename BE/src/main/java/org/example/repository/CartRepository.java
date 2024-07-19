package org.example.repository;

import org.example.entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;

//@Repository
public interface CartRepository extends JpaRepository<CartEntity, Integer> {
}
