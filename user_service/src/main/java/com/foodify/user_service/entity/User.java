package com.foodify.user_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

private String name;
private String email;
private String phone;

@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
List<Address> addressesList = new ArrayList<>();

@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
List<Orders> ordersList = new ArrayList<>();

}
