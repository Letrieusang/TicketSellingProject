package org.example.controller;

import org.example.entity.CartEntity;
import org.example.service.impl.CartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/carts")
@CrossOrigin(origins = "http://localhost:3000")
public class CartController {
    @Autowired
    CartServiceImpl cartServiceImpl;

    @GetMapping
    public List<CartEntity> getAllCarts() {
        return cartServiceImpl.getAllCarts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CartEntity> getCartById(@PathVariable Integer id) {
        Optional<CartEntity> cart = cartServiceImpl.getCartById(id);
        return cart.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/")
    public CartEntity createCart(@RequestBody CartEntity cart) {
        return cartServiceImpl.createCart(cart);
    }

    @PutMapping("/")
    public ResponseEntity<CartEntity> updateCart(@RequestBody CartEntity cartDetails) {
        CartEntity updatedCart = cartServiceImpl.updateCart(cartDetails);
        return ResponseEntity.ok(updatedCart);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCart(@PathVariable Integer id) {
        cartServiceImpl.deleteCart(id);
        return ResponseEntity.noContent().build();
    }
}