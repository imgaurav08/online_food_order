package com.foodify.user_service.mapper;

import com.foodify.user_service.dto.AddressDTO;
import com.foodify.user_service.entity.Address;

public class AddressMapper {

    public static AddressDTO toAddressDTO(Address addressDTO){
        AddressDTO address = new AddressDTO();
        address.setCity(addressDTO.getCity());
        address.setStreet(addressDTO.getStreet());
        address.setPincode(addressDTO.getPincode());
        return address;
    }

}
