package org.example.dto.ProductDto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.entity.CategoryEntity;
import org.example.entity.ProductEntity;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProductResDto {
    private Integer productId;
    private String title;
    private String  categoryName;
    private BigDecimal value;
    private BigDecimal currentPrice;
    private String barcode;
    private String description;
    private Integer quantity;
    private java.sql.Date warehouseEntryDate;
    private String dimensions;
    private BigDecimal weight;
    private Boolean rushOrderSupport;
    private String image;
    public ProductResDto(ProductEntity product) {
        this.productId = product.getProductId();
        this.title = product.getTitle();
        this.categoryName = product.getCategory().getCategoryName();
        this.value = product.getValue();
        this.currentPrice = product.getCurrentPrice();
        this.barcode = product.getBarcode();
        this.description = product.getDescription();
        this.quantity = product.getQuantity();
        this.warehouseEntryDate = product.getWarehouseEntryDate();
        this.dimensions = product.getDimensions();
        this.weight = product.getWeight();
        this.rushOrderSupport = product.getRushOrderSupport();
        this.image = product.getImage();
    }
}
