package org.example.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "provinces")
public class ProvinceEntity {

    @Id
    @Column(name = "province_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer provinceId;

    @Column(name = "province_name")
    private String provinceName;


}