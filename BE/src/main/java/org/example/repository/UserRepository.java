package org.example.repository;

import org.example.dto.UserDto.UserDtoInfoRes;
import org.example.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    @Query("SELECT new org.example.dto.UserDto.UserDtoInfoRes(u.username, r.roleName, u.blocked) " +
            "FROM UserEntity u JOIN RoleEntity r ON u.roleId = r.roleId")
    List<UserDtoInfoRes> findAllUserDetails();
    Optional<UserEntity> findByUsername(String username);
}
