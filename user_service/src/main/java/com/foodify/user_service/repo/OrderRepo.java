package com.foodify.user_service.repo;

import com.foodify.user_service.entity.Orders;
import com.foodify.user_service.entity.User;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepo  extends JpaRepository<Orders,Long> {
    Page<Orders> findByUser(User user, Pageable pageable);
}
