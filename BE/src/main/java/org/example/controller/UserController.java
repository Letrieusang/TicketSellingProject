package org.example.controller;

import org.example.dto.UserDto.UserDtoCredentReq;
import org.example.dto.UserDto.UserDtoInfoRes;
import org.example.entity.UserEntity;
import org.example.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    @Autowired
    UserServiceImpl userServiceImpl;

    @GetMapping
    public List<UserEntity> getAllUsers() {
        return userServiceImpl.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable Integer id) {
        Optional<UserEntity> user = userServiceImpl.getUserById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/")
    public UserEntity createUser(@RequestBody UserEntity user) {
        return userServiceImpl.createUser(user);
    }

    @PutMapping("/")
    public ResponseEntity<UserEntity> updateUser(@RequestBody UserEntity userDetails) {
        UserEntity updatedUser = userServiceImpl.updateUser(userDetails);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
        userServiceImpl.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/details")
    public List<UserDtoInfoRes> getAllUserDetails() {
        return userServiceImpl.getAllUserDetails();
    }

    @PostMapping("/checkCredentials")
    public ResponseEntity<Boolean> checkCredentials(@RequestBody UserDtoCredentReq credentials) {
        boolean isValid = userServiceImpl.checkCredentials(credentials);
        return ResponseEntity.ok(isValid);
    }
}
