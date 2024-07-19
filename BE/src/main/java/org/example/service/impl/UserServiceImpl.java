package org.example.service.impl;

import org.example.dto.UserDto.UserDtoCredentReq;
import org.example.dto.UserDto.UserDtoInfoRes;
import org.example.entity.UserEntity;
import org.example.repository.UserRepository;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<UserDtoInfoRes> getAllUserDetails() {
        return userRepository.findAllUserDetails();
    }

    @Override
    public Optional<UserEntity> getUserById(Integer userId) {
        return userRepository.findById(userId);
    }

    @Override
    public UserEntity createUser(UserEntity user) {
        return userRepository.save(user);
    }

    @Override
    public UserEntity updateUser(UserEntity userDetails) {
        UserEntity user = userRepository.findById(userDetails.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setRoleId(userDetails.getRoleId());
        user.setUsername(userDetails.getUsername());
        user.setPassword(userDetails.getPassword());
        user.setBlocked(userDetails.getBlocked());
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Integer userId) {
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        userRepository.delete(user);
    }

    @Override
    public boolean checkCredentials(UserDtoCredentReq credentials) {
        Optional<UserEntity> userOptional = userRepository.findByUsername(credentials.getUsername());
        if (userOptional.isPresent()) {
            UserEntity user = userOptional.get();
            return user.getPassword().equals(credentials.getPassword());
        }
        return false;
    }
}