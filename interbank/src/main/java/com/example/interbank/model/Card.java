package com.example.interbank.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "card")
public class Card {
    @Id
    @Column(name = "card_code", unique = true)
    private String cardCode;

    @Column(name = "card_holder_name")
    private String cardHolderName;

    @Column(name = "cvv_code")
    private String cvvCode;

    @Column(name = "date_expired")
    private String dateExpired;

    @Column(name = "balance")
    private long balance;
}
