package org.example.dto.ProductDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.entity.ProductEntity;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProductStockResDto {
    private Integer productId;
    private Integer quantity;

    public ProductStockResDto(ProductEntity product) {
        this.productId = product.getProductId();
        this.quantity = product.getQuantity();

    }
}
