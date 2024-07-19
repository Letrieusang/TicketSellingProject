package org.example.controller;

import org.example.entity.CartEntity;
import org.example.entity.ProvinceEntity;
import org.example.repository.ProvinceRepository;
import org.example.service.impl.CartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/provinces")
@CrossOrigin(origins = "http://localhost:3000")
public class ProvinceController {
    @Autowired
    ProvinceRepository provinceRepository;

    @GetMapping
    public List<ProvinceEntity> getAllCarts() {
        return provinceRepository.findAll();
    }

}