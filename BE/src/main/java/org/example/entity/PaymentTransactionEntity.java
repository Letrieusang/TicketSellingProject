package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "payment_transactions")
public class PaymentTransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_transaction_id")
    private Integer transactionId;

    @Column(name = "transaction_content")
    private String transactionContent;

    @Column(name = "transaction_date")
    private java.sql.Date transactionDate ;

    @Column(name = "transaction_status")
    private String transactionStatus;
}