package com.foodify.user_service.mapper;

import com.foodify.user_service.dto.OrderDTO;
import com.foodify.user_service.entity.Orders;

public class OrderMapper {

    public static OrderDTO toOrderDTO(Orders order){
        OrderDTO dto = new OrderDTO();
        dto.setId(order.getId());
        dto.setStatus(order.getStatus());
        dto.setTotalAmount(order.getTotalAmount());
        return dto;
    }

}
