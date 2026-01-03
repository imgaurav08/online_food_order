package com.foodify.user_service.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "address")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

    private String street;

    @Column(length = 6)
    private String pincode;

    private String city;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
