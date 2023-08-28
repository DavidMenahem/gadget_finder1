package com.dvmena.gadget_finder1.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "gadget")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Gadget {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Long userID;
    @Column
    private String gadget;
}
