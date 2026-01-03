package com.foodify.user_service.serviceImpl;

import com.foodify.user_service.dto.OrderDTO;
import com.foodify.user_service.entity.User;
import com.foodify.user_service.mapper.OrderMapper;
import com.foodify.user_service.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepo repo;

    @Autowired
    private UserService userService;


    public Page<OrderDTO> getOrderHistory(String email, int page, int size){
User user =userService.getOrCreateUser(email);
        Pageable pageable =PageRequest.of(page,size);
       return repo.findByUser(user,pageable).map(OrderMapper::toOrderDTO);
    }
}
