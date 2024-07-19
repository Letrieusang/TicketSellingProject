package org.example.service;

import org.example.entity.CartEntity;

import java.util.List;
import java.util.Optional;

public interface CartService {
    List<CartEntity> getAllCarts();
    Optional<CartEntity> getCartById(Integer cartId);
    CartEntity createCart(CartEntity cart);
    CartEntity updateCart(CartEntity cartDetails);
    void deleteCart(Integer cartId);
}