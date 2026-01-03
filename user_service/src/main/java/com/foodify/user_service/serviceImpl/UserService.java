package com.foodify.user_service.serviceImpl;

import com.foodify.user_service.dto.UserDTO;
import com.foodify.user_service.dto.UserResponseDTO;
import com.foodify.user_service.entity.User;
import com.foodify.user_service.mapper.UserMapper;
import com.foodify.user_service.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;


    public User getOrCreateUser(String email){
      return   repo.findByEmail(email).orElseGet(()->
        {
            User user = new User();
            user.setEmail(email);
          return   repo.save(user);
        });
    }

    public UserResponseDTO updateOrGetUserDetail(String email, UserDTO userDTO){
       User user = getOrCreateUser(email);
       user.setName(userDTO.getName());
       user.setPhone(userDTO.getPhone());
       User saved = repo.save(user);
       return UserMapper.toDTO(saved);
    }

    public UserResponseDTO getProfile(String email) {
        User user = getOrCreateUser(email);
        return UserMapper.toDTO(user);
    }
}
