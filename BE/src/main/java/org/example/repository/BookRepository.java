package org.example.repository;

import org.example.entity.productEntity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

//@Repository
public interface BookRepository extends JpaRepository<BookEntity, Integer> {
}
