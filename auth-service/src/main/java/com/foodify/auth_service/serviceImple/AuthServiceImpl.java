package com.foodify.auth_service.serviceImple;

import com.foodify.auth_service.dto.LoginRequestDTO;
import com.foodify.auth_service.dto.RegisterRequestDTO;
import com.foodify.auth_service.dto.ResponseDTO;
import com.foodify.auth_service.entity.RoleEntity;
import com.foodify.auth_service.entity.UserEntity;
import com.foodify.auth_service.repository.AuthService;
import com.foodify.auth_service.repository.RoleRepository;
import com.foodify.auth_service.repository.UserEntityRepo;
import com.foodify.auth_service.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
   private UserEntityRepo userEntityRepo;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder  passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;


    @Override
    public ResponseDTO register(RegisterRequestDTO requestDTO) {

        if (userEntityRepo.existsByEmail(requestDTO.getEmail())){
            throw new RuntimeException(" Email Already exists ");
        }

      RoleEntity role =  roleRepository.findByName("ROLE_USER").orElseGet(()->
                roleRepository.save(new RoleEntity(null,"ROLE_USER")));


        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(requestDTO.getEmail());
        userEntity.setPassword(passwordEncoder.encode(requestDTO.getPassword()));
       userEntity.setRoleEntitySet(Set.of(role));
       userEntityRepo.save(userEntity);

       return response(userEntity);

    }

    @Override
    public ResponseDTO login(LoginRequestDTO loginRequestDTO) {
        UserEntity user = userEntityRepo.findByEmail(loginRequestDTO.getEmail()).orElseThrow(
                 ()-> new RuntimeException("Invalid Email")
         );

        if (!passwordEncoder.matches(loginRequestDTO.getPassword(), user.getPassword())){
            throw  new RuntimeException(" Password Invalid ");
        }

return response(user);

    }

    public  ResponseDTO response( UserEntity user){
       String token= jwtUtil.generateToken(user.getEmail());
        ResponseDTO dto = new ResponseDTO();
        dto.setEmail(user.getEmail());
        dto.setJwt(token);
        return dto;
    }
}
