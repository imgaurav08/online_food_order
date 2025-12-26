package com.foodify.auth_service.repository;

import com.foodify.auth_service.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<RoleEntity,Long> {
     Optional<RoleEntity> findByName(String name);
}
