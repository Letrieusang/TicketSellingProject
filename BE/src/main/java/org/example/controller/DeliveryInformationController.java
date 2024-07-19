package org.example.controller;

import org.example.dto.DeliveryInformationDto.DeliveryInformationDtoInfoResDto;
import org.example.entity.DeliveryInformationEntity;
import org.example.service.DeliveryInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/deliveryInformation")
@CrossOrigin(origins = "http://localhost:3000")
public class DeliveryInformationController {
    @Autowired
    DeliveryInformationService deliveryInformationService;

    @GetMapping
    public List<DeliveryInformationEntity> getAllDeliveryInformation() {
        return deliveryInformationService.getAllDeliveryInformation();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeliveryInformationDtoInfoResDto> getDeliveryInformationById(@PathVariable Integer id) {
        Optional<DeliveryInformationDtoInfoResDto> deliveryInformation = deliveryInformationService.getDeliveryInformationById(id);
        return deliveryInformation.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/")
    public DeliveryInformationEntity createDeliveryInformation(@RequestBody DeliveryInformationEntity deliveryInformation) {
        return deliveryInformationService.createDeliveryInformation(deliveryInformation);
    }

    @PutMapping("/")
    public ResponseEntity<DeliveryInformationEntity> updateDeliveryInformation(@RequestBody DeliveryInformationEntity deliveryInformationDetails) {
        DeliveryInformationEntity updatedDeliveryInformation = deliveryInformationService.updateDeliveryInformation(deliveryInformationDetails);
        return ResponseEntity.ok(updatedDeliveryInformation);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteDeliveryInformation(@PathVariable Integer id) {
        deliveryInformationService.deleteDeliveryInformation(id);
        return ResponseEntity.noContent().build();
    }
}