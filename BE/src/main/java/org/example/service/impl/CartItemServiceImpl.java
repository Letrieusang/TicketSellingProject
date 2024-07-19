package org.example.service.impl;

import org.example.entity.CartEntity;
import org.example.entity.CartItemEntity;
import org.example.repository.CartItemRepository;
import org.example.repository.CartRepository;
import org.example.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class CartItemServiceImpl implements CartItemService {
    @Autowired
    CartItemRepository cartItemRepository;
    @Autowired
    private CartRepository cartRepository;

//    @Override
//    public List<CartItemEntity> getAllCartItems() {
//        return cartItemRepository.findAll();
//    }

    @Override
    public Optional<CartItemEntity> getCartItemById(Integer cartItemId) {
        return cartItemRepository.findById(cartItemId);
    }

    @Override
    public CartItemEntity createCartItem(CartItemEntity cartItem) {
        CartItemEntity savedCartItem = cartItemRepository.save(cartItem);

        CartEntity cart = cartRepository.findById(savedCartItem.getCart().getCartId())
                .orElseThrow(() -> new RuntimeException("Cart not found"));
        cart.setTotalWeight(cart.getTotalWeight().add(savedCartItem.getProduct().getWeight().multiply(new BigDecimal(savedCartItem.getQuantity()))));
        cart.setTotalPrice(cart.getTotalPrice().add(savedCartItem.getProduct().getValue().multiply(new BigDecimal(savedCartItem.getQuantity()))));
        cartRepository.save(cart);
        return savedCartItem;
    }

    @Override
    public CartItemEntity updateCartItem(CartItemEntity cartItemDetails) {
        CartItemEntity cartItem = cartItemRepository.findById(cartItemDetails.getCartItemId())
                .orElseThrow(() -> new RuntimeException("Cart item not found"));
        cartItem.setQuantity(cartItemDetails.getQuantity());
        return cartItemRepository.save(cartItem);
    }

    @Override
    public void deleteCartItem(Integer cartItemId) {
        CartItemEntity cartItem = cartItemRepository.findById(cartItemId)
                .orElseThrow(() -> new RuntimeException("Cart item not found"));
        CartEntity cart = cartRepository.findById(cartItem.getCart().getCartId())
                .orElseThrow(() -> new RuntimeException("Cart not found"));
        cartRepository.save(cart);
        cartItemRepository.delete(cartItem);
    }

    @Override
    public List<CartItemEntity> getCartItemsByCartId(Integer cartId) {
        return cartItemRepository.findByCart_CartId(cartId);
    }
}

