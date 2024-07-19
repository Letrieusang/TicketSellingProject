package org.example.repository;

import org.example.entity.productEntity.CDEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CDRepository extends JpaRepository<CDEntity, Integer> {
}
