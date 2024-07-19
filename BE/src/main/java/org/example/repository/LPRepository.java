package org.example.repository;

import org.example.entity.productEntity.LPEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LPRepository extends JpaRepository<LPEntity, Integer> {
}
