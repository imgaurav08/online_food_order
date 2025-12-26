package com.foodify.auth_service.repository;

import com.foodify.auth_service.dto.LoginRequestDTO;
import com.foodify.auth_service.dto.RegisterRequestDTO;
import com.foodify.auth_service.dto.ResponseDTO;
import org.springframework.stereotype.Service;


public interface AuthService {

    ResponseDTO register(RegisterRequestDTO requestDTO);

    ResponseDTO login(LoginRequestDTO loginRequestDTO) ;

}
