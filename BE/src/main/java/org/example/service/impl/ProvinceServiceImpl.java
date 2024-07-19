package org.example.service.impl;

import org.example.entity.ProvinceEntity;
import org.example.repository.ProvinceRepository;

import org.example.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceServiceImpl implements ProvinceService {

    ProvinceRepository provinceRepository;

    @Override
    public List<ProvinceEntity> getAllProvince() {
        return provinceRepository.findAll();
    }
}
