package org.example.dto.DeliveryInformationDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryInformationDtoInfoResDto {
    private Integer deliveryId;
    private Integer recipientName;
    private String email;
    private String phoneNumber;
    private Integer provinceId;
    private String provinceName;
    private java.math.BigDecimal originalShippingFee;
    private String address;
    private Boolean isRushOrder;


}