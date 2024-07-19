package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "orders")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer orderId;

    @OneToOne
    @JoinColumn(name = "delivery_id", referencedColumnName = "delivery_id")
    private DeliveryInformationEntity delivery;

    @OneToOne
    @JoinColumn(name = "invoice_id", referencedColumnName = "invoice_id")
    private InvoiceEntity  invoice;

    @OneToOne
    @JoinColumn(name = "payment_transaction_id", referencedColumnName = "payment_transaction_id")
    private PaymentTransactionEntity  paymentTransaction;

    @Column(name = "create_at")
    private Date createAt;

    @Column(name = "error_code")
    private String errorCode;

    @Column(name = "transaction_content")
    private String transactionContent;

    @Column(name = "order_state")
    private String orderState;

}