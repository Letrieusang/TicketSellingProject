package org.example.controller;

import org.example.entity.CartItemEntity;
import org.example.service.impl.CartItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cartItems")
@CrossOrigin(origins = "http://localhost:3000")
public class CartItemController {
    @Autowired
    CartItemServiceImpl cartItemServiceImpl;

//    @GetMapping
//    public List<CartItemEntity> getAllCartItems() {
//        return cartItemServiceImpl.getAllCartItems();
//    }

    @GetMapping("/{id}")
    public ResponseEntity<CartItemEntity> getCartItemById(@PathVariable Integer id) {
        Optional<CartItemEntity> cartItem = cartItemServiceImpl.getCartItemById(id);
        return cartItem.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/")
    public CartItemEntity createCartItem(@RequestBody CartItemEntity cartItem) {
        return cartItemServiceImpl.createCartItem(cartItem);
    }

    @PutMapping("/")
    public ResponseEntity<CartItemEntity> updateCartItem(@RequestBody CartItemEntity cartItemDetails) {
        CartItemEntity updatedCartItem = cartItemServiceImpl.updateCartItem(cartItemDetails);
        return ResponseEntity.ok(updatedCartItem);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCartItem(@PathVariable Integer id) {
        cartItemServiceImpl.deleteCartItem(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/cart/{cartId}")
    public List<CartItemEntity> getCartItemsByCartId(@PathVariable Integer cartId) {
        return cartItemServiceImpl.getCartItemsByCartId(cartId);
    }
}