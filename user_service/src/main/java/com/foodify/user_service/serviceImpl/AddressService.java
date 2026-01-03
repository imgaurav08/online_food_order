package com.foodify.user_service.serviceImpl;

import com.foodify.user_service.dto.AddressDTO;
import com.foodify.user_service.entity.Address;
import com.foodify.user_service.entity.User;
import com.foodify.user_service.exception.ResourceNotFound;
import com.foodify.user_service.mapper.AddressMapper;
import com.foodify.user_service.repo.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressService {


    @Autowired
    private AddressRepo addressRepo;

    @Autowired
    private UserService userService;


    public void addAddress(AddressDTO addressDTO,String email){
       User user=     userService.getOrCreateUser(email);

        Address address = new Address();
        address.setCity(addressDTO.getCity());
        address.setPincode(addressDTO.getPincode());
        address.setStreet(addressDTO.getStreet());
        address.setUser(user);
        addressRepo.save(address);
    }


    public List<AddressDTO> getAddress(String email){
          User user=userService.getOrCreateUser(email);
          return addressRepo.findByUser(user).
                  stream()
                  .map(AddressMapper::toAddressDTO)
                  .toList();

    }

    public void deleteAddress(Long id, String email){
      User user=  userService.getOrCreateUser(email);
     Address address= addressRepo.findById(id)
             .orElseThrow(()-> new ResourceNotFound("Address not found"));
     if (!address.getId().equals(user.getId())){
   throw  new RuntimeException("UnAuthorised");
     }
     addressRepo.delete(address);
    }

}
