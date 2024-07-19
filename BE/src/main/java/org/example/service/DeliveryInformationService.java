package org.example.service;

import org.example.dto.DeliveryInformationDto.DeliveryInformationDtoInfoResDto;
import org.example.entity.DeliveryInformationEntity;

import java.util.List;
import java.util.Optional;

public interface DeliveryInformationService {
    List<DeliveryInformationEntity> getAllDeliveryInformation();

    Optional<DeliveryInformationDtoInfoResDto> getDeliveryInformationById(Integer deliveryId);

    DeliveryInformationEntity createDeliveryInformation(DeliveryInformationEntity deliveryInformation);

    DeliveryInformationEntity updateDeliveryInformation(DeliveryInformationEntity deliveryInformationDetails);

    void deleteDeliveryInformation(Integer deliveryId);
}