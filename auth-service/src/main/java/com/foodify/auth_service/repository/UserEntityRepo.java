package com.foodify.auth_service.repository;

import com.foodify.auth_service.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;


public interface UserEntityRepo extends JpaRepository<UserEntity,Long> {

    Optional<UserEntity>findByEmail(String email);
    boolean existsByEmail(String email);
}
