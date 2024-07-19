package org.example.service;

import org.example.dto.ProductDto.ProductDetailDto;
import org.example.dto.ProductDto.ProductStockResDto;
import org.example.entity.ProductEntity;
import java.util.List;

public interface ProductService {
    List<ProductEntity> getAllProducts();
    ProductEntity getProductById(Integer id) throws  Exception;
    ProductDetailDto getProductDetailById(Integer id) throws Exception;
    ProductEntity createProduct(ProductEntity product);
    ProductEntity updateProduct(ProductEntity productDetails);
    void deleteProduct(Integer id);
//    List<Object> getProductsByCategoryId();
    List<ProductEntity> getRandomProducts();
    ProductStockResDto getStock(Integer productId) throws Exception;
}
