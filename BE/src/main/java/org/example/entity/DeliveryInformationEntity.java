package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "delivery_informations")
public class DeliveryInformationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "delivery_id")
    private Integer deliveryId;

    @Column(name = "recipient_name")
    private Integer recipientName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "province_id", referencedColumnName = "province_id")
    private ProvinceEntity province;

    @Column(name = "address")
    private String address;

    @Column(name = "is_rush_order")
    private Boolean isRushOrder;

}