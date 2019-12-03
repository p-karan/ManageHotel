package com.stays.hotelmanagement.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Address {

    @GeneratedValue(strategy = GenerationType.AUTO)
    private int addressId;

    @Column(nullable = false)
    private String addressBldgFlat;

    @Column(nullable = false)
    private String addressStreet;

    @Column(nullable = false)
    private String addressCity;

    @Column(nullable = false)
    private String addressState;

    @Column(nullable = false)
    private String addressPincode;

}
