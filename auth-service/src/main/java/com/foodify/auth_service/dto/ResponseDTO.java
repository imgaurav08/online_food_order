package com.foodify.auth_service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDTO {

    private String jwt;
    private String email;
}
