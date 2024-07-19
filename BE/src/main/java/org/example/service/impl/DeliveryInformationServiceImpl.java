package org.example.service.impl;

import org.example.dto.DeliveryInformationDto.DeliveryInformationDtoInfoResDto;
import org.example.entity.DeliveryInformationEntity;
import org.example.repository.DeliveryInformationRepository;
import org.example.service.DeliveryInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeliveryInformationServiceImpl implements DeliveryInformationService {
    @Autowired
    DeliveryInformationRepository deliveryInformationRepository;

    @Override
    public List<DeliveryInformationEntity> getAllDeliveryInformation() {
        return deliveryInformationRepository.findAll();
    }

    @Override
    public Optional<DeliveryInformationDtoInfoResDto> getDeliveryInformationById(Integer deliveryId) {
        return deliveryInformationRepository.findById(deliveryId)
                .map(this::convertToDto);
    }

    @Override
    public DeliveryInformationEntity createDeliveryInformation(DeliveryInformationEntity deliveryInformation) {
        return deliveryInformationRepository.save(deliveryInformation);
    }

    @Override
    public DeliveryInformationEntity updateDeliveryInformation(DeliveryInformationEntity deliveryInformationDetails) {
        DeliveryInformationEntity deliveryInformation = deliveryInformationRepository.findById(deliveryInformationDetails.getDeliveryId())
                .orElseThrow(() -> new RuntimeException("Delivery Information not found"));
        deliveryInformation.setRecipientName(deliveryInformationDetails.getRecipientName());
        deliveryInformation.setEmail(deliveryInformationDetails.getEmail());
        deliveryInformation.setPhoneNumber(deliveryInformationDetails.getPhoneNumber());
        deliveryInformation.setProvince(deliveryInformationDetails.getProvince());
        deliveryInformation.setAddress(deliveryInformationDetails.getAddress());
        deliveryInformation.setIsRushOrder(deliveryInformationDetails.getIsRushOrder());
        return deliveryInformationRepository.save(deliveryInformation);
    }

    @Override
    public void deleteDeliveryInformation(Integer deliveryId) {
        DeliveryInformationEntity deliveryInformation = deliveryInformationRepository.findById(deliveryId)
                .orElseThrow(() -> new RuntimeException("Delivery Information not found"));
        deliveryInformationRepository.delete(deliveryInformation);
    }

    private DeliveryInformationDtoInfoResDto convertToDto(DeliveryInformationEntity deliveryInformation) {
        DeliveryInformationDtoInfoResDto dto = new DeliveryInformationDtoInfoResDto();
        dto.setDeliveryId(deliveryInformation.getDeliveryId());
        dto.setRecipientName(deliveryInformation.getRecipientName());
        dto.setEmail(deliveryInformation.getEmail());
        dto.setPhoneNumber(deliveryInformation.getPhoneNumber());
        dto.setProvinceId(deliveryInformation.getProvince().getProvinceId());
        dto.setProvinceName(deliveryInformation.getProvince().getProvinceName());
        dto.setAddress(deliveryInformation.getAddress());
        dto.setIsRushOrder(deliveryInformation.getIsRushOrder());
        return dto;
    }
}