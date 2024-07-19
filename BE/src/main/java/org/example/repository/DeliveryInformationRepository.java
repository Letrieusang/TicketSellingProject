package org.example.repository;

import org.example.entity.DeliveryInformationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryInformationRepository extends JpaRepository<DeliveryInformationEntity, Integer> {
}