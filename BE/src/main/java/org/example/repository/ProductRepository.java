package org.example.repository;

import org.example.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
    @Query(value = "SELECT * FROM products ORDER BY RANDOM() LIMIT 20", nativeQuery = true)
    List<ProductEntity> findRandomProducts();

}
