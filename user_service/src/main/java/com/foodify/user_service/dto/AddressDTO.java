package com.foodify.user_service.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDTO {

    @NotBlank
    private String street;

    @NotBlank
    private String pincode;

    @NotBlank
    private String city;
}
