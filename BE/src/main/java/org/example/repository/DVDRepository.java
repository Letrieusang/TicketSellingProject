package org.example.repository;

import org.example.entity.productEntity.DVDEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DVDRepository extends JpaRepository<DVDEntity, Integer> {
}
