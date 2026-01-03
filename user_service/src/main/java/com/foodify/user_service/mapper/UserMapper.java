package com.foodify.user_service.mapper;

import com.foodify.user_service.dto.UserDTO;
import com.foodify.user_service.dto.UserResponseDTO;
import com.foodify.user_service.entity.User;

public class UserMapper {

    public static UserResponseDTO toDTO(User user ){
        UserResponseDTO dto = new UserResponseDTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setPhone(user.getPhone());
        return dto;
    }

}
