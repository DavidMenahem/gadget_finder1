package com.dvmena.gadget_finder1.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Register {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name",nullable = false)
    private String user_first_name;

    @Column(name = "last_name",nullable = false)
    private String user_last_name;

    @Column(unique = true,name = "email",nullable = false)
    private String email;

    @Column(name="password",nullable = false)
    private String password;
    @Column(name="mobile")
    private String mobile;

    @Column(name = "street")
    private String street;

    @Column(name = "street_number")
    private String streetNumber;

    @Column(name = "city")
    private String city;

    @Column(name = "zipcode")
    private String zipcode;
}
