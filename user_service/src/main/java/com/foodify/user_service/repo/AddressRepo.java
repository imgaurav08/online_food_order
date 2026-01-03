package com.foodify.user_service.repo;

import com.foodify.user_service.entity.Address;
import com.foodify.user_service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepo extends JpaRepository<Address,Long> {
     List<Address> findByUser(User user);
}
