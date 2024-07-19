package com.example.interbank.repository;

import com.example.interbank.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CardRepository extends JpaRepository<Card, String> {
    Card save(Card card);
    Optional<Card> findById(String cardCode);
}
