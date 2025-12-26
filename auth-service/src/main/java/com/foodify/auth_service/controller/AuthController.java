package com.foodify.auth_service.controller;

import com.foodify.auth_service.dto.LoginRequestDTO;
import com.foodify.auth_service.dto.RegisterRequestDTO;
import com.foodify.auth_service.dto.ResponseDTO;
import com.foodify.auth_service.repository.AuthService;
import com.foodify.auth_service.serviceImple.AuthServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthServiceImpl authService;

    @PostMapping("/register")
     public ResponseEntity<ResponseDTO> registerUser(@RequestBody RegisterRequestDTO requestDTO){
   return  ResponseEntity.status(HttpStatus.CREATED).body(authService.register(requestDTO));
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseDTO> loginUser(@RequestBody LoginRequestDTO requestDTO){
        return ResponseEntity.status(HttpStatus.OK).body(authService.login(requestDTO));
    }

}
