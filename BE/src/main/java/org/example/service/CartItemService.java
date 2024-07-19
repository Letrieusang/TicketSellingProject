package org.example.service;

import org.example.entity.CartItemEntity;

import java.util.List;
import java.util.Optional;

public interface CartItemService {
//    List<CartItemEntity> getAllCartItems();
    Optional<CartItemEntity> getCartItemById(Integer cartItemId);
    CartItemEntity createCartItem(CartItemEntity cartItem);
    CartItemEntity updateCartItem(CartItemEntity cartItemDetails);
    void deleteCartItem(Integer cartItemId);
    List<CartItemEntity> getCartItemsByCartId(Integer cartId);
}