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

    @Column(nullable = false)
    private String fName;

    @Column(nullable = false)
    private String lName;

    @Column(unique = true,nullable = false)
    private String email;

    @Column(nullable = false)
    private int password;
    @Column
    private String mobile;

    @Column
    private String street;

    @Column
    private String streetNumber;

    @Column
    private String city;

    @Column
    private String zipcode;

    public void setPassword(String password) {
        this.password = password.hashCode();
    }
}
