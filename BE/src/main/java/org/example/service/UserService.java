package org.example.service;

import org.example.dto.UserDto.UserDtoCredentReq;
import org.example.dto.UserDto.UserDtoInfoRes;
import org.example.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserEntity> getAllUsers();

    List<UserDtoInfoRes> getAllUserDetails();

    Optional<UserEntity> getUserById(Integer userId);

    UserEntity createUser(UserEntity user);

    UserEntity updateUser(UserEntity userDetails);

    void deleteUser(Integer userId);

    boolean checkCredentials(UserDtoCredentReq credentials);
}