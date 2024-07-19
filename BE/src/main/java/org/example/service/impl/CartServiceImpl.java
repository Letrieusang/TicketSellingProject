package org.example.service.impl;

import org.example.entity.CartEntity;
import org.example.repository.CartRepository;
import org.example.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    CartRepository cartRepository;

    @Override
    public List<CartEntity> getAllCarts() {
        return cartRepository.findAll();
    }

    @Override
    public Optional<CartEntity> getCartById(Integer cartId) {
        return cartRepository.findById(cartId);
    }

    @Override
    public CartEntity createCart(CartEntity cart) {
        return cartRepository.save(cart);
    }

    @Override
    public CartEntity updateCart(CartEntity cartDetails) {
        CartEntity cart = cartRepository.findById(cartDetails.getCartId())
                .orElseThrow(() -> new RuntimeException("Cart not found"));
        cart.setTotalWeight(cartDetails.getTotalWeight());
        cart.setTotalPrice(cartDetails.getTotalPrice());
        return cartRepository.save(cart);
    }

    @Override
    public void deleteCart(Integer cartId) {
        CartEntity cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new RuntimeException("Cart not found"));
        cartRepository.delete(cart);
    }
}