package com.foodify.user_service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDTO {
    private Long id;

    private String status;

    private Double totalAmount;

}
