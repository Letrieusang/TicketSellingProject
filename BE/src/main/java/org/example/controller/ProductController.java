package org.example.controller;

import org.example.dto.ProductDto.ProductDetailDto;
import org.example.dto.ProductDto.ProductStockResDto;
import org.example.entity.ProductEntity;
import org.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // Get all products
    @GetMapping
    public ResponseEntity<List<ProductEntity>> getAllProducts() {
        List<ProductEntity> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ProductEntity getProductById(@PathVariable Integer id) throws Exception{
        return productService.getProductById(id);
    }
    // Get product by ID
    @GetMapping("/detail/{id}")
    public ProductDetailDto getProductDetailById(@PathVariable Integer id) throws Exception{
        return productService.getProductDetailById(id);
    }

    // Create new product
    @PostMapping("/")
    public ResponseEntity<ProductEntity> createProduct(@RequestBody ProductEntity product) {
        ProductEntity savedProduct = productService.createProduct(product);
        return ResponseEntity.ok(savedProduct);
    }

    // Update product by ID
    @PutMapping("/")
    public ResponseEntity<ProductEntity> updateProduct(@RequestBody ProductEntity productDetails) {
        try {
            ProductEntity updatedProduct = productService.updateProduct(productDetails);
            return ResponseEntity.ok(updatedProduct);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete product by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id) {
        try {
            productService.deleteProduct(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Get 20 random products
    @GetMapping("/random")
    public ResponseEntity<List<ProductEntity>> getRandomProducts() {
        List<ProductEntity> products = productService.getRandomProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/stock/{id}")
    public ProductStockResDto getStock(@PathVariable Integer id) throws Exception {
        return productService.getStock(id);
    }
}
