package org.example.service.impl;

import org.example.dto.BookDto.BookResDto;
import org.example.dto.CDDto.CDResDto;
import org.example.dto.DVDDto.DVDResDto;
import org.example.dto.LPDto.LPResDto;
import org.example.dto.ProductDto.ProductDetailDto;
import org.example.dto.ProductDto.ProductResDto;
import org.example.dto.ProductDto.ProductStockResDto;
import org.example.entity.*;
import org.example.entity.productEntity.BookEntity;
import org.example.entity.productEntity.CDEntity;
import org.example.entity.productEntity.DVDEntity;
import org.example.entity.productEntity.LPEntity;
import org.example.repository.*;
import org.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    CDRepository cdRepository;
    @Autowired
    DVDRepository dvdRepository;
    @Autowired
    LPRepository lpRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public ProductEntity getProductById(Integer id) throws  Exception{
        return productRepository.findById(id)
                .orElseThrow(() -> new Exception("Product not found"));
    }
    @Override
    public ProductDetailDto getProductDetailById(Integer id) throws Exception {
        ProductEntity product = productRepository.findById(id)
                .orElseThrow(() -> new Exception("Product not found"));
        ProductResDto productHaveCategory = new ProductResDto(product);
        BookEntity book = null;
        CDEntity cd = null;
        DVDEntity dvd = null;
        LPEntity lp = null;
        BookResDto bookRes = null;
        CDResDto cdRes = null;
        DVDResDto dvdRes = null;
        LPResDto lpRes = null;

        switch (productHaveCategory.getCategoryName()) {
            case "Book":
                book = bookRepository.findById(id).orElse(null);
                assert book != null;
                bookRes = new BookResDto(book);
                break;
            case "CD":
                cd = cdRepository.findById(id).orElse(null);
                assert cd != null;
                cdRes = new CDResDto(cd);
                break;
            case "LP":
                lp = lpRepository.findById(id).orElse(null);
                assert lp != null;
                lpRes = new LPResDto(lp);
                break;
            case "DVD":
                dvd = dvdRepository.findById(id).orElse(null);
                assert dvd != null;
                dvdRes = new DVDResDto(dvd);
                break;

            default:
                System.out.print(productHaveCategory.getCategoryName());
        }
        return ProductDetailDto.createEntity(productHaveCategory, bookRes, dvdRes, cdRes, lpRes);
    }

    @Override
    public ProductEntity createProduct(ProductEntity product) {
        return productRepository.save(product);
    }

    @Override
    public ProductEntity updateProduct(ProductEntity productDetails) {
        Optional<ProductEntity> existingProduct = productRepository.findById(productDetails.getProductId());

        if (existingProduct.isPresent()) {
            ProductEntity productToUpdate = existingProduct.get();
            productToUpdate.setTitle(productDetails.getTitle());
            productToUpdate.setCategory(productDetails.getCategory());
            productToUpdate.setValue(productDetails.getValue());
            productToUpdate.setCurrentPrice(productDetails.getCurrentPrice());
            productToUpdate.setBarcode(productDetails.getBarcode());
            productToUpdate.setDescription(productDetails.getDescription());
            productToUpdate.setQuantity(productDetails.getQuantity());
            productToUpdate.setWarehouseEntryDate(productDetails.getWarehouseEntryDate());
            productToUpdate.setDimensions(productDetails.getDimensions());
            productToUpdate.setWeight(productDetails.getWeight());
            return productRepository.save(productToUpdate);
        } else {
            throw new RuntimeException("Product not found with id " + productDetails.getProductId());
        }
    }

    @Override
    public void deleteProduct(Integer id) {
        Optional<ProductEntity> existingProduct = productRepository.findById(id);

        if (existingProduct.isPresent()) {
            productRepository.deleteById(id);
        } else {
            throw new RuntimeException("Product not found with id " + id);
        }
    }

    @Override
    public List<ProductEntity> getRandomProducts() {
        return productRepository.findRandomProducts();
    }

    @Override
    public ProductStockResDto getStock(Integer productId) throws Exception {
        ProductEntity product = productRepository.findById(productId)
                .orElseThrow(() -> new Exception("Product not found"));
        return new ProductStockResDto(product);
    }
}
