package com.foodify.user_service.controller;

import com.foodify.user_service.dto.AddressDTO;
import com.foodify.user_service.dto.OrderDTO;
import com.foodify.user_service.dto.UserDTO;
import com.foodify.user_service.dto.UserResponseDTO;
import com.foodify.user_service.entity.Address;
import com.foodify.user_service.entity.User;
import com.foodify.user_service.serviceImpl.AddressService;
import com.foodify.user_service.serviceImpl.OrderService;
import com.foodify.user_service.serviceImpl.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class Controller {

    @Autowired
    private UserService userService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public ResponseEntity<UserResponseDTO> createProfile(@Valid @RequestBody UserDTO dto, Authentication auth){
      return  ResponseEntity.status(HttpStatus.CREATED).body(userService.updateOrGetUserDetail(auth.getName(), dto));
    }

    @GetMapping("/profile")
    public  ResponseEntity<UserResponseDTO> getProfile(Authentication authentication){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getProfile(authentication.getName()));
    }


    @PostMapping("/addAddress")
    public ResponseEntity<String> createAddress(@Valid @RequestBody AddressDTO dto,Authentication auth){
        addressService.addAddress(dto,auth.getName());
        return ResponseEntity.status(HttpStatus.CREATED).body("Address saved successfully ");
    }

    @GetMapping("/Addresses")
    public ResponseEntity<List<AddressDTO>> getAddressInfo(Authentication auth){
        return ResponseEntity.status(HttpStatus.OK).body(addressService.getAddress(auth.getName()));
    }


    @DeleteMapping("/deleteAddress/{id}")
    public ResponseEntity<String> deleteAddressInfo(@PathVariable Long id, Authentication authentication){
        addressService.deleteAddress(id, authentication.getName());
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Address Deleted");

    }


    @GetMapping("/orders")
    public ResponseEntity<Page<OrderDTO>> orderHistory(Authentication authentication, @RequestParam(defaultValue = "0") int size,
                                                       @RequestParam(defaultValue = "5") int page){

return ResponseEntity.status(HttpStatus.OK).body(orderService.getOrderHistory(authentication.getName(), size,page));
    }

}
